package br.org.eldorado.labmov.everydayamovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.org.eldorado.labmov.everydayamovie.mock.GenerateMoviesData;
import br.org.eldorado.labmov.everydayamovie.movie.Movie;

public class DetailsActivity extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_details, container, false);

            Bundle extras = getActivity().getIntent().getExtras();

            if(extras == null){
                extras = getArguments();
            }

            GenerateMoviesData generator = new GenerateMoviesData(getActivity());

            Movie movie = null;

            if(extras == null){
                movie = generator.generateById(0);
            }else {
                movie = generator.generateById(extras.getInt("ID"));
            }


            if(movie != null) {
                getActivity().setTitle(movie.getShowDate());

                TextView movieNameTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailNameId);
                movieNameTextView.setText(movie.getName());

                ImageView movieImageView = (ImageView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailImageId);
                movieImageView.setImageResource(movie.getImage());

                TextView classificationTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieItemDetailClassificationId);
                classificationTextView.setText(movie.getClassification().toString());

                TextView durationTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailListDurationId);
                durationTextView.setText(movie.getDuration() + " MIN");

                TextView genresTextView = (TextView) rootView.findViewById(R.id.fragmentEverDayAMovieDetailGenreId);
                genresTextView.setText(movie.getGenresString());

                TextView directorsTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailDirectorId);
                directorsTextView.setText(movie.getDirectorsNamesString());

                TextView writersTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailWritersId);
                writersTextView.setText(movie.getWritersNameString());

                TextView resumeTextView = (TextView) rootView.findViewById(R.id.fragmentEverydayAMovieDetailResumeId);
                resumeTextView.setText(movie.getResume());
            }

            return rootView;

        }
    }
}
