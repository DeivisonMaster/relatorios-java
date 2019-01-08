package br.com.relatorio.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.relatorio.util.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GeradorDeRelatorios {
	
	public void geraRelatorios(String arquivoJasper, Connection conexao, Map<String, Object> parametros) {
		try {

			// JasperCompileManager.compileReportToFile("jasper/relatorio_movimentacoes.jrxml");

			// carrega o relatorio e parametros
			JasperPrint jasperPrint = JasperFillManager.fillReport(arquivoJasper, parametros,
					conexao);

			// exporta o relatorio
			JRExporter exportaPDF = new JRPdfExporter();
			exportaPDF.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exportaPDF.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("pdf/movimentacoes.pdf"));

			exportaPDF.exportReport();

			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
