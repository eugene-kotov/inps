package uz.tengebank.inps.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @SerializedName(value = "inn")
    private String inn;
    @SerializedName(value = "org_name")
    private String orgName;
    @SerializedName(value = "org_addres")
    private String orgAddress;
    @SerializedName(value = "period")
    private Date period;
    @SerializedName(value = "send_date")
    private Date sendDate;
    @SerializedName(value = "total_invoices")
    private Double totalInvoices;
}
