PASSO A PASSO DE COMO FAZER UM CRUD:

CRUD
C.CREATE==CRIAR
R.READ==LER
U.UPDATE==ATUALIZAR
D.DELETE==DELETAR
PODEMOS USAR O CRUD COMO BASE PARA O BANCO DE DADOS
POIS USAMOS AS QUATRO OPERAÇÕES.

PARA REPASSAR ELE PARA O INTELIJ
USAMOS ESSES MODELOS ABAIXO:

1.criar um model
== seria uma estrutura de identidade
por exemplo:
criei uma tabela clientes e dentro
dela tem cinco colunas e cada uma delas 
tem um nome relacionado ao nome da tabela


2.criar um repository
== seria uma ponte para
o banco de dados ==

3.criar um service
== injecao de dependencia,
falara que o service depende de alguem,
e aqui seria a parte que o controller se
direciona para o service, criar uma lista de clients
utilizando o clienteRepository,
pra listar todos os id criados ==

4.criar um controller
== ele recebe todas as requisiÇões
que chegam de clients e direcionando
para o service ==

5.maven repository
== serve para pegar uma expansão
para poder usaro swagger ==

6.documenar no swagger
== depois de pegar a expansão no maven
e rodar seu projeto ele mostrara todos os model
que voce criou ==
