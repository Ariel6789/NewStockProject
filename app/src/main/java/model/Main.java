package model;

import kotlin.collections.UArraySortingKt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String [] args){
        List<String> holdings = Arrays.asList("AAPL", "MSFT", "GOOG", "TSLA");

        StockMarketData stockData = new StockMarketData();

        StockService stockService = new StockService(stockData);

        String report = stockService.portfolioReport(holdings);
        System.out.println(report);




        }

    }

