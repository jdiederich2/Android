package edu.cvtc.jdiederich2.workordersapp.Views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import edu.cvtc.jdiederich2.workordersapp.Data.WorkOrderRepository;
import edu.cvtc.jdiederich2.workordersapp.Models.WorkOrderModel;

public class WorkOrderViewModel extends AndroidViewModel {

    private WorkOrderRepository mWorkOrderRepository;

    private LiveData<List<WorkOrderModel>> mWorkOrderList;

    public WorkOrderViewModel(@NonNull Application application) {
        super( application );
        mWorkOrderRepository = new WorkOrderRepository(application);
        mWorkOrderList = mWorkOrderRepository.getAllWorkOrders();
    }

    public LiveData<List<WorkOrderModel>> getAllWorkOrders() {
        return mWorkOrderList;
    }

    public void insert(WorkOrderModel workOrder) {
        mWorkOrderRepository.insertWorkOrder(workOrder);
    }
}
