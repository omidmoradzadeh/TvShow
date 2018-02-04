package com.iomdroid.tvshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import Component.ImageCache.ImageLoader;
import config.application;
import DTO.Show;

public class ShowDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        try {
            //get selected index from content activity
            int selectedIndex = getIntent().getIntExtra("selectedIndex", 0);
            application applicationConfig = (application) getApplication();

            //get json from application
            List<Show> shows = applicationConfig.getShows();

            //define varibale for elements
            ImageView ivShowDetail = (ImageView) findViewById(R.id.ivShowDetail);
            ImageView ivShowDetailBack = (ImageView) findViewById(R.id.ivShowDetailBack);
            TextView tvShowDetailName = (TextView) findViewById(R.id.tvShowDetailName);
            TextView tvShowDetailOthers = (TextView) findViewById(R.id.tvShowDetailOthers);
            TextView tvShowDetailDecription = (TextView) findViewById(R.id.tvShowDetailDecription);

            //load data into elements
            ImageLoader imageLoader = new ImageLoader(getApplicationContext());
            imageLoader.DisplayImage(shows.get(selectedIndex).getImage().getOriginal(), ivShowDetail);
            tvShowDetailName.setText(shows.get(selectedIndex).getName());
            tvShowDetailOthers.setText(shows.get(selectedIndex).getPremiered() + " - "
                    + shows.get(selectedIndex).getRuntime() + " min - "
                    + shows.get(selectedIndex).getRating().getAverage() + "/10");
            tvShowDetailDecription.setText(Html.fromHtml("<div style='text-align: justify;'>" +
                    shows.get(selectedIndex).getSummary() + "</div>"));
            ivShowDetailBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception ex) {
            TastyToast.makeText(this, "ٍError occurred in processing data...", TastyToast.LENGTH_LONG, TastyToast.ERROR);
            finish();
        }
    }
}
