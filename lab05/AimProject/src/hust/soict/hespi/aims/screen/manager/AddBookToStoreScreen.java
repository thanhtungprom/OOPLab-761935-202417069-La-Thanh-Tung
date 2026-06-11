package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store"); // Gọi constructor của lớp cha
        
        // Tạo các ô nhập liệu đặc thù cho Book
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        formPanel.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        formPanel.add(tfTitle);
        
        formPanel.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        formPanel.add(tfCategory);
        
        formPanel.add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField();
        formPanel.add(tfCost);
        
        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            
            Book newBook = new Book(title, category, cost);
            store.addMedia(newBook);
            
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText(""); // Xóa form sau khi thêm
        });
        
 
        centerPanel.add(formPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        centerPanel.add(btnAdd);
    }
}