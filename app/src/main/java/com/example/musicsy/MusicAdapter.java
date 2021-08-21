package com.example.musicsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private final Context context;
    private OnItemClickListener mOnItemClickListener;

    public MusicAdapter(Context context, ArrayList<SongInfo> songs) {
        this.context = context;
        this._songs = songs;
    }
    public interface OnItemClickListener {
        void onItemClick(Button b ,View view, SongInfo obj, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SongInfo s = _songs.get(position);
        holder.tvSongName.setText(_songs.get(position).getSongname());
        holder.tvSongArtist.setText(_songs.get(position).getArtistname());
        holder.tvSongAlbum.setText(_songs.get(position).getAlbumname());
        holder.play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder.play_btn,v, s, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongName,tvSongArtist, tvSongAlbum;
        Button play_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);
            tvSongArtist = (TextView) itemView.findViewById(R.id.tvArtistName);
            tvSongAlbum = (TextView) itemView.findViewById(R.id.tvAlbumName);
            play_btn = (Button) itemView.findViewById(R.id.btnPlay);
        }
    }
}
