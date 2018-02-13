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
import com.mycompany.bankApp.model.Transaction;
import com.mycompany.bankApp.service.AccountService;
import com.mycompany.bankApp.service.CustomerService;
import com.mycompany.bankApp.service.TransactionService;
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
public class GenerateListTransactions {
    public static void main(String[] args) {
        
    TransactionService tranasctionService = new TransactionService();
    Map<Long, Transaction> transactions = DatabaseClass.getTransactions();

    System.out.println("---------------- ANYTHING IN TABLE? ------------------");
    for (Long key : transactions.keySet ()) {
   
        //System.out.println("Iterating or looping map using java5 foreach loop");
        //System.out.println("key: " + key + " value: " + transactions.get(key) + " Name: " + transactions.get(key).getName() + " Address: " + transactions.get(key).getAddress());
        System.out.println("key: " + key + " value: " + transactions.get(key) + " Name: " + transactions.get(key).getType() + " : " + transactions.get(key).getSourceAcc() + " : " + transactions.get(key).getDestinationAcc());
    }
}

}