package edu.cvtc.jdiederich2.workordersapp.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity
(foreignKeys = @ForeignKey(entity = UserModel.class,
        parentColumns = "userID",
        childColumns = "userID",
        onDelete = CASCADE))

public class WorkOrderModel {

    @PrimaryKey(autoGenerate = true)
    private int orderID;

    @ColumnInfo(name = "userID")
    private int userID;

    @NonNull
    @ColumnInfo(name = "csFirstName")
    private String csFirstName;

    @NonNull
    @ColumnInfo(name = "csLastName")
    private String csLastName;

    @NonNull
    @ColumnInfo(name = "csPhoneNum")
    private String csPhoneNumber;

    @NonNull
    @ColumnInfo(name = "csAddress")
    private String csAddress;

    @NonNull
    @ColumnInfo(name = "csCity")
    private String csCity;

    @NonNull
    @ColumnInfo(name = "csAcctNum")
    private int csAccountNum;

    @NonNull
    @ColumnInfo(name = "csInstallDate")
    private String csInstallDate;

    public WorkOrderModel(int orderID, int userID, @NonNull String csFirstName, @NonNull String csLastName, @NonNull String csPhoneNumber, @NonNull String csAddress, @NonNull String csCity, @NonNull int csAccountNum, @NonNull String csInstallDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.csFirstName = csFirstName;
        this.csLastName = csLastName;
        this.csPhoneNumber = csPhoneNumber;
        this.csAddress = csAddress;
        this.csCity = csCity;
        this.csAccountNum = csAccountNum;
        this.csInstallDate = csInstallDate;
    }

    @Ignore
    public WorkOrderModel(@NonNull String csFirstName, @NonNull String csLastName, @NonNull String csPhoneNumber, @NonNull String csAddress, @NonNull String csCity, @NonNull int csAccountNum, @NonNull String csInstallDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.csFirstName = csFirstName;
        this.csLastName = csLastName;
        this.csPhoneNumber = csPhoneNumber;
        this.csAddress = csAddress;
        this.csCity = csCity;
        this.csAccountNum = csAccountNum;
        this.csInstallDate = csInstallDate;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setCsFirstName(@NonNull String csFirstName) {
        this.csFirstName = csFirstName;
    }

    public void setCsLastName(@NonNull String csLastName) {
        this.csLastName = csLastName;
    }

    public void setCsPhoneNumber(@NonNull String csPhoneNumber) {
        this.csPhoneNumber = csPhoneNumber;
    }

    public void setCsAddress(@NonNull String csAddress) {
        this.csAddress = csAddress;
    }

    public void setCsCity(@NonNull String csCity) {
        this.csCity = csCity;
    }

    public void setCsAccountNum(@NonNull int csAccountNum) {
        this.csAccountNum = csAccountNum;
    }

    public void setCsInstallDate(@NonNull String csInstallDate) {
        this.csInstallDate = csInstallDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    @NonNull
    public String getCsFirstName() {
        return csFirstName;
    }

    @NonNull
    public String getCsLastName() {
        return csLastName;
    }

    @NonNull
    public String getCsPhoneNumber() {
        return csPhoneNumber;
    }

    @NonNull
    public String getCsAddress() {
        return csAddress;
    }

    @NonNull
    public String getCsCity() {
        return csCity;
    }

    @NonNull
    public int getCsAccountNum() {
        return csAccountNum;
    }

    @NonNull
    public String getCsInstallDate() {
        return csInstallDate;
    }


}