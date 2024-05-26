package com.conversor_monedas.api;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;


public class Request {

    String[] currency = {"USD", "ARS", "BRL", "COP"};
    String[] currency2 = {"USD", "ARS", "BRL", "COP"};



    public void requestMethod(int coin1, int coin2, double amount) {
        String address = "https://v6.exchangerate-api.com/v6/07713e8f719aca0b3d76cd37/pair/" + currency[coin1] + "/" + currency2[coin2] + "/" + amount;

        try {

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            double conversionResult = jsonObject.getAsJsonPrimitive("conversion_result").getAsDouble();
            System.out.println(conversionResult);


        } catch (IOException e) {
            System.out.println("Error making HTTP request: " + e.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception: " + ex.getMessage());
        }

    }

}
