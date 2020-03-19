package uz.tengebank.inps.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.tengebank.inps.service.InpsService;
import uz.tengebank.inps.dto.InpsRq;

@RestController
public class InpsRestController {

    private final InpsService inpsService;

    public InpsRestController(InpsService inpsService) {
        this.inpsService = inpsService;
    }

    @PostMapping(path = "/inps", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendInps(@RequestBody InpsRq rq) {
        return inpsService.getInfo(rq.getInps());
    }
}
