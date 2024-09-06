package com.Springpro.Spring.controller;

import com.Springpro.Spring.service.BarcodeScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BarcodeController {

    @Autowired
    private BarcodeScannerService barcodeScannerService;

    @PostMapping("/scan")
    public String scanBarcode(@RequestParam("file") MultipartFile file) {
        try {
            return barcodeScannerService.scanBarcode(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
