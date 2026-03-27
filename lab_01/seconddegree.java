import javax.swing.JOptionPane;
public class seconddegree {
    public static void main(String[] args) {
        String ax;
        String bx;
        String cx;

        
        ax = JOptionPane.showInputDialog(null,
            "Dien he so a","ax^2 + bx + c = 0",
            JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(ax);
        bx = JOptionPane.showInputDialog(null,
            "Dien he so b","ax^2 + bx + c = 0",
            JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(bx);
        cx = JOptionPane.showInputDialog(null,
            "Dien he so c","ax^2 + bx + c = 0",
            JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(cx);
        
        if(a == 0 && b == 0) {
            if(c != 0) {
                System.out.println("Vo nghiem");
            } else {
                System.out.println("Vo so nghiem");
            }
        } else if(a==0 && b != 0) {
            System.out.println("Nghiem la " + (-c / b));
        } else {
            double denta = b * b - 4 * a * c;
            if(denta < 0) {
                System.out.println("Vo nghiem");
            } else if(denta == 0) {
                System.out.println("Nghiem la "+ (-b / (2 * a)));
            } else {
                double can = Math.sqrt(denta);
                System.out.println("Nghiem 1 la " + ((-b + can) / 2 * a));
                System.out.println("Nghiem 1 la " + ((-b - can) / 2 * a));
            }
        }
    }
}
