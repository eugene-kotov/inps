package uz.tengebank.inps.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InpsPersonData implements Serializable {
    @JsonProperty(value = "pass_sn")
    private String passSn;
    @JsonProperty(value = "pass_num")
    private String passNum;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "resident")
    private String resident;
    @JsonProperty(value = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @JsonProperty(value = "gender")
    private String gender;
    @JsonProperty(value = "adress")
    private String address;
    @JsonProperty(value = "inps")
    private String inps;
    @JsonProperty(value = "invoices")
    private List<Invoice> invoices;
    @JsonProperty(value = "result_code")
    private Integer resultCode;
    @JsonProperty(value = "result_message")
    private String resultMessage;
}
