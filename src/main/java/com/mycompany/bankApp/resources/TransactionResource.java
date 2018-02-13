/*
 * V9b2_Sean
 */
package com.mycompany.bankApp.resources;

// importing the crap outta everything for the mo...
import com.mycompany.bankApp.database.commonHtml;
import static com.mycompany.bankApp.database.commonHtml.htmlend;
import static com.mycompany.bankApp.database.commonHtml.htmlstart;
import com.mycompany.bankApp.model.Account;
import com.mycompany.bankApp.model.Transaction;
import com.mycompany.bankApp.service.AccountService;
import com.mycompany.bankApp.service.TransactionService;
import java.util.List;
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
@Path("/transactions")
public class TransactionResource {
    
    TransactionService transactionService = new TransactionService();
    AccountService accountService = new AccountService();
    
    // POST Methods (create)
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Transaction addTransaction(Transaction trans) { // Accept the model type as argument to bind to the request body
        return transactionService.addTransaction(trans);
    }
    
    /**
     * Processes the form data to create an instance of Transaction and add
     * to the database
     * @param sourceAccId
     * @param destinationAccId
     * @param transactionAmount
     * @param operation
     * @param userid
     * @param pin
     * @return 
     */
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addTransaction(
        @FormParam("sourceAcc") long sourceAccId,
        @FormParam("destinationAcc") long destinationAccId,
        @FormParam("transactionAmount") double transactionAmount,
        @FormParam("operation") String operation,
        @FormParam("userid") String userid,
        @FormParam("pin") String pin) {
        
        if(operation.equals("transfer")){
            Transaction trans = new Transaction(sourceAccId, destinationAccId, operation, transactionAmount);
            System.out.println("Transfer Transaction Complete \n" + trans);
            transactionService.addTransaction(trans);
        }else{
            Transaction transDepWith = new Transaction(sourceAccId, operation, transactionAmount);
            System.out.println("Deposit/Withdrawal Transaction Complete \n" + transDepWith);
            transactionService.addTransaction(transDepWith);
        }
        return "Successful Transaction from resource";  // handy + debug
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/byId")
    public String getTransactionHTML(@FormParam("transactionId") long transactionId) {
        Transaction obj = transactionService.getTransaction(transactionId);
        System.out.println("Trying to get transaction via ID: " + transactionId);
        String htmlCode = htmlstart + "<table><tr><td>ID</td><td>Name</td><td>Address</td><td>Email</td><td>User ID</td><td>User Pin</td><td>Delete</td><td>Add Acc </td></tr>";
        htmlCode += "<tr><td>" + obj.getTransactionId() + "</td>";
        htmlCode += "<td>" + obj.getSourceAcc() + "</td>";
        htmlCode += "<td>" + obj.getDestinationAcc() + "</td>";
        htmlCode += "<td>" + obj.getTransDate() + "</td>";
        htmlCode += "<td>" + obj.getType()+ "</td>";
        htmlCode += "<td>" + obj.getTransactionAmount() + "</td>";
        
        // NOT ADAPTED FOR THIS APPLICATION
        //htmlCode +="<td><form method='post' action='http://localhost:8080/webapi-V9b/customers/delete\' ><input type='submit' name='customerId' value='" + obj.getCustomerId() + "'/></form></td>";
        // htmlCode +="<td><form method='post' action='http://localhost:8080/webapi-V9b/accounts/addAccCustId\' ><input type='submit' name='customerId' value='" + obj.getCustomerId() + "'/></form></td>";
        
        htmlCode += "</tr></table>";
        htmlCode += htmlend;
        return htmlCode;
    }
    
    /**
     * Gets all transactions from database, parsed as XML
     * @return All transactions as XML
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transaction> getTransactionsXML() {
        return transactionService.getAllTransactions();
    }
    
    /**
     * Gets all transactions from database, parsed as JSON
     * @return All transactions as XML
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactionsJSON() {
        return transactionService.getAllTransactions();
    }
    //long transactionId
    /**
     * Gets all transactions from database by ID, parsed as XML
     * @return All transactions as XML
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{transactionId}")
    public Transaction getTransactionXML(@PathParam("transactionId") long transactionId) {
        return transactionService.getTransaction(transactionId);
    }
    
    /**
     * Gets all transactions from database by ID, parsed as JSON
     * @return All transactions as XML
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{transactionId}")
    public Transaction getTransactionJSON(@PathParam("transactionId") long transactionId) {
        return transactionService.getTransaction(transactionId);
    }

}
