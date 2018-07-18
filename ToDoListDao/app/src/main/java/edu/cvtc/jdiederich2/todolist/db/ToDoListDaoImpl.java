package edu.cvtc.jdiederich2.todolist.db;

import edu.cvtc.jdiederich2.todolist.ToDoListDao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

public class ToDoListDaoImpl implements ToDoListDao {

    private TaskDbHelper mHelper;

    public ToDoListDaoImpl(Context context) {
        mHelper = new TaskDbHelper(context);
    }

    @Override
    public void insert(String task) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public ArrayList<String> fetchData() {
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

        c.close();
        db.close();

        return taskList;
    }

    public void deleteData(String task) {
         SQLiteDatabase db = this.mHelper.getWritableDatabase();
         db.delete(TaskContract.TaskEntry.TABLE,
                TaskContract.TaskEntry.COL_TASK_TITLE + " = ?",
                new String[]{task});
         db.close();
    }

}
