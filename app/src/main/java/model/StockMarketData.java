package model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StockMarketData {
    // API key for accessing Alpha Vantage API
    public static final String API_KEY = "R77EKEXDGNOTOGWA";

    // Fetch stock market data for a given stock symbol
    public double fetchStockMarketData(String stock) {
        // Prepare the API endpoint and the query parameters
        String endpoint = "https://www.alphavantage.co/query";
        // We are fetching daily time series data for the stock symbol
        String queryParams = String.format("function=TIME_SERIES_DAILY&symbol=%s&apikey=%s", stock, API_KEY);
        String urlString = endpoint + "?" + queryParams;  // Complete URL for the API request

        try {
            // Create a URL object from the constructed URL string
            URL url = new URL(urlString);

            // Open the HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");  // Specify the request method (GET)
            connection.connect();  // Initiate the connection

            // Get the HTTP response code from the server
            int responseCode = connection.getResponseCode();
            // If the response code is not HTTP 200 (OK), print the error code and return 0
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Failed to fetch data: Error Code: " + responseCode);
                return 0;  // Return 0 to indicate failure
            }

            // Read the response from the API server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            // Read each line of the response and append it to the StringBuilder
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();  // Close the reader after reading the response

            // Parse the JSON response and return the result
            return parseJsonResponse(response.toString());  // Call a helper method to parse the JSON response

        } catch (IOException e) {
            // Handle any IO exceptions (network or server errors)
            System.out.println("Failed to fetch data: " + e.getMessage());
            return 0;  // Return 0 to indicate failure
        }
    }

    // Helper method to parse the JSON response from Alpha Vantage and extract stock data
    private double parseJsonResponse(String response) {
        // Parse the raw JSON response string into a JsonObject
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();

        // Get the "Time Series (Daily)" object from the JSON response
        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");

        // Get the most recent date (the first key in the time series data)
        String currentDate = timeSeries.keySet().iterator().next();  // Get the first date

        // Retrieve the stock data for the most recent date (such as open, high, low, close)
        JsonObject currentData = timeSeries.getAsJsonObject(currentDate);

        // Extract the closing price for the most recent day
        double closingPrice = currentData.get("4. close").getAsDouble();  // Get the closing price as a double

        // Return the closing price
        return closingPrice;
    }
}
