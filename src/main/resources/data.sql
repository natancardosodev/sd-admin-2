--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`id`, `nome`, `empresa_id`, `fornecedor_id`) VALUES
(1, 'Angela Pigatto Ferro', 1, 1);

--
-- Extraindo dados da tabela `departamento`
--

INSERT INTO `departamento` (`id`, `cod_dep`, `empresa_id`) VALUES
(1, 562, 1),
(2, 482, 2);

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`id`, `nome`, `endereco_id`) VALUES
(1, 'Luna Comércios e Bebidas LTDA', 2),
(2, 'Adriana e Bernardo Fotografias Ltda', 3);

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `bairro`, `cidade`, `estado`, `rua`) VALUES
(1, 'Parreão', 'Fortaleza', 'CE', 'Rua Esperanto, 622'),
(2, 'Cuiá', 'João Pessoa', 'PB', 'Rua Professor Manoel Pacífico de Oliveira, 718'),
(3, 'Santo Amaro', 'Recife', 'PE', 'Avenida João de Barros, 762'),
(4, 'Santo Antônio', 'Mossoró', 'RN', 'Rua Edinor Lima de Moura, 511');

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `endereco`, `nome`, `telefone`) VALUES
(1, 'Rua Afonso Campos, 658 - Mangabeira I', 'Aliança Madeireira LTDA', '(83) 3568-8598'),
(2, 'Av. Celso Garcia, 412 - Geisel', 'Casa da Construção', '(83) 3223-1547');
