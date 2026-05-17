package hust.soict.hespi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import hust.soict.hespi.aims.store.Store;

// Class này thường sẽ kế thừa JFrame để làm một cửa sổ hiển thị
public class StoreManagerScreen extends JFrame {
    
	public static void main(String[] args) {
        // 1. Tạo một đối tượng Store rỗng để truyền vào màn hình
        Store demoStore = new Store();
        
        // 2. Khởi tạo và hiển thị màn hình StoreManagerScreen
        new StoreManagerScreen(demoStore);
    }
	
    private Store store;

    // Hàm tạo (Constructor) của màn hình
    public StoreManagerScreen(Store store) {
        this.store = store;
        
        // Thiết lập cơ bản cho JFrame (Cửa sổ chính)
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        // Thêm phần giao diện phía Bắc (NORTH) vào cửa sổ
        cp.add(createNorth(), BorderLayout.NORTH);
        
        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Hàm tạo khu vực phía Bắc (chứa Menu và Header)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader()); // Đã hết bị lỗi đỏ vì hàm này đã được định nghĩa ở dưới
        return north;
    }

    // Hàm tạo thanh Menu
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

    // Hàm tạo Header (Bạn sẽ hoàn thiện nội dung hàm này ở phần sau của bài Lab)
    JPanel createHeader() {
        JPanel header = new JPanel();
        // TODO: Thêm code tạo tiêu đề (Title) cho cửa hàng tại đây
        return header;
    }
}