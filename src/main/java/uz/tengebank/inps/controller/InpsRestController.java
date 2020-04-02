package uz.tengebank.inps.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.tengebank.inps.model.dto.*;
import uz.tengebank.inps.persistence.InpsRepository;
import uz.tengebank.inps.service.InpsService;
import uz.tengebank.response.HealthCheckResponse;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class InpsRestController {

    private final InpsService inpsService;
    private final InpsRepository inpsRepository;

    @PostMapping(path = "/inps", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendInps(@RequestBody InpsRq rq) {
        return inpsRepository.findByInps(rq.getInps()).isEmpty()?
                inpsService.getInfo(rq.getInps()):
                new ResponseEntity<String>(String.valueOf(inpsRepository.findByInps(rq.getInps())), HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        HealthCheckResponse response = new HealthCheckResponse("OK", LocalDateTime.now());
        return new ResponseEntity<HealthCheckResponse>(response, HttpStatus.OK);
    }
}
