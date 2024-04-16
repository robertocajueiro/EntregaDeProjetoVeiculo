# Entrega do Projeto Veiculo

Banco de dados criado atraves do hibernate utilizado nas classes a anotation @Entity e @Table. Foi definido nos atributos codigo a anotation @Id para ser seu identificado único PK - Primary key e também a anotation @GeneratedValue com a estrategia IDENTITY.

Para isso utilizamos o gerenciador de dependencia Maven com a dependencia do hibernate. Abaixo o diagrama com as tabelas criado.

Para os teste criei um pacote aplicacao e dentro uma classe aplicação executando na criação das classes, aumaticamente criando as tabelas no banco postgreSQL. Para popular o banco criei um arquivo com extensão sql dentro de resource chamado import.sql para que todas as vezes que fizesse uma mudança de uma nova classe pudesse popular o banco de dados


![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/59c7fe6d-1a79-479a-80fb-70bd016cae5f)


em resource definir o arquivo persistence.xml para fazer a conexão com banco. Inicialmente criei o pacote jdbc com a classe ConnectionFactory para iniciar os teste com banco utilizando query sql.

foi criado também o pacote dao para definir o acesso aos dados juntos com suas interfaces onde foi definido o contrato na criação dos metodos

As classes Veiculo, Cliente, vendedor e vendas.

por ser um projeto pequeno resolvi deixa em uma unica classe cliente e endereço. Inicialmente para testes. atualmente definir como TODO a criação modulo de vendas onde o vendedor cria os pedidos de vendas.

foi feito uma tela de login. Onde o usuário faz autenticação pela tabela de vendedor que contem os campos email e senha.

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/b4a14863-5d3b-49d5-83de-f03312e8aa94)

chamando o FrmMenu essas classes ficam dentro do pacote view

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/f763d362-5f7f-48b6-a128-de4b9ea7eec7)

podendo em manutenção chamar Lista de Clientes, cadastro de cliente, cadastro de veiculos, lista de veiculos como também fazer a troca do usuário. Ficou como TODO a definição dos niveis de acesso.

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/5f7afa0a-3345-4c51-a510-ed3e95f9a045)
Cadastro de clientes. foi feito uma classe WebServiceCEP, uma API para consulta de CEP.

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/c2ea7d63-6085-4de7-825c-c969edb42554)
Consulta de clientes.


![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/ff8895cd-bc1f-407a-8cef-938f292e58ff)
Cadastro de veículos.

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/4479c1e8-507c-4edd-a47d-70dd418a8ad8)
Consulta de Veículos.

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/e677b2ed-40aa-4383-b406-0bb42262ac9a)
Cadastro de vendedores onde os campos email e senha será o usuário que vai acessar o sistema de veículos

![image](https://github.com/robertocajueiro/EntregaDeProjetoVeiculo/assets/28118980/626d245f-554c-4656-a746-aa3042275f51)
Consulta de Vendedores.


// TODO para criação do modulo de vendas frente de loja. 

