package com.learning.cryptotracker.cryptocurrency;

import com.learning.cryptotracker.webclient.CryptoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoService {

    private final CryptoClient cryptoClient;
    private final CryptoRepo cryptoRepo;

    public List<Crypto> getAllCrypto(int page){
        //cryptoRepo.saveAll(cryptoClient.getCrypto());
        return cryptoClient.getCrypto(page);
    }

}
