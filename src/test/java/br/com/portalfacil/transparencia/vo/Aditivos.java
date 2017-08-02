package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Aditivos implements Serializable{

    private static final long serialVersionUID = 7337923254997835007L;

    @SerializedName("DescObservacao")
    @Expose
    private String descObservacao;
    
    @SerializedName("DtAditivo")
    @Expose
    private Date dtAditivo;
    
    @SerializedName("DtAssinaturaAditivo")
    @Expose
    private Date dtAssinaturaAditivo;
    
    @SerializedName("NumAditivo")
    @Expose
    private Long numAditivo;
    
    @SerializedName("VlAditivo")
    @Expose
    private BigDecimal llAditivo;
}
