package br.org.eldorado.labmov.everydayamovie;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.org.eldorado.labmov.everydayamovie.mock.GenerateMoviesData;
import br.org.eldorado.labmov.everydayamovie.movie.Movie;


public class EveryDayAMovie extends AppCompatActivity {

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_every_day_a_movie);

        if(findViewById(R.id.fragmentEverydayADetailMovies) != null){

            mTwoPane = true;

             if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentEverydayADetailMovies,
                                new DetailsActivity.PlaceholderFragment(), "DFTAG")
                        .commit();


            }

        }else{
            mTwoPane = false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_every_day_a_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public boolean isTwoPane(){
        return mTwoPane;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_every_day_a_movie, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.fragmentEveryDayListId);

            GenerateMoviesData generator = new GenerateMoviesData(getActivity());

            final List<Movie> movies = generator.generate();

            EverdayAMovieListAdapter adapter =
                    new EverdayAMovieListAdapter(getActivity().getApplicationContext(), 0, movies);

            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Bundle args = new Bundle();
                    args.putInt("ID", position);

                    if(((EveryDayAMovie) getActivity()).isTwoPane()){
                        DetailsActivity.PlaceholderFragment fragment = new DetailsActivity.PlaceholderFragment();
                        fragment.setArguments(args);

                        ((EveryDayAMovie) getActivity()).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentEverydayADetailMovies,
                                        fragment, "DFTAG")
                                .commit();
                    }else {

                        Intent i = new Intent(getActivity(), DetailsActivity.class);
                        i.putExtras(args);
                        startActivity(i);
                    }
                }
            });

            return rootView;
        }
    }
}
