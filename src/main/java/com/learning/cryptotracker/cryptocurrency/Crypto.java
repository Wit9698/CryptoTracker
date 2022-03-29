package com.learning.cryptotracker.cryptocurrency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties(value = "id", ignoreUnknown = true)
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String symbol;
    @JsonProperty("current_price")
    private double currentPrice;
}
