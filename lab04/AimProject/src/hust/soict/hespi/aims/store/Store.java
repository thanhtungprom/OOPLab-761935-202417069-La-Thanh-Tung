package hust.soict.hespi.aims.store;

import hust.soict.hespi.aims.media.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm thành công media '" + media.getTitle());
        } else {
            System.out.println("Media da co san");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
                System.out.println("Đã xóa DVD '" + media.getTitle()); 
            } else {
            System.out.println("Lỗi: Không tìm thấy media '" + media.getTitle());
        }
    }
    public void printStore() {
        if(itemsInStore.isEmpty()) {
        	System.out.println("Kho hang rong");
        } else {
        	System.out.println("Cac mat hang trong kho");
        	for (int i = 0; i < itemsInStore.size(); i++) {
        		System.out.println((i+1) + " " + itemsInStore.get(i).toString());
        	}
        }
    }
    public ArrayList<Media> getItemsInStore() {
    	return itemsInStore;
    }
}