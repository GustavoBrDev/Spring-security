package spring.security.com.springsecurity.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("MI74");
    }
}
