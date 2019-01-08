-- CONSULTA DE TODAS AS MOVIMENTAÇÕES NO SISTEMA

SELECT cat.nomecategoria, mov.id, mov.datamovimentacao, mov.descricao,
	mov.tipo_movimentacao, mov.valor, conta.titular
FROM movimentacoes AS mov
INNER JOIN categorias AS cat
	ON mov.id_categoria = cat.id
INNER JOIN conta AS conta
	ON mov.id_conta = conta.id
    WHERE mov.tipo_movimentacao LIKE 'SAIDA' AND mov.datamovimentacao BETWEEN $P{DATA_INI} AND $P{DATA_FIM} 
    ORDER BY conta.titular ASC, mov.datamovimentacao ASC;