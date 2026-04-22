package hust.soict.hespi.test.cart;

import hust.soict.hespi.aims.media.*;
import hust.soict.hespi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
    Store store = new Store();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
            "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
            "Science Fiction", "George Lucas", 121, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter",
            "Fantasy", "Chris Columbus", 152, 29.95f);
    
    System.out.println("Kiểm tra thêm DVD");
    store.addMedia(dvd1);
    store.addMedia(dvd2);
    store.addMedia(dvd3);

    System.out.println("Kiểm tra xóa DVD");
    store.removeMedia(dvd1);
    store.removeMedia(dvd2);
    store.removeMedia(dvd3);
    }
}
