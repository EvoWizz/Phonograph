package com.kabouzeid.gramophone.model.smartplaylist;

import android.content.Context;

import com.kabouzeid.gramophone.App;
import com.kabouzeid.gramophone.R;
import com.kabouzeid.gramophone.loader.TopAndRecentlyPlayedTracksLoader;
import com.kabouzeid.gramophone.model.DataBaseChangedEvent;
import com.kabouzeid.gramophone.model.Song;
import com.kabouzeid.gramophone.provider.SongPlayCountStore;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class MyTopTracksPlaylist extends AbsSmartPlaylist {

    public MyTopTracksPlaylist(Context context) {
        super(context.getString(R.string.my_top_tracks), R.drawable.ic_trending_up_white_24dp);
    }

    @Override
    public ArrayList<Song> getSongs(Context context) {
        return TopAndRecentlyPlayedTracksLoader.getTopTracks(context);
    }

    @Override
    public void clear(Context context) {
        SongPlayCountStore.getInstance(context).clear();
        App.bus.post(new DataBaseChangedEvent(DataBaseChangedEvent.PLAYLISTS_CHANGED));
    }
}