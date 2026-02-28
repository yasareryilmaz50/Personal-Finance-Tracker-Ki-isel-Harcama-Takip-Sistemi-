import java.util.ArrayList;
import java.util.Scanner;
class Transaction {
    String type; 
    double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

 public class FinanceTracker {

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Kişisel Finans Takip Sistemi ---");
            System.out.println("1- Gelir Ekle");
            System.out.println("2- Gider Ekle");
            System.out.println("3- İşlemleri Listele");
            System.out.println("4- Bakiye Görüntüle");
            System.out.println("5- Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTransaction("Gelir");
                    break;
                case 2:
                    addTransaction("Gider");
                    break;
                case 3:
                    listTransactions();
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
                    System.out.println("Program sonlandırıldı.");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    static void addTransaction(String type) {
        System.out.print(type + " miktarı girin: ");
        double amount = scanner.nextDouble();

        transactions.add(new Transaction(type, amount));
        System.out.println(type + " eklendi.");
    }

    static void listTransactions() {
        System.out.println("\n--- İşlem Listesi ---");
        for (Transaction t : transactions) {
            System.out.println(t.type + " - " + t.amount + " TL");
        }
    }

    static void showBalance() {
        double balance = 0;

        for (Transaction t : transactions) {
            if (t.type.equals("Gelir"))
                balance += t.amount;
            else
                balance -= t.amount;
        }

        System.out.println("Mevcut Bakiye: " + balance + " TL");
    }
}