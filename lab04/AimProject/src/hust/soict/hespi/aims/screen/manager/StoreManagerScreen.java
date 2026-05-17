package hust.soict.hespi.aims.screen.manager;

// Các thư viện quản lý Layout
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.media.*;

public class StoreManagerScreen extends JFrame {
    private Store store;
    
    // 3.1.5 Putting it all together: Constructor
    public StoreManagerScreen(Store store) {
        this.store = store;

	    // 3.1.2 The NORTH component
	    JPanel createNorth() {
	        JPanel north = new JPanel();
	        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	        north.add(createMenuBar());
	        north.add(createHeader());
	        return north;
	    }

	    JMenuBar createMenuBar() {
	        JMenu menu = new JMenu("Options");
	
	        menu.add(new JMenuItem("View store"));
	
	        JMenu smUpdateStore = new JMenu("Update Store");
	        smUpdateStore.add(new JMenuItem("Add Book"));
	        smUpdateStore.add(new JMenuItem("Add CD"));
	        smUpdateStore.add(new JMenuItem("Add DVD"));
	        menu.add(smUpdateStore);
	
	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	        menuBar.add(menu);
	
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

	    // 3.1.3 The CENTER component
	    JPanel createCenter() {
	        JPanel center = new JPanel();
	        center.setLayout(new GridLayout(3, 3, 2, 2));
	
	        ArrayList<Media> mediaInStore = store.getItemsInStore();
	        // Tài liệu yêu cầu lặp qua 9 phần tử đầu tiên
	        for (int i = 0; i < 9; i++) {
	            if (i < mediaInStore.size()) {
	                MediaStore cell = new MediaStore(mediaInStore.get(i));
	                center.add(cell);
	            } else {
	                // Thêm các panel trống nếu không đủ 9 item để giữ đúng layout 3x3
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

            // Kiểm tra xem Media có thể "Play" được không (CD/DVD)
            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
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

    // Main method để khởi chạy ứng dụng
    public static void main(String[] args) {
        Store store = new Store();
        // Bạn có thể add thêm vài món đồ mẫu vào đây để test hiển thị
        new StoreManagerScreen(store);
    }
}