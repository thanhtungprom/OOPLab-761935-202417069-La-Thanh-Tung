package hust.soict.hespi.aims.screen.customer.store;

import hust.soict.hespi.aims.cart.Cart;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hespi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	final String STORE_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        
        // TRUYỀN CẢ STORE VÀ CART VÀO CONTROLLER
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        
        // Thêm vài đĩa mẫu vào Cửa hàng để hiển thị lên lưới (GridPane)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        store.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Science Fiction", 25.5f);
        store.addMedia(dvd4);
        
        launch(args);
    }
}