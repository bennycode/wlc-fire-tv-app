package com.welovecoding.app.firetv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyMainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);

        setContentView(R.layout.activity_list_view_android_example);
        ListView listView = (ListView) findViewById(R.id.listView2);

        String[] values = new String[]{
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

    }
}
