/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucaspart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class selectrestaurant {
    
    public Scanner scan = new Scanner(System.in);
    public ArrayList<String> input = new ArrayList<>();
    
    public void sRestaurant(){
    
        System.out.println("Restaurant Selection\n");
        System.out.println("--------------------------------\n\n\n");
        System.out.print("Please key in Restaurant Name : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
        System.out.print("Please key in restaurant address : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
        
        System.out.println("You have done the restaurant selection..........");
        
        
    }
    public boolean checkExit(ArrayList l)
   {
       boolean exit = false;
       if(l.contains("exit"))
          exit=true;
       return exit;
   }
    
    public static void main(String[] args) {
        // TODO code application logic here

        selectrestaurant a = new selectrestaurant();
         a.sRestaurant();

    }
    
}
