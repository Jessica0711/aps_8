package br.com.aps.service;

import static br.com.aps.service.util.XmlToStringJson.converter;
import static java.util.Arrays.asList;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.aps.model.BuscaCidades;
import br.com.aps.model.Cidade;
import br.com.aps.model.Cidades;

@Service
public class CidadeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CidadeService.class);

	private String webService = "http://servicos.cptec.inpe.br/XML/listaCidades?city=";
	private int codigoSucesso = 200;

	public List<Cidade> buscarPrevisaoPorCidade(String nomeCidade) {
		if(nomeCidade == null || nomeCidade.trim().isEmpty()) {
			return null;
		}
		String urlParaChamada = webService + nomeCidade;
		LOGGER.info("CONEXAO COM WEB SERVICE / " + urlParaChamada);
		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			if (conexao.getResponseCode() != codigoSucesso) {
				LOGGER.error("ERRO AO CONECTAR / HTTP error code " + conexao.getResponseCode());
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}
			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			LOGGER.info("FINALIZADA A CONEXÃO / HTTP code " + conexao.getResponseCode());
			String jsonEmString = converter(resposta);
			if (!isEmpty(jsonEmString)) {
				Gson gson = new Gson();
				Cidades cidades = gson.fromJson(jsonEmString, BuscaCidades.class).getCidades();
				return asList(cidades.getCidade());
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
