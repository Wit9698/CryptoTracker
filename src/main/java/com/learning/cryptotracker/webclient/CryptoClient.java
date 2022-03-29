package com.learning.cryptotracker.webclient;

import com.learning.cryptotracker.cryptocurrency.Crypto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class CryptoClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String CRYPTO_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&";



    public List<Crypto> getCrypto(int page){
        ResponseEntity<List<Crypto>> response = restTemplate.exchange(CRYPTO_URL + "page={page}&sparkline=false", HttpMethod.GET, null, new ParameterizedTypeReference<List<Crypto>>() {
        }, page);
        List<Crypto> crypto = response.getBody();
        return crypto;
    }
}
