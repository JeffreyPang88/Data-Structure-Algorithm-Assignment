package Java;

import Domain.DeliveryMen;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterDelMen {

    Scanner scan = new Scanner(System.in);
    ArrayList<String> check = new ArrayList();
    ArrayList<DeliveryMen> ad = new ArrayList();
    String ans;

    public void RegisterDelMen() {
        System.out.println("----------------------------------------------------");
        System.out.println("Delivery Men Registration");
        System.out.println("Enter 'exit' to cancel the registration");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Delivery Men Name : ");
        ans = scan.nextLine();
        if (!"exit".equals(ans)) {
            check.add(ans);
            System.out.print("Enter Contact Number : ");
            ans = scan.nextLine();
            if (!"exit".equals(ans)) {
                Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                Matcher matcher = pattern.matcher(ans);
                if (!matcher.matches()) {
                    System.out.println("Invalid Format! E.g. 011-23456789");
                    System.out.println("");
                    RegisterDelMen();
                } else {
                    check.add(ans);
                    System.out.print("Enter Home Address : ");
                    ans = scan.nextLine();
                    if (!"exit".equals(ans)) {
                        check.add(ans);
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        result();
                    } else {
                        exit();
                    }
                }
            } else {
                exit();
            }
        } else {
            exit();
        }
    }

    public void result() {
        System.out.println("====================================================");
        System.out.println("Please confirm the information~");
        System.out.println("====================================================");
        System.out.println("ID Number : " + DeliveryMen.getDelmenID());
        System.out.println("Name : " + check.get(0));
        System.out.println("Contact Number : " + check.get(1));
        System.out.println("Home Address : " + check.get(2));
        System.out.println("Join Date : " + getDateTime());
        System.out.println("Status : Available");
        System.out.println("====================================================");
        System.out.println("Confirm? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                DeliveryMen dm = new DeliveryMen(DeliveryMen.getDelmenID(), "ABC123",check.get(0), check.get(1), check.get(2), getDateTime(), "Available");
                ad.add(dm);
                System.out.println("Register Sucessful!");
                System.out.println("");
                for (int i = 0; i < ad.size(); i++) {
                   System.out.println(""+ad.get(i).getDelmenId());
                System.out.println(""+ad.get(i).getDelmenName());
                }
                
                check.clear();
                RegisterDelMen();
                break;
            case "N":
                System.out.println("Register Unsucessful!");
                System.out.println("");
                check.clear();
                RegisterDelMen();
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                result();
                break;
        }
    }

    public void exit() {
        System.out.println("You have cancel the registration~");
        System.out.println("Do You want to register again? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                RegisterDelMen();
                System.out.println("");
                break;
            case "N":
                System.out.println("Thanks for using our system~");
                System.out.println("");
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                exit();
                break;
        }
    }

    private String getDateTime() {
        DateFormat joinDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return joinDate.format(date);
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
