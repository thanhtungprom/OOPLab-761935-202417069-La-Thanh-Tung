package hust.soict.hespi.aims.cart;

import hust.soict.hespi.aims.media.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if(!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);
				System.out.println("Da them vao gio hang");
			} else {
				System.out.println("Da co media nay trong gio hang");
			}
		} else {
			System.out.println("Gio hang da day");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("Media da duoc loai bo");
		} else {
			System.out.println("Khong tim thay media");
		}
	}
	public float totalCost() {
		float total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	public void print() {
		System.out.println("*****************Cart*****************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + " " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("**********************************");
	}
	public void searchById(int id) {
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				System.out.println("Đã tìm thấy DVD:" + itemsOrdered.get(i).toString());
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Không tìm thấy DVD với ID: " + id);
		}
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for(int i = 0; i< itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).isMatch(title)) {
				System.out.println("Đã tìm thấy DVD: " + itemsOrdered.get(i).toString());
				found = true;
			}
		}
		if(!found) {
			System.out.println("Không tìm thấy DVD với tiêu đề: " + title);
		}
	}
	
	public void sortByTitle() {
        Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo tiêu đề.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo giá.");
    }
}
