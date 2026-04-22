package hust.soict.hespi.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hespi.aims.media.*;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		} else {
		System.out.println("Tac gia da ton tai");
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("Khong tim thay tac gia");
		}
	}
	
	@Override
	public String toString() {
	    return "Book: [ID=" + getId() + ", Title='" + getTitle() + "', Category='" + getCategory() + 
	           "', Authors=" + authors + ", Cost=" + getCost() + "$]";
	}
}
