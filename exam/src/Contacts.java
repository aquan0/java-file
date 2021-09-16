import java.util.HashMap;
import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        String name, numberPhone;

        while(true) {
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Number phone: ");
            numberPhone = sc.nextLine();
             if (numberPhone.equals("x") || numberPhone.equals("X")) {
                 System.out.println(map);
                 break;
             }
             map.put(name,numberPhone);
        }
    }
}
