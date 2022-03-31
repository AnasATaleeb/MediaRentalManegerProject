package application;


public class Album extends Media{
	// define attributes 
	private String artist;
	private String songs;
	
	// Default constructor
	public Album() {
		super();
	}
	// non default constructor
	public Album(String code,String title, int numOfCopies, String artist, String songs) {
		super(code,title, numOfCopies);
		this.artist = artist;
		this.songs = songs;
	}
	// getter for artist
	public String getArtist() {
		return artist;
	}
	//setter for artist
	public void setArtist(String artist) {
		this.artist = artist;
	}
	// getter for songs
	public String getSongs() {
		return songs;
	}
	//setter for songs
	public void setSongs(String songs) {
		this.songs = songs;
	}
	// to string to return data of object in string
	@Override
	public String toString() {
		return  " Album [ " + super.toString() +" Artist=" + artist + ", Songs=" + songs + "]";
	}	
}
