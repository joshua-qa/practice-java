package Joshua.DesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 2017-04-17.
 */
public class SongList implements Aggregate {
    private List<Song> songs;
    private int last = 0;

    public SongList() {
        // 연습문제 1-1 : 배열대신 ArrayList를 사용해서 크기를 초과해도 추가할 수 있도록 구현
        this.songs = new ArrayList<>();
    }

    public Song getSongAt(int index) {
        return songs.get(index);
    }

    public void appendSong(Song song) {
        this.songs.add(song);
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator iterator() {
        return new SongListIterator(this);
    }
}
