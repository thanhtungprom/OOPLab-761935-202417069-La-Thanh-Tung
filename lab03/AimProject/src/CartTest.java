public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // To-do: Test the search methods here
        System.out.println("\n--- TÌM KIẾM THEO ID ---");
        cart.searchById(1); // Thử tìm DVD có ID là 1
        cart.searchById(99); // Thử tìm ID không tồn tại

        System.out.println("\n--- TÌM KIẾM THEO TIÊU ĐỀ ---");
        cart.searchByTitle("Star"); // Khớp với "Star Wars"
        cart.searchByTitle("Lion"); // Khớp với "The Lion King"
        cart.searchByTitle("Nemo"); // Không tồn tại
    }
}