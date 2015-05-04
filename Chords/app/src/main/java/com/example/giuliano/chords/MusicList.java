package com.example.giuliano.chords;

/**
 * Created by Giuliano on 27/03/2015.
 */
import java.util.List;
import java.util.LinkedList;

public class MusicList {

    List<Music> musics = new LinkedList<Music>();

    public MusicList(){
        initializeMusics();
    }

    public Music searchMusic(Specification spec){

        List<Music> found = new LinkedList<Music>();
        for(Music music:musics){
            if(music.getSpec().matches(spec)) return music;
        }
        return null;

    }

    public void initializeMusics(){
        this.musics.add(new Music("Note:Capo in the 3rd -- [G] How many special people change [F] How many lives...", new Specification("Oasis", "Champagne Supernova")));
    }

}
