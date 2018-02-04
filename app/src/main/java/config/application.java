package config;

import android.app.Application;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

import DTO.Show;



public class application extends Application {

    ArrayList<Show> showArrayList = new ArrayList<Show>();

    public void setShows(ArrayList<Show> shows) {
        this.showArrayList = shows;
    }

    public ArrayList<Show> getShows() {
        return this.showArrayList;
    }
}
