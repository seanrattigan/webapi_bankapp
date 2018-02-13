
package com.mycompany.bankApp.service;

import com.mycompany.bankApp.database.DatabaseClass;
import com.mycompany.bankApp.model.Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Group-E
 */
public class CustomerService {
       //Added after creating fake db serviceclass DatabaseClass.java
    private Map<Long, Customer> customers = DatabaseClass.getCustomers();
    
    public CustomerService() {
        if ( customers.size() ==0 )  {
            Customer customer1 = new Customer("Daragh Mulvey","10 Some Street, Somewhere","daragh.mulvey@gmail.com","daragh", "007");
            Customer customer2 = new Customer("Ajitha Devapathni","35 Some other Street, Newbridge","ajitha@place.com","ajitha","552135");
            Customer customer3 = new Customer("Chen Sagi","49 Lower Place, Sometown","chen@place.com","ajitha","123456");
            Customer customer4 = new Customer("Sean Rattigan","3 Lower Back, Athlon","ihatewindows@place.com","sean","987454");
            customers.put(customer1.getCustomerId(), customer1);
            customers.put(customer2.getCustomerId(), customer2);
            customers.put(customer3.getCustomerId(), customer3);
            customers.put(customer4.getCustomerId(), customer4);
//        customers.put(78L, new Customer("Daragh Mulvey","10 Some Street, Somewhere","daragh.mulvey@gmail.com","daragh", "007"));
//        customers.put(79L, new Customer("Ajitha Devapathni","35 Some other Street, Newbridge","ajitha@place.com","ajitha","552135"));
//        customers.put(80L, new Customer("Chen Sagi","49 Lower Place, Sometown","chen@place.com","ajitha","123456"));
//        customers.put(81L, new Customer("Sean Rattigan","3 Lower Back, Athlon","ihatewindows@place.com","sean","987454"));
        }
    }
    
    public List<Customer> getAllCustomers() {
        return new ArrayList<Customer>(customers.values());
    }

    
    public Customer getCustomer(long customerId) {
        return customers.get(customerId);
    }
   
    
    /** AJITHA'S Code that matches by name - hope to edit so that it does partial matches like a search **/
 public Customer getCustomer(String name) {
        for(Customer temp : customers.values()){
            if(temp.getName().equals(name)){
                return temp;
            }
        }      
     return null;
 }

/** Attempt at a list of customers **/
//public void printMap(Map customers) {
//    Iterator cust = customers.entrySet().iterator();
//    while (cust.hasNext()) {
//        Map.Entry pair = (Map.Entry)cust.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
//        //cust.remove(); // avoids a ConcurrentModificationException
//    }
//    //return pair;
//}

    
//    public Customer addCustomer(Customer customer) {
//        //customer.setCustomerId(customers.size()+1);
//        customer.setCustomerId(customer.getCustomerId());
//        customers.put(customer.getCustomerId(),customer);
//        return customer;
//    }
    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(customer.getCustomerId());
        customers.put(customer.getCustomerId(),customer);
        return customer;
    }
    public Customer updateCustomer(Customer customer) {
        if(customer.getCustomerId() <= 0) {
            return null;
        }
        customers.put(customer.getCustomerId(),customer);
        return customer;
    }
    public Customer removeCustomer(long customerId) {
        System.out.println("Customer ID to delete: " + customerId);
        return customers.remove(customerId);
    }
}
