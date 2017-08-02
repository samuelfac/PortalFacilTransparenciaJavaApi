package br.com.portalfacil.transparencia.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.portalfacil.transparencia.PortalFacilApi;
import br.com.portalfacil.transparencia.vo.Clientes;
import br.com.portalfacil.transparencia.vo.Contratos;
import br.com.portalfacil.transparencia.vo.Despesas;
import br.com.portalfacil.transparencia.vo.Empenhos;
import br.com.portalfacil.transparencia.vo.ExtraOrcamentarias;
import br.com.portalfacil.transparencia.vo.Liquidacoes;
import br.com.portalfacil.transparencia.vo.Pagamentos;
import br.com.portalfacil.transparencia.vo.RestosAPagar;
import br.com.portalfacil.transparencia.vo.Servidores;

public class PortalFacilApiTest {

    private static PortalFacilApi api;
    
    private static String idCliente = "210";
    private static Date data2016 = new Date(2016-1900,1,1);
    private static Date dataAgora = new Date();
    
    @BeforeClass
    public static void init() throws Exception {
	api = new PortalFacilApi();
    }
    
    @Test
    public void getClientes() throws Exception {
	List<Clientes> list = api.getClientes();
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getContratos() throws Exception {
	List<Contratos> list = api.getContratos(idCliente, data2016, dataAgora);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getServidores() throws Exception {
	List<Servidores> list = api.getServidores(idCliente, data2016);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getDespesas() throws Exception {
	List<Despesas> list = api.getDespesas(idCliente, 2016);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getEmpenhos() throws Exception {
	List<Empenhos> list = api.getEmpenhos(idCliente, data2016, dataAgora);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getLiquidacoes() throws Exception {
	List<Liquidacoes> list = api.getLiquidacoes(idCliente, data2016, dataAgora);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getPagamentos() throws Exception {
	List<Pagamentos> list = api.getPagamentos(idCliente, data2016, dataAgora);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getExtraOrcamentarias() throws Exception {
	List<ExtraOrcamentarias> list = api.getExtraOrcamentarias(idCliente, data2016, dataAgora);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
    @Test
    public void getRestosAPagar() throws Exception {
	List<RestosAPagar> list = api.getRestosAPagar(idCliente, 2015);
	assertNotNull(list);
	Assert.assertTrue(list.size()>0);
    }
    
}
