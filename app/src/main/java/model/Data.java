package model;
import java.time.LocalDateTime;
import java.util.List;
public class Data {
    private int id;
    private String userName;
    private LocalDateTime startTime;
    private List<String> holdings;
    private double stockBalance;

    public Data(int id, List<String> holdings, LocalDateTime startTime, double stockBalance, String userName) {
        this.userName = userName;
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

    public String getUserName() {
        return userName;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", startTime=" + startTime + ", holdings=" + holdings + '}';
    }
}
