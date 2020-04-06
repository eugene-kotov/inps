package uz.tengebank.inps.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(value = "inps resources")
public class InpsRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InpsRestController.class);
    private final InpsService inpsService;

    @GetMapping("/healthcheck")
    @ApiOperation(value = "show app status", response = HealthCheckResponse.class)
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        HealthCheckResponse response = new HealthCheckResponse("OK", LocalDateTime.now());
        LOGGER.info("Health check: ", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/inps", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "show data by inps", response = InpsPersonData.class)
    public ResponseEntity<List<InpsPersonData>> sendInps(@RequestBody InpsRq rq) {
        LOGGER.info("Inps request started.");
        List<InpsPersonData> personData = inpsService.getImpsInfo(rq.getInps());
        LOGGER.info("Inps data received: ", personData);
        return new ResponseEntity<>(personData, HttpStatus.OK);
    }
}
