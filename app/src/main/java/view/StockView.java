package view;

import java.util.List;

public class StockView {
    public void displayStockData(List<String> holdings, List<Double> prices) {
        System.out.println("Stock Portfolio Report:");
        System.out.println("--------------------------");

        for (int i = 0; i < holdings.size(); i++) {
            System.out.printf("Stock: %s | Price: $%.2f%n", holdings.get(i), prices.get(i));
        }
    }
}