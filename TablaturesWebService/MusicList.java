/**
 * Created by Giuliano on 27/03/2015.
 */


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class MusicList {

	private ObjectContainer musics = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../musicsDB.db4o");
    
    public void addMusic(Music music){
    	musics.store(music);
    }

    public Music searchMusic(Specification spec){

    	Query query=musics.query();
		query.constrain(Music.class);
	    ObjectSet<Music> result = query.execute();
        for(Music music:result){
            if(music.getSpec().matches(spec)) return music;
        }
        return null;

    }
    

}