package uz.tengebank.inps.service;

import uz.tengebank.inps.model.InpsPersonData;

import java.util.List;

public interface InpsService {
    List<InpsPersonData> getImpsInfo(String inps);
}
