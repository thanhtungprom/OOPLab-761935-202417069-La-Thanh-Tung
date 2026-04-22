package hust.soict.hespi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director, 0);
		nbDigitalVideoDiscs++;
		this.setID(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, director, length);
		nbDigitalVideoDiscs++;
		this.setID(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost,null, 0);
		nbDigitalVideoDiscs++;
		this.setID(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title) {
		super(title,null,0.0f,null,0);
		nbDigitalVideoDiscs++;
		this.setID(nbDigitalVideoDiscs);
	}
	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + 
			this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
	}	
	public boolean isMatch(String title) {
		if(this.getTitle() != null && this.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("Length: " + this.getLength());
	}
}
