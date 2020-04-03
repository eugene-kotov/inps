package uz.tengebank.inps.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {
    @JsonProperty(value = "inn")
    private String inn;
    @JsonProperty(value = "org_name")
    private String orgName;
    @JsonProperty(value = "org_addres")
    private String orgAddress;
    @JsonProperty(value = "period")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date period;
    @JsonProperty(value = "send_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date sendDate;
    @JsonProperty(value = "total_invoices")
    private Double totalInvoices;
}
