public class ATMSystem {

    // ---------- BankAccount Class ----------
    static class BankAccount {
        private String accountNumber;
        private double balance;
        private int pin;

        public BankAccount(String accountNumber, double balance, int pin) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.pin = pin;
        }

        public boolean validatePin(int enteredPin) {
            return enteredPin == pin;
        }

        public void debit(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }

    // ---------- ATM Class ----------
    static class ATM {
        private BankAccount linkedAccount;

        public ATM(BankAccount linkedAccount) {
            this.linkedAccount = linkedAccount;
        }

        public void withdraw(int enteredPin, double amount) {
            System.out.println("\nATM: Processing withdrawal request...");
            if (linkedAccount.validatePin(enteredPin)) {
                linkedAccount.debit(amount);
                System.out.println("ATM: Transaction successful. Dispensing cash...");
            } else {
                System.out.println("Invalid PIN. Transaction failed.");
            }
        }
    }

    // ---------- Customer Class ----------
    static class Customer {
        private String name;
        private ATM atm;

        public Customer(String name, ATM atm) {
            this.name = name;
            this.atm = atm;
        }

        public void performWithdrawal(int pin, double amount) {
            System.out.println("\n" + name + " is requesting withdrawal of ₹" + amount + "...");
            atm.withdraw(pin, amount);
        }
    }

    // ---------- Main Demo ----------
    public static void main(String[] args) {
        // Step 1 - Create BankAccount
        BankAccount account = new BankAccount("ACC123", 50000, 1234);

        // Step 2 - Create ATM linked to BankAccount
        ATM atm = new ATM(account);

        // Step 3 - Create Customer linked to ATM
        Customer customer = new Customer("Rahul", atm);

        // Step 4 - Withdraw with correct PIN
        customer.performWithdrawal(1234, 10000);

        // Step 5 - Withdraw with incorrect PIN
        customer.performWithdrawal(9999, 5000);
    }
}
