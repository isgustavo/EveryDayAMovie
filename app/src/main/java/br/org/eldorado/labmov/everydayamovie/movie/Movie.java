package br.org.eldorado.labmov.everydayamovie.movie;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gustavo.freitas on 08/04/15.
 */
public class Movie {

    public enum Classification{
        FREE("FREE"), PG13("PG-13"), PG16("PG-16"), PGR("PG-R");

        private final String classification;

        Classification(String classification){
            this.classification = classification;
        }

        @Override
        public String toString() {
            return this.classification;
        }
    }

    public enum Genre{
        ACTION, ADVENTURE,COMEDY, DRAMA, FANTASY, MUSIC, ROMANCE, SCI_FI, THRILLER ;
    }

    private String mName;
    private String mWeekDateString;
    private Classification mClassification;
    private int mDuration;
    private List<Genre> mGenres;
    private List<String> mDirectorsNames;
    private List<String> mWritersName;
    private String mResume;

    private Integer mImage;

    public Movie(String name, String showDate, Classification classification, int duration,
                 List<Genre> genres, List<String> directorsNames, List<String> writesName,
                 String resume, Integer image){

        this.mName = name;
        this.mWeekDateString = showDate;
        this.mClassification = classification;
        this.mDuration = duration;
        this.mGenres = genres;
        this.mDirectorsNames = directorsNames;
        this.mWritersName = writesName;
        this.mResume = resume;
        this.mImage = image;
    }

    public Movie(String name, String showDate, Classification classification, int duration,
                 String resume, Integer image) {
        this(name, showDate, classification, duration, new ArrayList<Genre>(), new ArrayList<String>(),
                new ArrayList<String>(), resume, image);

    }

    public String getName() {
        return mName;
    }

    public String getShowDate() {
        return mWeekDateString;
    }

    public Classification getClassification() {
        return mClassification;
    }

    public int getDuration() {
        return mDuration;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public String getGenresString(){

        StringBuilder names = new StringBuilder();
        for(Genre genre : mGenres){
            names.append(genre.toString());
            names.append(",");
        }

        return names.substring(0, names.toString().length()-1);
    }

    public void setGenres(Genre... genres){
        this.mGenres = Arrays.asList(genres);
    }

    public List<String> getDirectorsNames() {
        return mDirectorsNames;
    }

    public String getDirectorsNamesString(){

        StringBuilder names = new StringBuilder();
        for(String director : mDirectorsNames){
            names.append(director);
            names.append(",");
        }

        return names.substring(0, names.toString().length()-1);
    }

    public void setDirectorsNames(String... names){
        this.mDirectorsNames = Arrays.asList(names);
    }

    public List<String> getWritersName() {
        return mWritersName;
    }

    public String getWritersNameString(){

        StringBuilder names = new StringBuilder();
        for(String writer : mWritersName){
            names.append(writer);
            names.append(",");
        }

        return names.substring(0, names.toString().length()-1);
    }

    public void setWritersName(String... names){
        this.mWritersName = Arrays.asList(names);
    }

    public String getResume() {
        return mResume;
    }

    public Integer getImage() {
        return mImage;
    }

}



