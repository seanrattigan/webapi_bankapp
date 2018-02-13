/** This version taken from Sean's v9b2 **/
package com.mycompany.bankApp.database;

import com.mycompany.bankApp.model.Account;
import com.mycompany.bankApp.model.Customer;
import com.mycompany.bankApp.model.Transaction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Group-E
 */
public class DatabaseClass {
                // AccountNum, Acc instance
    public static Map<Long, Account> accounts = new HashMap<>();
                // customerId, Customer instance
    public static Map<Long, Customer> customers = new HashMap<>();
                // transactionID, Trans instance
    public static Map<Long, Transaction> transactions = new HashMap<>();

    public static Map<Long, Account> getAccounts() {
        return accounts;
    }
    
    public static Map<Long, Customer> getCustomers() {
        return customers;
    }
    
    public static Map<Long, Transaction> getTransactions() {
        return transactions;
    }
    
    

}
