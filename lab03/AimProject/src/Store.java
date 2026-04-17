
public class Store {
    public static final int MAX_NUMBERS_DVD = 1000; 
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_DVD];
    private int qtyInStore = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_DVD) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("Đã thêm thành công DVD '" + disc.getTitle());
        } else {
            System.out.println("Kho đã đầy");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) { 
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; 
                qtyInStore--;
                System.out.println("Đã xóa DVD '" + disc.getTitle());
                break; 
            }
        }
        if (!found) {
            System.out.println("Lỗi: Không tìm thấy DVD '" + disc.getTitle());
        }
    }
    public void printStore() {
        if (qtyInStore == 0) {
            System.out.println("Kho hàng hiện đang trống.");
        } else {
            System.out.println("Các đĩa DVD có sẵn trong kho:");
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ") " + itemsInStore[i].getTitle());
            }
        }
    }
}