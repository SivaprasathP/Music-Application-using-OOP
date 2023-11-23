package Music;
import java.util.*;
public class Main {
	private static ArrayList<Album> albums=new ArrayList<>();

	public static void main(String[] args) {
		//create albums of songs and store it in arraylist
		
		Album album=new Album("Leo","Anirudh");
		album.addSong("Ordinary Person", 2.19);
		album.addSong("Badass", 3.49);
		album.addSong("I'm Scared", 2.25);
		album.addSong("Naa Ready", 4.08);
		albums.add(album);
		
		album=new Album("Good Night","Sean Roldan");
		album.addSong("Naan Gaali", 4.30);
		album.addSong("Chill Makkaa", 4.14);
		album.addSong("Anbirkum", 2.13);
		albums.add(album);
		
		
		//create a linked list of a playlist
		LinkedList<Song> playlist_1=new LinkedList<>();
		
		//add an album to the playlist
		albums.get(0).addToPlayList("Ordinary Person", playlist_1);
		albums.get(0).addToPlayList("Badass", playlist_1);
		albums.get(1).addToPlayList("Naan Gaali", playlist_1);
		albums.get(1).addToPlayList("Chill Makkaa", playlist_1);
		
		//create a method to play this album
		play(playlist_1);
	}
	
	private static void play(LinkedList<Song> playlist) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator=playlist.listIterator();
		
		if(playlist.size()==0) {
			System.out.println("This playlist have no songs");
		}else {
			System.out.println("Now Playling "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			//take input
			int action=sc.nextInt();
			sc.nextLine();//break that line
			
			switch(action) {
			     
			case 0:
				System.out.println("Playlist is complete");
				quit=true;
				break;
			case 1:
				if(forward) {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
					}
					forward=true;
				}else {
					System.out.println("No Song Available, reached to the end of the playlist");
					forward=false;
				}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
						System.out.println("Now Playing, "+listIterator.previous().toString());
					}
					forward=false;
				}
				else {
					System.out.println("We are at the start of playlist");
					forward=false;
				}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing, "+listIterator.previous().toString());
						forward=false;
					}else {
						System.out.println("We are at the start of playlist");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
						forward=true;
					}else {
						System.out.println("We reached to the end of the playlist");
					}
				}
				break;
			case 4:
				printPlaylist(playlist);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playlist.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now Playing, "+listIterator.previous().toString());
						}
					}
				}
			}
			
		}
	}
	
	//adding some functionalities
	private static void printMenu() {
		System.out.println("Available options \npress");
		System.out.println("0 - to quit\n"+
		                   "1 - to play next song\n"+
				           "2 - to play previous song\n"+
		                   "3 - to replay the current song\n"+
				           "4 - to list of all songs \n"+
		                   "5 - print all available options \n"+
				           "6 - delete current song");
	}
	
	private static void printPlaylist(LinkedList<Song> playlist) {
		Iterator<Song> iterator =playlist.iterator();
		System.out.println("-----------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-----------------------");
	}

}
