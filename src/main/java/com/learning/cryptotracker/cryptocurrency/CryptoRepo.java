package com.learning.cryptotracker.cryptocurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepo extends JpaRepository<Crypto, Long> {

}
