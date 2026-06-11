package hust.soict.hespi.javafx;

import javafx.event.ActionEvent; // Sửa từ java.awt.event.ActionEvent
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent; // Sửa từ java.awt.event.MouseEvent
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void drawingAreaMouseClicked(MouseEvent event) {
        // Sử dụng logic tương tự như MouseDragged
        Color color = eraserRadioButton.isSelected() ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Nếu chọn Eraser thì dùng màu trắng (để tẩy), không thì màu đen
        Color color = eraserRadioButton.isSelected() ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
