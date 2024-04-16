/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Roberto Dantas
 * Created: 12 de abr. de 2024
 */

insert into tb_vendedor(nome) values ('Lucas Batista');
insert into tb_vendedor(nome) values ('João da Silva');
insert into tb_vendedor(nome) values ('Bob');
insert into tb_vendedor(nome) values ('Maria');

insert into tb_vendedor (email, senha, nome) values ('roberto@fuctura.com.br', '123', 'Roberto Dantas');
insert into tb_vendedor (email, senha, nome) values ('bob@fuctura.com.br', '123', 'João');
insert into tb_vendedor (email, senha, nome) values ('maria@fuctura.com.br', '123', 'Maria');
insert into tb_vendedor (email, senha, nome) values ('joao@fuctura.com.br', '123', 'João da Silva');
insert into tb_vendedor (email, senha, nome) values ( 'admin@fuctura.com.br', '123', 'Roberto Cajueiro');

insert into tb_veiculo(placa,marca,modelo,ano, valor) values('PFI2233', 'CHEVROLET', 'CELTA', 2012,  15000);
insert into tb_veiculo(placa,marca,modelo,ano,valor) values('PPT1111', 'CHEVROLET', 'ONIXJOIN', 2018, 47000);
insert into tb_veiculo(placa,marca,modelo,ano,valor) values('OYT4467', 'FORD', 'FIESTA 1.0', 2014, 28000);
insert into tb_veiculo(placa,marca,modelo,ano,valor) values('PFI5252', 'CHEVROLET', 'PRISMA 1.4', 2012, 21000);
insert into tb_veiculo(placa,marca,modelo,ano,valor) values('PY0K123', 'FIAT', 'PULSE 200T', 2024, 119000);

insert into tb_cliente (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf) values ( 'Beltrano da Silva', '12355','000.222.555-00', 'beltrano@gmail.com','33225588','8188998888','54325612','Rua jose alves',10, 'Casa','Guararapes','Jaboatao','PE');
insert into tb_cliente (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf) values ( 'MARIA', '2255874','000.111.000-00', 'maria@gmail.com','33225588','8188998888','54325612','Rua jose alves',10, 'Casa','Guararapes','Jaboatao','PE');

