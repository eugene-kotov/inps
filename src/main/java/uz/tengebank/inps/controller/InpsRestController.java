package uz.tengebank.inps.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.tengebank.inps.model.InpsPersonData;
import uz.tengebank.inps.model.dto.*;
import uz.tengebank.inps.service.InpsService;
import uz.tengebank.response.HealthCheckResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class InpsRestController {

    private final InpsService inpsService;

    @PostMapping(path = "/inps", consumes = "application/json", produces = "application/json")
    public List<InpsPersonData> sendInps(@RequestBody InpsRq rq) {
        return inpsService.getImpsInfo(rq.getInps());
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        HealthCheckResponse response = new HealthCheckResponse("OK", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
