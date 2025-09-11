public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
            return true;
        }
        return false;
    }

    public boolean deposit(double amount, int enteredPin) {
        if (amount <= 0 || !validatePin(enteredPin)) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount, int enteredPin) {
        if (amount <= 0 || !validatePin(enteredPin)) return false;
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (withdraw(amount, enteredPin)) {
            target.balance += amount;
            return true;
        }
        return false;
    }

    private void lockAccount() {
        isLocked = true;
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("123", 500);
        SecureBankAccount acc2 = new SecureBankAccount("456", 1000);

        acc1.setPin(0, 1111);
        acc2.setPin(0, 2222);

        acc1.deposit(100, 1111);
        acc2.withdraw(200, 2222);

        acc1.withdraw(50, 9999);
        acc1.withdraw(50, 9999);
        acc1.withdraw(50, 9999);

        acc1.deposit(100, 1111);
        acc1.unlockAccount(1111);
        acc1.deposit(100, 1111);

        acc1.transfer(acc2, 50, 1111);

        System.out.println("Acc1: " + acc1.getBalance());
        System.out.println("Acc2: " + acc2.getBalance());
    }
}
