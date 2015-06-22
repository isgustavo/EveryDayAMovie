package br.org.eldorado.labmov.everydayamovie.mock;

import android.content.Context;
import android.graphics.drawable.Drawable;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.org.eldorado.labmov.everydayamovie.R;
import br.org.eldorado.labmov.everydayamovie.movie.Movie;

/**
 * Created by gustavo.freitas on 08/04/15.
 */
public class GenerateMoviesData {

    private int MAX = 10;

    private Context mContext;

    private Date mToday;
    private Calendar mCalendar;

    public GenerateMoviesData(Context context) {

        mContext = context;

        this.mToday = new Date();
        this.mCalendar = mCalendar.getInstance();


    }

    public Movie generateById(Integer id) {

        Movie movie = null;
        String name = null;
        String synopsis = null;
        Integer imageIntResource = null;

        this.mCalendar.setTime(mToday);
        this.mCalendar.add(Calendar.DATE, id - 1);

        switch(id) {

            case 0:

                name = mContext.getString(R.string.avangers);
                synopsis = mContext.getString(R.string.synopsis_avangers);

                imageIntResource = R.drawable.avengers;

                movie = new Movie(name,
                        "TODAY, " + getMonthOfYear(mCalendar.get(Calendar.MONTH)) + " " + mCalendar.get(Calendar.DAY_OF_MONTH),
                        Movie.Classification.PG13,
                        142,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.ACTION, Movie.Genre.ADVENTURE, Movie.Genre.SCI_FI);
                movie.setDirectorsNames("Joss Whedon");
                movie.setWritersName("Joss Whedon", "Stan Lee", "Jack Kirby");

                break;

            case 1:

                name = mContext.getString(R.string.whiplash);
                synopsis = mContext.getString(R.string.synopsis_whiplash);
                imageIntResource = R.drawable.whiplash;

                movie = new Movie(name,
                                "TOMORROW",
                                Movie.Classification.PG13,
                                107,
                                synopsis,
                                imageIntResource);

                movie.setGenres(Movie.Genre.DRAMA, Movie.Genre.MUSIC);
                movie.setDirectorsNames("Damien Chazelle");
                movie.setWritersName("Damien Chazelle");

                break;

            case 2:

                name = mContext.getString(R.string.birdman);
                synopsis = mContext.getString(R.string.synopsis_birdman);
                imageIntResource = R.drawable.birdman;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_WEEK)),
                        Movie.Classification.PG16,
                        119,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.COMEDY, Movie.Genre.DRAMA);
                movie.setDirectorsNames("Alejandro G. Inárritu");
                movie.setWritersName("Alejandro G. Inárritu", "Nocolás Giacobone", "Alexander Dinelaris", "Armando Bo", "Raymond Carver");

                break;

            case 3:

                name = mContext.getString(R.string.start_wars_v);
                synopsis = mContext.getString(R.string.synopsis_start_wars_v);
                imageIntResource = R.drawable.star_wars_v;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_WEEK)),
                        Movie.Classification.FREE,
                        124,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.ACTION, Movie.Genre.ADVENTURE, Movie.Genre.FANTASY);
                movie.setDirectorsNames("Irvin Kershner");
                movie.setWritersName("George Lucas", "Leigh Brackett", "Lawrence Kasdan");

                break;

            case 4:

                name = mContext.getString(R.string.jurassic_park);
                synopsis = mContext.getString(R.string.synopsis_jurassic_park);
                imageIntResource = R.drawable.jurassic_park;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_WEEK)),
                        Movie.Classification.FREE,
                        127,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.ACTION, Movie.Genre.SCI_FI, Movie.Genre.THRILLER);
                movie.setDirectorsNames("Steven Spielberg");
                movie.setWritersName("Michael Crichton", "David Koepp");

                break;

            case 5:

                name = mContext.getString(R.string.fight_club);
                synopsis = mContext.getString(R.string.synopsis_fight_club);
                imageIntResource = R.drawable.fight_club;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_WEEK)),
                        Movie.Classification.PGR,
                        139,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.DRAMA);
                movie.setDirectorsNames("David Fincher");
                movie.setWritersName("Chuck Palahniuk");

                break;
            case 6:

                name = mContext.getString(R.string.pacific_rim);
                synopsis = mContext.getString(R.string.synopsis_pacific_rim);
                imageIntResource = R.drawable.pacific;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_WEEK)),
                        Movie.Classification.PG13,
                        132,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.ACTION, Movie.Genre.SCI_FI, Movie.Genre.ADVENTURE);
                movie.setDirectorsNames("Guillermo del Toro");
                movie.setWritersName("Travis Beacham", " Guillermo del Toro");

                break;

            case 7:

                name = mContext.getString(R.string.hangover_i);
                synopsis = mContext.getString(R.string.synopsis_hangover_i);
                imageIntResource = R.drawable.hangover_i;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_MONTH)) + getMonthOfYear(mCalendar.get(Calendar.MONTH)),
                        Movie.Classification.PG13, 100,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.COMEDY);
                movie.setDirectorsNames("Todd Phillips");
                movie.setWritersName("Jon Lucas", "Scott Moore");

                break;

            case 8:

                name = mContext.getString(R.string.hangover_ii);
                synopsis = mContext.getString(R.string.synopsis_hangover_ii);
                imageIntResource = R.drawable.hangover_ii;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_MONTH)) + getMonthOfYear(mCalendar.get(Calendar.MONTH)),
                        Movie.Classification.PG16,
                        102,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.COMEDY);
                movie.setDirectorsNames("Todd Phillips");
                movie.setWritersName("Craig Mazin", "Scot Armstrong", "Todd Phillips");

                break;

            case 9:

                name = mContext.getString(R.string.hangover_iii);
                synopsis = mContext.getString(R.string.synopsis_hangover_iii);
                imageIntResource = R.drawable.hangover_iii;

                movie = new Movie(name,
                        getDayOfWeek(mCalendar.get(Calendar.DAY_OF_MONTH)) + getMonthOfYear(mCalendar.get(Calendar.MONTH)),
                        Movie.Classification.PG13,
                        100,
                        synopsis,
                        imageIntResource);

                movie.setGenres(Movie.Genre.COMEDY);
                movie.setDirectorsNames("Todd Phillips");
                movie.setWritersName("Todd Phillips", "Craig Mazin");

                break;

        }

        return movie;

    }

    public List<Movie> generate() {

        List<Movie> movies = new ArrayList<Movie>();

        for(int x = 0; x <= MAX - 1; x ++) {

            movies.add(generateById(x));

        }

        return movies;
    }

    private static String getDayOfWeek(int day) {
        switch (day) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
            default:
                return day+", ";
        }
    }

    private static String getMonthOfYear(int month) {
        switch (month) {
            case 0:
                return "JANUARY";
            case 1:
                return "FEBRUARY";
            case 2:
                return "MARCH";
            case 3:
                return "APRIL";
            case 4:
                return "MAY";
            case 5:
                return "JUNE";
            case 6:
                return "JULY";
            case 7:
                return "AUGUST";
            case 8:
                return "SEPTEMBER";
            case 9:
                return "OCTOBER";
            case 10:
                return "NOVEMBER";
            case 11:
                return "DECEMBER";
            default:
                return "";
        }
    }
}


