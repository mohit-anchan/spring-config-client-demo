package com.curio.configclient.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${greeting:Hello from localhost}")
    private String greeting;

    @Value("${encrypted.greeting:Unable to decrypt}")
    private String encryptedGreeting;


    @GetMapping("/greeting")
    public String greeting() {
        return greeting;
    }

    @GetMapping("/greeting/encrypted")
    public String encryptedGreeting() {
        return encryptedGreeting;
    }
}
