package edu.cvtc.jdiederich2.todolist;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import edu.cvtc.jdiederich2.todolist.db.TaskContract;
import edu.cvtc.jdiederich2.todolist.db.TaskDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TaskDbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    private void showAddTaskDialog() {
        final EditText taskEditText = new EditText(this);
        // Builder Pattern
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add new task")
                .setMessage("What do you want to do next?")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String task = String.valueOf(taskEditText.getText());  // Gets the text of the value they want to add
                        SQLiteDatabase db = mHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
                        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                                null,
                                values,
                                SQLiteDatabase.CONFLICT_REPLACE);
                        db.close();
                        updateUI();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    private void updateUI() {
        // Create array list of tasks
        ArrayList<String> taskList = new ArrayList<String>();
        SQLiteDatabase db = this.mHelper.getReadableDatabase();

        Cursor c = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{
                        TaskContract.TaskEntry._ID,
                        TaskContract.TaskEntry.COL_TASK_TITLE
                }, null, null, null, null, null);
        // Iterate through table
        while (c.moveToNext()) {
            int index = c.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);

            // Add to our array list
            String message = c.getString(index);
            taskList.add(message);
        }

        if (null == this.mAdapter) {
            // If not set populate
            this.mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo, // View to use for the items
                    R.id.task_title, // the string to display
                    taskList); // Where the data is coming from

            this.mTaskListView.setAdapter(this.mAdapter);
        } else {
            this.mAdapter.clear();
            this.mAdapter.addAll(taskList);
            this.mAdapter.notifyDataSetChanged();
        }

        c.close();
        db.close();
    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent(); // Get access to parent view
        // find what was clicked
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = this.mHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.TABLE,
                TaskContract.TaskEntry.COL_TASK_TITLE + " = ?",
                new String[]{task});
        db.close();
        this.updateUI();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_menu, menu);  // Sub menu added to parent menu
        return super.onCreateOptionsMenu(menu); // Render both menus
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                Log.d(TAG, "Add a new task");
                this.showAddTaskDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mHelper = new TaskDbHelper(this);
        this.mTaskListView = (ListView) this.findViewById(R.id.list_todo);
        this.updateUI();

    }
}
