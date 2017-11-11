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
public class FoodMenu {
    
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Food> AllFood = new ArrayList<>();
    ArrayList<Food> flist = new ArrayList<>();
    public void addFood()
    {
        String option;
        
        
       do{
           Food f=new Food();
            option="";
        System.out.println("Add New Food\n(Type \"exit\" at any input to Cancel");
        System.out.println("--------------------------------");
        System.out.print("Please input Food Name : ");
        f.setFoodName(scan.nextLine());
        if(checkExit(f.getFoodName()))
            return;
       
        f.setPrice(checkInput("Please input a price : "));
        if(checkExit(f.getPrice()+""))
            return;
        f.setQuantity(checkIntInput("Please input a quantity : "));
        if(checkExit(f.getQuantity()+""))
            return;
       // checkInput("Please input a Category : ");
       
        String cat =  chooseCategory();
        f.setCategory(cat);
        if(checkExit(f.getCategory()+""))
            return;
       
         String day = chooseAvailableDay();
        f.setDayAvailable(day);
        if(checkExit(f.getDayAvailable()+""))
            return;
        f.setCompanyName("Jeffrey Restaurant");
        AllFood.add(f);
        System.out.println("\nYou Are successfully add new food, Food ID Is "+f.getFoodID()+"\n");
        System.out.println("Summary Of new Food");
        System.out.println("Food Name       : "+ f.getFoodName());
        System.out.println("Quantity        : "+ f.getQuantity());
        System.out.println("Category        : "+ f.getCategory());
        System.out.println("Available Day   :"+ f.getDayAvailable());
        System.out.println("Price/Unit      :"+ f.getPrice());
       do{
        
        System.out.println("\nDo you want to add more food? Y/N");
        option = scan.nextLine();}while(!option.equals("Y")&&!option.equals("N"));}while(option.equals("Y"));
        return;
    }
    
    public static boolean checkExit(String test)
   {
       boolean exit = false;
       if(test.equals("exit"))
          exit=true;
       return exit;
   }
    
    public double checkInput(String title)
    {
        int i=0;
        double x=0;
         do{
             i=0;
        System.out.println();
        System.out.print(title);
        try{
           x = scan.nextDouble();
                }catch(Exception e)
        {
            System.out.println("Invalid Input");
            i++;
        }scan.nextLine();}while(i!=0);
       
        return x;
    }
     public void displayAllFood()
     {
         ArrayList<String> name = new ArrayList<>();
         int option=0;
         int j=0;
         int grabFoods=0;
         System.out.println("Food Name        Category         Quantity           Price          Day");
          System.out.println("=========        ========         ========           =====         ===");
         for(int i=0;i<AllFood.size();i++)
         {
             if( AllFood.get(i).getCompanyName().equals("Jeffrey Restaurant") )
             { 
                 System.out.println(j+"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice()+"         "+     AllFood.get(i).getDayAvailable());
                 j++;
                 name.add(AllFood.get(i).getFoodName());
             }
         }
         do{
         System.out.println("Please select a food : ");
         try{
         option = scan.nextInt();scan.nextLine();}catch(Exception e){
             System.out.println("Invalid Input");
             scan.nextLine();
             displayAllFood();
         }
         if(option<=name.size())
         {
             for(int i=0;i<AllFood.size();i++)
             {if(name.get(option).equals(AllFood.get(i).getFoodName()))
             {System.out.println("Food That you selected : "+AllFood.get(i).getFoodName());
               grabFoods=i;}
             }
             
         }
         }while(option>name.size());
         if(!name.isEmpty())
         {
         System.out.println("1. Delete Food  2. Update Food  3.Exit");
         String grab = scan.nextLine();
         do{if(grab.equals("1")){deleteFood(grabFoods);displayAllFood();}else if(grab.equals("2")){}else if(grab.equals("3")){return;}else{System.out.println("Invalid Input");}}while(!grab.equals("1") &&!grab.equals("2")&& !grab.equals("2")&&!grab.equals("3"));}else{return;}
         name.clear();
     }
     
     public void deleteFood(int option)
     {
         AllFood.remove(option);
     }
     public int checkIntInput(String title)
    {
        Scanner in = new Scanner(System.in);
        int i=0;
        int j=0;
         do{
            
       System.out.println();
        System.out.print(title);
        try{
            i=0;
           
           
            j=in.nextInt();
            
           if(j<0)
               i++;
           
               
                }catch(Exception e)
        {
            
            System.out.println("Invalid Input");
            i++;
        }in.nextLine();}while(i!=0);
       
        
        return j;
    }
    
     public String chooseAvailableDay()
   {
       String style="";
       int choose;
       System.out.print("Please choose a Day (1.Monday & Tuesday or 2.Wednesday & Thursday or 3.Friday & Saturday or 4.Sunday "
                );
       choose = scan.nextInt();
       scan.nextLine();
       switch(choose)
       {
           case 1:
                style="Monday & Tuesday";
                break;
            case 2:
                 style="Wednesday & Thursday";
                break;
            case 3:
                 style="Friday & Saturday";
                break;
            default:
                   style = "Sunday";
                   break;
                
               
       }
       return style;
   }
     
     public String chooseCategory()
   {
       String styles="";
       System.out.print("Please choose a Category (1.Set or 2.Beverage or 3.Noodles or 4.Others(Please Specify)) "
                );
      
       
       switch(scan.nextInt())
       {
           case 1:
                styles="Set";
                break;
            case 2:
                 styles="Beverage";
                break;
            case 3:
                 styles="Noodles";
                break;
            default:
                   System.out.print("Please input other category: ");
                   scan.nextLine();
                   styles = scan.nextLine();
                   break;
                
               
       }
      scan.nextLine();
       return styles;
   }
     
     public void displayMenu()
     {
        
         int options;
         Collections.sort(AllFood,Comparator.comparing(Food::getFoodName));
        do{
         String CompanyName="";
         
         
         Calendar cal = Calendar.getInstance();
         int d = cal.get(Calendar.DAY_OF_WEEK);
         System.out.print("Today Menu List : \n");
         System.out.print("Select Company Name : \n");
         for(int i=0;i<Restaurant.Ro.size();i++)
         {
             System.out.print(i+" "+Restaurant.Ro.get(i).getRestaurantName()+"\n");
         }
         
         CompanyName = Restaurant.Ro.get(scan.nextInt()).getRestaurantName(); 
          System.out.println("Food Name        Category         Quantity           Price");
          System.out.println("=========        ========         ========           =====");
         for(int i=0;i<AllFood.size();i++)
         {
            
             if(d==1 && AllFood.get(i).getCompanyName().equals(CompanyName) && AllFood.get(i).getDayAvailable().equals("Sunday"))
             { flist.add(AllFood.get(i));
                 System.out.println(flist.size()+"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());}
             if((d==2 || d==3)&& AllFood.get(i).getCompanyName().equals(CompanyName) && (AllFood.get(i).getDayAvailable().equals("Monday & Tuesday")))
             {flist.add(AllFood.get(i));
                    System.out.println(flist.size()+"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());}
                 if((d==4 || d==5) && AllFood.get(i).getCompanyName().equals(CompanyName) && (AllFood.get(i).getDayAvailable().equals("Wednesday & Thursday")))
                 {flist.add(AllFood.get(i)); 
                  System.out.println(flist.size()+"      "+AllFood.get(i).getFoodName()+"             "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());}
                     if((d==6 || d==7) && AllFood.get(i).getCompanyName().equals(CompanyName) && (AllFood.get(i).getDayAvailable().equals("Friday & Saturday")))
                     { flist.add(AllFood.get(i));
                      System.out.println(flist.size()+"      "+AllFood.get(i).getFoodName()+"            "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());}
           
                         }  System.out.println("Please choose a sort options : 1. Sort By Name 2. Sort By Categories 3. Sort By Price");
                          options=scan.nextInt();
                         switch(options)
                         {
                             case 1:
                                  Collections.sort(AllFood,Comparator.comparing(Food::getFoodName));
                                  break;
                             case 2:
                                 Collections.sort(AllFood,Comparator.comparing(Food::getCategory));
                                 break;
                             default:
                                 Collections.sort(AllFood,Comparator.comparing(Food::getPrice));
                                 break;
                                  
                         }
     }while(options<4&&options>0);
     
     }
 
}
