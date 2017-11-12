package Java;

import Domain.DeliveryMen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Teck Siong
 */
public class updDelmenConInfo {

    Scanner scan = new Scanner(System.in);
    ArrayList<DeliveryMen> ad = new ArrayList();
    String ans;
    int i;
    int c;

    public void DeliveryMenDetails() {
        ad.add(new DeliveryMen(601001, "ABC123", "Jorn Lim", "011-12345678", "Pertaling Jaya", "13/11/2016", "Available"));
        ad.add(new DeliveryMen(601002, "Hii123", "Mark", "018-1234567", "Wangsa Maju", "10/11/2016", "Available"));
        ad.add(new DeliveryMen(601003, "Waa123", "Jolin", "017-1234567", "Setapak", "17/11/2016", "Available"));
        ad.add(new DeliveryMen(601004, "Qzz123", "Sam", "016-1234567", "Seremban", "21/11/2016", "Available"));
        ad.add(new DeliveryMen(601005, "Zaa123", "Zack", "013-1234567", "Port Dickson", "30/11/2016", "Available"));
    }

    public void RegisterDelMan() {
        c = 0;
        if (c == 0) {
            DeliveryMenDetails();
            updDelmenConInfo();
        } else {
            updDelmenConInfo();
        }
    }

    public void updDelmenConInfo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Update Contact Information");
        System.out.println("Enter 'exit' to cancel the Update");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Delivery men's ID : ");
        ans = scan.nextLine();
        int count = 0;
        if (!ans.equals("exit")) {
            for (i = 0; i < ad.size(); i++) {
                if (Integer.parseInt(ans) == ad.get(i).getDelmenId()) {
                    result();
                    count = 1;
                }
                if (count == 1) {
                    System.out.println("Invalid ID number!");
                    System.out.println("");
                    updDelmenConInfo();
                }
            }
        } else {
            exit();
        }
        System.out.println("----------------------------------------------------");
    }

    public void exit() {
        System.out.println("");
        System.out.println("You have cancel the Update~");
        System.out.print("Do You want to Update again? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                System.out.println("");
                updDelmenConInfo();
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

    public void result() {
        System.out.println("====================================================");
        System.out.println("Delivery Men's Information");
        System.out.println("====================================================");
        System.out.println("ID Number : " + ad.get(i).getDelmenId());
        System.out.println("Name : " + ad.get(i).getDelmenName());
        System.out.println("Contact Number : " + ad.get(i).getContactNum());
        System.out.println("Home Address : " + ad.get(i).getHomeAddress());
        System.out.println("Join Date : " + ad.get(i).getJoinDate());
        System.out.println("Status : " + ad.get(i).getStatus());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("************************");
        System.out.println("Update for > ");
        System.out.println("1. Contact Number");
        System.out.println("2. Home Address");
        System.out.println("0. Exit");
        System.out.println("************************");
        String update = scan.nextLine();
        System.out.println("");
        switch (update) {
            case "1":
                System.out.print("Enter new contact number : ");
                String upd = scan.nextLine();
                Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                Matcher matcher = pattern.matcher(upd);
                if (!matcher.matches()) {
                    System.out.println("Invalid Format! E.g. 011-23456789");
                    System.out.println("");
                    result();
                } else {
                    System.out.println("");
                    System.out.println("Update Successful!");
                    ad.get(i).setContactNum(upd);
                    System.out.println("");
                    finalResult();
                }
                break;
            case "2":
                System.out.print("Enter new Home Address : ");
                String home = scan.nextLine();
                System.out.println("");
                System.out.println("Update Successful!");
                ad.get(i).setHomeAddress(home);
                System.out.println("");
                finalResult();
                break;
            case "0":
                exit();
                break;
            default:
                System.out.println("Invalid input! (1/2/0)");
                System.out.println("");
                result();
                break;
        }
    }

    public void finalResult() {
        System.out.println("====================================================");
        System.out.println("Delivery Men's Information");
        System.out.println("====================================================");
        System.out.println("ID Number : " + ad.get(i).getDelmenId());
        System.out.println("Name : " + ad.get(i).getDelmenName());
        System.out.println("Contact Number : " + ad.get(i).getContactNum());
        System.out.println("Home Address : " + ad.get(i).getHomeAddress());
        System.out.println("Join Date : " + ad.get(i).getJoinDate());
        System.out.println("Status : " + ad.get(i).getStatus());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("Do you want continue? [Y/N]");
        System.out.println("****************************************************");
        String ans = scan.nextLine();
        switch (ans) {
            case "Y":
                result();
                break;
            case "N":
                System.out.println("Thanks for using our system~");
                System.out.println("");
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                finalResult();
                break;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
