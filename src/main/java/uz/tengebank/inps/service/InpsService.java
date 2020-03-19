package uz.tengebank.inps.service;

import org.springframework.http.ResponseEntity;

public interface InpsService {
    ResponseEntity<String> getInfo(String inps);
}
