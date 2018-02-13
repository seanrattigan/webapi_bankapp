/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://javarevisited.blogspot.com/2011/12/how-to-traverse-or-loop-hashmap-in-java.html#ixzz4dPHiwJav
 */
package com.mycompany.bankApp.database;

import com.mycompany.bankApp.database.commonHtml;
import static com.mycompany.bankApp.database.commonHtml.htmlend;
import static com.mycompany.bankApp.database.commonHtml.htmlstart;
import com.mycompany.bankApp.model.Account;
import com.mycompany.bankApp.model.Customer;
import com.mycompany.bankApp.service.AccountService;
import com.mycompany.bankApp.service.CustomerService;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.HttpMethod;
import org.glassfish.jersey.message.XmlHeader;

/**
 *
 * @author darag
 */
public class GenerateListCustomers {
    public static void main(String[] args) {
        
    CustomerService customerService = new CustomerService();
    Map<Long, Customer> customers = DatabaseClass.getCustomers();

    for (Long key : customers.keySet ()) {
   System.out.println("------------------------------------------------");
        //System.out.println("Iterating or looping map using java5 foreach loop");
        //System.out.println("key: " + key + " value: " + customers.get(key) + " Name: " + customers.get(key).getName() + " Address: " + customers.get(key).getAddress());
        System.out.println("key: " + key + " value: " + customers.get(key) + " Name: " + customers.get(key).getName() + " Address: " + customers.get(key).getAddress() + " URL WE CREATE: http://showcust/" + key);
    }
}

}
