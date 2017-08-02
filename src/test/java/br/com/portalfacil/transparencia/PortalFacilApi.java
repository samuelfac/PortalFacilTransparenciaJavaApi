package br.com.portalfacil.transparencia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.portalfacil.transparencia.adapter.DateAdapter;
import br.com.portalfacil.transparencia.vo.Clientes;
import br.com.portalfacil.transparencia.vo.Contratos;
import br.com.portalfacil.transparencia.vo.Despesas;
import br.com.portalfacil.transparencia.vo.Empenhos;
import br.com.portalfacil.transparencia.vo.ExtraOrcamentarias;
import br.com.portalfacil.transparencia.vo.Liquidacoes;
import br.com.portalfacil.transparencia.vo.Pagamentos;
import br.com.portalfacil.transparencia.vo.Receitas;
import br.com.portalfacil.transparencia.vo.RestosAPagar;
import br.com.portalfacil.transparencia.vo.Servidores;

/**
 * A API disponibiliza dados relativos à transparência na gestão pública,
 * conforme exigência da Lei 12.527 de 18 de novembro de 2011, Art. 8º, §3º,
 * Incisos III e IV.
 * <br>
 * <br>
 * <a href='http://www.portalfacil.com.br/'>http://www.portalfacil.com.br/</a>
 * 
 * @author samuelfac@gmail.com
 * 
 *
 */
public class PortalFacilApi {

    private final String DOMAIN = "http://transparencia.portalfacil.com.br/api/";

    private Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateAdapter()).create();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Lista de todos os clientes
     * 
     * @return
     * @throws Exception
     */
    public List<Clientes> getClientes() throws Exception {
	return get("clientes", new TypeToken<ArrayList<Clientes>>() {}.getType());
    }
    
    /**
     * Retorna lista de clientes que contém o nome
     * @param nome 
     * @return
     * @throws Exception
     */
    public List<Clientes> getClientes(String nome) throws Exception {
	List<Clientes> list = getClientes();
	List<Clientes> ret = new ArrayList<Clientes>();
	for (Clientes cliente : list) {
	    if(cliente.getDescCliente().contains(nome)){
		ret.add(cliente);
	    }
	}
	return ret;
    }

    /**
     * Retorna todos os contratos dentro da faixa de datas do cliente
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param dtInicio
     *            Data inicial equivalente ao período da data do contrato.
     * @param dtFim
     *            Data final equivalente ao período da data do contrato.
     * @return
     * @throws Exception
     */
    public List<Contratos> getContratos(String idCliente, Date dtInicio, Date dtFim) throws Exception {
	return getContratos(idCliente, dtInicio, dtFim, null, null, null, null, null);
    }

    /**
     * Retorna todos os contratos dentro da faixa de datas do cliente
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param dtInicio
     *            Data inicial equivalente ao período da data do contrato.
     * @param dtFim
     *            Data final equivalente ao período da data do contrato.
     * @param numContrato
     *            Número do contrato.
     * @param descFornecedor
     *            Nome do fornecedor do contrato.
     * @param dtAssinatura
     *            Data de assinatura do contrato.
     * @param dtPublicacao
     *            Data de publicação do contrato.
     * @param descObjeto
     *            Objeto do contrato.
     * @return
     * @throws Exception
     */
    public List<Contratos> getContratos(String idCliente, Date dtInicio, Date dtFim, Integer numContrato,
	    String descFornecedor, Date dtAssinatura, Date dtPublicacao, String descObjeto) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	if (numContrato != null)
	    params.put("numContrato", numContrato);
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (dtAssinatura != null)
	    params.put("dtAssinatura", sdf.format(dtAssinatura));
	if (dtPublicacao != null)
	    params.put("dtPublicacao", sdf.format(dtPublicacao));
	if (descObjeto != null)
	    params.put("descObjeto", descObjeto);
	params.put("dtInicio", sdf.format(dtInicio));
	params.put("dtFim", sdf.format(dtFim));

	return get("contratos", new TypeToken<ArrayList<Contratos>>() {
	}.getType(), params);
    }

    /**
     * Retorna as receitas do ano do cliente
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param numAno
     *            Ano da receita.
     * @return
     * @throws Exception
     */
    public List<Receitas> getReceitas(String idCliente, Integer numAno) throws Exception {
	return getReceitas(idCliente, numAno, null, null);
    }

    /**
     * Retorna as receitas do ano do cliente
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param numAno
     *            Ano da receita.
     * @param numReceita
     *            Número da receita.
     * @param descReceita
     *            Descrição da receita.
     * @return
     * @throws Exception
     */
    public List<Receitas> getReceitas(String idCliente, Integer numAno, String numReceita, String descReceita)
	    throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("numAno", numAno);
	if (numReceita != null)
	    params.put("numReceita", numReceita);
	if (descReceita != null)
	    params.put("descReceita", descReceita);

	return get("receitas", new TypeToken<ArrayList<Receitas>>() {
	}.getType(), params);
    }

    /**
     * Retorna os servidores do cliente.
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param dtCompetencia
     *            Data de Competência do servidor.
     * @return
     * @throws Exception
     */
    public List<Servidores> getServidores(String idCliente, Date dtCompetencia) throws Exception {
	return getServidores(idCliente, dtCompetencia, null, null);
    }

    /**
     * Retorna os servidores do cliente.
     * 
     * @param idCliente
     *            buscar codigo de getClientes()
     * @param dtCompetencia
     *            Data de Competência do servidor.
     * @param descNome
     *            Nome do Servidor.
     * @param descCargoFuncao
     *            Descrição do Cargo/Função.
     * @return
     * @throws Exception
     */
    public List<Servidores> getServidores(String idCliente, Date dtCompetencia, String descNome, String descCargoFuncao)
	    throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	SimpleDateFormat sdfTmp = new SimpleDateFormat("MM/yyyy");
	params.put("dtCompetencia", sdfTmp.format(dtCompetencia));
	sdfTmp = null;
	if (descNome != null)
	    params.put("descNome", descNome);
	if (descCargoFuncao != null)
	    params.put("descCargoFuncao", descCargoFuncao);

	return get("servidores", new TypeToken<ArrayList<Servidores>>() {
	}.getType(), params);
    }

    /**
     * Retorna despesas do cliente
     * 
     * @param idCliente
     * @param numAno
     *            Ano da despesa.
     * @return
     * @throws Exception
     */
    public List<Despesas> getDespesas(String idCliente, Integer numAno) throws Exception {
	return getDespesas(idCliente, numAno, null, null);
    }

    /**
     * Retorna despesas do cliente
     * 
     * @param idCliente
     * @param numAno
     *            Ano da despesa.
     * @param numDespesa
     *            Número da despesa.
     * @param descDespesa
     *            Descrição da despesa.
     * @return
     * @throws Exception
     */
    public List<Despesas> getDespesas(String idCliente, Integer numAno, String numDespesa, String descDespesa)
	    throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("numAno", numAno);
	if (numDespesa != null)
	    params.put("numDespesa", numDespesa);
	if (descDespesa != null)
	    params.put("descDespesa", descDespesa);

	return get("despesas", new TypeToken<ArrayList<Despesas>>() {
	}.getType(), params);
    }

    /**
     * Retorna empenhos do cliente
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período do empenho.
     * @param dtFim
     *            Data final para filtrar o período do empenho.
     * @return
     * @throws Exception
     */
    public List<Empenhos> getEmpenhos(String idCliente, Date dtInicio, Date dtFim) throws Exception {
	return getEmpenhos(idCliente, dtInicio, dtFim, null, null, null, null);
    }

    /**
     * Retorna empenhos do cliente
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período do empenho.
     * @param dtFim
     *            Data final para filtrar o período do empenho.
     * @param numEmpenho
     *            Número do empenho.
     * @param descFornecedor
     *            Nome do fornecedor.
     * @param descUnidade
     *            Nome da Unidade.
     * @param tpEmpenho
     *            Tipo do empenho.
     * @return
     * @throws Exception
     */
    public List<Empenhos> getEmpenhos(String idCliente, Date dtInicio, Date dtFim, String numEmpenho,
	    String descFornecedor, String descUnidade, String tpEmpenho) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("dtInicio", sdf.format(dtInicio));
	params.put("dtFim", sdf.format(dtFim));
	if (numEmpenho != null)
	    params.put("numEmpenho", numEmpenho);
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (descUnidade != null)
	    params.put("descUnidade", descUnidade);
	if (tpEmpenho != null)
	    params.put("tpEmpenho", tpEmpenho);

	return get("empenhos", new TypeToken<ArrayList<Empenhos>>() {
	}.getType(), params);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período da liquidação.
     * @param dtFim
     *            Data final para filtrar o período da liquidação.
     * @return
     * @throws Exception
     */
    public List<Liquidacoes> getLiquidacoes(String idCliente, Date dtInicio, Date dtFim) throws Exception {
	return getLiquidacoes(idCliente, dtInicio, dtFim, null, null, null, null);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período da liquidação.
     * @param dtFim
     *            Data final para filtrar o período da liquidação.
     * @param numEmpenho
     *            Número do Empenho.
     * @param numLiquidacao
     *            Número da Liquidação.
     * @param descFornecedor
     *            Nome do Fornecedor.
     * @param descUnidade
     *            Nome da Unidade.
     * @return
     * @throws Exception
     */
    public List<Liquidacoes> getLiquidacoes(String idCliente, Date dtInicio, Date dtFim, Integer numEmpenho,
	    Integer numLiquidacao, String descFornecedor, String descUnidade) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("dtInicio", sdf.format(dtInicio));
	params.put("dtFim", sdf.format(dtFim));
	if (numEmpenho != null)
	    params.put("numEmpenho", numEmpenho);
	if (numLiquidacao != null)
	    params.put("numLiquidacao", numLiquidacao);
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (descUnidade != null)
	    params.put("descUnidade", descUnidade);

	return get("liquidacoes", new TypeToken<ArrayList<Liquidacoes>>() {
	}.getType(), params);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período da liquidação.
     * @param dtFim
     *            Data final para filtrar o período da liquidação.
     * @return
     * @throws Exception
     */
    public List<Pagamentos> getPagamentos(String idCliente, Date dtInicio, Date dtFim) throws Exception {
	return getPagamentos(idCliente, dtInicio, dtFim, null, null, null, null);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período da liquidação.
     * @param dtFim
     *            Data final para filtrar o período da liquidação.
     * @param numEmpenho
     *            Número do Empenho.
     * @param numPagamento
     *            Número do Pagamento.
     * @param descFornecedor
     *            Nome do Fornecedor.
     * @param descUnidade
     *            Nome da Unidade.
     * @return
     * @throws Exception
     */
    public List<Pagamentos> getPagamentos(String idCliente, Date dtInicio, Date dtFim, Integer numEmpenho,
	    Integer numPagamento, String descFornecedor, String descUnidade) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("dtInicio", sdf.format(dtInicio));
	params.put("dtFim", sdf.format(dtFim));
	if (numEmpenho != null)
	    params.put("numEmpenho", numEmpenho);
	if (numPagamento != null)
	    params.put("numPagamento", numPagamento);
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (descUnidade != null)
	    params.put("descUnidade", descUnidade);

	return get("liquidacoes", new TypeToken<ArrayList<Liquidacoes>>() {
	}.getType(), params);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período de Extra Orçamentária.
     * @param dtFim
     *            Data final para filtrar o período de Extra Orçamentária.
     * @return
     * @throws Exception
     */
    public List<ExtraOrcamentarias> getExtraOrcamentarias(String idCliente, Date dtInicio, Date dtFim)
	    throws Exception {
	return getExtraOrcamentarias(idCliente, dtInicio, dtFim, null, null);
    }

    /**
     * 
     * @param idCliente
     * @param dtInicio
     *            Data inicial para filtrar o período de Extra Orçamentária.
     * @param dtFim
     *            Data final para filtrar o período de Extra Orçamentária.
     * @param descFornecedor
     *            Nome do Fornecedor.
     * @param tpExtra
     *            Tipo da Extra Orçamentária (P ou R).
     * @return
     * @throws Exception
     */
    public List<ExtraOrcamentarias> getExtraOrcamentarias(String idCliente, Date dtInicio, Date dtFim,
	    String descFornecedor, String tpExtra) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("dtInicio", sdf.format(dtInicio));
	params.put("dtFim", sdf.format(dtFim));
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (tpExtra != null)
	    params.put("tpExtra", tpExtra);

	return get("extraorcamentarias", new TypeToken<ArrayList<ExtraOrcamentarias>>() {
	}.getType(), params);
    }

    /**
     * 
     * @param idCliente
     * @param numAno
     *            Ano da receita.
     * @return
     * @throws Exception
     */
    public List<RestosAPagar> getRestosAPagar(String idCliente, Integer numAno) throws Exception {
	return getRestosAPagar(idCliente, numAno, null, null, null, null);
    }

    /**
     * 
     * @param idCliente
     * @param numAno
     *            Ano da receita.
     * @param numEmpenho
     *            Número do Empenho.
     * @param descFornecedor
     *            Nome do Fornecedor.
     * @param descUnidade
     *            Nome da Unidade.
     * @param tpEmpenho
     *            Tipo do Empenho.
     * @return
     * @throws Exception
     */
    public List<RestosAPagar> getRestosAPagar(String idCliente, Integer numAno, Integer numEmpenho,
	    String descFornecedor, String descUnidade, String tpEmpenho) throws Exception {
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("idCliente", idCliente);
	params.put("numAno", numAno);
	if (numEmpenho != null)
	    params.put("numEmpenho", numEmpenho);
	if (descFornecedor != null)
	    params.put("descFornecedor", descFornecedor);
	if (descUnidade != null)
	    params.put("descUnidade", descUnidade);
	if (tpEmpenho != null)
	    params.put("tpEmpenho", tpEmpenho);

	return get("restos", new TypeToken<ArrayList<RestosAPagar>>() {
	}.getType(), params);
    }

    private <T> T get(String method, Type typeOfT) throws Exception {
	return get(method, typeOfT, null);
    }

    private <T> T get(String method, Type typeOfT, Map<String, Object> params) throws Exception {
	StringBuilder result = new StringBuilder();
	if (params == null) {
	    params = new HashMap<String, Object>();
	}
	params.put("type", "json");
	URL url = new URL(DOMAIN + method + "?" + urlEncodeUTF8(params));
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String line;
	while ((line = rd.readLine()) != null) {
	    System.out.println(line);
	    result.append(line);
	}
	rd.close();
	if (result.toString().startsWith("\"")) {
	    throw new Exception(result.toString());
	}
	return gson.fromJson(result.toString(), typeOfT);
    }

    private static String urlEncodeUTF8(String s) {
	try {
	    return URLEncoder.encode(s, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    throw new UnsupportedOperationException(e);
	}
    }

    private static String urlEncodeUTF8(Map<?, ?> map) {
	StringBuilder sb = new StringBuilder();
	for (Map.Entry<?, ?> entry : map.entrySet()) {
	    if (sb.length() > 0) {
		sb.append("&");
	    }
	    sb.append(String.format("%s=%s", urlEncodeUTF8(entry.getKey().toString()),
		    urlEncodeUTF8(entry.getValue().toString())));
	}
	return sb.toString();
    }

}
