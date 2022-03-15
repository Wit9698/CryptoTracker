package com.learning.cryptotracker.appuser;

import com.learning.cryptotracker.registration.token.ConfirmationToken;
import com.learning.cryptotracker.registration.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser){
        boolean userExist = appUserRepo.findByEmail(appUser.getEmail()).isPresent();

        if(userExist){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepo.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(20),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
}
