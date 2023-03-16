package com.conservor.moeda.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.conservor.moeda.model.Coin;
import com.google.gson.Gson;

public class CambioService {
    static String webService = "https://economia.awesomeapi.com.br/json/";

    public static Double cambio(String moeda) throws Exception {
        String urlParaChamada = webService + moeda;
        URL url = new URL(urlParaChamada);
        URLConnection conn = url.openConnection();

        try {
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String co = "";
            List<String> json = new ArrayList<>();

            while ((co = br.readLine()) != null) {
                json.add(co);
            }

            String singleString = json.toString().replaceAll("[\\[\\]]", "");

            Coin coin = new Gson().fromJson(singleString, Coin.class);

            return coin.getBid();

        } catch (Exception ex) {
            throw new Exception("Erro: " + ex.getMessage());
        }
    }
}
