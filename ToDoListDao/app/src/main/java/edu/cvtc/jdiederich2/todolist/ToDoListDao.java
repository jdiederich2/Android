package edu.cvtc.jdiederich2.todolist;

import java.util.ArrayList;

public interface ToDoListDao {

    void insert(String task);

    ArrayList<String> fetchData();

    void deleteData(String task);


}
