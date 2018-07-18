package edu.cvtc.jdiederich2.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Menu specific logic
    // This code displays the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("Clicked item: " + item.getItemId());

        // Display the fragment with fragment manager and attach to current view
        FragmentManager manager = this.getFragmentManager();
            switch(item.getItemId()) {
                case R.id.actionadd1:
                    // first step: create transaction (exchange view)
                    FragmentTransaction transaction = manager.beginTransaction();
                    // add our fragment to dynamic layout - this is in our fragment layout
                    transaction.add(R.id.fragmentcontainer1, new MyListFragment());
                    transaction.setTransition(
                            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
                    );
                    // tHIS IS WHERE CHANGE HAPPENS
                    transaction.commit();
                    break;

                case R.id.anctionadd2:
                    FragmentTransaction transaction2 = manager.beginTransaction();
                    transaction2.add(R.id.fragmentcontainer2, new MyListFragment());
                    transaction2.setTransition(
                            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
                    );
                    transaction2.commit();
                    break;

                default:
                    break;
        }

        return true;
    }
}
