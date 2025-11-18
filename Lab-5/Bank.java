import java.util.Scanner;

class Account {
    String Name;
    int accno;
    String acctype;
    double balance;

    Account(String Name, int accno, String acctype, double balance) {
        this.Name = Name;
        this.accno = accno;
        this.acctype = acctype;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited amount: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn amount: Rs." + amount);
        }
    }

    void displayBalance() {
        System.out.println("\nAccount Holder: " + Name);
        System.out.println("Account Number: " + accno);
        System.out.println("Account Type: " + acctype);
        System.out.println("Current Balance: Rs." + balance);
    }

    
    
    
}

class Savings extends Account {
    double rate = 0.05;

    Savings(String Name, int accno, double balance) {
        super(Name, accno, "savings", balance);
    }

    
    void computeInterest() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of years: ");
        int years = s.nextInt();
        double interest = balance * Math.pow((1 + rate), years) - balance;
        balance += interest;
        System.out.println("Compound Interest added: Rs." + interest);
    }
}

class Current extends Account {
    double minbalance = 1000;
    double sercharge = 100;

    Current(String Name, int accno, double balance) {
        super(Name, accno, "current", balance);
    }

    @Override
    void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < minbalance) {
            balance -= sercharge;
            System.out.println("Service charge of Rs." + sercharge + " applied.");
            System.out.println("New Balance: Rs." + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = s.nextLine();

        System.out.print("Enter account number: ");
        int accno = s.nextInt();
        s.nextLine(); 

        System.out.print("Enter account type (saving/current): ");
        String type = s.nextLine().toLowerCase();

        System.out.print("Enter initial balance: ");
        double balance = s.nextDouble();  

        Savings sv = new Savings(name, accno, balance);        
        Current ct = new Current(name, accno, balance);
       

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double d = s.nextDouble();
                    if(type.equals("savings")){
                        sv.deposit(d);
                    }
                    else{
                        ct.deposit(d);
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double w = s.nextDouble();
                    if(type.equals("savings")){
                        sv.withdraw(w);
                    }
                    else{
                        ct.withdraw(w);
                    }
                    break;

                case 3:
                    if(type.equals("savings")){
                        sv.computeInterest();
                    }
                    else{
                        System.out.println("Intrest cant be computed for acc type");
                    }
                    break;

                case 4:
                    if(type.equals("savings")){
                        sv.displayBalance();
                    }
                    else{
                        ct.displayBalance();
                    }
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        s.close();
    }
}

