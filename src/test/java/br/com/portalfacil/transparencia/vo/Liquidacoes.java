package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Liquidacoes implements Serializable {

    private static final long serialVersionUID = -2394447577517837049L;

    @SerializedName("NumLiquidacao")
    @Expose
    private Integer numLiquidacao;
    @SerializedName("NumEmpenho")
    @Expose
    private Integer numEmpenho;
    @SerializedName("DescUnidade")
    @Expose
    private String descUnidade;
    @SerializedName("NumUnidade")
    @Expose
    private Integer numUnidade;
    @SerializedName("DescDespesa")
    @Expose
    private String descDespesa;
    @SerializedName("NumDespesa")
    @Expose
    private String numDespesa;
    @SerializedName("DescFornecedor")
    @Expose
    private String descFornecedor;
    @SerializedName("NumCpfCnpjFornecedor")
    @Expose
    private String numCpfCnpjFornecedor;
    @SerializedName("DtLiquidacao")
    @Expose
    private Date dtLiquidacao;
    @SerializedName("VlLiquidado")
    @Expose
    private BigDecimal vlLiquidado;
    @SerializedName("DescLiquidacao")
    @Expose
    private String descLiquidacao;
}
