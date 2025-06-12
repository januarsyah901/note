public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter method only for ownerName
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Deposit method with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Withdrawal amount must be positive");
        }
    }

    @Override
    public String toString() {
        return String.format("Account[number=%s, name=%s, balance=%.1f]", 
               accountNumber, ownerName, balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456", "John Doe", 1000.0);
        acc.deposit(500);
        acc.withdraw(200);
        acc.setOwnerName("John Smith");
        System.out.println(acc);
        // Output: Account[number=123456, name=John Smith, balance=1300.0]
    }
}
