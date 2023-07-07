package vidal.falcon.ef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.falcon.ef.entities.ClvfPayment;
import vidal.falcon.ef.services.ClvfPaymentService;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClvfPaymentController {
    @Autowired
    ClvfPaymentService clvfPaymentService;

    @PostMapping("/payment")
    public ResponseEntity<ClvfPayment> createPayment(@RequestBody ClvfPayment clvfPayment) {
        ClvfPayment clvfSavedPayment = clvfPaymentService.clvfSave(clvfPayment);
        return ResponseEntity.ok(clvfSavedPayment);
    }
}
