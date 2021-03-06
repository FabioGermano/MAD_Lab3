package it.polito.mad_lab3.data.restaurant;

/**
 * Created by f.germano on 25/04/2016.
 */
public class Review {

    private String userName;
    private String thumbPath;
    private float rank;
    private String date;
    private String comment;

    public Review(String userName, String thumbPath, float rank, String date, String comment) {
        this.userName = userName;
        this.thumbPath = thumbPath;
        this.rank = rank;
        this.date = date;
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
