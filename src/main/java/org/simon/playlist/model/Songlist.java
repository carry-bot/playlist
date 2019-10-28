package org.simon.playlist.model;

import java.util.ArrayList;
import java.util.List;

public class Songlist {
	List<Song> songs = new ArrayList<Song>();

	public void addSong(Song song) {
		this.songs.add(song);
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song search(String name) {
		for (Song song : songs) {
			if (song.getName().equalsIgnoreCase(name)) {
				return song;
			}
		}
		return null;
	}
}
