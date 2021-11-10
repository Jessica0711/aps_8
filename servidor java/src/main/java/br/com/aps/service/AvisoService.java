package br.com.aps.service;

import static br.com.aps.repository.ConnectionFactory.closeConnection;
import static br.com.aps.repository.ConnectionFactory.getConnection;
import static java.lang.Integer.parseInt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aps.model.Aviso;
import br.com.aps.model.Previsao;

@Service
public class AvisoService {

	@Autowired
	private AvisoService avisoService;

	@Autowired
	private PrevisaoService previsaoService;

	public List<Previsao> buscarprevisao(String idCidade) {
		List<Previsao> previsoes = previsaoService.buscarPrevisaoPorCidade(idCidade);
		for (Previsao previsao : previsoes) {
			List<Aviso> avisos = new ArrayList<>();
			Aviso avisoTempo = avisoService.findById(previsao.getTempo());
			avisos.add(avisoTempo);
			buscarAvisosComplementares(previsao, avisos, avisoTempo);
			previsao.setAvisos(avisos);
		}
		return previsoes;
	}

	private void buscarAvisosComplementares(Previsao previsao, List<Aviso> avisos, Aviso avisoTempo) {
		if (parseInt(previsao.getMaxima()) > 35) {
			avisos.add(avisoService.findById("cae"));
		} else if (parseInt(previsao.getMaxima()) > 23) {
			avisos.add(avisoService.findById("ca"));
		} else if (parseInt(previsao.getMaxima()) < 18) {
			avisos.add(avisoService.findById("fr"));
		}
		if (parseInt(previsao.getIuv()) >= 11) {
			avisos.add(avisoService.findById("uvm"));
		} else if (parseInt(previsao.getIuv()) >= 3) {
			avisos.add(avisoService.findById("uva"));
		}
		if (previsao.getTempo().equals("t") || avisoTempo.getMensagem().contains("pancadas")) {
			avisos.add(avisoService.findById("chuf"));
		}
		if ((previsao.getTempo().startsWith("c") && !previsao.getTempo().equals("cl"))
				|| previsao.getTempo().equals("ec")
				|| avisoTempo.getMensagem().toLowerCase().contains("possibilidade de chuva")) {
			avisos.add(avisoService.findById("chu"));
		}
		if (previsao.getTempo().equals("ne") || parseInt(previsao.getMinima()) <= 0) {
			avisos.add(avisoService.findById("nev"));
		}
	}

	public Aviso findById(String id) {
		String sql = "select * from Avisos " + "where id=?";
		Connection con = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Aviso aviso = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				String mensagem = rs.getString("mensagem");
				String idAviso = rs.getString("id");
				String nivel = rs.getString("nivel");
				aviso = new Aviso(idAviso, mensagem, nivel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(con, pst);
		}
		return aviso;
	}
}
