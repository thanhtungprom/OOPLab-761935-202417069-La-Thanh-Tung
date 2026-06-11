package hust.soict.hespi.aims.screen.customer.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import hust.soict.hespi.aims.store.Store;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;

public class ViewStoreController {
    
    private Store store;
    private hust.soict.hespi.aims.cart.Cart cart;

    // Constructor đầy đủ để nhận cả Store và Cart
    public ViewStoreController(Store store, hust.soict.hespi.aims.cart.Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    // Constructor cũ (nếu bạn muốn giữ phòng hờ)
    public ViewStoreController(Store store) {
        this.store = store;
    }

    // Đã đổi tên biến Button thành btnViewCart để không trùng với tên hàm
    @FXML
    private Button btnViewCart;

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();

                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Hàm xử lý sự kiện bấm nút
    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            // Nạp file Cart.fxml
            final String CART_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Cart.fxml";
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            
            // Truyền lại cả store và cart sang cho CartController
            fxmlLoader.setController(new CartController(store, cart));
            javafx.scene.Parent root = fxmlLoader.load();
            
            // Chuyển cảnh
            javafx.stage.Stage stage = (javafx.stage.Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root, 1024, 768));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}