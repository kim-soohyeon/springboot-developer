package me.kimsoohyeon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.kimsoohyeon.springbootdeveloper.domain.RefreshToken;
import me.kimsoohyeon.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected Token"));
    }
}
