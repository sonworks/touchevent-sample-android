package org.TouchEventExample;

import android.app.Activity;
import android.os.Bundle;


public class TouchEventExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TouchEventExampleView(this));
    }
    
}