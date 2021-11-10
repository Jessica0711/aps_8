package br.com.aps.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.aps.model.Cidade;
import br.com.aps.model.Previsao;
import br.com.aps.service.AvisoService;
import br.com.aps.service.CidadeService;


@RestController
@RequestMapping(value = "/consultaprevisoes", method = RequestMethod.GET, produces = "application/json")
public class ConsultaPrevisaoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaPrevisaoController.class);

	@Autowired
	private AvisoService avisoService;

	@Autowired
	private CidadeService cidadeService;

	@GetMapping(value = "/", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public List<Previsao> getCidadas(@NotEmpty @Param(value = "nomeCidade") String nomeCidade) {
		LOGGER.info("INICIO CONSULTA PREVISOES / CIDADE = " + nomeCidade);
		List<Cidade> cidades = cidadeService.buscarPrevisaoPorCidade(nomeCidade);
		String idCidade = cidades.get(0).getId();
		return avisoService.buscarprevisao(idCidade);
	}
}
