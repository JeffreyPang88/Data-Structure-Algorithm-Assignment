/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastest.deliveryman;

/**
 *
 * @author Jeffrey
 */
public class FastestDeliveryman {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         Restaurant r = new Restaurant();
         FoodMenu f = new FoodMenu();
         r.registrationRestaurantOwner();
         r.DisplayAccountInfo();
        // f.addFood();
         //f.displayAllFood();
         //f.displayMenu();
         
    }
    
}