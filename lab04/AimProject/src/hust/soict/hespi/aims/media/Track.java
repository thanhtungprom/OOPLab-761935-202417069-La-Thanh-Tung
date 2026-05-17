package hust.soict.hespi.aims.media;

public class Track {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Track)) {
			return false;
		}
		Track other = (Track) obj;
		return this.title.equalsIgnoreCase(other.getTitle())
				&& this.length == other.getLength();
	}
	
	@Override
	public String toString() {
	    return "Track: [Title='" + title + "', Length=" + length + "s]";
	}
}
