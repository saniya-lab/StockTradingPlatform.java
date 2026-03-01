import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    double balance = 10000;
    int shares = 0;

    void buy(Stock stock, int qty) {
        double cost = qty * stock.price;
        if(cost <= balance) {
            shares += qty;
            balance -= cost;
            System.out.println("Bought successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sell(Stock stock, int qty) {
        if(qty <= shares) {
            shares -= qty;
            balance += qty * stock.price;
            System.out.println("Sold successfully!");
        } else {
            System.out.println("Not enough shares!");
        }
    }

    void showPortfolio() {
        System.out.println("Balance: " + balance);
        System.out.println("Shares Owned: " + shares);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock stock = new Stock("ABC", 150);
        Portfolio portfolio = new Portfolio();

        int choice;
        do {
            System.out.println("\n1. View Stock");
            System.out.println("2. Buy");
            System.out.println("3. Sell");
            System.out.println("4. Portfolio");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Stock: " + stock.name + " Price: " + stock.price);
                    break;
                case 2:
                    System.out.print("Enter quantity: ");
                    portfolio.buy(stock, sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter quantity: ");
                    portfolio.sell(stock, sc.nextInt());
                    break;
                case 4:
                    portfolio.showPortfolio();
                    break;
            }

        } while(choice != 5);
    }
}
