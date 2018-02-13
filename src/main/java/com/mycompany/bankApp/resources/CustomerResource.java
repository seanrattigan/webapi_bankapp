/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankApp.resources;

import com.mycompany.bankApp.database.commonHtml;
import static com.mycompany.bankApp.database.commonHtml.htmlend;
import static com.mycompany.bankApp.database.commonHtml.htmlstart;
import static com.mycompany.bankApp.database.commonHtml.menu;
import com.mycompany.bankApp.model.Account;
import com.mycompany.bankApp.model.Customer;
import com.mycompany.bankApp.service.AccountService;
import com.mycompany.bankApp.service.CustomerService;
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
 * @author Group-E
 */
@Path("/customers")
public class CustomerResource {

    CustomerService customerService = new CustomerService();
    AccountService accountService = new AccountService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    //@XmlHeader("<?xml-stylesheet type=\"text/css\" href=\"http://localhost:8080/style.css\"?>")
    public List<Customer> getCustomersXML() {
        return customerService.getAllCustomers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomersJSON() {
        return customerService.getAllCustomers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public Customer getCustomerJSON(@PathParam("customerId") long customerId) {
        return customerService.getCustomer(customerId);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    //@XmlHeader("<?xml-stylesheet type=\"text/css\" href=\"http://localhost:8080/style.css\"?>")
    @Path("/{customerId}") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public Customer getCustomerXML(@PathParam("customerId") long customerId) {
        return customerService.getCustomer(customerId);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/list") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public String showSomething() {
        String msg = "Arbitary HTML";
        return msg;

    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/byId") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public String getCustomerHTML(@FormParam("customerId") long customerId) {
        Customer obj = customerService.getCustomer(customerId);
        System.out.println("Trying to get customer via Customer ID: " + customerId);
        String htmlCode = htmlstart + "<table><tr><td>ID</td><td>Name</td><td>Address</td><td>Email</td><td>User ID</td><td>User Pin</td><td>Delete</td><td>Add Acc </td></tr>";
        htmlCode += "<tr><td>" + obj.getCustomerId() + "</td>";
        htmlCode += "<td>" + obj.getName() + "</td>";
        htmlCode += "<td>" + obj.getAddress() + "</td>";
        htmlCode += "<td>" + obj.getEmail() + "</td>";
        htmlCode += "<td>" + obj.getUserid() + "</td>";
        htmlCode += "<td>" + obj.getPin() + "</td>";
        htmlCode += "<td><form method='post' action='http://localhost:8080/webapi-V10/customers/delete\' ><input type='submit' name='customerId' value='" + obj.getCustomerId() + "'/></form></td>";

        htmlCode += "<td><form method='post' action='http://localhost:8080/webapi-V10/accounts/addAccCustId\' ><input type='submit' name='customerId' value='" + obj.getCustomerId() + "'/></form></td>";
        htmlCode += "</tr></table>";
        htmlCode += htmlend;
        return htmlCode;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer addCustomerJSON(Customer customer) { // Accept the model type as argument to bind to the request body
        //return "Post works!";
        return customerService.addCustomer(customer);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Customer addCustomerXML(Customer customer) { // Accept the model type as argument to bind to the request body
        //return "Post works!";
        return customerService.addCustomer(customer);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    //public String outputHtml(@FormParam("customerId") long customerId,
    public String addCustomer(@FormParam("customerId") long customerId,
            @FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("email") String email,
            @FormParam("userid") String userid,
            @FormParam("pin") String pin) {

        //Customer cust = new Customer(customerId, name,address,email,userid,pin);
        Customer cust = new Customer(name, address, email, userid, pin);
        //Account acc = new Account(accountId, accNum,sortCode,curBalance,customerId);
        customerService.addCustomer(cust);
        //accountService.addAccount(account);

        String msg = "<h2>This is what should now be in our system database:</h2>";
        msg += "<p>ID: --> we'd need to retrieve this as system shows --> " + customerId + " </p>";
        msg += "<p>Name: " + name + " </p>";
        msg += "<p>Address: " + address + " </p>";
        msg += "<p>Email: " + email + " </p>";
        msg += "<p>UserID: " + userid + " </p>";
        msg += "<p>Pin: " + pin + " </p>";

        return msg;

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{customerId}") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public void delCustomerJSON(@PathParam("customerId") long customerId) {
        System.out.println("Attemptting to remove customer customerId: " + customerId);
        customerService.removeCustomer(customerId);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/{customerId}") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public void delCustomerXML(@PathParam("customerId") long customerId) {
        System.out.println("Attemptting to remove customer customerId: " + customerId);
        customerService.removeCustomer(customerId);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public String delCustomerHTML(@FormParam("customerId") long customerId) {
        Customer obj = customerService.getCustomer(customerId);
        if (obj == null) {
            System.out.println("Empty - already deleted");
            return "Already delete (return)";
        } else {

            System.out.println("Attemptting to remove customer customerId: " + customerId);
            customerService.removeCustomer(customerId);
            return "Customer: " + obj.getName() + " deleted";
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{customerId}")
    public Customer updateCustomer(@PathParam("customerId") long customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerService.updateCustomer(customer);
    }

    /**
     * AJITHA'S Code that matches by name - hope to edit so that it does partial
     * matches like a search *
     */
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/search")
    public String customer(@FormParam("name") String name) {
        System.out.println("Show in console - from search " + name);
        Customer temp = customerService.getCustomer(name);
        String msg = "<p>Name: " + name + " </p>";
        String address = temp.getAddress();
        String all = temp.getName() + " " + temp.getAddress() + " " + temp.getUserid() + " " + temp.getUserid();
        msg += "<p>Address: " + address + " </p>";
        msg += all;
        return msg;

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getCustomers() {
        
        StringBuilder returnmsg = new StringBuilder();
        returnmsg.append(menu);
        String tableStart = "<table border='1' cellpadding='2' cellspacing='0' width='100%'>";
        tableStart +="<tr>\n\t<td>ID</td><td>Name</td><td>Address</td><td>Email</td><td>User ID</td><td>Pin</td>\n</tr>";
        String tableEnd = "</table>";
        returnmsg.append(tableStart);
        for (Customer cust : customerService.getAllCustomers()) {
            returnmsg.append(this.objectToString(cust));
        }
        returnmsg.append(tableEnd);
        return returnmsg.toString();
    }

    private String objectToString(Customer cust) {
        
        
        String msg = "";
        
        //msg +=  "<h2>This is what should now be in our system database:</h2>";
        msg += "<tr>\n\t<td>ID:" + cust.getCustomerId() + " </td>\n";
        msg += "\t<td>" + cust.getName() + " </td>\n";
        msg += "\t<td>" + cust.getAddress() + " </td>\n";
        msg += "\t<td>" + cust.getEmail() + " </td>\n";
        msg += "\t<td>" + cust.getUserid() + " </td>\n";
        msg += "\t<td>" + cust.getPin() + " </td>\n";
        msg += "\t<td><form method='post' action='http://localhost:8080/webapi-V10/accounts/addAccCustId' ><input type='image' src='/img/add-account.jpg' name='customerId' value='" + cust.getCustomerId() + "'/></form></td>\n</tr>\n";
        
        

        return msg;
    }

}
