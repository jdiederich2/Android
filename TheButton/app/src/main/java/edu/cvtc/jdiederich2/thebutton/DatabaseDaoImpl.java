package edu.cvtc.jdiederich2.thebutton;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import edu.cvtc.jdiederich2.thebutton.db.TaskDbContract;
import edu.cvtc.jdiederich2.thebutton.db.TaskDbHelper;

public class DatabaseDaoImpl implements DatabaseDao{

    private TaskDbHelper mHelper;
    private String[] tasks = {"Task1", "Task2", "Task3"};

    public void createTableTaskList() {
        SQLiteDatabase db = mHelper.getWritableDatabase();

        for (int i = 0; i < tasks.length; i++) {
            Log.d(tasks[i], "task");
        }

    }

    @Override
    public void getDatabaseInfo() {
        ArrayList<String> dbData = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();

        Cursor cursor = db.query(TaskDbContract.TaskEntry.TABLE,
                new String[] {
                    TaskDbContract.TaskEntry._ID,
                    TaskDbContract.TaskEntry.COL_TASK_TITLE
                }, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(TaskDbContract.TaskEntry.COL_TASK_TITLE);

            String row = cursor.getString(index);
            dbData.add(row);
        }
    }
}
