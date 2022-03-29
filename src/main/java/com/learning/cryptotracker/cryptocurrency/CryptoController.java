package com.learning.cryptotracker.cryptocurrency;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CryptoController {

    private final CryptoService cryptoService;


    @GetMapping("/crypto/{page}")
    public List<Crypto> getAllCrypto(@PathVariable int page) {
        return cryptoService.getAllCrypto(page);
    }

}
