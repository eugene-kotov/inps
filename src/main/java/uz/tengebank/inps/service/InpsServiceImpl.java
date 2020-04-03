package uz.tengebank.inps.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import uz.tengebank.inps.model.InpsPersonData;
import uz.tengebank.inps.model.dto.InpsRq;
import uz.tengebank.inps.persistence.InpsRepository;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class InpsServiceImpl implements InpsService {

    private final SettingsService settingsService;
    private final InpsRepository inpsRepository;

    @Override
    public List<InpsPersonData> getImpsInfo(String inps) {

        List<InpsPersonData> inpsPersonData = inpsRepository.findByInps(inps);

        if (inpsPersonData.isEmpty()) {
            inpsPersonData = getInpsPersonData(inps);
            if (null != inpsPersonData.get(0).getInps()) {
                inpsRepository.insert(inpsPersonData.get(0));
            }
        }

        return inpsPersonData;
    }

    private List<InpsPersonData> getInpsPersonData(String inps) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", getBasicAuthHeaderValue(settingsService.getUser(), settingsService.getPassword()));
        HttpEntity<InpsRq> requestEntity = new HttpEntity<InpsRq>(new InpsRq(inps), headers);
        return Collections.singletonList(rest.exchange(settingsService.getServiceURL(), HttpMethod.POST, requestEntity, InpsPersonData.class).getBody());
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
