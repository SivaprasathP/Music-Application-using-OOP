package Music;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;//it stores all the songs
	
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	//add a new song to the album
	public boolean addSong(String title,double duration) {
		if(findSong(title)==null) {
			songs.add(new Song(title,duration));
		//	System.out.println(title+" successfully added to the list");
			return true;
		}else {
			System.out.println("Song with the name "+title+" already exist in the list");
			return false;
		}
	}
	
	public Song findSong(String title) {
		for(Song checkedSong:songs) {
			if(checkedSong.getTitle().equals(title)) {
				return checkedSong;
			}
		}
		return null;
	}
	
	//add song to the playlist(based on user choice the songs are added)
	public boolean addToPlayList(int trackNumber,LinkedList<Song> Playlist) {
		//convert tracknumber to index
		int index=trackNumber-1;
		if(index>0 && index<=this.songs.size()) {
			Playlist.add(this.songs.get(index));
			return true;
		}
		System.out.println("this album does not have the song with track number "+trackNumber);   
		return false;
	}
	
	//add song to playlist which takes the title as input
	public boolean addToPlayList(String title,LinkedList<Song> Playlist) {
		for(Song checkSong:this.songs) {
			if(checkSong.getTitle().equals(title)) {
				Playlist.add(checkSong);
				return true;
			}
		}
		System.out.println("There is no such song named "+title+" exists");
		return false;
	}
}
