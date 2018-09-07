import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist{

	List<String> list = new ArrayList<String>();


	
	
	public String[] toArray() throws IOException {
	
	BufferedReader in = new BufferedReader(new FileReader("Playlist.txt"));
	String str;	
			
		while((str = in.readLine()) != null) {
		list.add(str);
		}
	
	String[] playlist = list.toArray(new String[0]);


	return playlist;
	}
		
	
	public void shuffle() throws IOException {
		 FileWriter fileWriter = new FileWriter("DimitrovKonstantinPlaylist.txt");
		 PrintWriter printWriter = new PrintWriter(fileWriter);
		String[] playlist = toArray();
		String temp = "";
		Random r = new Random();
		r.setSeed(20);
		
		for (int i = playlist.length-1; i > 0; i-- ) // loop through array backwards
		{
		    int j = r.nextInt(i);
			temp = playlist[i];
			playlist[i] = playlist[j];
			playlist[j] = temp;
			
			printWriter.printf(playlist[i]);
		}	
	}
	
	
}