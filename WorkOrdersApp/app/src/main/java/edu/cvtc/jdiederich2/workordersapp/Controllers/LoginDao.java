/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package edu.cvtc.jdiederich2.workordersapp.Controllers;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import edu.cvtc.jdiederich2.workordersapp.Models.UserModel;

@Dao
public interface LoginDao {

    @Query( "SELECT * FROM UserModel WHERE userName = :loginUserName" )
    public abstract UserModel getUserNameAndPassword(String loginUserName);
}
