package edu.cvtc.jdiederich2.workordersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkOrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_work_order_list );
    }
}
