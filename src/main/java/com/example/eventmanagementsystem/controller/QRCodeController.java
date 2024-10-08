package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.service.QRCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate/{participantId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String participantId) {
        try {
            String qrText = "Participant ID: " + participantId; // Exemple de texte pour le QR Code
            byte[] qrImage = qrCodeService.generateQRCode(qrText, 350, 350);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/png");

            return new ResponseEntity<>(qrImage, headers, HttpStatus.OK);

        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
