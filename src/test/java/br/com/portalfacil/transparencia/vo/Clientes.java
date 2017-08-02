package br.com.portalfacil.transparencia.vo;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Clientes implements Serializable{

    private static final long serialVersionUID = 4695896421707284605L;

    @SerializedName("IdCliente")
    @Expose
    private String idCliente;
    @SerializedName("DescCliente")
    @Expose
    private String descCliente;
    
}
