/**
 * Created by Giuliano on 27/03/2015.
 */
import java.util.List;
import java.util.LinkedList;

public class MusicList {

    private List<Music> musics = new LinkedList<Music>();
    
    public void addMusic(Music music){
    	musics.add(music);
    }

    public Music searchMusic(Specification spec){

        List<Music> found = new LinkedList<Music>();
        for(Music music:musics){
            if(music.getSpec().matches(spec)) return music;
        }
        return null;

    }
    
    public List<Music> getMusics(){
    	return musics;
    }

}