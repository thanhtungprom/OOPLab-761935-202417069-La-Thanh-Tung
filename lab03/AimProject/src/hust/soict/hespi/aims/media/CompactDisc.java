package hust.soict.hespi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
		super(title, category, cost,director, length);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		} else {
			System.out.println("Track da ton tai");
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		} else {
			System.out.println("Khong tim thay track nay");
		}
	}
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void play() {
		System.out.println("Playing CD:" + this.getTitle());
		for(Track track : tracks) {
			track.play();
		}
		
	}
	
	@Override
	public String toString() {
	    String trackList = "";
	    for (Track t : tracks) {
	        trackList += "\n    - " + t.toString();
	    }
	    return "CD: [ID=" + getId() + ", Title='" + getTitle() + "', Category='" + getCategory() + 
	           "', Artist='" + artist + "', Cost=" + getCost() + "$]" + 
	           "\n  Tracks:" + (tracks.isEmpty() ? " Empty" : trackList);
	}
}
