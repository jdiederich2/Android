package edu.cvtc.jdiederich2.todolist.db;

import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "edu.cvtc.jdiederich2.db"; // Use standard naming convetion so reads the correct db
    public static final int DB_VERSION = 2; // Each time you update it will run the correct version

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks"; // Table name
        public static final String COL_TASK_TITLE = "title"; // Column name
    }

    // Need to create a helper

}
