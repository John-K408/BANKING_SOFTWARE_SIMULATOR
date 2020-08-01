import javax.swing.*;

public class creditAccount extends Account {

    public creditAccount(String accountName){
        super(accountName);
    }

    @Override
    public void deposit(int amount) {
        if(balance + amount > maxLimit){
            JOptionPane.showMessageDialog(null,"You are paying more than you owe in credit. " +
                    "Kindly deposit less into credit account");
            
        }
        else{
            super.deposit(amount);
        }
    }


    public void pay(int amount){
        if (amount > balance){
            JOptionPane.showMessageDialog(null,"Your credit balance is below the cost of the product. Please pay past credits" +
                    "to complete transaction");
        }
        else{
            super.withdraw(amount);
            JOptionPane.showMessageDialog(null,"Amount successfully paid");
        }

    }


}
