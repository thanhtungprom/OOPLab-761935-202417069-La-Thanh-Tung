import javax.swing.JOptionPane;
public class lineasystem {
    public static void main(String[] args) {
        String a1;
        String a2;
        String b1;
        String b2;
        String c1;
        String c2;
        
        a1 = JOptionPane.showInputDialog(null,
            "Dien he so a","a1x + b1 = c1",
            JOptionPane.INFORMATION_MESSAGE);
        double a1x = Double.parseDouble(a1);
        b1 = JOptionPane.showInputDialog(null,
            "Dien he so b","a1x + b1 = c1",
            JOptionPane.INFORMATION_MESSAGE);
        double b1x = Double.parseDouble(b1);
        c1 = JOptionPane.showInputDialog(null,
            "Dien he so c","a1x + b1 = c1",
            JOptionPane.INFORMATION_MESSAGE);
        double c1x = Double.parseDouble(c1);
       
        a2 = JOptionPane.showInputDialog(null,
            "Dien he so a","a2x + b2 = c2",
            JOptionPane.INFORMATION_MESSAGE);
        double a2x = Double.parseDouble(a2);
        b2 = JOptionPane.showInputDialog(null,
            "Dien he so b","a2x + b2 = c2",
            JOptionPane.INFORMATION_MESSAGE);
        double b2x = Double.parseDouble(b2);
        c2 = JOptionPane.showInputDialog(null,
            "Dien he so c","a2x + b2 = c2",
            JOptionPane.INFORMATION_MESSAGE);
        double c2x = Double.parseDouble(c2);

        double D = a1x * b2x - a2x * b1x;
        double D1 = c1x * b2x - c2x * b1x;
        double D2 = a1x * c2x - a2x * c1x;
        if(D != 0){
            System.out.println("x = " + D1/D + "va y= " + D2/D);
        } else {
            if(D1 == 0 && D2 == 0) {
                System.out.println("Vo so nghiem");
            } else {
                System.out.println("Vo nghiem");
            }
        }
    }
}
