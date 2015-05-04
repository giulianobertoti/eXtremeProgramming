package com.example.giuliano.chords;

/**
 * Created by Giuliano on 27/03/2015.
 */
public class Music {

    private String chords;
    private Specification spec;

    public Music(String chords, Specification spec){
        this.chords = chords;
        this.spec = spec;
    }

    public String getChords(){
        return chords;
    }

    public Specification getSpec(){
        return spec;
    }
}
