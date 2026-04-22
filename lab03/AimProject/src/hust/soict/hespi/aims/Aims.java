package hust.soict.hespi.aims;

import hust.soict.hespi.aims.media.*;
import hust.soict.hespi.aims.store.*;
import hust.soict.hespi.aims.cart.*;
import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
    	store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
    	store.addMedia(new Book("Java Programming", "Technology", 45.5f));
    	store.addMedia(new CompactDisc("Thriller", "Pop", "Michael Jackson", "Quincy Jones", 42, 15.0f));
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    store.printStore();
                    viewStoreController();
                    break;
                case 2:
                    updateStoreController();
                    break;
                case 3:
                    cart.print();
                    cartController();
                    break;
                case 0:
                    System.out.println("Cảm ơn Lã thanh Tùng đã sử dụng hệ thống. Tạm biệt!");
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
        scanner.close();
    }

    
    public static void viewStoreController() {
        boolean back = false;
        while (!back) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    System.out.print("Nhập tiêu đề (title) của Media muốn xem: ");
                    String title = scanner.nextLine();
                    Media foundMedia = findMediaInStore(title);
                    
                    if (foundMedia != null) {
                        System.out.println(foundMedia.toString());
                        mediaDetailsController(foundMedia);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + title);
                    }
                    break;
                case 2:
                    System.out.print("Nhập tiêu đề (title) của Media muốn thêm vào giỏ: ");
                    String titleToAdd = scanner.nextLine();
                    Media mediaToAdd = findMediaInStore(titleToAdd);
                    
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                       
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + titleToAdd);
                    }
                    break;
                case 3: 
                    System.out.print("Nhập tiêu đề (title) của Media muốn Play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = findMediaInStore(titleToPlay);
                    
                    if (mediaToPlay != null) {
                        playMedia(mediaToPlay);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + titleToPlay);
                    }
                    break;
                case 4: 
                    cart.print();
                    cartController();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void mediaDetailsController(Media media) {
        boolean back = false;
        while (!back) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2: 
                    playMedia(media);
                    break;
                case 0: 
                    back = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void updateStoreController() {
        System.out.println("--- CẬP NHẬT KHO HÀNG ---");
        System.out.println("1. Thêm một Media vào kho");
        System.out.println("2. Xóa một Media khỏi kho");
        System.out.println("0. Quay lại");
        System.out.print("Lựa chọn của bạn: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhập tiêu đề DVD mới: ");
                String newTitle = scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(newTitle));
                break;
            case 2:
                System.out.print("Nhập tiêu đề Media muốn xóa: ");
                String titleToRemove = scanner.nextLine();
                Media mediaToRemove = findMediaInStore(titleToRemove);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Không tìm thấy!");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }


    public static void cartController() {
        boolean back = false;
        while (!back) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Filter
                    System.out.println("1. Lọc theo ID");
                    System.out.println("2. Lọc theo Tiêu đề (Title)");
                    System.out.print("Lựa chọn: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Nhập ID: ");
                        cart.searchById(scanner.nextInt());
                        scanner.nextLine();
                    } else if (filterChoice == 2) {
                        System.out.print("Nhập Tiêu đề: ");
                        cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. Sắp xếp theo Tiêu đề -> Giá");
                    System.out.println("2. Sắp xếp theo Giá -> Tiêu đề");
                    System.out.print("Lựa chọn: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else if (sortChoice == 2) {
                        cart.sortByCost();
                    }
                    cart.print();
                    break;
                case 3: // Remove
                    System.out.print("Nhập tiêu đề muốn xóa khỏi giỏ: ");
                    String titleToRemove = scanner.nextLine();
                    System.out.println("Tính năng xóa đang hoàn thiện..."); 
                    break;
                case 4: 
                    System.out.print("Nhập tiêu đề muốn Play trong giỏ: ");
                    String titleToPlay = scanner.nextLine();
                    System.out.println("Tính năng Play đang hoàn thiện...");
                    break;
                case 5: 
                    System.out.println("Đơn hàng đã được ghi nhận. Cảm ơn bạn!");
                    cart = new Cart(); 
                    back = true; 
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static Media findMediaInStore(String title) {
        for (Media m : store.getItemsInStore()) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }

    public static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Sản phẩm này không hỗ trợ phát (Ví dụ: Book).");
        }
    }

    public static void showMenu() {
        System.out.println("\n--- AIMS MAIN MENU ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\n--- STORE OPTIONS ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n--- MEDIA DETAILS OPTIONS ---");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\n--- CART OPTIONS ---");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
}