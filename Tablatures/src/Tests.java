import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class Tests {

	@Test
	public void test() {
		MusicList list = new MusicList();
		
		list.addMusic(new Music("Note:Capo in the 3rd -- [G] How many special people change [F] How many lives...", new Specification("Oasis", "Champagne Supernova")));
		list.addMusic(new Music("Note:Capo in the 2rd -- [Em] Today is ...", new Specification("Oasis", "Wonderwall")));
		
		assertEquals(list.getMusics().size(), 2); //testing ADD
		
		Music music = list.searchMusic(new Specification("Oasis", "Wonderwall"));
		
		assertEquals(music.getChords(), "Note:Capo in the 2rd -- [Em] Today is ..."); // Testing search and matches
	}

}
