package model;

import java.time.LocalDateTime;
import java.util.List;

public class Data {
    private int id;
    private LocalDateTime startTime;
    private List<String> holdings;
    private double stockBalance;

    public Data(int id,  List<String> holdings, LocalDateTime startTime, double stockBalance) {
        this.id = id;
        this.startTime = startTime;
        this.holdings = holdings;
        this.stockBalance = stockBalance;

    }

    //getters
    public int getId() {
        return id;
    }

    public double getStockBalance() {
        return stockBalance;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<String> getHoldings() {
        return holdings;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStockBalance(double stockBalance) {
        this.stockBalance = stockBalance;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setHoldings(List<String> holdings) {
        this.holdings = holdings;
    }

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", startTime=" + startTime + ", holdings=" + holdings + '}';
    }
}
