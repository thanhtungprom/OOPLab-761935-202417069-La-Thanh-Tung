import java.util.Scanner;
public class NgayThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int thang;
        int nam;

        while (true) {
            System.out.println("Nhap thang ");
            String thanginput = sc.nextLine().trim();
            thang = getMonthNumber(thanginput);
            
            System.out.println("Nhap nam");
            if (sc.hasNextInt()) {
                nam = sc.nextInt(); 
                sc.nextLine();
            } else {
                nam = -1; 
                sc.nextLine();
            }
            if(thang != 0 && nam >= 0) {
                break;
            } else {
                System.out.println("Try again");
            }
        }
        int flag = 0;
        if(nam % 4 ==0) {
            if(nam % 400 == 0) {
                flag = 1;
            } else if(nam % 100 != 0) {
                flag = 1;
            }
        }
        int day;
        switch(thang) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                day = 31;
                break;
            case 4: case 6: case 11: case 9:
                day = 30;
                break;
            case 2:
                if(flag == 1){
                    day = 29;
                } else {
                    day = 28;
                }
                break;
            default: 
                day = 0;
        }
        System.out.println("So ngay la " + day);
    }
    private static int getMonthNumber(String input) {
        switch (input.toLowerCase()) {
            case "1": case "jan": case "jan.": case "january": return 1;
            case "2": case "feb": case "feb.": case "february": return 2;
            case "3": case "mar": case "mar.": case "march": return 3;
            case "4": case "apr": case "apr.": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "june": return 6;
            case "7": case "jul": case "july": return 7;
            case "8": case "aug": case "aug.": case "august": return 8;
            case "9": case "sep": case "sept.": case "september": return 9;
            case "10": case "oct": case "oct.": case "october": return 10;
            case "11": case "nov": case "nov.": case "november": return 11;
            case "12": case "dec": case "dec.": case "december": return 12;
            default: return 0; 
        }
    }
}
