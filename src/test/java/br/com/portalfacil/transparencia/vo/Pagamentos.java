package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Pagamentos implements Serializable {

    private static final long serialVersionUID = -2896941026847180342L;

    @SerializedName("NumPagamento")
    @Expose
    private Integer numPagamento;
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
    @SerializedName("DtPagamento")
    @Expose
    private Date dtPagamento;
    @SerializedName("VlPagamento")
    @Expose
    private BigDecimal vlPagamento;
    @SerializedName("DescPagamento")
    @Expose
    private String descPagamento;
}
