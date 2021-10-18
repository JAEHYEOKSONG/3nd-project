package org.techtown.dongseomap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


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


public class SearchActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //mTextViewResult = (TextView)findViewById(R.id.textView_main_result);
        recyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        mEditTextSearchKeyword1 = (EditText) findViewById(R.id.editText_main_searchKeyword1);
        //mEditTextSearchKeyword2 = (EditText) findViewById(R.id.editText_main_searchKeyword2);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        Button button_search = (Button) findViewById(R.id.button_main_search);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mArrayList.clear();


                GetData task = new GetData();
                //task.execute( mEditTextSearchKeyword1.getText().toString(), mEditTextSearchKeyword2.getText().toString());
                task.execute( mEditTextSearchKeyword1.getText().toString(), null);
            }
        });


        mArrayList = new ArrayList<>();

        Intent intent = getIntent();
        processIntent(intent);


    }

    private void processIntent(Intent intent){
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            if(intent != null){
                mEditTextSearchKeyword1.setText(bundle.getString("search"));
            }
            mArrayList.clear();


            GetData task = new GetData();
            //task.execute( mEditTextSearchKeyword1.getText().toString(), mEditTextSearchKeyword2.getText().toString());
            task.execute( mEditTextSearchKeyword1.getText().toString(), null);
        }
    }


    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SearchActivity.this, "Please Wait", null, true, true);
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

/*                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put(TAG_ID, id);
                hashMap.put(TAG_NAME, name);
                hashMap.put(TAG_ADDRESS, address);

                mArrayList.add(hashMap);*/
                adapter.addItem(new Searchinfo(name,address));

            }

            /*ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, mArrayList, R.layout.item_list,
                    new String[]{TAG_ID,TAG_NAME, TAG_ADDRESS},
                    new int[]{R.id.textView_list_id, R.id.textView_list_name, R.id.textView_list_address}
            );*/
            recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(new OnPersonItemClickListener() {
                @Override
                public void onItemClick(InfoAdapter.ViewHolder holder, View view, int position) {
                    Searchinfo item = adapter.getItem(position);
                    //Toast.makeText(getApplicationContext(),"아이템선택됨: "+item.getName(),Toast.LENGTH_LONG).show();
                    if(item.getMobile().equals("Main2Activity.class"))
                    {
                        /*Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(intent);*/
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                        intent.putExtra("name", item.getName());
                        intent.putExtra("mobile", item.getMobile());
                        startActivity(intent);
                    }
                }
            });


        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}