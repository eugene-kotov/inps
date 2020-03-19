package uz.tengebank.inps.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static uz.tengebank.inps.enums.SystemEnv.*;

@Service
public class SettingsServiceImpl implements SettingsService {

    private static final String DEFAULT_SERVICE_URL = "";
    private static final String DEFAULT_SERVICE_USER = "";
    private static final String DEFAULT_SERVICE_PASSWORD = "";

    @Override
    public String getServiceURL() {
        return DEFAULT_SERVICE_URL;//StringUtils.isNotBlank(System.getenv(SERVICE_URL.name())) ? System.getenv(SERVICE_URL.name()) : DEFAULT_SERVICE_URL;
    }

    @Override
    public String getUser() {
        return DEFAULT_SERVICE_USER;//StringUtils.isNotBlank(System.getenv(SERVICE_USER.name())) ? System.getenv(SERVICE_USER.name()) : DEFAULT_SERVICE_USER;
    }

    @Override
    public String getPassword() {
        return DEFAULT_SERVICE_PASSWORD;//StringUtils.isNotBlank(System.getenv(SERVICE_PASSWORD.name())) ? System.getenv(SERVICE_PASSWORD.name()) : DEFAULT_SERVICE_PASSWORD;
    }
}
