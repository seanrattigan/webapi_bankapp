/**
 * V9b2_Sean
 */

package com.mycompany.bankApp.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
//import com.mycompany.bankApp.database.DatabaseClass;

/**
 *
 * @author Group-E
 */
@XmlRootElement
public class Transaction {

    private static long transactionUniqueId = 222222; // no getter or setter
    private long transactionId;  // unique key
    private long sourceAcc;  //linked to account- would req. iteration
    private long destinationAcc;  // only needed for transfer- workaround- make same
    private Date transDate;
    private String type;  // determined by constructor? Maybe
    private double transactionAmount;  // neg for withdrawal?

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", sourceAcc=" + sourceAcc + ", destinationAcc=" + destinationAcc + ", transDate=" + transDate + ", type=" + type + ", transactionAmount=" + transactionAmount + '}';
    }
    
    

    /**
     * Default no-args constructor
     */
    public Transaction() {
        System.out.println("No-args Transaction constructor called"); //debug + interesting
    }
     
    /**
     * Constructor when performing a bank transfer- this constructor will only
     * be called when there are two instances of Account in the params, so type
     * may be redundant, or could possibly be made so.
     * @param sourceAccId the ID of the source account
     * @param destinationAccId the ID of the destination account
     * @param transType type: withdraw, deposit, transfer
     * @param transactionAmount amount of cash in transaction
     */
    public Transaction(long sourceAccId, long destinationAccId, String transType, double transactionAmount) {
        this.transactionId = ++transactionUniqueId;
        this.sourceAcc = sourceAccId;
        this.destinationAcc = destinationAccId;
        this.transDate = new Date();
        this.type = transType;
        this.transactionAmount = transactionAmount;
        System.out.println("Primary Transaction constructor called"); //debug
        // call implemOperation
        
    }
    
    /**
     * Alt constructor: This handles both deposit and withdraw and is chosen by 
     * Java based on the parameters passed to it.
     * @param sourceAccId the ID of the account
     * @param type type: withdraw, deposit, transfer
     * @param transactionAmount amount of cash in transaction
     */
    public Transaction(long sourceAccId, String type, double transactionAmount) {
        this.sourceAcc = sourceAccId;
        this.destinationAcc = sourceAccId; // either this or null
        this.transDate = new Date();  // auto-set
        this.type = type;  // from form via Service
        this.transactionAmount = transactionAmount;
        System.out.println("Secondary Transaction constructor called"); //debug
//        if("deposit".equals(this.type)){
//            sourceAcc.deposit(transactionAmount);
//            this.type = "Successful Deposit";
//        }
//        if("withdraw".equals(this.type)){
//            if(sourceAcc.withdraw(transactionAmount)){
//                this.type = "Successful Withdrawal";
//            }else{
//                this.type = "Unsuccessful Withdrawal";
//            }
//            
//        }
    }
    
//        if(this.sourceAcc.getCurBalance() < this.transactionAmount){
//            this.sourceAcc.withdraw(transactionAmount);
//            this.destinationAcc.deposit(transactionAmount);
//            this.type = "Successful Transfer";
//        }else{
//            /* 
//            In this case, the date, account nums and amount are recorded
//            but no balances are effected- shows an attempted transfer
//            */
//            this.type = "Insufficient Funds for Transfer: No Transfer";
//        }
    
//        if(this.sourceAcc.getCurBalance() < this.transactionAmount){
//            this.sourceAcc.withdraw(transactionAmount);
//            this.destinationAcc.deposit(transactionAmount);
//            this.type = "Successful Transfer";
//        }else{
//            /* 
//            In this case, the date, account nums and amount are recorded
//            but no balances are effected- shows an attempted transfer
//            */
//            this.type = "Insufficient Funds for Transfer: No Transfer";
//      }


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getSourceAcc() {
        return sourceAcc;
    }

    public void setSourceAcc(long sourceAcc) {
        this.sourceAcc = sourceAcc;
    }

    public long getDestinationAcc() {
        return destinationAcc;
    }

    public void setDestinationAcc(long destinationAcc) {
        this.destinationAcc = destinationAcc;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    

}

