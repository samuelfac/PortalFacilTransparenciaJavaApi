package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Contratos implements Serializable {

    private static final long serialVersionUID = -5696766881325017034L;

    @SerializedName("NumContrato")
    @Expose
    private String numContrato;
    @SerializedName("NumProcesso")
    @Expose
    private String numProcesso;
    @SerializedName("DescFornecedor")
    @Expose
    private String descFornecedor;
    @SerializedName("NumCpfCnpjFornecedor")
    @Expose
    private String numCpfCnpjFornecedor;
    @SerializedName("DescObjeto")
    @Expose
    private String descObjeto;
    @SerializedName("VlContrato")
    @Expose
    private BigDecimal vlContrato;
    @SerializedName("DtInicio")
    @Expose
    private Date dtInicio;
    @SerializedName("DtFim")
    @Expose
    private Date dtFim;
    @SerializedName("DtAssinatura")
    @Expose
    private Date dtAssinatura;
    @SerializedName("DtPublicacao")
    @Expose
    private Date dtPublicacao;
    @SerializedName("NumAnoLicitacao")
    @Expose
    private Integer numAnoLicitacao;
    @SerializedName("TpLicitacao")
    @Expose
    private String tpLicitacao;
    @SerializedName("Aditivos")
    @Expose
    private List<Aditivos> aditivos = null;

}
