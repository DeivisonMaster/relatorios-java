package br.com.relatorio.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import br.com.relatorio.util.ConnectionFactory;

public class TestaRelatorio {
	public static void main(String[] args) {
		Connection conexao = new ConnectionFactory().getConnection();
		GeradorDeRelatorios geradorDeRelatorios = new GeradorDeRelatorios();
		
		
		Map<String, Object> parametros = new HashMap<>();
		String arquivoJasper = "jasper/relatorio_movimentacoes.jasper";
		geradorDeRelatorios.geraRelatorios(arquivoJasper, conexao, parametros );
		
	}
}
