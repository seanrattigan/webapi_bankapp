/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankApp.resources;

import static com.mycompany.bankApp.database.commonHtml.htmlend;
import static com.mycompany.bankApp.database.commonHtml.htmlstart;
import static com.mycompany.bankApp.database.commonHtml.menu;
import com.mycompany.bankApp.model.Account;
import com.mycompany.bankApp.model.Customer;
import com.mycompany.bankApp.service.AccountService;
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

/**
 *
 * @author Group-E
 */
@Path("/accounts")
public class AccountResource {

    AccountService accountService = new AccountService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Account> getAccountsXML() {
        return accountService.getAllAccounts();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountsJSON() {
        return accountService.getAllAccounts();
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_XML)
    public Account getAccountXML(@PathParam("accountId") long accountId) {
        return accountService.getAccount(accountId);
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountJSON(@PathParam("accountId") long accountId) {
        return accountService.getAccount(accountId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Account addAccountXML(Account account) {
        return accountService.addAccount(account);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addAccountJSON(Account account) {
        return accountService.addAccount(account);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/addAccCustId")
    public String ShowSomething(@FormParam("customerId") double customerId) {
        String htmlform = " <form method=\"post\" action=\"http://localhost:8080/webapi-V9b/accounts/\">\n"
                + "        <!--Enter ID: <input type=\"text\" name=\"customerId\" /><br /> -->\n"
                + "\n"
                + "        <table>\n"
                + "            <tr>\n"
                + "                <td width=\"200\">Customer ID: </td>\n"
                + "                <td width=\"300\"><input type=\"text\" name=\"customerId\" value=\"  " + customerId + "\" /></td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td width=\"200\">Balance:</td>\n"
                + "                <td width=\"300\"><input type=\"text\" name=\"curBalance\" /></td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td width=\"200\">Sort Code: </td>\n"
                + "                <td width=\"300\"><input type=\"text\" name=\"sortCode\" /></td>\n"
                + "            </tr>\n"
                + "\n"
                + "\n"
                + "            <td width=\"500\" colspan=\"2\"><input type =\"submit\" value=\"GO\" /></td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </form>";
        return htmlform;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    //public String outputHtml(@FormParam("customerId") double customerId,
    public String addAccount(
            @FormParam("accountId") long accountId,
            @FormParam("accNum") long accNum,
            @FormParam("customerId") long customerId,
            @FormParam("curBalance") double curBalance,
            @FormParam("sortCode") long sortCode) {

        System.out.println("@Post: From Add account form");
        //Customer cust = new Customer(customerId, name,address,email,userid,pin);
        //public Account(long accountId, long accNum, long sortCode, double curBalance, double customerId) {
        //Account acc = new Account(accountId, accNum, sortCode, curBalance, customerId);

        Account acc = new Account(sortCode, curBalance, customerId);
        //customerService.addCustomer(cust);
        accountService.addAccount(acc);

        String msg = "<h2>This is what should now be in our system database:</h2>";
        msg += "<p> Account ID: --> we'd need to retrieve this as system shows --> " + customerId + " </p>";
        msg += "<p>Current Balance : " + curBalance + " </p>";
        msg += "<p>Customer ID: " + customerId + " </p>";
        msg += "<p>Sort Code: " + sortCode + " </p>";

        return msg;
    }

    @PUT
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_XML)
    public Account updateAccountXML(@PathParam("accountId") long accountId, Account account) {
        account.setAccountId(accountId);
        return accountService.updateAccount(account);
    }

    @PUT
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account updateAccountJSON(@PathParam("accountId") long accountId, Account account) {
        account.setAccountId(accountId);
        return accountService.updateAccount(account);
    }

    @DELETE
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_XML)
    public Account deleteAccountXML(@PathParam("accountId") long accountId) {
        return accountService.removeAccount(accountId);
    }

    @DELETE
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account deleteAccountJSON(@PathParam("accountId") long accountId) {
        return accountService.removeAccount(accountId);
    }

//    @POST
//    @Produces(MediaType.TEXT_HTML)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Path("/delete")
//    public String deleteAccountHTML(@FormParam("accountId") long accountId) {
//        System.out.println("Trying to remove: " + accountId);
//        accountService.removeAccount(accountId);
//        
//        return("<p>Account ID: " + accountId + " deleted!" + "</p>");
//    }
//    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete") // Jersey will expect string here, but will auto convert to long as it sees long in line 49
    public String delAccountHTML(@FormParam("accountId") long accountId) {
        Account obj = accountService.getAccount(accountId);
        if (obj == null) {
            System.out.println("Empty - already deleted - Account ID: " + accountId);
            return "Already delete accountId: " + accountId + " (return)";
        } else {

            System.out.println("Attempting to remove account accountId: " + accountId);
            accountService.removeAccount(accountId);
            return "Account: " + obj.getAccountId() + " deleted";
        }
    }

    @POST
    @Path("/byid")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getAccountHTML(@FormParam("accountId") long accountId) {
        System.out.println("Console: Test by id " + accountId);
        Account obj = accountService.getAccount(accountId);
        if (obj == null) {
            System.out.println("Cannot find this account - already deleted?");
            return "Already deleted or doesn't exist (return)";
        } else {
            System.out.println("Trying to get customer via Account ID: " + accountId);
            String htmlCode = htmlstart + "<table><tr><td>ID</td><td>Account Number</td><td>Sort Code</td><td>Current Balance</td><td>Customer ID</td><td>Delete</td><td>Add Acc </td></tr>";

            htmlCode += "<tr><td>" + obj.getAccountId() + "</td>";
            htmlCode += "<td>" + obj.getAccNum() + "</td>";
            htmlCode += "<td>" + obj.getSortCode() + "</td>";
            htmlCode += "<td>" + obj.getCurBalance() + "</td>";
            htmlCode += "<td>" + obj.getCustomerId() + "</td>";
            htmlCode += "<td><form method='post' action='http://localhost:8080/webapi-V9b/accounts/delete\' ><input type='submit' name='accountId' value='" + obj.getAccountId() + "'/></form></td>";

            htmlCode += "<td><form method='post' action='http://localhost:8080/webapi-V9b/accounts/addAccCustId\' ><input type='submit' name='acountId' value='" + obj.getAccountId() + "'/></form></td>";
            htmlCode += "</tr></table>";

            htmlCode += htmlend;
            return htmlCode;
        }
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/showbalance")
    public String getAccountBalanceHTML(@FormParam("accNum") long accNum) {
        return "<html><body><h1> The current balance for your account " + accNum + " is " + accountService.getAccountBalance(accNum) + " euros </h1></body></html>";
    }

    @GET
    @Path("/balance/{accNum}")
    @Produces("text/html")
    public String getAccountBalanceXML(@PathParam("accNum") long accNum) {
        return "<html><body><h1> The current balance for your account " + accNum + " is " + accountService.getAccountBalance(accNum) + " euros </h1></body></html>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAccounts() {
        StringBuilder returnmsg = new StringBuilder();
        returnmsg.append(menu);
        String tableStart = "<table border='1' cellpadding='2' cellspacing='0' width='100%'>";
        tableStart += "<tr>\n\t<td>Acc ID</td><td>Acc Num</td><td>Sort Code</td><td>Balance</td><td>Customer ID</td><td>Customer ID (in DB)</td><td>Date Created</td><td>Delete Acc</td><td>Customer Info</td>\n</tr>";
        String tableEnd = "</table>";
        returnmsg.append(tableStart);
        for (Account acc : accountService.getAllAccounts()) {
            returnmsg.append(this.objectToString(acc));
        }
        returnmsg.append(tableEnd);
        return returnmsg.toString();
    }

    private String objectToString(Account acc) {

        //hack for customerId
        
        String custId = Double.toString(acc.getCustomerId());
        String bits[] = custId.split("\\.");
        String newCustId = bits[0];
        
        
        
        String msg = "";
        msg += "<tr>\n\t<td>ID:" + acc.getAccountId() + " </td>\n";
        msg += "\t<td>" + acc.getAccNum() + " </td>\n";
        msg += "\t<td>" + acc.getSortCode() + " </td>\n";
        msg += "\t<td>" + acc.getCurBalance() + " </td>\n";
        msg += "\t<td>" + newCustId + " </td>\n";
        msg += "\t<td>" + acc.getCustomerId() + " </td>\n";
        msg += "\t<td>" + acc.getDateCreated() + " </td>\n";
        msg += "\t<td><form method='post' action='http://localhost:8080/webapi-V10/accounts/delete' ><input type='image' src='/img/delete-account.jpg' name='accountId' value='" + acc.getAccountId() + "'/></form></td>\n";
        msg += "\t<td><form method='post' action='http://localhost:8080/webapi-V10/customers/byId' ><input type='image' src='/img/view-customer.jpg' name='customerId' value='" + newCustId + "'/></form></td>\n</tr>\n";
        return msg;
    }
}
