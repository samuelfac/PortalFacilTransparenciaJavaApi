package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RestosAPagar implements Serializable {

    private static final long serialVersionUID = -6061104980805307300L;

    @SerializedName("NumEmpenho")
    @Expose
    private Integer numEmpenho;
    @SerializedName("TpEmpenho")
    @Expose
    private String tpEmpenho;
    @SerializedName("DtEmpenho")
    @Expose
    private Date dtEmpenho;
    @SerializedName("VlEmpenho")
    @Expose
    private BigDecimal vlEmpenho;
    @SerializedName("NumDespesa")
    @Expose
    private String numDespesa;
    @SerializedName("DescDespesa")
    @Expose
    private String descDespesa;
    @SerializedName("NumCpfCnpjFornecedor")
    @Expose
    private String numCpfCnpjFornecedor;
    @SerializedName("DescFornecedor")
    @Expose
    private String descFornecedor;
    @SerializedName("NumUnidade")
    @Expose
    private Integer numUnidade;
    @SerializedName("DescUnidade")
    @Expose
    private String descUnidade;
    @SerializedName("VlInscrito")
    @Expose
    private BigDecimal vlInscrito;
    @SerializedName("VlPago")
    @Expose
    private BigDecimal vlPago;
    @SerializedName("VlCancelado")
    @Expose
    private BigDecimal vlCancelado;
}
