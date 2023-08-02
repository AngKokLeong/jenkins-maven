package com.sddevops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SongCollectionTest {
    
    private SongCollection songCollection;
    private Song s1; 
    private Song s2; 
    private Song s3;
    private Song s4;

    private final int SONG_COLLECTION_SIZE = 4;

    @BeforeEach
    void setUp() throws Exception{

        songCollection = new SongCollection();
        s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
        s3 = new Song("003", "MONTERO", "Lil Nas", 2.3);
        s4 = new Song("004", "bad guy", "billie eilish", 3.14);

        songCollection.addSong(s1);
        songCollection.addSong(s2);
        songCollection.addSong(s3);
        songCollection.addSong(s4);

    }



    @Test
    void testAddSong(){
        List<Song> testSongCollection = songCollection.getSongs();

        Song testSong = new Song("005", "TEST", "TEST", 9.00);
        
        assertEquals(testSongCollection.size(), SONG_COLLECTION_SIZE);
        
        songCollection.addSong(testSong);
        
        assertTrue(songCollection.getSongs().size() == SONG_COLLECTION_SIZE + 1);
    }

    @Test 
    void testAddSongValidateSongCapacity(){

        int CURRENT_SONG_COLLECTION_CAPACITY = 3;

        SongCollection songCollection = new SongCollection(CURRENT_SONG_COLLECTION_CAPACITY);

        Song firstSong = new Song("005", "TEST", "TEST", 9.00);
        Song secondSong = new Song("006", "TEST", "TEST", 9.00);
        Song thirdSong = new Song("007", "TEST", "TEST", 9.00);


        songCollection.addSong(firstSong);
        songCollection.addSong(secondSong);
        songCollection.addSong(thirdSong);
        
        assertEquals(songCollection.getSongs().size(), CURRENT_SONG_COLLECTION_CAPACITY);

        Song fourthSong = new Song("008", "TEST", "TEST", 9.00);

        songCollection.addSong(fourthSong);
        
        assertNotEquals(songCollection.getSongs().size(), CURRENT_SONG_COLLECTION_CAPACITY + 1);
    }

    @Test
    void testGetSongs(){
        List<Song> testSongList = songCollection.getSongs();

        assertTrue(testSongList.size() > 0);
        assertEquals(testSongList.size(), SONG_COLLECTION_SIZE);
    }

    @Test
    void testGetSongsWithZeroCapacity(){
        SongCollection testSongCollection = new SongCollection(0);

        List<Song> testSongList = testSongCollection.getSongs();

        assertTrue(testSongList.size() == 0);

    }

    @Test
    void testFindSongsById(){
        Song song = songCollection.findSongsById("001");

        assertNotEquals(song, null);
    }

    @Test
    void testFindSongsByIdWithZeroCapacitySongCollection(){
        SongCollection testSongCollection = new SongCollection(0);

        Song song = testSongCollection.findSongsById("001");

        assertEquals(song, null);
    }

    @Test
    void testFindSongsByTitle(){
        Song song = songCollection.findSongByTitle("Peaches");

        assertNotEquals(song, null);
    }

    @Test
    void testFindSongsByTitleWithNullValue(){
        Song song = songCollection.findSongByTitle(null);

        assertEquals(song, null);
    }

    @Test
    void testFindSongsByTitleWithWrongMatchingTitle(){
        Song song = songCollection.findSongByTitle("peaches");

        assertEquals(song, null);
    }

    @Test
    void testSortSongsByTitle(){
        List<Song> songList = songCollection.sortSongsByTitle();
        
        List<Song> testSongList = new ArrayList<Song>();

        Song s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        Song s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
        Song s3 = new Song("003", "MONTERO", "Lil Nas", 2.3);
        Song s4 = new Song("004", "bad guy", "billie eilish", 3.14);

        testSongList.add(s3);
        testSongList.add(s2);
        testSongList.add(s4);
        testSongList.add(s1);

        assertEquals(songList, testSongList);
    }

    @Test
    void testSortSongsBySongLength(){
        List<Song> songList = songCollection.sortSongsBySongLength();
        List<Song> testSongList = new ArrayList<Song>();

        Song s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        Song s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
        Song s3 = new Song("003", "MONTERO", "Lil Nas", 2.3);
        Song s4 = new Song("004", "bad guy", "billie eilish", 3.14);

        testSongList.add(s1);
        testSongList.add(s2);
        testSongList.add(s4);
        testSongList.add(s3);

        assertEquals(songList, testSongList);
    }

}