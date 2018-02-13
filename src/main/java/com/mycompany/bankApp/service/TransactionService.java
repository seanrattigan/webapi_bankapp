/**
 * V9b2_Sean
 */
package com.mycompany.bankApp.service;

import com.mycompany.bankApp.database.DatabaseClass;
import com.mycompany.bankApp.model.Customer;
import com.mycompany.bankApp.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Group-E
 */
public class TransactionService {
    
    private Map<Long, Transaction> transactions = DatabaseClass.getTransactions();

    // no-arg constructor for maven
    public TransactionService() {
        if ( transactions.size() ==0 )  {
        Transaction t1 = new Transaction(123123123,456456456,"transfer",50);
        transactions.put(t1.getTransactionId(), t1);
//        transactions.put(79L, new Transaction("Ajitha Devapathni","35 Some other Street, Newbridge","ajitha@place.com","ajitha","552135"));
//        transactions.put(80L, new Transaction("Chen Sagi","49 Lower Place, Sometown","chen@place.com","ajitha","123456"));
//        transactions.put(81L, new Transaction("Sean Rattigan","3 Lower Back, Athlon","ihatewindows@place.com","sean","987454"));
        }
    }
    
    /**
     * 
     * @return all transactions from the database
     */
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions.values());
    }
    
    /**
     * gets the transaction by the ID
     * @param transactionId
     * @return a transaction instance
     */
    public Transaction getTransaction(long transactionId) {
        return transactions.get(transactionId);
    }

    /**
     * Not quite sure if this does anything, but mirrors Customer
     * @param theTransaction transaction to be added
     * @return the transaction object
     */
    public Transaction addTransaction(Transaction theTransaction) {
        transactions.put(theTransaction.getTransactionId(), theTransaction);
        return theTransaction;
    }
    
    /**
     * Update transaction details. Required? I don't know.
     * @param trans
     * @return 
     */
    public Transaction updateTransaction(Transaction trans) {
        if(trans.getTransactionId() <= 0) {
            return null;
        }
        transactions.put(trans.getTransactionId(),trans);
        return trans;
    }
    
    public Transaction removeTransaction(long TransactionId) {
        System.out.println("Transaction ID to delete: " + TransactionId);
        return transactions.remove(TransactionId);
    }

}