package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ExtraOrcamentarias implements Serializable {
    
    private static final long serialVersionUID = 3319394221895301053L;

    @SerializedName("NumOrdem")
    @Expose
    private String numOrdem;
    @SerializedName("NumExtra")
    @Expose
    private String numExtra;
    @SerializedName("DtMovimento")
    @Expose
    private Date dtMovimento;
    @SerializedName("DescConta")
    @Expose
    private String descConta;
    @SerializedName("DescFornecedor")
    @Expose
    private String descFornecedor;
    @SerializedName("TpExtra")
    @Expose
    private String tpExtra;
    @SerializedName("VlExtra")
    @Expose
    private BigDecimal vlExtra;
    
}
