/**
 * V9b2_Sean
 * 
 * 
 */



package com.mycompany.bankApp.model;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Group -E
 */
@XmlRootElement
public class Account {
    private static long accBase = 100000000;
    private static long idIdentifier = 268; // static class var to auto-assign id //sean
    private long accountId;
    private long accNum = 10000000;  // default 8-digit account num
    private long sortCode = 987654; // default for online bank (no region) 6-diigt
    private double curBalance;
    private double customerId;
    private Date dateCreated;

    /**
     * Default no-args constructor
     */
    public Account() {
    }
    
    /**
     * All args constructor.  Mainly used from Form
     * Should check accNum does NOT exist before execution!
     * @param fsortCode sortcode from form- may be dropdown in future
     * @param curBalance opening balance
     * @param customerId id of the customer with the account
     */
    public Account(long fsortCode, double curBalance, long customerId) {  
        this.accNum = accBase + idIdentifier;
        this.setSortCode(fsortCode);
        this.curBalance = curBalance;
        this.customerId = customerId;
        this.accountId = idIdentifier++; //sean :  increments idIdentifier and assigns
        this.dateCreated = new Date(); // sean : can be handy, and is free.
        System.out.println("Account Form constructor called");  // debug only
    }

    /**
     * Increments the account balance by the amount
     * @param depositAmount cash deposited
     * @return indication of success or failure
     */
    public boolean deposit(double depositAmount) {
        this.curBalance += depositAmount;
        System.out.println("Deposit Made");
        return true;
    }
    
    /**
     * This method can be used for a withdrawal, as well as in the case of a
     * fund transfer
     * @param withdrawAmount the amount the customer wishes to withdraw
     * @return a boolean indicating if the withdrawal was successful or not
     */
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount >= this.curBalance) {
            this.curBalance -= withdrawAmount;
            System.out.println("Account funds withdrawn");
            return true;
        } else {
            System.out.println("Insufficient funds available"); // debug
            return false;
        }
    }
    
    
//    public static long getIdIdentifier() {
//        return idIdentifier;
//    }
//
//    public static void setIdIdentifier(long idIdentifier) {
//        Account.idIdentifier = idIdentifier;
//    }
    
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public long getSortCode() {
        return sortCode;
    }

    private void setSortCode(long sortCode) {
        if((sortCode >= 100000) && (sortCode <= 999999)){
            this.sortCode = sortCode; // sortcode from form- otherwise, generic 6-digit
        }else{
            this.sortCode = 987654;
        }
    }

    public double getCurBalance() {
        return curBalance;
    }

    public void setCurBalance(double curBalance) {
        this.curBalance = curBalance;
    }

    public double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(double customerId) {
        this.customerId = customerId;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }

   
}
