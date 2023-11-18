package com.quizplayground.quizplayground.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class EnvironmentAccessor {
    @Value("${frontend.url}")
    private @Getter String frontendUrl;
}
