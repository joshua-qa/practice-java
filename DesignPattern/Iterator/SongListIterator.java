package Joshua.DesignPattern.Iterator;

/**
 * Created by Joshua on 2017-04-17.
 */
public class SongListIterator implements Iterator {
    private SongList songList;
    private int index;

    public SongListIterator(SongList songList) {
        this.songList = songList;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < songList.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Song song = songList.getSongAt(index);
        index++;
        return song;
    }
}
