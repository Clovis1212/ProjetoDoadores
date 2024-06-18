/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import com.mycompany.projdoad.Hospital;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author clovis
 */
public class Geolocalização {
   
private static final String API_KEY = "AIzaSyC5kN81Uy8yHRx6FBZzI4oWT2EKumIBz5I";


    public void gerarLatlong(Usuario usuario) throws IOException {
        String cep = usuario.getCep();
        String geocodingUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + cep + "&region=BR&key=" + API_KEY;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(geocodingUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("Erro na solicitação: " + response);
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            System.out.println("Resposta da API: " + responseBody); // Log da resposta
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray results = jsonResponse.getJSONArray("results");
            if (results.length() > 0) {
                JSONObject firstResult = results.getJSONObject(0);
                JSONObject geometry = firstResult.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");
                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");
                usuario.setLat(latitude);
                usuario.setLog(longitude);
            } else {
                JOptionPane.showMessageDialog(null, "Endereço não informado", "Alerta", 0);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void gerarLatlongHosp(Hospital hosp) throws IOException {
        String cep = hosp.getCep();
        String geocodingUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + cep + "&region=BR&key=" + API_KEY;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(geocodingUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("Erro na solicitação: " + response);
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            System.out.println("Resposta da API: " + responseBody); // Log da resposta
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray results = jsonResponse.getJSONArray("results");
            if (results.length() > 0) {
                JSONObject firstResult = results.getJSONObject(0);
                JSONObject geometry = firstResult.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");
                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");
                hosp.setLat(latitude);
                hosp.setLon(longitude);
            } else {
                JOptionPane.showMessageDialog(null, "Endereço não informado", "Alerta", 0);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


