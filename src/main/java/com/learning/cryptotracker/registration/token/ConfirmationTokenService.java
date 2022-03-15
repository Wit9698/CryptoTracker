package com.learning.cryptotracker.registration.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
public class ConfirmationTokenService {

    private final ConfirmationTokenRepo confirmationTokenRepo;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepo.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
