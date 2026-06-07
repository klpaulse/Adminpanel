package no.adminpanel.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Denne controlleren brukes bare for å teste at backend kjører.
// Den lager en enkel rute for forsiden "/" og en enkel API-rute "/api/test".
@RestController
public class TestController {

    // Denne ruten svarer når du åpner Render-URL-en direkte i nettleseren.
    // Eksempel:
    // https://adminpanel-api-he24.onrender.com/
    @GetMapping("/")
    public String home() {
        return "Backend kjører live!";
    }

    // Denne ruten brukes for å teste API-et.
    // Eksempel:
    // https://adminpanel-api-he24.onrender.com/api/test
    @GetMapping("/api/test")
    public String testBackend() {
        return "API fungerer live!";
    }
}