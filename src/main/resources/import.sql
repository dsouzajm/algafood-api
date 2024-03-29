insert into estado (id, nome) values (1, 'São Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');
insert into estado (id, nome) values (3, 'Bahia');
insert into estado (id, nome) values (4, 'Minas Gerais');
insert into estado (id, nome) values (5, 'Paraná');
insert into estado (id, nome) values (6, 'Rio Grande do Sul');
insert into estado (id, nome) values (7, 'Santa Catarina');
insert into estado (id, nome) values (8, 'Pernambuco');
insert into estado (id, nome) values (9, 'Rio Grande do Norte');
insert into estado (id, nome) values (10, 'Mato Grosso');
insert into estado (id, nome) values (11, 'Mato Grosso do Sul');
insert into estado (id, nome) values (12, 'Goiás');
insert into estado (id, nome) values (13, 'Distro Federal');
insert into estado (id, nome) values (14, 'Amapá');
insert into estado (id, nome) values (15, 'Roraima');
insert into estado (id, nome) values (16, 'Rondônia');
insert into estado (id, nome) values (17, 'Acre');
insert into estado (id, nome) values (18, 'Amazonas');
insert into estado (id, nome) values (19, 'Paraíba');
insert into estado (id, nome) values (20, 'Sergipe');
insert into estado (id, nome) values (21, 'Tocantins');
insert into estado (id, nome) values (22, 'Espírito Santo');
insert into estado (id, nome) values (23, 'Maranhão');
insert into estado (id, nome) values (24, 'Pará');
insert into estado (id, nome) values (25, 'Ceará');
insert into estado (id, nome) values (26, 'Piauí');
insert into estado (id, nome) values (27, 'Alagoas');

insert into cidade (id, nome, estado_id) values (1, 'São Paulo', 1);
insert into cidade (id, nome, estado_id) values (2, 'Rio de Janeiro', 2);
insert into cidade (id, nome, estado_id) values (3, 'Salvador', 3);
insert into cidade (id, nome, estado_id) values (4, 'Belo Horizonte', 4);
insert into cidade (id, nome, estado_id) values (5, 'Curitiba', 5);
insert into cidade (id, nome, estado_id) values (6, 'Porto Alegre', 6);
insert into cidade (id, nome, estado_id) values (7, 'Florianópilis', 7);
insert into cidade (id, nome, estado_id) values (8, 'Recife', 8);
insert into cidade (id, nome, estado_id) values (9, 'Natal', 9);
insert into cidade (id, nome, estado_id) values (10, 'Cuiabá', 10);
insert into cidade (id, nome, estado_id) values (11, 'Campo Grande', 11);
insert into cidade (id, nome, estado_id) values (12, 'Goiânia', 12);
insert into cidade (id, nome, estado_id) values (13, 'Brasília', 13);
insert into cidade (id, nome, estado_id) values (14, 'Macapá', 14);
insert into cidade (id, nome, estado_id) values (15, 'Boa Vista', 15);
insert into cidade (id, nome, estado_id) values (16, 'Porto Velho', 16);
insert into cidade (id, nome, estado_id) values (17, 'Rio Branco', 17);
insert into cidade (id, nome, estado_id) values (18, 'Manaus', 18);
insert into cidade (id, nome, estado_id) values (19, 'João Pessoa', 19);
insert into cidade (id, nome, estado_id) values (20, 'Aracaju', 20);
insert into cidade (id, nome, estado_id) values (21, 'Tocantins', 21);
insert into cidade (id, nome, estado_id) values (22, 'Vitória', 22);
insert into cidade (id, nome, estado_id) values (23, 'São Luís', 23);
insert into cidade (id, nome, estado_id) values (24, 'Belém', 24);
insert into cidade (id, nome, estado_id) values (25, 'Fortaleza', 25);
insert into cidade (id, nome, estado_id) values (26, 'Teresina', 26);
insert into cidade (id, nome, estado_id) values (27, 'Maceió', 27);

insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Italiana');
insert into cozinha (nome) values ('Espanhola');
insert into cozinha (nome) values ('Portuguesa');

insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (1, 'Thay Food', 3.5, 1, '02100-000', 'apto 1', 'Rua do Marco Zero', '2', 1, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (2, 'Muay Taka Taka', 4.5, 1, '02200-000', 'apto 12', 'Rua do Paraiso', '2', 2, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (3, 'New Delhi', 2.5, 2, '02300-000', 'apto 21', 'Rua das Estrelas', '2', 3, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (4, 'Kama Food', 5.5, 2, '02400-000', 'apto 31', 'Rua da Paz', '2', 4, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (5, 'Jeca Tatu', 0, 3, '02500-000', 'apto 41', 'Rua do Marco Zero', '2', 7, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (6, 'Fogo de Chão', 7.5, 3, '02000-000', 'apto 21', 'Rua do Marco Zero', '2', 2, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (7, 'Va Bene', 2, 4, '01100-000', 'apto 18', 'Rua do Marco Zero', '2', 5, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (8, 'Ragazzo', 2.8, 4, '00100-000', 'apto 19', 'Rua do Marco Zero', '2', 7, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (9, 'Questro', 2.53, 4, '04100-000', 'apto 123', 'Rua do Marco Zero', '2', 8, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (10, 'La Furia', 2.59, 5, '05100-000', 'apto 13', 'Rua do Marco Zero', '2', 9, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (11, 'Roja', 5.50, 5, '06100-000', 'apto 14', 'Rua do Marco Zero', '2', 2, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (12, 'Belem', 7.5, 6, '07100-000', 'apto 17', 'Rua do Marco Zero', '2', 2, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (13, 'Navegantes', 8.5, 6, '08100-000', 'apto 14', 'Rua do Marco Zero', '2', 1, utc_timestamp(6), utc_timestamp(6));
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_cidade_id, data_cadastro, data_atualizacao) values (14, 'Madeira Cruz', 9.5, 6, '09100-000', 'apto 14', 'Rua do Marco Zero', '2', 1, utc_timestamp(6), utc_timestamp(6));

insert into forma_pagamento (id, descricao) values (1, 'Pix');
insert into forma_pagamento (id, descricao) values (2, 'Débito');
insert into forma_pagamento (id, descricao) values (3, 'Crédito');

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (1, 'Picanha', 'Embalagem contendo 1 kg de picanha', 100.0, true, 1);

insert into restaurante_forma_pagamento values (1,1);
insert into restaurante_forma_pagamento values (1,2);
insert into restaurante_forma_pagamento values (2,2);
insert into restaurante_forma_pagamento values (2,3);
insert into restaurante_forma_pagamento values (3,1);
insert into restaurante_forma_pagamento values (3,3);
insert into restaurante_forma_pagamento values (4,1);
insert into restaurante_forma_pagamento values (4,2);
insert into restaurante_forma_pagamento values (4,3);
insert into restaurante_forma_pagamento values (5,3);
insert into restaurante_forma_pagamento values (6,3);
insert into restaurante_forma_pagamento values (7,3);
insert into restaurante_forma_pagamento values (8,3);
insert into restaurante_forma_pagamento values (9,3);
insert into restaurante_forma_pagamento values (10,3);
insert into restaurante_forma_pagamento values (11,3);
insert into restaurante_forma_pagamento values (12,3);
insert into restaurante_forma_pagamento values (13,3);
insert into restaurante_forma_pagamento values (14,3);

insert into permissao (id, nome, descricao) values (1, 'Permissao incluida por script 1', 'Desc Permissao incluida por script 1');
insert into permissao (id, nome, descricao) values (2, 'Permissao incluida por script 2', 'Desc Permissao incluida por script 2');

insert into grupo (id, nome) values (1, "Grupo 1");
insert into grupo (id, nome) values (2, "Grupo 2");
insert into grupo_permissao (grupo_id, permissao_id) values (1, 1);

insert into usuario (id, nome, email, senha, data_cadastro) values (1, "usuario1", "usuario1@gmail.com", "123", utc_timestamp(6))
insert into usuario (id, nome, email, senha, data_cadastro) values (2, "usuario2", "usuario2@gmail.com", "234", utc_timestamp(6))

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1);
insert into usuario_grupo (usuario_id, grupo_id) values (2, 1);
insert into usuario_grupo (usuario_id, grupo_id) values (2, 2);
