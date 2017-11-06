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
public class RestaurantOwner {
    
    private static int id=1000;
    private String RestaurantName;
    private String ContactNo;
    private String address;
    private String style;
    private String AvailableTime;
    private String password;
    
    public RestaurantOwner()
    {
        
    }
    
    public RestaurantOwner(String RestaurantName,String ContactNo,String password, String address,String style,String AvailableTime)
    {
        
        this.RestaurantName = RestaurantName;
        this.ContactNo = ContactNo;
        this.address = address;
        this.style = style;
        this.AvailableTime = AvailableTime;
        this.password = password;
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAvailableTime() {
        return AvailableTime;
    }

    public void setAvailableTime(String AvailableTime) {
        this.AvailableTime = AvailableTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
