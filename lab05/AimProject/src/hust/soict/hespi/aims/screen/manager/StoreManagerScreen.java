package hust.soict.hespi.aims.screen.manager;

// Các thư viện quản lý Layout
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.media.*;

public class StoreManagerScreen extends JFrame {
    private Store store;
    
    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	    JPanel createNorth() {
	        JPanel north = new JPanel();
	        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	        north.add(createMenuBar());
	        north.add(createHeader());
	        return north;
	    }

	    JMenuBar createMenuBar() {
	        JMenu menu = new JMenu("Options");
	        
	        // Đặt tên biến cho các JMenuItem để dễ gọi sự kiện
	        JMenuItem viewStoreMenu = new JMenuItem("View store");
	        menu.add(viewStoreMenu);

	        JMenu smUpdateStore = new JMenu("Update Store");
	        JMenuItem addBookMenu = new JMenuItem("Add Book");
	        JMenuItem addCDMenu = new JMenuItem("Add CD");
	        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
	        
	        smUpdateStore.add(addBookMenu);
	        smUpdateStore.add(addCDMenu);
	        smUpdateStore.add(addDVDMenu);
	        menu.add(smUpdateStore);

	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	        menuBar.add(menu);

	        viewStoreMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new StoreManagerScreen(store);
	                dispose(); // Đóng cửa sổ hiện tại
	            }
	        });

	        addBookMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new AddBookToStoreScreen(store); 
	                dispose(); 
	            }
	        });

	        addCDMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new AddCompactDiscToStoreScreen(store); 
	                dispose();
	            }
	        });
	        addDVDMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new AddDigitalVideoDiscToStoreScreen(store); 
	                dispose();
	            }
	        });

	        return menuBar;
	    }

	    JPanel createHeader() {
	        JPanel header = new JPanel();
	        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	
	        JLabel title = new JLabel("AIMS");
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	        title.setForeground(Color.CYAN);
	
	        header.add(Box.createRigidArea(new Dimension(10, 10)));
	        header.add(title);
	        header.add(Box.createHorizontalGlue());
	        header.add(Box.createRigidArea(new Dimension(10, 10)));
	
	        return header;
	    }

	    JPanel createCenter() {
	        JPanel center = new JPanel();
	        center.setLayout(new GridLayout(3, 3, 2, 2));
	
	        ArrayList<Media> mediaInStore = store.getItemsInStore();
	        for (int i = 0; i < 9; i++) {
	            if (i < mediaInStore.size()) {
	                MediaStore cell = new MediaStore(mediaInStore.get(i));
	                center.add(cell);
	            } else {
	                center.add(new JPanel());
	            }
	        }
	        return center;
	    }

    // 3.1.4 The MediaStore class
    public class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                
                playButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Media Player"); 
                        dialog.setSize(300, 150);
                        dialog.setLayout(new BorderLayout());
                        dialog.setLocationRelativeTo(null); 

                        String playMessage = "<html><div style='text-align: center;'>Playing:<br/><b>" 
                                             + media.getTitle() + "</b></div></html>";
                        JLabel label = new JLabel(playMessage, SwingConstants.CENTER);
                        dialog.add(label, BorderLayout.CENTER);
                        
                        JButton closeButton = new JButton("Close");
                        closeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialog.dispose(); 
                            }
                        });
                        
                        JPanel buttonPanel = new JPanel();
                        buttonPanel.add(closeButton);
                        dialog.add(buttonPanel, BorderLayout.SOUTH);
                        
                        dialog.setVisible(true);
                    }
                });
                
                container.add(playButton);
            }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 29.99f);

        Book book1 = new Book("Java Core & Advanced", "Education", 45.00f);
        Book book2 = new Book("Design Patterns", "Technology", 54.50f);
        Book book3 = new Book("Effective Java", "Technology", 62.10f);

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "John Landis", 42, 15.00f);
        CompactDisc cd2 = new CompactDisc("Abbey Road", "Rock", "The Beatles", "George Martin", 47, 18.50f);

        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(cd1);
        store.addMedia(dvd2);
        store.addMedia(book2);
        store.addMedia(dvd3);
        store.addMedia(book3);
        store.addMedia(cd2);

        
        new StoreManagerScreen(store);
    }
}