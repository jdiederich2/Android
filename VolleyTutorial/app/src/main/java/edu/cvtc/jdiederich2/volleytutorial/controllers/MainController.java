package edu.cvtc.jdiederich2.volleytutorial.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import edu.cvtc.jdiederich2.volleytutorial.R;
import edu.cvtc.util.App;
import edu.cvtc.volleytutorial.middleware.RequestQueueSingleton;


public class MainController extends AppCompatActivity {

    public void jsonRequestButtonOnClick(View view) {

        String url = "https://androidtutorialpoint.com/api/JsonObject";
        // Json object request
        JsonObjectRequest jsonReqObject = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String TAG = RequestQueueSingleton.REQUEST_TAG + "jsonRequest";
                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // Send request object
        RequestQueueSingleton.addToRequestQueue(jsonReqObject, "jsonTestTag");

    }


    public void stringRequestButtonOnClick(View view) {
        RequestQueueSingleton.addToRequestQueue(
                volleyStringRequest("https://androidtutorialpoint.com/api/volleyString"),
                "testTag");
    }

    public StringRequest volleyStringRequest(String url) {

        StringRequest strReq = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String TAG = RequestQueueSingleton.REQUEST_TAG + ".stringRequest";
                Log.d(TAG, response.toString());
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return strReq;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.setContext(this);
    }

}
