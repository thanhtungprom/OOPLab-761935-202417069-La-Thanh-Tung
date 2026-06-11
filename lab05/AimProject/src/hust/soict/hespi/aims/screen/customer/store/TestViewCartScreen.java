package hust.soict.hespi.aims.screen.customer.store;

import hust.soict.hespi.aims.cart.Cart;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.screen.customer.controller.CartController;
import hust.soict.hespi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	final String CART_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        
        // TRUYỀN CẢ STORE VÀ CART VÀO CONTROLLER
        CartController cartController = new CartController(store, cart);
        fxmlLoader.setController(cartController);
        
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        
        // Thêm sẵn vài đĩa mẫu vào Giỏ hàng để test bảng hiển thị và nút xóa/phát phim
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);
        
        launch(args);
    }
}