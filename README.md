# Controlador Ativos Financeiros
Controlador de Ativos Financeiros - Trabalho 01 Disciplina DSO-II - UFSC

Neste trabalho você deve criar um sistema de controle de carteira de ativos financeiros (ações), através do qual devem ser registrados as ações adquiridas pelo usuários e fornecido o valor atualizado da carteira de ativos financeiros.

A aplicação deve ser programada na linguagem Java utilizando componentes gráficos da API Swing. 

## Requisitos da Aplicação
O sistema deve realizar as seguintes ações através de sua interface gráfica:

- registrar a compra de ações, considerando a corretagem paga;
- registrar a venda de ações, considerando a corretagem e o imposto pagos;
- atualizar o lucro e prejuízo não-realizado (ou seja as posições que não foram fechadas). 
- Registrar o lucro e prejuízo realizados (operações que foram efetivadas).

Crie um componente que armazene dados no formato (chave, valor). Este componente deve fornecer uma interface para armazenar, recuperar e remover dados.

O CPF do investidor deve ser utilizado como chave, e a carteira do usuário (número da carteira) deve ser registrado no campo carteira. Fica a seu critério definir como serão efetivamente armazenados os dados - se em memória, serializados e salvos em um arquivo, ou em um banco de dados. 

Implemente também um componente para cálculo do valor da carteira, lucro e/ou prejuízo realizado e não realizado. Este componente deve receber a quantidade de ações negociadas, custo unitário e custo de corretagem e calcular o valor da carteira (assim como o lucro e/ou prejuízo realizado e não realizado). As seguintes opções podem ser configuradas na interface gráfica:

- valor da corretagem
- quantidade de ações compradas e/ou vendidas
- valor unitário de cada ação (comprada e/ou vendida)
- valor em caixa (valor disponível para investimento)

As propriedades acima poderão ser configuradas através da interface gráfica da aplicação. 

O código do sistema deve ser organizado de acordo com o padrão MVC, no qual o Modelo é composto pelas entidades manipuladas pela aplicação, a Visão corresponde à interface gráfica e o Controlador implementa a lógica da aplicação. Os componentes devem estar em pacotes ou projetos separados do código da interface gráfica da aplicação. 

Para facilitar os testes do sistema, sugerimos que no lugar de utilizar uma API de cotações, você obtenha as cotações a partir de um componente que modifique aleatóriamente as cotações dos ativos.



## Importante:

É Necessário ter o MySQL instalado para o programa compilar

### Database: ``acoes_db``

### Tabela Acionistas:
`CREATE TABLE `Acionistas` (
  `CPF` varchar(15) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Carteira` int(15) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`CPF`),
  KEY `fk_Acionistas_1_idx` (`Carteira`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 `

### Tabela Carteira:
``CREATE TABLE `Carteira` (
  `ID` int(15) NOT NULL,
  `Saldo` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `carteira_fk_idx` (`ID`),
  CONSTRAINT `fk_Carteira_1` FOREIGN KEY (`ID`) REFERENCES `Acionistas` (`Carteira`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1``

### Tabela Ações:
``CREATE TABLE `Acoes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Quantidade` int(20) NOT NULL,
  `Corretagem` double(10,2) NOT NULL,
  `Cotacao` double(10,2) NOT NULL,
  `Custo` double(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1``

### Tabela Cotacoes:
``CREATE TABLE `Cotacoes` (
  `Nome` varchar(20) NOT NULL,
  `Valor` double(10,2) DEFAULT NULL,
  `Corretagem` double(10,2) DEFAULT NULL,
  `Imposto` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1``
