package org.techtown.dongseomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            if(intent != null){
                textView1.setText(bundle.getString("name"));
                textView2.setText(bundle.getString("mobile"));
            }
        }
    }
}
