/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package edu.cvtc.jdiederich2.workordersapp.Views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import edu.cvtc.jdiederich2.workordersapp.Controllers.LoginDao;
import edu.cvtc.jdiederich2.workordersapp.Controllers.UserDao;
import edu.cvtc.jdiederich2.workordersapp.Data.WorkOrderRepository;
import edu.cvtc.jdiederich2.workordersapp.Models.UserModel;

public class LoginActivityViewModel extends AndroidViewModel implements LoginDao {

    private WorkOrderRepository mWorkOrderRepository;
    private LiveData<List<UserModel>> mUser;

    private String dbUserName;
    private String dbPassword;

    // Constructor. References the repository and gets the user from the repository.
    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mWorkOrderRepository = new WorkOrderRepository( application );
        mUser = mWorkOrderRepository.getUser();
    }

    public LiveData<List<UserModel>> getUser() {
        return mUser;
    }

    @Override
    public UserModel getUserNameAndPassword(String userName) {
        return null;
    }
}
