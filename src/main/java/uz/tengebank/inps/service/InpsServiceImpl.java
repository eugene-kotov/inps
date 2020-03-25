package uz.tengebank.inps.service;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import uz.tengebank.inps.model.dto.InpsRq;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@Service
public class InpsServiceImpl implements InpsService {

    private final SettingsService settingsService;

    public InpsServiceImpl(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @Override
    public ResponseEntity<String> getInfo(String inps) {
        checkInpsLength(inps);
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", getBasicAuthHeaderValue(settingsService.getUser(), settingsService.getPassword()));
        HttpEntity<String> requestEntity = new HttpEntity<>(getRequestBody(inps), headers);
        return rest.exchange(settingsService.getServiceURL(), HttpMethod.POST, requestEntity, String.class);
    }

    @PostConstruct
    public void setupProxy() {
        System.setProperty("http.proxyHost", "10.226.74.10");
        System.setProperty("http.proxyPort", "8080");
    }

    private static String getRequestBody(String inps) {
        return new Gson().toJson(new InpsRq(inps));
    }

    private static String getBasicAuthHeaderValue(String user, String password) {
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        return "Basic " + new String(encodedAuth);
    }

    public void checkInpsLength(String inps) {
        if (!StringUtils.isNumeric(inps) && inps.length() != 14)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid inps");
    }
}
