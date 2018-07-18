package edu.cvtc.jdiederich2.workordersapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.cvtc.jdiederich2.workordersapp.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workordersapp.Views.WorkOrderListRecyclerViewAdapter;
import edu.cvtc.jdiederich2.workordersapp.Views.WorkOrderViewModel;

public class WorkOrderInsertActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.reply";

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhone;
    private EditText mAddress;
    private EditText mCity;
    private EditText mAccountNumber;
    private EditText mInstallDate;
    
    private WorkOrderViewModel mWorkOrderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_work_order_insert);

        // RecyclerView recyclerView = findViewById( R.id.recyclerView );

        mFirstName = findViewById( R.id.editText_FirstName);
        mLastName = findViewById( R.id.editText_LastName);
        mPhone = findViewById( R.id.editText_Phone);
        mAddress = findViewById( R.id.editText_Address);
        mCity = findViewById(R.id.editText_City);
        mAccountNumber = findViewById( R.id.editText_AcctNumber);
        mInstallDate = findViewById( R.id.editText_InstallDate);
        final Button mAddWorkOrderButton = findViewById( R.id.button_AddWorkOrder );



        mAddWorkOrderButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty( mFirstName.getText())) {
                    setResult( RESULT_CANCELED, replyIntent );
                } else {
                    String fName = mFirstName.getText().toString();
                    String lName = mLastName.getText().toString();
                    String phone = mPhone.getText().toString();
                    String address = mAddress.getText().toString();
                    String city = mCity.getText().toString();
                    String acctNumber = mAccountNumber.getText().toString();
                    String installDate = mInstallDate.getText().toString();
                    replyIntent.putExtra( EXTRA_REPLY, lName);
                    setResult( RESULT_OK, replyIntent );
                }
            }
        } );

        mWorkOrderViewModel = ViewModelProviders.of(this).get(WorkOrderViewModel.class);

        mWorkOrderViewModel.getAllWorkOrders().observe(this, new Observer<List<WorkOrderModel>>() {

            WorkOrderListRecyclerViewAdapter adapter;
            @Override
            public void onChanged(@Nullable List<WorkOrderModel> workOrders) {
                adapter.setWorkOrderList( workOrders );
            }
        });
    }
}
