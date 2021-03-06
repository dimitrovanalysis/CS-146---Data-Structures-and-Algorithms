import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class PlaylistTest {


	@Test
	public void testToArray() throws IOException {
		
		Playlist list = new Playlist();
		String[] playlist = list.toArray();

		assertEquals("String[] playlist should contain 459 elements" , 459, playlist.length );
		
		assertEquals("1st element should be: 12-Bar Original" , "12-Bar Original", playlist[0] );	
		assertEquals("10th element should be: All I've Got To Do" , "All I've Got To Do", playlist[9] );	
		assertEquals("last element should be: Radetzky March" , "Radetzky March", playlist[458] );

	}


	
		//shuffles  the playlist, then checks to see if files are where they are ssupposed to be
	@Test
	public void testShuffle() throws IOException {
		FileWriter fileWriter = new FileWriter("DimitrovKonstantinPlaylist.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		 
		Playlist list = new Playlist();
		String[] playlist = list.toArray();
		String temp = "";
		Random r = new Random();
		r.setSeed(20);
		int k = 0;
		
		for (int i = playlist.length-1; i > 0; i-- ) // loop through array backwards
		{
		    int j = r.nextInt(i);
			temp = playlist[i];
			playlist[i] = playlist[j];
			playlist[j] = temp;	
		}
		for (k=0;k<=playlist.length-1;k++)
		printWriter.println(playlist[k]);
		
		assertEquals("1st element should be: I'm Talking About You" , "I'm Talking About You", playlist[0] );	
		assertEquals("10th element should be: Carnival Of Light" , "Carnival Of Light", playlist[10] );	
		assertEquals("last element should be: I'll Get You" , "I'll Get You", playlist[458] );	
	
		printWriter.close();
	}
	

		
}


