package edu.cvtc.jdiederich2.workordersapp.Data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import edu.cvtc.jdiederich2.workordersapp.Controllers.UserDao;
import edu.cvtc.jdiederich2.workordersapp.Controllers.WorkOrderDao;
import edu.cvtc.jdiederich2.workordersapp.Models.UserModel;
import edu.cvtc.jdiederich2.workordersapp.Models.WorkOrderModel;

public class WorkOrderRepository {

    private UserDao mUserDao;
    private LiveData<List<UserModel>> mUser;

    private WorkOrderDao mWorkOrderDao;
    private LiveData<List<WorkOrderModel>> mAllWorkOrders;
    private LiveData<List<WorkOrderModel>> mSingleWorkOrder;

    // Respository constructor
    public WorkOrderRepository(Application application) {
        WorkOrdersDatabase db = WorkOrdersDatabase.getDatabaseInstance(application);

        mWorkOrderDao = db.workOrderModelDao();
        mAllWorkOrders =  mWorkOrderDao.getAllWorkOrders();
        mSingleWorkOrder = mWorkOrderDao.getSingleWorkOrder();
    }

    // LiveData Observer to refresh workOrders list when changed
    public LiveData<List<WorkOrderModel>> getAllWorkOrders() {
        return mAllWorkOrders;
    }

    // LiveData Observer for workOrder insert
    public void insertWorkOrder(WorkOrderModel workOrder) {
        new insertWorkOrderAsyncTask(mWorkOrderDao).execute(workOrder);
    }

    public LiveData<List<UserModel>> getUser() {
        return mUser;
    }

    private static class insertWorkOrderAsyncTask extends AsyncTask<WorkOrderModel, Void, Void> {

        private WorkOrderDao mAsyncTaskDao;

        insertWorkOrderAsyncTask(WorkOrderDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final WorkOrderModel... params) {
            mAsyncTaskDao.insertWorkOrder( params[0] );
            return null;
        }
    }
}
