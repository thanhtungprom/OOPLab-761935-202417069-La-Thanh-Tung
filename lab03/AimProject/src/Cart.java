public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i< qtyOrdered; i++) {
			if(itemsOrdered[i] == disc ) {
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
			System.out.println("The disc has been removed");
			return;
			}
		}
		System.out.println("The disc is not in the cart");
	}
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
	    for (int i = 0; i < dvdList.length; i++) {
	        this.addDigitalVideoDisc(dvdList[i]); 
	    }
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    this.addDigitalVideoDisc(dvd1);
    this.addDigitalVideoDisc(dvd2);
	}
	public void print() {
		System.out.println("*****************Cart*****************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("**********************************");
	}
	public void searchById(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].getId() == id) {
				System.out.println("Đã tìm thấy DVD:" + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Không tìm thấy DVD với ID: " + id);
		}
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for(int i = 0; i< qtyOrdered; i++) {
			if(itemsOrdered[i].isMatch(title)) {
				System.out.println("Đã tìm thấy DVD: " + itemsOrdered[i].toString());
				found = true;
			}
		}
		if(!found) {
			System.out.println("Không tìm thấy DVD với tiêu đề: " + title);
		}
	}
}
