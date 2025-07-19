package com.example.video;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
// Remove this import as it's not directly used in the constructor
// import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List; // Import List

public class AdaptadorVideos extends ArrayAdapter<Videos> {
    // Change the type of 'datos' from ListView to List<Videos>
    public AdaptadorVideos(Context context, List<Videos> datos) {
        super(context, R.layout.lytitemv, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lytitemv, null);

        Videos videos = getItem(position);
        TextView lblCategoria = item.findViewById(R.id.lblCategoria);
        lblCategoria.setText(
                Html.fromHtml(videos.getCategoria(), Html.FROM_HTML_MODE_LEGACY),
                TextView.BufferType.SPANNABLE
        );


        TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblSubtitulo.setText(getItem(position).getTitulo());


        TextView lblSubtitulo2 = (TextView)item.findViewById(R.id.publicacion);
        lblSubtitulo2.setText(
                "Publicada el: " + getItem(position).getFecha()
        );


        TextView lblSubtitulo3 = (TextView)item.findViewById(R.id.tvUrl);
        lblSubtitulo3.setText(getItem(position).getUrlnoticia());


        ImageView imageView = (ImageView)item.findViewById(R.id.imgNt);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);

        return(item);
    }
}
