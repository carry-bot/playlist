package org.simon.playlist;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.simon.playlist.control.SongIO;
import org.simon.playlist.model.Song;
import org.simon.playlist.model.Songlist;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		System.out.println("Liederliste gestartet");
		
		Songlist list = SongIO.read(new File("songs.simon"));
		// System.out.println("Hello World!");
//		Song songOne = new Song();
//		songOne.setName("Wicked");
//		songOne.setLink("https://www.youtube.com/watch?v=USs-w8frt4s");
//		list.addSong(songOne);
//
//		Song songTwo = new Song();
//		songTwo.setName("Lied 2");
//		songTwo.setLink("Link zu Lied 2");
//		list.addSong(songTwo);
//
//		SongIO.write(list);

//		System.out.println(songTwo);

		String searchname = "";

		while (searchname != null) {

		//	System.out.println("Bitte Liedname eingeben:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			try {
				searchname = reader.readLine();

				Song resultSong = list.search(searchname);

				if (resultSong != null) {
				//	System.out.println(resultSong.getLink());
					
					if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					    try {
							Desktop.getDesktop().browse(new URI(resultSong.getLink()));
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				} else {
					System.out.println("Nichts gefunden");
				}
				
				if (searchname.equals("exit")) {
					System.out.println("Liederliste wird beendet");
					System.exit(0);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
