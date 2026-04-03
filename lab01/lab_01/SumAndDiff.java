import javax.swing.JOptionPane;

public class SumAndDiff {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog(null,"Nhap so thu nhat");
        String s2 = JOptionPane.showInputDialog(null,"Nhap so thu hai");

        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double pro = num1 * num2;
        System.out.println("Tong " + sum + "\nHieu " + diff + "\nTich " + pro);
        if(num2 == 0) {
            System.out.println("Khong chia duoc cho 0");
        } else {
            System.out.println("Thuong " + num1 / num2);
        }
    }
}