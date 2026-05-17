package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
        
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        
        formPanel.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        formPanel.add(tfTitle);
        
        formPanel.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Director:"));
        JTextField tfDirector = new JTextField();
        formPanel.add(tfDirector);

        formPanel.add(new JLabel("Length (minutes):"));
        JTextField tfLength = new JTextField();
        formPanel.add(tfLength);
        
        formPanel.add(new JLabel("Cost ($):"));
        JTextField tfCost = new JTextField();
        formPanel.add(tfCost);
        
        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
                
                // Tạo DVD và thêm vào store
                DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(newDVD);
                
                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                
                // Reset form
                tfTitle.setText(""); tfCategory.setText(""); tfDirector.setText(""); 
                tfLength.setText(""); tfCost.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format for Length or Cost!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        centerPanel.add(formPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(btnAdd);
    }
}