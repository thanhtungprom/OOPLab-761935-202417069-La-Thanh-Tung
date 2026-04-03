import javax.swing.JOptionPane;
public class linearequation {
    public static void main(String[] args) {
        String s1, s2;
        s1 = JOptionPane.showInputDialog(null,
            "Dien he so a","ax + b",
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(s1);
        s2 = JOptionPane.showInputDialog(null,
            "Dien he so b","ax + b",
            JOptionPane.INFORMATION_MESSAGE
        );
        double num2 = Double.parseDouble(s2);
        if(num1 == 0 && num2 == 0) {
            System.out.println("Vo so nghiem");
        } else if(num1 == 0 && num2 != 0) {
            System.out.println("Vo nghiem");
        } else {
            System.out.println("Nghiem la " + -num2/num1);
        }
    }
}
