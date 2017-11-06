/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastest.deliveryman;
import java.util.*;
/**
 *
 * @author Jeffrey
 */
public class Restaurant {
    
    public Scanner scan = new Scanner(System.in);
    public static int Time;
    public static int count=0;
    public String temp;
    public ArrayList<String> input = new ArrayList<>();
    public ArrayList<RestaurantOwner> Ro = new ArrayList<>();
    
   public void registrationRestaurantOwner()
    {
        System.out.println("Registration Of Restaurant Owner\n(Type \"exit\" at any input to Cancel Registration");
        System.out.println("--------------------------------");
        System.out.print("Please input Restaurant Name : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
        System.out.print("Please input Contact No : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
       System.out.print("Please input Password : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
         System.out.print("Please input Address : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
        input.add(chooseStyleMethod());
        if(checkExit(input))
            return;
         do{
             if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time : Start TIme (Format HH:MM)");
          temp = scan.nextLine();
          if(checkExit(input))
            return;
         count++;
         }while(!checkTime(temp));
         count=0;
         input.add(temp);
         System.out.print("Please input Available Time : To");
          do{
              if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time : End TIme (Format HH:MM");
        temp = scan.nextLine();
        if(checkExit(input))
            return;
         count++;
        }while(!checkTime(temp));
         count=0;
         input.add(temp);
        RestaurantOwner o = new RestaurantOwner(input.get(0),input.get(1),
                input.get(2),input.get(3),input.get(4),input.get(5)+" - "+input.get(6));
        Ro.add(o);
         System.out.println("\nYou Are successfully Register New Account, Your ID Is "+Ro.get(0).getId()+"\n");
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Restaurant Name : "+ Ro.get(0).getRestaurantName());
        System.out.println("Contact No      : "+ Ro.get(0).getContactNo());
        System.out.println("Password        : "+ Ro.get(0).getPassword());
        System.out.println("Address         :"+ Ro.get(0).getAddress());
        System.out.println("Style           :"+ Ro.get(0).getStyle());
        System.out.println("Available Time  :"+ Ro.get(0).getAvailableTime());
        System.out.println("\nPress any key to continue");
        scan.nextLine();
       
    }
   
   public boolean checkExit(ArrayList l)
   {
       boolean exit = false;
       if(l.contains("exit"))
          exit=true;
       return exit;
   }
   
   public boolean checkTime(String test)
   {
       boolean timeValid = true;
       if( test.length()==5)
       {  if(test.charAt(2)==':' )
         {
            String split[]  = test.split(":");
            try{
                    if(Integer.parseInt(split[0])>24||Integer.parseInt(split[0])<-1)
                       timeValid=false;
                    if(Integer.parseInt(split[1])>=60||Integer.parseInt(split[1])<-1)
                       timeValid=false;
            }catch(NumberFormatException ex)
            {
                timeValid=false;
            }
         }else
           timeValid=false;}else
           timeValid=false;
       return timeValid;
   }
   
   public String chooseStyleMethod()
   {
       String style="";
       System.out.print("Please choose a Style (1.Korean or 2.Japanese or 3.Thai, "
               + "other character for other options) : ");
       style = scan.nextLine();
       
       switch(style)
       {
           case "1":
                style="Korean Style";
                break;
            case "2":
                 style="Japanese Style";
                break;
            case "3":
                 style="Thai Style";
                break;
            default:
                   System.out.print("Please input other style: ");
                   style = scan.nextLine();
                   break;
                
               
       }
       return style;
   }
    
    
}
