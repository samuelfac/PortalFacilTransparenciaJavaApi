package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Servidores implements Serializable {
    
    private static final long serialVersionUID = 1470928591399889535L;

    @SerializedName("NumMatricula")
    @Expose
    private Integer numMatricula;
    @SerializedName("DescServidor")
    @Expose
    private String descServidor;
    @SerializedName("DescUnidade")
    @Expose
    private String descUnidade;
    @SerializedName("DescCargo")
    @Expose
    private String descCargo;
    @SerializedName("DescFuncao")
    @Expose
    private String descFuncao;
    @SerializedName("DtCompetencia")
    @Expose
    private String dtCompetencia;
    @SerializedName("VlBase")
    @Expose
    private BigDecimal vlBase;
    @SerializedName("VlProvento")
    @Expose
    private BigDecimal vlProvento;
    @SerializedName("VlDesconto")
    @Expose
    private BigDecimal vlDesconto;
    @SerializedName("VlLiquido")
    @Expose
    private BigDecimal vlLiquido;
    
}
