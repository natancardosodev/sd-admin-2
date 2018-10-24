INSERT INTO `endereco` (`id`, `bairro`, `cidade`, `estado`, `rua`) VALUES
(1, 'Parreão', 'Fortaleza', 'CE', 'Rua Esperanto, 622'),
(2, 'Cuiá', 'João Pessoa', 'PB', 'Rua Professor Manoel Pacífico de Oliveira, 718'),
(3, 'Santo Amaro', 'Recife', 'PE', 'Avenida João de Barros, 762'),
(4, 'Santo Antônio', 'Mossoró', 'RN', 'Rua Edinor Lima de Moura, 511'),
(5, 'Guarujá', 'Lages', 'SC', 'Rua Ilhéu da Coroa Vermelha, 658'),
(6, 'Santa Amélia', 'Macéio', 'AL', 'Rua Ernandi de Albuquerque Santos, 459'),
(7, 'Castelo Branco', 'Salvador', 'BA', 'Rua Criciúma, 715'),
(8, 'Industrial', 'Aracaju', 'SE', 'Avenida Filadelfo Dórea, 599'),
(9, 'Jeremias', 'Campina Grande', 'PB', 'Rua Vereador Augusto Ferreira Ramos, 569'),
(10, 'Brasília', 'Patos', 'PB', 'Rua Bossuet Wanderley, 364'),
(11, 'São Geraldo', 'Arcoverde', 'PB', 'Travessa Lupcínio Soares de Oliveira, 230'),
(12, 'Floriano', 'Jaboatão dos Guararapes', 'PE', 'Rua Rosa-Mesquita, 385');

INSERT INTO `empresa` (`id`, `nome`, `endereco_id`) VALUES
(1, 'Luna Comércios e Bebidas LTDA', 2),
(2, 'Adriana e Bernardo Fotografias Ltda', 3),
(3, 'Priscila e Igor Buffet ME', 1),
(5, 'Ester e Jéssica Gráfica Ltda', 4),
(6, 'Henry Entregas Expressas ME', 5);

INSERT INTO `departamento` (`id`, `cod_dep`, `empresa_id`) VALUES
(1, 562, 1),
(2, 482, 2),
(3, 685, 1),
(4, 489, 3),
(5, 965, 6),
(6, 123, 5),
(7, 769, 5),
(8, 960, 2),
(9, 338, 1),
(10, 146, 2),
(11, 555, 5),
(12, 755, 6),
(13, 635, 3),
(14, 449, 3);

INSERT INTO `funcionario` (`id`, `matricula`, `nome`, `endereco_id`) VALUES
(1, '69851', 'Igor Pietro Eduardo Martins', 1),
(2, '89121', 'Kaique Benjamin Duarte', 2),
(3, '95621', 'Andreia Benedita Jéssica Nogueira', 3),
(4, '89465', 'Heloisa Mariah Oliveira', 5),
(5, '28782', 'José Enzo Caldeira', 4),
(6, '04104', 'Breno Bernardo Isaac Almeida', 6),
(7, '52058', 'Isabela Carolina Duarte', 7);

INSERT INTO `fornecedor` (`id`, `endereco`, `nome`) VALUES
(1, 'Rua Afonso Campos, 658 - Mangabeira I', 'Aliança Madeireira LTDA'),
(2, 'Av. Celso Garcia, 412 - Geisel', 'Casa da Construção'),
(3, 'Rua José Oiticica Filho, 767 - Bayeux', 'Bento e Emily Limpeza Ltda'),
(4, 'Rua Doutor Roque José Balbo, 430 - Santa Rita', 'Laís e Natália Restaurante ME'),
(5, 'Rua Gasparino Ribeiro, 52 - Recife', 'Enrico Alves Marcenaria ME'),
(6, 'Rua Ferreira Aguiar, 535 - João Pessoa', 'Oliver Marketing Ltda'),
(7, 'Rua José Carlos Cirino, 251 - Olinda', 'Edson e Esther Eletrônica ME');

INSERT INTO `contato` (`id`, `nome`, `empresa_id`, `fornecedor_id`) VALUES
(1, 'Angela Pigatto Ferro', 1, 1),
(2, 'Augusto Francisco Henry Fogaça', 2, 3),
(3, 'Marlene Beatriz da Rosa', 2, 7),
(4, 'Fabiana Isabel Daniela Castro', 3, 4),
(5, 'Nicolas Giovanni Miguel Moraes', 1, 6);

INSERT INTO `email` (`id`, `descricao`, `contato_id`, `empresa_id`, `fornecedor_id`, `funcionario_id`) VALUES
(1, 'augustofh@hotmail.com', 2, 2, 2, 2),
(2, 'angelapf@gmail.com', 1, 2, 4, 3),
(3, 'nicolasgm@yahoo.com', 5, 6, 6, 6);

INSERT INTO `telefone` (`id`, `descricao`, `contato_id`, `empresa_id`, `fornecedor_id`, `funcionario_id`) VALUES
(1, '(83) 3021-6582', 2, 3, 2, 2),
(2, '(82) 3224-8563', 1, 6, 6, 4),
(3, '(85) 3566-9871', 5, 5, 5, 3),
(4, '(83) 3222-6352', 3, 2, 5, 6),
(5, '(82) 4044-5862', 4, 1, 3, 1);

INSERT INTO `produto` (`id`, `categoria`, `codigo`, `data_validade`, `nome`, `fornecedor_id`) VALUES
(1, 'Eletroportáteis', 5692, '2020-03-19', 'Sanduicheira e Grill', 4),
(2, 'Tv e Acessórios', 68925, '2020-06-25', 'Smart TV LED 43\" UHD 4K Samsung', 7),
(3, 'Câmeras digitais', 45200, '2021-10-29', 'Câmera Nikon D5300 24,2 Mp', 6),
(4, 'Bebidas', 48798, '2018-12-28', 'Refrigerante Coca-cola 2L', 4),
(5, 'Comunicação Visual', 3695, '2019-02-22', 'Banner 1,2 x 0,8m', 6);