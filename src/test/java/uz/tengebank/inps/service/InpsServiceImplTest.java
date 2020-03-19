package uz.tengebank.inps.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
class InpsServiceImplTest {

    @Mock InpsServiceImpl inpsService;

//    @Test
//    public void shouldThrowWhenLengthInvalid() {
//        String inps = "1234567890123411";
//        Throwable exception = assertThrows(ResponseStatusException.class, () -> inpsService.checkInpsLength(inps));
//        assertEquals("Invalid inps", exception.getMessage());
//    }
}