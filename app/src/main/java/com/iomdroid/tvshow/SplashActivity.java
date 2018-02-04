package com.iomdroid.tvshow;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import config.application;
import DTO.SearchMovie;
import DTO.Show;

public class SplashActivity extends AppCompatActivity {

    ArrayList<Show> showArrayList;
    ArrayList<Bitmap> imageArrayList;
    ArrayList<ImageView> imageViews;
    SearchMovie[] searchMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        try {
            //check access to storage
            ActivityCompat.requestPermissions(SplashActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } catch (Exception ex) {

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    try {
                        String result = new GetShowList(this).execute("http://api.tvmaze.com/search/shows?q=father").get();
                        if (!result.isEmpty())
                            finish();
                    } catch (InterruptedException e) {
                        TastyToast.makeText(this, "ٍError occurred in connection ...", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        TastyToast.makeText(this, "ٍError occurred in connection ...", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        e.printStackTrace();
                    }
                } else {
                    TastyToast.makeText(this, "ٍPermission denied to read your External storage", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    finish();
                }
                return;
            }
        }
    }

    //Get Json Data from Api
    public class GetShowList extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        ArrayList<Show> showArrayList = new ArrayList<Show>();
        Context context;
        boolean isSuccess = true;
        String errorMessage = "";


        public GetShowList(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String stringUrl = params[0];
            String result = "";

            try {
                Gson gson = new Gson();
                URL myUrl = new URL(stringUrl);
                //Make request to api
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();
                int status = connection.getResponseCode();
                if (status != 200) {
                    errorMessage = "ٍMake sure fro your connection";
                    isSuccess = false;
                } else {
                    InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                    BufferedReader reader = new BufferedReader(streamReader);
                    try {
                        //cast json to object
                        searchMovie = gson.fromJson(reader, SearchMovie[].class);
                    } catch (Exception ex) {
                        isSuccess = false;
                        errorMessage = "ٍError while processing data...";
                    } finally {
                        reader.close();
                        reader.close();
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (ProtocolException e) {
                isSuccess = false;
                errorMessage = "ٍError while processing data...";
                e.printStackTrace();
            } catch (MalformedURLException e) {
                isSuccess = false;
                errorMessage = "ٍError while processing data...";
                e.printStackTrace();
            } catch (IOException e) {
                isSuccess = false;
                errorMessage = "ٍError while processing data...";
                e.printStackTrace();
            }

            return errorMessage;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (isSuccess) {
                imageViews = new ArrayList<ImageView>();
                List<String> urlList = new ArrayList<>();
                for (int i = 0; i < searchMovie.length; i++) {
                    showArrayList.add(searchMovie[i].getShow());
                }
                //call content activity
                Intent intent = new Intent(context, ContentActivity.class);
                application app = (application) getApplication();
                app.setShows(showArrayList);
                startActivity(intent);
            } else
                TastyToast.makeText(context, errorMessage, TastyToast.LENGTH_LONG, TastyToast.ERROR);
        }
    }


}

