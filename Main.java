import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main (String[]args){
        JOptionPane.showMessageDialog(null,"Welcome to Bank Of Ghana. Please provide" +
                " details to help create your account.");
        String name = JOptionPane.showInputDialog("Please Enter Your name: ");
        Random rand = new Random();
        int ID = 100 + rand.nextInt(900) ;
        JOptionPane.showMessageDialog(null,"Your randomly generated user identification" +
                " numer is " + "1865" + ID);

        
        int savingAmount = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to " +
                "keep in your savings account ? (Max: $2500)"));
        int checkingAmount = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to keep in your" +
                " checking account ?(Max: $2500)"));
        String response = JOptionPane.showInputDialog("Would you like to create a Credit Account too ? Yes / No");

        Person myAccount;
        if(response.toLowerCase().equals("yes")) {
            myAccount = new Person(name, ID, "Savings Account", savingAmount, "Checking " +
                    "Account", checkingAmount,"Yes");
            JOptionPane.showMessageDialog(null,"Credit Account was successfully created. Your current" +
                    "credit is $500");
        }
        else{
            myAccount = new Person(name,ID,"Savings Account",savingAmount,"Checking Account",
                    checkingAmount);
        }

        JOptionPane.showMessageDialog(null,"Congratulations "+ name + "!, Your account was " +
                "successfully created");


        String input = "yes";

        while(input.toLowerCase().equals("yes")){

                System.out.println("====================================================================================");
                System.out.println("1.Deposit Cash");
                System.out.println("2.Withdraw Cash");
                System.out.println("3.Transfer Cash");
                System.out.println("4.Pay With Credit Card");
                System.out.println("5.Check Balance");
                System.out.println("6.Check recent transaction");
                System.out.println("7.Show Account Details");
                System.out.println("=====================================================================================");
                String action = JOptionPane.showInputDialog("Please select action to perform (1-7)[see console]");
                if(action.equals("1")){
                    System.out.println("=======================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("3.Credit Account");
                System.out.println("============================================================================");
                String account = JOptionPane.showInputDialog("Please select account option to deposit into (1-3) " +
                        "[see console]:");

                System.out.println();
                int amount = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to deposit ?"));
                if(account.equals("1")){
                    myAccount.mySavingsAccount.deposit(amount);
                }
                if(account.equals("2")){
                    myAccount.myCreditAccount.deposit(amount);
                }
                if(account.equals("3")){
                    if(myAccount.myCreditAccount == null){
                        JOptionPane.showMessageDialog(null,"Please create a credit account " +
                                "to be able to perform this transaction");
                    }
                    else{
                        //Use swing in class to show if transaction was successful or not.
                        myAccount.myCreditAccount.deposit(amount);
                    }
                }

            }
            else if(action.equals("2") ){
                System.out.println("========================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("========================================================================");
                String account = JOptionPane.showInputDialog("Select account to withdraw from (1 - 2)" +
                        "[see console]:");
                int amount = Integer.parseInt(JOptionPane.showInputDialog("Select amount to withdraw"));
                if(account.equals("1")){
                    myAccount.mySavingsAccount.withdraw(amount);
                }
                else if(account.equals("2")){
                    myAccount.myCheckingAccount.withdraw(amount);
                }
            }
            //Transfer cash
            else if(action.equals("3")) {
                System.out.println("=========================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("==========================================================================");
                String account1 = JOptionPane.showInputDialog("From (1-3)[see console]:");
                System.out.println("===========================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("3.Credit Account");
                System.out.println("=============================================================================");
                String account2 = JOptionPane.showInputDialog("To (1 - 3)[see console]:");
                String result = account1 + account2;

                int amount = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to transfer ?"));
                //From savings account to savings account
                if(result.equals("11")){
                    JOptionPane.showMessageDialog(null,"You cannot transfer money from an " +
                            "account into the same account. Please select two different accounts");
                }
                //From savings account to checking account
                else if(result.equals("12")){
                    myAccount.transfer(myAccount.mySavingsAccount,myAccount.myCheckingAccount,amount);
                }
                //From savings account to credit account
                else if(result.equals("13")){
                    if(myAccount.myCreditAccount == null){
                        JOptionPane.showMessageDialog(null,"You do not have a credit account." +
                                " Please create one");
                    }
                    else {
                        myAccount.transfer(myAccount.mySavingsAccount, myAccount.myCreditAccount, amount);
                    }
                }
                //From checking account to savings account
                else if(result.equals("21")){
                        myAccount.transfer(myAccount.myCheckingAccount,myAccount.mySavingsAccount,amount);
                }
                //From checking account to checking account
                else if(result.equals("22")){
                       JOptionPane.showMessageDialog(null,"You cannot transfer money from an " +
                               "account into the same account.");
                }
                //From checking account to credit account
                else if(result.equals("23")){
                    if(myAccount.myCreditAccount == null){
                        JOptionPane.showMessageDialog(null,"You do not have a credit account." +
                                " Please create one to perform transaction");
                    }
                    else{
                        myAccount.transfer(myAccount.myCheckingAccount,myAccount.myCreditAccount,amount);
                    }
                }

            }
            //Pay with credit card
            else if(action.equals("4")){
                int amount = Integer.parseInt(JOptionPane.showInputDialog("What is the cost of the product ?"));
                myAccount.myCreditAccount.pay(amount);
            }
            //Check Balance
            else if(action.equals("5")){
                System.out.println("=============================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("3.Credit Account");
                System.out.println("==============================================================================");
                String account = JOptionPane.showInputDialog("Please select account (1 - 3)[see console]:");
                if(account.equals("1")){
                    myAccount.mySavingsAccount.checkBalance();
                }
                if(account.equals("2")){
                    myAccount.myCheckingAccount.checkBalance();
                }
                if(account.equals("3")){
                    myAccount.myCreditAccount.checkBalance();
                }
            }
            // Check recent transaction
            else if(action.equals("6")){
                System.out.println("================================================================================");
                System.out.println("1.Savings Account");
                System.out.println("2.Checking Account");
                System.out.println("3.Credit Account");
                System.out.println("=================================================================================");
                String account = JOptionPane.showInputDialog("What account would you like to perform this action on ?" +
                        " (1 - 3)[see console]:");
                if(account.equals("1")) myAccount.mySavingsAccount.checkRecentTransaction();
                if(account.equals("2")) myAccount.myCheckingAccount.checkRecentTransaction();
                if(account.equals("3")) myAccount.myCreditAccount.checkRecentTransaction();
            }
            //Show account details
            else if( action.equals("7")){
                myAccount.showDetails();
            }
            input = JOptionPane.showInputDialog("Would you like to do anything else (Yes/No)");

        }





    }
}
