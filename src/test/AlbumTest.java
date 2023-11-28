import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumTest {

    private Album album;

    @BeforeEach
    public void setUp() {
        album = new Album("Stormbringer", "Deep Purple");
    }

    @Test
    public void testAddSong() {
        assertTrue(album.addSong("Stormbringer", 4.6));
        assertTrue(album.addSong("Love don't mean a thing", 4.22));

        // Adding a duplicate song should return false
        assertFalse(album.addSong("Stormbringer", 4.6));
    }

    @Test
    public void testAddToPlayListByTrackNumber() {
        assertTrue(album.addSong("Stormbringer", 4.6));
        assertTrue(album.addSong("Love don't mean a thing", 4.22));

        LinkedList<Song> playlist = new LinkedList<>();
        assertTrue(album.addToPlayList(1, playlist));
        assertEquals("Stormbringer", playlist.getFirst().getTitle());

        assertTrue(album.addToPlayList(2, playlist));
        assertEquals("Love don't mean a thing", playlist.getLast().getTitle());


    }

    @Test
    public void testAddToPlayListByTitle() {
        assertTrue(album.addSong("Stormbringer", 4.6));
        assertTrue(album.addSong("Love don't mean a thing", 4.22));

        LinkedList<Song> playlist = new LinkedList<>();
        assertTrue(album.addToPlayList("Stormbringer", playlist));
        assertEquals("Stormbringer", playlist.getFirst().getTitle());

        assertTrue(album.addToPlayList("Love don't mean a thing", playlist));
        assertEquals("Love don't mean a thing", playlist.getLast().getTitle());

        assertFalse(album.addToPlayList("Holy man", playlist));
    }
}
