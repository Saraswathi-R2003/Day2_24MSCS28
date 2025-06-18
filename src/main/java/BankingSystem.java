import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Scanner;

class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

class BankSystem {
    private final MongoCollection<Document> collection;

    public BankSystem() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // use Atlas URI for cloud
        MongoDatabase database = mongoClient.getDatabase("Bank");
        this.collection = database.getCollection("Accounts");
    }

    public void createAccount(int accountNumber, String holderName) throws BankingException {
        if (collection.find(Filters.eq("accountNumber", accountNumber)).first() != null) {
            throw new BankingException("Account already exists.");
        }

        Document doc = new Document("accountNumber", accountNumber)
                .append("holderName", holderName)
                .append("balance", 0.0);
        collection.insertOne(doc);
    }

    public void deposit(int accountNumber, double amount) throws BankingException {
        if (amount <= 0) throw new BankingException("Deposit must be positive.");

        Document acc = collection.find(Filters.eq("accountNumber", accountNumber)).first();
        if (acc == null) throw new BankingException("Account not found.");

        double newBalance = acc.getDouble("balance") + amount;
        collection.updateOne(Filters.eq("accountNumber", accountNumber),
                new Document("$set", new Document("balance", newBalance)));
    }

    public void withdraw(int accountNumber, double amount) throws BankingException {
        if (amount <= 0) throw new BankingException("Withdrawal must be positive.");

        Document acc = collection.find(Filters.eq("accountNumber", accountNumber)).first();
        if (acc == null) throw new BankingException("Account not found.");

        double currentBalance = acc.getDouble("balance");
        if (amount > currentBalance) throw new BankingException("Insufficient funds.");

        double newBalance = currentBalance - amount;
        collection.updateOne(Filters.eq("accountNumber", accountNumber),
                new Document("$set", new Document("balance", newBalance)));
    }

    public void checkBalance(int accountNumber) throws BankingException {
        Document acc = collection.find(Filters.eq("accountNumber", accountNumber)).first();
        if (acc == null) throw new BankingException("Account not found.");

        System.out.println("Account Holder: " + acc.getString("holderName"));
        System.out.println("Balance: $" + acc.getDouble("balance"));
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSystem bank = new BankSystem();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        int accNum = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter holder name: ");
                        String name = scanner.nextLine();
                        bank.createAccount(accNum, name);
                        System.out.println("Account created.");
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        int depAcc = scanner.nextInt();
                        System.out.print("Enter deposit amount: ");
                        double depAmt = scanner.nextDouble();
                        bank.deposit(depAcc, depAmt);
                        System.out.println("Deposit successful.");
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        int witAcc = scanner.nextInt();
                        System.out.print("Enter withdrawal amount: ");
                        double witAmt = scanner.nextDouble();
                        bank.withdraw(witAcc, witAmt);
                        System.out.println("Withdrawal successful.");
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int balAcc = scanner.nextInt();
                        bank.checkBalance(balAcc);
                        break;

                    case 5:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (BankingException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
                scanner.nextLine(); // clear buffer
            }
        }

        scanner.close();
    }
}

