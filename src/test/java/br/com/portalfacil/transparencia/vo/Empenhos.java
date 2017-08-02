package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Empenhos implements Serializable {
    
    private static final long serialVersionUID = 7824640670341366755L;

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
    @SerializedName("NumLicitacao")
    @Expose
    private Integer numLicitacao;
    @SerializedName("TpLicitacao")
    @Expose
    private String tpLicitacao;
    @SerializedName("DtLicitacao")
    @Expose
    private Date dtLicitacao;
    @SerializedName("NumProcesso")
    @Expose
    private String numProcesso;
}
