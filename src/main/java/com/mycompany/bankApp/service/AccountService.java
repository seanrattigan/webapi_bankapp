package com.mycompany.bankApp.service;

import com.mycompany.bankApp.database.DatabaseClass;
import com.mycompany.bankApp.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Group-E
 */
public class AccountService {
    
    private Map<Long, Account> accountsDB = DatabaseClass.getAccounts();
    
    public AccountService() {
        //long accountId, long accNum, long sortCode, double curBalance,double customerId
        if (accountsDB.isEmpty()) { // sort, bal, custID
            Account acc1 = new Account(111111, 111, 100);
            Account acc2 = new Account(222222, 202, 110);
            Account acc3 = new Account(333333, 555, 150);
            Account acc4 = new Account(444444, 1024,1);
            Account acc5 = new Account(21, 1024, 1);
            accountsDB.put(acc1.getAccNum(), acc1);
            accountsDB.put(acc2.getAccNum(), acc2);
            accountsDB.put(acc3.getAccNum(), acc3);
            accountsDB.put(acc4.getAccNum(), acc4);
            accountsDB.put(acc5.getAccNum(), acc5);
        }
    }
    
    public List<Account> getAllAccounts() {
        return new ArrayList<Account>(accountsDB.values());
    }
    
    public Account getAccount(long accountId) {
        Account requestedAcc = new Account();
        for (Map.Entry<Long, Account> acc : accountsDB.entrySet()) {
            Account value = acc.getValue();     
            if (value.getAccountId() == accountId) {
                requestedAcc = value;
            }
        }
        return requestedAcc;
    }
    
    
   
    public Account addAccount(Account account) {
        Random rand = new Random(); // cn get the same num twice using random
        //account.setAccountId(accountsDB.size() + 1);  // .size part of ArrayList- no need to track?
//        account.setAccountId(account.getAccountId());
//        account.setAccNum(Integer.parseInt(String.format("%09d", rand.nextInt(1000000000))));
        accountsDB.put(account.getAccNum(), account);
        return account;
    }
    
    public Account updateAccount(Account account) {
        if (account.getAccountId() <= 0) {
            return null;
        }
        account.getSortCode();
        account.getAccNum();
        accountsDB.put(account.getAccountId(), account);
        return account;
    }
    
    public Account removeAccount(long accountId) {
        return accountsDB.remove(accountId);
    }
    
    public String getAccountBalance(long accNum) {
        double currentBalance;
        currentBalance = 0.0;
        for (Map.Entry<Long, Account> acc : accountsDB.entrySet()) {
            Account value = acc.getValue();     
            if (value.getAccNum() == accNum) {
                currentBalance = value.getCurBalance();
            }
        }
        return Double.toString(currentBalance);
    }

}
