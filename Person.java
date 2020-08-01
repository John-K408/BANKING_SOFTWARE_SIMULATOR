import javax.swing.*;

class Person{
    Account mySavingsAccount;
    Account myCheckingAccount;
    creditAccount myCreditAccount;
    String name;
    String ID;
    public Person(String name,int ID,String savingAccount,int savingAmount,String checkingAccount,int checkingAmount,String Credit_Account){
        mySavingsAccount = new Account(savingAmount,savingAccount);
        myCheckingAccount = new Account(checkingAmount,checkingAccount);
        myCreditAccount = new creditAccount("Credit Account");
        this.name = name;
        this.ID = "1865" + ID;
    }

    public Person(String name,int ID,String savingAccount,int savingAmount,String checkingAccount,int checkingAmount){
        this.name = name;
        this.ID = "1865" + ID;
        mySavingsAccount = new Account(savingAmount,savingAccount);
        myCheckingAccount = new Account(checkingAmount,checkingAccount);
        this.myCreditAccount = null;
    }

    public void transfer(Account account1,Account account2,int amount){
        if(amount > 0){
            account1.withdraw(amount);
            account2.deposit(amount);
            JOptionPane.showMessageDialog(null,"Amount successfully transferred from "+
                    account1.accountName + " to " + account2.accountName);
        }
    }
    public void transfer(Account account1,creditAccount account2,int amount) {
        if (amount > 0) {
            account1.withdraw(amount);
            account2.deposit(amount);
            JOptionPane.showMessageDialog(null,"Amount successfully transferred from " +
                    account1.accountName + " to " + account2.accountName);
        }
    }
    public void transfer(creditAccount account1,Account account2,int amount){
        JOptionPane.showMessageDialog(null,"Sorry, you cannot withdraw money from your credit card. Try paying for something" +
                "with the card.");
    }

    public void showDetails(){
        System.err.println("======================================================================================");
        System.err.println("Name: "+ this.name);
        System.err.println("Identification Number: " + this.ID);
        System.err.println("Savings Account Amount: $" + mySavingsAccount.balance );
        System.err.println("Checking Account Amount: $"+ myCheckingAccount.balance);
        if(this.myCreditAccount != null) System.err.println("Credit Balance: $" + myCreditAccount.balance);
        System.err.println("=====================================================================================");
        JOptionPane.showMessageDialog(null,"See console for account details ");
    }
}
