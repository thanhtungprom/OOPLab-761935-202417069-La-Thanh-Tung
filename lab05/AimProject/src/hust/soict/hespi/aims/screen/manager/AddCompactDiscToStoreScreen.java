package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");
        
        // Tạo lưới 6 hàng, 2 cột
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        formPanel.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        formPanel.add(tfTitle);
        
        formPanel.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Artist:"));
        JTextField tfArtist = new JTextField();
        formPanel.add(tfArtist);

        formPanel.add(new JLabel("Director:"));
        JTextField tfDirector = new JTextField();
        formPanel.add(tfDirector);

        formPanel.add(new JLabel("Length (minutes):"));
        JTextField tfLength = new JTextField();
        formPanel.add(tfLength);
        
        formPanel.add(new JLabel("Cost ($):"));
        JTextField tfCost = new JTextField();
        formPanel.add(tfCost);
        
        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String artist = tfArtist.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
                
                CompactDisc newCD = new CompactDisc(title, category, artist, director, length, cost);
                store.addMedia(newCD);
                
                JOptionPane.showMessageDialog(this, "CD added successfully!");
                
                // Reset form
                tfTitle.setText(""); tfCategory.setText(""); tfArtist.setText(""); 
                tfDirector.setText(""); tfLength.setText(""); tfCost.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format for Length or Cost!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        centerPanel.add(formPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(btnAdd);
    }
}