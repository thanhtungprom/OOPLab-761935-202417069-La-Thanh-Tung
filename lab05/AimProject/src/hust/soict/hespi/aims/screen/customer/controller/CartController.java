package hust.soict.hespi.aims.screen.customer.controller;

import hust.soict.hespi.aims.cart.Cart;
import hust.soict.hespi.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
	private Cart cart;
    private hust.soict.hespi.aims.store.Store store; // Thêm dòng này

    // Nâng cấp Constructor để nhận cả Store và Cart
    public CartController(hust.soict.hespi.aims.store.Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
	@FXML
    private javafx.scene.control.Label costLabel;

    @FXML
    private javafx.scene.control.Button btnPlay;

    @FXML
    private javafx.scene.control.Button btnRemove;

    // Khai báo rõ kiểu dữ liệu <Media, Kiểu_Của_Cột> để không bị lỗi
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    // Constructor để nhận dữ liệu giỏ hàng
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        // Gán thuộc tính của Media vào các cột
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Đổ dữ liệu từ Cart vào Bảng
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        // --- CODE MỚI: LẮNG NGHE SỰ KIỆN CLICK CHUỘT VÀO BẢNG ---
        
        // Mặc định ban đầu giấu 2 nút đi vì chưa chọn gì
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự thay đổi khi click chọn 1 hàng trong bảng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) { // Nếu có chọn 1 bộ phim
                    updateButtonBar(newValue);
                } else { // Nếu click ra ngoài, không chọn gì cả
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                }
            }
        );
        costLabel.setText(cart.totalCost() + " $");

        // 2. Gắn Listener để tự động cập nhật mỗi khi giỏ hàng có sự thay đổi (thêm/xóa đĩa)
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            costLabel.setText(cart.totalCost() + " $");
        });
    }

    // Hàm phụ trợ để ẩn/hiện nút dựa vào loại đĩa
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true); // Nút Remove luôn hiện nếu có chọn đĩa
        
        // Chỉ hiện nút Play nếu đĩa đó có giao diện Playable (CD, DVD)
        if (media instanceof hust.soict.hespi.aims.media.Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Lấy đĩa đang được chọn trong bảng
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        // Xóa đĩa đó khỏi giỏ hàng
        cart.removeMedia(media);
        // Vì dùng ObservableList, bảng sẽ tự động giật đĩa đó biến mất ngay lập tức!
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy đĩa đang được chọn
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        
        // Bật một cửa sổ thông báo (Dialog) lên để giả lập việc phát phim
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText("Now playing: " + media.getTitle());
        alert.setContentText("DVD length: " + ((hust.soict.hespi.aims.media.DigitalVideoDisc) media).getLength() + " minutes");
        alert.showAndWait();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            // Nạp lại file Store.fxml
            final String STORE_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Store.fxml";
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            
            // Truyền lại cả store và cart sang cho ViewStoreController
            fxmlLoader.setController(new ViewStoreController(store, cart));
            javafx.scene.Parent root = fxmlLoader.load();
            
            // Lấy cửa sổ hiện tại và đổi nội dung (Scene) bên trong
            javafx.stage.Stage stage = (javafx.stage.Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root, 1024, 768));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}