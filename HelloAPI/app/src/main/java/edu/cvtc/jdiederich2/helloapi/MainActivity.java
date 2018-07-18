package edu.cvtc.jdiederich2.helloapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public void getGithubProfile(View view) {

            // Network requests manually through request objects through java
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    TextView textView = findViewById(R.id.textView);
                    try {
                        EditText editText = (EditText) findViewById(R.id.editText);

                        // Create URL
                        URL githubEndpoint =
                                new URL("https://api.github.com/users/" + editText.getText().toString());

                        // Create URL Connection
                        HttpsURLConnection githubConnection =
                                (HttpsURLConnection) githubEndpoint.openConnection();

                        // Content we are willing to get
                        githubConnection.setRequestProperty("User-Agent", "helloapi-android-v0.1");

                        // Type of content we want back
                        githubConnection.setRequestProperty("Accept", "application/vnd.github.v3+json");

                        if (githubConnection.getResponseCode() == 200) {
                            // Android Requires stream reader to read data as it's coming in
                            InputStream responseBody = githubConnection.getInputStream();

                            // Create stream reader
                            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                            // Create json reader
                            JsonReader jsonReader = new JsonReader(responseBodyReader);

                            // Prep object to be parsed
                            // Any response from API will be an object
                            jsonReader.beginObject();


                            // Iterate over object
                            // Parsing bytes into attributes
                            while(jsonReader.hasNext()) {
                                String key = jsonReader.nextName();

                                // Limit resources
                                if (key.equals("name")) {
                                    String value = jsonReader.nextString();

                                    // Update textView
                                    textView.setText(value);
                                    break;
                                }

                                // Else, skip value
                                jsonReader.skipValue();
                            }

                            // Close Reader
                            jsonReader.close();
                            responseBody.close();
                        }

                        // Close connection
                        githubConnection.disconnect();

                    } catch (Exception e) {
                        textView.setText(e.toString());

                    }
                }

            });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
