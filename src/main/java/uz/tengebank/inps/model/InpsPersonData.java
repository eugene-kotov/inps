package uz.tengebank.inps.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpsPersonData {
    @SerializedName(value = "pass_sn")
    private String passSn;
    @SerializedName(value = "pass_num")
    private String passNum;
    @SerializedName(value = "name")
    private String name;
    @SerializedName(value = "resident")
    private String resident;
    @SerializedName(value = "birth_date")
    private Date birthDate;
    @SerializedName(value = "gender")
    private String gender;
    @SerializedName(value = "adress")
    private String address;
    @Id
    @SerializedName(value = "inps")
    private String inps;
    @SerializedName(value = "invoices")
    private List<Invoice> invoices;
    @SerializedName(value = "result_code")
    private Integer resultCode;
    @SerializedName(value = "result_message")
    private String resultMessage;
}
