package uz.tengebank.inps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpsPersonData {
    private String passNum;
    private String name;
    private String resident;
    private Date birthDate;
    private String gender;
    private String address;
    @Id
    private String inps;
}
//"pass_sn": "AA",
//        "pass_num": "1111111",
//        "name": "AAA AAA AAA",
//        "resident": "N",
//        "birth_date": "1991-01-01",
//        "gender": "M",
//        "adress": " ANGREN 0 ",
//        "inps": "11111111111111",