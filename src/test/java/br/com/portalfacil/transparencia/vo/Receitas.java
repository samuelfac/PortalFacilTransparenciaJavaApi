package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Receitas implements Serializable {

    private static final long serialVersionUID = -5983930493119616481L;

    @SerializedName("NumExercicio")
    @Expose
    private Integer numExercicio;
    @SerializedName("NumReceita")
    @Expose
    private String numReceita;
    @SerializedName("DescReceita")
    @Expose
    private String descReceita;
    @SerializedName("VlPrevisto")
    @Expose
    private BigDecimal vlPrevisto;
    @SerializedName("VlRealizado")
    @Expose
    private BigDecimal vlRealizado;
}
