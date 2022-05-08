insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');


insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1, 'Restaurante 1', 3.5, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Restaurante 2', 4.5, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Restaurante 3', 2.5, 2);


insert into forma_pagamento (id, descricao) values (1, 'Pix');
insert into forma_pagamento (id, descricao) values (2, 'Débito');
insert into forma_pagamento (id, descricao) values (3, 'Crédito');

insert into permissao (id, nome, descricao) values (1, 'Permissao incluida por script 1', 'Desc Permissao incluida por script 1');
insert into permissao (id, nome, descricao) values (2, 'Permissao incluida por script 2', 'Desc Permissao incluida por script 2');

insert into estado (id, nome) values (1, 'São Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');

insert into cidade (id, nome, estado_id) values (1, 'Parati', 2);
insert into cidade (id, nome, estado_id) values (2, 'Niterói', 2);
