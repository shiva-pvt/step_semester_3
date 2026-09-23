package week7.assignment;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[capacity];
        count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count++] = title;
        }
    }

    /** Returns a defensive copy that cannot modify the playlist. */
    public String[] getSongs() {
        String[] copy = new String[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return copy;
    }

    public int getSongCount() {
        return count;
    }
}
