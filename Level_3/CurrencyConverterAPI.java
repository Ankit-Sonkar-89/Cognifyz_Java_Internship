package Level_3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverterAPI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("💱 PRO LIVE CURRENCY CONVERTER 💱");
        System.out.println("=====================================\n");

        System.out.print("Enter Base Currency Code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase().trim();

        System.out.print("Enter Target Currency Code (e.g., INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase().trim();

        System.out.print("Enter Amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        System.out.println("\n📡 Fetching Live Exchange Rates from internet...");

        try {
            // 🔥 The Pro Move: Using Java 11+ HttpClient for modern API calls
            String url = "https://open.er-api.com/v6/latest/" + baseCurrency;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Using Regex to parse JSON without external libraries!
                String jsonResponse = response.body();
                Pattern pattern = Pattern.compile("\"" + targetCurrency + "\":\\s*([0-9.]+)");
                Matcher matcher = pattern.matcher(jsonResponse);

                if (matcher.find()) {
                    double exchangeRate = Double.parseDouble(matcher.group(1));
                    double convertedAmount = amount * exchangeRate;

                    System.out.println("✅ Live Rate: 1 " + baseCurrency + " = " + exchangeRate + " " + targetCurrency);
                    System.out.printf("💰 Result: %.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
                } else {
                    System.out.println("❌ Target currency '" + targetCurrency + "' not found in the API data.");
                }
            } else {
                System.out.println("❌ API Error! Could not fetch rates for " + baseCurrency);
            }

        } catch (Exception e) {
            System.out.println("❌ Network Error: Make sure you are connected to the internet!");
        }
        
        System.out.println("=====================================");
        scanner.close();
    }
}