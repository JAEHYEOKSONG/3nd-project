package org.techtown.dongseomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton search_btn = findViewById(R.id.search_btn);
        ImageButton map_btn = findViewById(R.id.map_btn);
        Button gong_btn = findViewById(R.id.gong_btn);
        Button dong_btn = findViewById(R.id.dong_btn);
        Button che_btn = findViewById(R.id.che_btn);
        Button mat_btn = findViewById(R.id.mat_btn);

        final EditText editText = findViewById(R.id.search_Text);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("search", editText.getText().toString());
                startActivity(intent);
            }
        });
        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        gong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                intent.putExtra("src", "http://www.dongseo.ac.kr/kr/index.php?pCode=MN2000191");
                startActivity(intent);
            }
        });
        dong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                intent.putExtra("src", "http://www.dongseo.ac.kr/kr/index.php?pCode=stuactivities01");
                startActivity(intent);
            }
        });
        che_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                intent.putExtra("src", "http://uni.dongseo.ac.kr/job/");
                startActivity(intent);
            }
        });

        mat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent);
            }
        });

    }
}