import javax.swing.JOptionPane;
class Account {
    int balance;
    int recentTransaction;
    final int maxLimit;
    final int minLimit;
    String accountName;

    public Account(int amount,String accountName) {
        if (amount <= 0) throw new IllegalArgumentException("You cannot create a BankAccount with no money");
        this.accountName = accountName;
        balance = amount;
        maxLimit = 25000;
        minLimit = 25;
    }
    public Account(String StringName){
        maxLimit = 500;
        balance = maxLimit;
        minLimit = 0;
    }

    public void deposit(int amount) {
        if (balance + amount > maxLimit) {
            JOptionPane.showMessageDialog(null, "You are exceeding your limit for this account:" +
                    "Please try depositing a lesser amount or withdrawing some money to make this deposit");
        }
        if (amount != 0) {
            balance += amount;
            recentTransaction = amount;
            JOptionPane.showMessageDialog(null,"Amount successfully deposited into "
            + this.accountName);
        }
    }

    public void withdraw(int amount) {
        if (balance - amount < minLimit) {
            JOptionPane.showMessageDialog(null,"Your amount after this transaction will be less than your minimum limit for this account." +
                    "Please try withdrawing a new amount or depositing some cash before making transaction");
        }
        if (amount != 0) {
            balance -= amount;
            recentTransaction = -balance;
            JOptionPane.showMessageDialog(null,"Amount successfully withdrawn from " + this.accountName);
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null,"Your current balance is : $" + this.balance);
    }

    public void checkRecentTransaction() {
        if (recentTransaction < 0) {
           JOptionPane.showMessageDialog(null,"You withdrew $" + Math.abs(recentTransaction) +
                   " from "+ this.accountName);
        } else {
           JOptionPane.showMessageDialog(null,"You deposited $" + recentTransaction + " into "
           + this.accountName);
        }
    }

}
