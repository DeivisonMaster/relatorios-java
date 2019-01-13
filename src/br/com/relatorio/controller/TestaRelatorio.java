package br.com.relatorio.controller;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.relatorio.util.ConnectionFactory;

public class TestaRelatorio {
	public static void main(String[] args) throws ParseException {
		Connection conexao = new ConnectionFactory().getConnection();
		GeradorDeRelatorios geradorDeRelatorios = new GeradorDeRelatorios();
		
		String data_ini = "01/11/2018";
		String data_fim = "30/01/2019";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial = simpleDateFormat.parse(data_ini);
		Date dataFim = simpleDateFormat.parse(data_fim);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("DATA_INI", dataInicial);
		parametros.put("DATA_FIM", dataFim);
		
		
		String arquivoJasper = "jasper/relatorio_movimentacoes.jasper";
		geradorDeRelatorios.geraRelatorios(arquivoJasper, conexao, parametros );
		
	}
}
