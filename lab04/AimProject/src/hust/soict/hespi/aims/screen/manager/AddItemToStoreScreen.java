package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel centerPanel; 
    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createMenuBar(), BorderLayout.NORTH);
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        cp.add(centerPanel, BorderLayout.CENTER);
        
        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
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

        viewStoreMenu.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });

        addBookMenu.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });

        addCDMenu.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });

        addDVDMenu.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });

        return menuBar;
    }
}