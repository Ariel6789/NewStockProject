package model;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockMarketData {
    public static final String API_KEY = "R77EKEXDGNOTOGWA";

    public double fetchStockMarketData(String stock, LocalDateTime start, LocalDateTime end) {
        // Format the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedStart = start.format(formatter);
        String formattedEnd = end.format(formatter);

        // Prepare for API request
        String endpoint = "https://www.alphavantage.co/query";
        String queryParams = String.format("function=TIME_SERIES_DAILY&symbol=%s&apikey=%s", stock, API_KEY);
        String urlString = endpoint + queryParams;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Failed to fetch data: Error Code: " + responseCode);
                return 0;
            }

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // Parse the JSON response
            return parseJsonResponse(response.toString());
        } catch (IOException e) {
            System.out.println("Failed to fetch data: " + e.getMessage());
            return 0;
        }


    }
    private double parseJsonResponse(String response) {
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        // Log the Json response
        return 0;
    }
}
