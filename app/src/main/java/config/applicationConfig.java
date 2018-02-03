package config;

import android.app.Application;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

import DTO.Show;



public class applicationConfig extends Application {

    ArrayList<Show> showArrayList = new ArrayList<Show>();
    public void setShows(ArrayList<Show> shows) {
        this.showArrayList = shows;
    }
    public ArrayList<Show> getShows() {
        return this.showArrayList;
    }

    ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
    public void setImageViews(ArrayList<ImageView> imageViews) {
        this.imageViews = imageViews;
    }
    public ArrayList<ImageView> getImageViews() {
        return this.imageViews;
    }
}
