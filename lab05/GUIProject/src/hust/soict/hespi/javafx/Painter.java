package hust.soict.hespi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Nạp file FXML từ đúng thư mục package của bạn
    	
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/hespi/javafx/Painter.fxml"));
        // Tạo Scene từ nút gốc Root Node
        Scene scene = new Scene(root);
        
        // Cấu hình tiêu đề cửa sổ và hiển thị Stage
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Gọi phương thức launch để kích hoạt runtime của JavaFX
        launch(args);
    }
}