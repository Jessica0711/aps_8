package br.com.aps.service;

import static br.com.aps.service.util.XmlToStringJson.converter;
import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.aps.model.BuscaPrevisao;
import br.com.aps.model.Cidade;
import br.com.aps.model.Previsao;

@Service
public class PrevisaoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrevisaoService.class);

	private String webService = "http://servicos.cptec.inpe.br/XML/cidade/";
	private int codigoSucesso = 200;

	public List<Previsao> buscarPrevisaoPorCidade(String codigoCidade) {
		if (codigoCidade == null || codigoCidade.trim().isEmpty()) {
			return null;
		}
		String urlParaChamada = webService + codigoCidade + "/previsao.xml";
		LOGGER.info("CONEXAO COM WEB SERVICE / " + urlParaChamada);
		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			if (conexao.getResponseCode() != codigoSucesso) {
				LOGGER.error("ERRO AO CONECTAR / HTTP error code " + conexao.getResponseCode());
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}
			LOGGER.info("FINALIZADA A CONEXÃO / HTTP code " + conexao.getResponseCode());
			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = converter(resposta);
			Gson gson = new Gson();
			Cidade cidade = gson.fromJson(jsonEmString, BuscaPrevisao.class).getCidade();
			return asList(cidade.getPrevisao());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
