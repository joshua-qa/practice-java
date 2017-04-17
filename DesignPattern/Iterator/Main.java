package Joshua.DesignPattern.Iterator;

/**
 * Created by Joshua on 2017-04-17.
 */
public class Main {
    public static void main(String[] args) {
        SongList songList = new SongList();

        songList.appendSong(new Song("Neu", 49));
        songList.appendSong(new Song("Silent", 50));
        songList.appendSong(new Song("Triple Counter", 49));
        songList.appendSong(new Song("CURUS", 46));
        songList.appendSong(new Song("The Least 100sec", 48));
        songList.appendSong(new Song("Nobunaga", 48));

        Iterator it = songList.iterator();
        while (it.hasNext()) {
            Song song = (Song)it.next();
            System.out.println(song.getName() + " " + song.getLevel());
        }
    }
}
