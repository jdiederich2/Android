package edu.cvtc.jdiederich2.workordersapp.Controllers;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.cvtc.jdiederich2.workordersapp.Models.UserModel;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserModel user);

    @Query("SELECT * FROM UserModel")
    LiveData<List<UserModel>> getUser();

}
