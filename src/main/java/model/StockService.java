package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StockService {

    public StockService() {
    }

    // This function returns a Data object specific to the user's input.
    public Data getStockData(List<String> holdings, LocalDateTime start, LocalDateTime end) {
        List<Double> balances = holdings.stream()
                .map(holding -> fetchStockMarketData(holding, start, end))
                .collect(Collectors.toList());
        double aggregatedBalance = balances.stream().mapToDouble(Double::doubleValue).sum();
        return new Data(1, holdings, start, aggregatedBalance);

    }

    private double fetchStockMarketData(String stock, LocalDateTime start, LocalDateTime end) {
        // Placeholder - call an API or a database query
        // Dummy value for now
        return 0;
    }
}


