
package com.mycompany.bankApp.model;

/**
 *
 * @author Group-E
 */
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darag
 */

@XmlRootElement // Lets JAX-B know that this is the root element
public class Customer {
    //vars
    private static long idIdentifier = 77; // static class var to auto-assign id //sean
    private long customerId;
    private String name;
    private String address;
    private String email;
    private String userid;
    private String pin;
    private Date dateCreated;
//    private String houseNumber; // Or we can use Sean's ones....
//    private String streetName;
//    private String areaName;
//    private String town;
//    private String county;
//    private String country;

    //public Customer(long customerId, String name, String address, String email, String userid, String pin) {
    public Customer(String name, String address, String email, String userid, String pin) {
        //this.customerId = customerId;
        this.customerId = ++idIdentifier; //sean :  increments idIdentifier and assigns
        this.name = name;
        this.address = address;
        this.email = email;
        this.userid = userid;
        this.pin = pin;
        this.dateCreated = new Date(); // sean : can be handy, and is free.
    }

    public Customer() {
    }

    public static long getIdIdentifier() {
        return idIdentifier;
    }

    public static void setIdIdentifier(long idIdentifier) {
        Customer.idIdentifier = idIdentifier;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }

  

}
