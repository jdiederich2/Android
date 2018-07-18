package edu.cvtc.jdiederich2.thebutton.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDbHelper extends SQLiteOpenHelper {

    public TaskDbHelper(Context context) {
        super(context, TaskDbContract.DB_NAME, null, TaskDbContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE " +
                TaskDbContract.TaskEntry.TABLE + " ( " +
                TaskDbContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", " +
                TaskDbContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL " +
                " );";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskDbContract.TaskEntry.TABLE);
        this.onCreate(db);
    }
}
