package model;

import java.text.DecimalFormat;
import java.util.List;

public class StockService {
    private final StockMarketData stockMarketData;
    private static final DecimalFormat DF = new DecimalFormat("#,##0.00");

    public StockService(StockMarketData stockMarketData) {
        this.stockMarketData = stockMarketData;
    }

    // Calculates the total value of the portfolio
    public double calculatePortfolioValue(List<String> holdings) {
        double totalValue = 0;
        for (String stock : holdings) {
            double price = stockMarketData.fetchStockMarketData(stock);
            totalValue += price;
        }
        return totalValue;
    }

    // Generates a portfolio report for the provided holdings
    public String portfolioReport(List<String> holdings) {
        StringBuilder report = new StringBuilder();
        double totalValue = calculatePortfolioValue(holdings);

        report.append("Stock Portfolio Report:\n");
        report.append("-------------------------- \n");

        // Append each stock's information to the report
        for (String stock : holdings) {
            double price = stockMarketData.fetchStockMarketData(stock);
            report.append(String.format("Stock: %s | Price: $%s\n", stock, DF.format(price)));  // Use DF instead of df
        }
        // Append the total portfolio value to the report
        report.append(String.format(" Portfolio Value: $%s\n", DF.format(totalValue)));  // Use DF instead of df
        return report.toString();
    }
}


