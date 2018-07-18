package edu.cvtc.volleytutorial.middleware;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import edu.cvtc.util.App;


public class RequestQueueSingleton {

    // Define and end point where the request are going (this is not the normal way)
    // This is prefix
    public static String REQUEST_TAG = "com.androidtutorialpoint";

    private static RequestQueue queue;

    private RequestQueueSingleton() {}

    public static synchronized RequestQueue getInstance() {
        // Synchronized: only one request at a time. Allows to run in order. Only one thread
        // can use at a time.
        // Make sure only one thread can use at a time.
        if(null == queue) {
            // This insures we can only get one request
            queue = Volley.newRequestQueue(App.getContext().getApplicationContext());
        }
        return queue;
    }

    // Generic stating whatever type the request is
    // Then you can add tag to be able to find request
    public static synchronized <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(tag);

        // Get new queue, then add request
        getInstance().add(req);
    }

}
