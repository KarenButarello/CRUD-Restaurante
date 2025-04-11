insert into cozinha (id, nome_cozinha) values (1, 'Tailandesa');
insert into cozinha (id, nome_cozinha) values (2, 'Indiana');

insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into Forma_Pagamento(id, descricao) values (1, 'Crédito');
insert into Forma_Pagamento(id, descricao) values (2, 'Débito');
insert into Forma_Pagamento(id, descricao) values (3, 'Dinheiro');

insert into Permissao(id, nome, descricao) values (1, 'Permissao', 'Permissao1');
insert into Permissao(id, nome, descricao) values (2, 'Permissao', 'Permissao2');

insert into Estado(id, Estado) values (1, 'PR');
insert into Estado(id, Estado) values (2, 'SP');
insert into Estado(id, Estado) values (3, 'RS');
insert into Estado(id, Estado) values (4, 'RJ');

insert into Cidade(id, Cidade, Estado) values(1, 'Londrina', 1);
insert into Cidade(id, Cidade, Estado) values(2, 'Curitiba', 1);
insert into Cidade(id, Cidade, Estado) values(3, 'Sao Paulo', 2);
insert into Cidade(id, Cidade, Estado) values(4, 'Jundiai', 2);
insert into Cidade(id, Cidade, Estado) values(5, 'Porto Alegre', 3);
insert into Cidade(id, Cidade, Estado) values(6, 'Gramado', 3);
insert into Cidade(id, Cidade, Estado) values(7, 'Canela', 3);
insert into Cidade(id, Cidade, Estado) values(8, 'Rio de Janeiro', 4);


