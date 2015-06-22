package br.org.eldorado.labmov.everydayamovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import br.org.eldorado.labmov.everydayamovie.movie.Movie;

/**
 * Created by gustavo.freitas on 13/04/15.
 */
public class EverdayAMovieListAdapter extends ArrayAdapter<Movie>  {

    public EverdayAMovieListAdapter(Context context, int textViewResourceId,
                              List<Movie> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public Movie getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(position == 0){
            convertView = LayoutInflater.from(getContext()).inflate
                    (R.layout.fragment_every_day_a_movie_today_item_list, parent, false);
            viewHolder = new TodayItemViewHolder(convertView);
        }else{
            convertView = LayoutInflater.from(getContext()).inflate
                    (R.layout.fragment_every_day_a_movie_item_list, parent, false);
            viewHolder = new ItemViewHolder(convertView);
        }

        Movie movie = getItem(position);

        viewHolder.sMovieImageView.setBackgroundResource(movie.getImage());
        viewHolder.sMovieNameTextView.setText(movie.getName());
        viewHolder.sClassificationTextView.setText(movie.getClassification().toString());
        viewHolder.sDurationTextView.setText(movie.getDuration()+" MIN");
        viewHolder.sDataShowTextView.setText(movie.getShowDate().toString());
        viewHolder.sGenresTextView.setText(movie.getGenresString());

        convertView.setTag(viewHolder);
        return convertView;

    }


    /**
     * Cache of the children views for a forecast list item.
     */
    public abstract static class ViewHolder {
        public final ImageView sMovieImageView;
        public final TextView sMovieNameTextView;
        public final TextView sClassificationTextView;
        public final TextView sDataShowTextView;
        public final TextView sDurationTextView;
        public final TextView sGenresTextView;

        protected ViewHolder(ImageView movieImageView, TextView movieNameTextView, TextView classificationTextView,
                             TextView dataShowTextView, TextView durationTextView, TextView genresTextView) {

            sMovieImageView = movieImageView;
            sMovieNameTextView = movieNameTextView;
            sClassificationTextView = classificationTextView;
            sDataShowTextView = dataShowTextView;
            sDurationTextView = durationTextView;
            sGenresTextView = genresTextView;

        }
    }

    public static class ItemViewHolder extends ViewHolder{

        public ItemViewHolder(View view) {
            super((ImageView) view.findViewById(R.id.fragmentEverydayAMovieItemListImageMovieId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieItemListNameId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieItemListClassificationId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieItemListDateId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieItemListDurationId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieItemListGenreId));
        }
    }

    public static class TodayItemViewHolder extends ViewHolder {

        public TodayItemViewHolder(View view) {
            super((ImageView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListImageMovieId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListNameId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListClassificationId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListTodayId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListDurationId),
            (TextView) view.findViewById(R.id.fragmentEverydayAMovieTodayItemListGenreId));
        }
    }
}
