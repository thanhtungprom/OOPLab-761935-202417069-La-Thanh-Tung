
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
    store.addDVD(dvd1);
    store.addDVD(dvd2);
    store.addDVD(dvd3);

    System.out.println("Kiểm tra xóa DVD");
    store.removeDVD(dvd1);
    store.removeDVD(dvd2);
    store.removeDVD(dvd3);
    }
}
