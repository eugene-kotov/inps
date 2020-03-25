package uz.tengebank.inps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.tengebank.inps.model.dto.InpsRq;
import uz.tengebank.inps.persistence.InpsRepository;
import uz.tengebank.inps.service.InpsService;

@RestController
public class InpsRestController {

    private final InpsService inpsService;
    private final InpsRepository inpsRepository;

    public InpsRestController(InpsService inpsService, InpsRepository inpsRepository) {
        this.inpsService = inpsService;
        this.inpsRepository = inpsRepository;
    }

    @PostMapping(path = "/inps", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendInps(@RequestBody InpsRq rq) {
        return inpsRepository.findByInps(rq.getInps()).isEmpty()?
                inpsService.getInfo(rq.getInps()):
                new ResponseEntity<String>(String.valueOf(inpsRepository.findByInps(rq.getInps())), HttpStatus.OK);
    }
}
