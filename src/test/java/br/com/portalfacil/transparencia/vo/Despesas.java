package br.com.portalfacil.transparencia.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Despesas implements Serializable {
    
    private static final long serialVersionUID = -3895325207443141181L;

    @SerializedName("NumExercicio")
    @Expose
    private Integer numExercicio;
    @SerializedName("NumDespesa")
    @Expose
    private String numDespesa;
    @SerializedName("DescDespesa")
    @Expose
    private String descDespesa;
    @SerializedName("VlEmpenhado")
    @Expose
    private BigDecimal vlEmpenhado;
    @SerializedName("VlLiquidado")
    @Expose
    private BigDecimal vlLiquidado;
    @SerializedName("VlPago")
    @Expose
    private BigDecimal vlPago;
    
}
