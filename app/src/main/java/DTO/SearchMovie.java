package DTO;

/**
 * Created by omoradzadeh on 2/1/2018.
 */

public class SearchMovie {
    public double getScore() {
        return this.score;
    }
    public void setScore(double average) {
        this.score = score;
    }
    double score;

    public Show getShow() {
        return this.show;
    }
    public void setShow(Show movie) {
        this.show = movie;
    }
    Show show;

}
