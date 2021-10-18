package org.techtown.dongseomap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MapActivity extends AppCompatActivity {

    private static String TAG = "phpquerytest";

    private static final String TAG_JSON="webnautes";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADDRESS ="country";

    //private TextView mTextViewResult;
    ArrayList<HashMap<String, String>> mArrayList;
    RecyclerView recyclerView;
    EditText mEditTextSearchKeyword1, mEditTextSearchKeyword2;
    String mJsonString;

    InfoAdapter adapter;

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        Button btn_bus = findViewById(R.id.btn_bus);
        Button btn_build = findViewById(R.id.btn_build);
        Button btn_store = findViewById(R.id.btn_store);
        Button btn_cafe = findViewById(R.id.btn_cafe);

        Button btn_bus2 = findViewById(R.id.btn_bus2);
        Button btn_build2 = findViewById(R.id.btn_build2);
        Button btn_store2 = findViewById(R.id.btn_store2);
        Button btn_cafe2 = findViewById(R.id.btn_cafe2);

        Button button_back = findViewById(R.id.button_back);

        ImageButton bus_pos1 = findViewById(R.id.bus_pos1);
        ImageButton bus_pos2 = findViewById(R.id.bus_pos2);
        ImageButton store_pos1 = findViewById(R.id.store_pos1);
        ImageButton store_pos2 = findViewById(R.id.store_pos2);
        ImageButton build_uit = findViewById(R.id.build_uit);
        ImageButton build_sple = findViewById(R.id.build_sple);
        ImageButton cafe_pos1 = findViewById(R.id.cafe_pos1);
        ImageButton cafe_pos2 = findViewById(R.id.cafe_pos2);

        final ConstraintLayout bus_pos_layout = findViewById(R.id.bus_pos_layout);
        final ConstraintLayout build_pos_layout = findViewById(R.id.build_pos_layout);
        final ConstraintLayout store_pos_layout = findViewById(R.id.store_pos_layout);
        final ConstraintLayout cafe_pos_layout = findViewById(R.id.cafe_pos_layout);

        final ScrollView info_table = findViewById(R.id.info_table);

        btn_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                build_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                bus_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.VISIBLE);
            }
        });

        btn_bus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                build_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                bus_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_build2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_store2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.VISIBLE);
            }
        });
        btn_cafe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus_pos_layout.setVisibility(View.INVISIBLE);
                build_pos_layout.setVisibility(View.INVISIBLE);
                store_pos_layout.setVisibility(View.INVISIBLE);
                cafe_pos_layout.setVisibility(View.VISIBLE);
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_table.setVisibility(View.INVISIBLE);
            }
        });

        store_pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_table.setVisibility(View.VISIBLE);

                mArrayList.clear();


                MapActivity.GetData task = new MapActivity.GetData();
                task.execute( "세븐일레븐", null);
            }
        });
        store_pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_table.setVisibility(View.VISIBLE);

                mArrayList.clear();


                MapActivity.GetData task = new MapActivity.GetData();
                task.execute( "CU", null);
            }
        });
        cafe_pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_table.setVisibility(View.VISIBLE);

                mArrayList.clear();


                MapActivity.GetData task = new MapActivity.GetData();
                task.execute( "Herrys", null);
            }
        });
        cafe_pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_table.setVisibility(View.VISIBLE);

                mArrayList.clear();


                MapActivity.GetData task = new MapActivity.GetData();
                task.execute( "Cafe Meal", null);
            }
        });
        bus_pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                intent.putExtra("src", "https://m.search.naver.com/search.naver?query=%EC%82%AC%EC%83%81+5-1&where=m&sm=mtp_hty.top");
                startActivity(intent);
            }
        });
        bus_pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                intent.putExtra("src", "https://m.search.naver.com/search.naver?sm=mtp_hty.top&where=m&query=%EC%82%AC%EC%83%81+5-2");
                startActivity(intent);
            }
        });

        build_uit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UitActivity.class);
                startActivity(intent);
            }
        });

        mArrayList = new ArrayList<>();
    }

    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MapActivity.this, "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            //mTextViewResult.setText(result);
            Log.d(TAG, "response - " + result);

            if (result == null){

                //mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String searchKeyword1 = params[0];
            String searchKeyword2 = params[1];

            String serverURL = "http://1.176.33.31/query.php"; //서버 주소
            String postParameters = "country=" + searchKeyword1 + "&name=" + searchKeyword2;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            adapter = new InfoAdapter();

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getString(TAG_ID);
                String name = item.getString(TAG_NAME);
                String address = item.getString(TAG_ADDRESS);

                textView1.setText(name);
                textView2.setText(address);

            }


        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }
}
