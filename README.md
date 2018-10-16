# Projeto ACME

O projeto em questão, trata-se do gerenciamento de uma empresa fictícia, chamada ACME Ltda. Nessa empresa termos o controle dos departamentos, funcionários, contatos da empresa e de seus departamentos assim como, as demais entidades envolvidas em todos os processos. 
Inicialmente, iremos realizar os cadastros das entidades apresentadas no diagrama de classe abaixo, consideremos que após todos os cadastros realizados e de acordo com os seus relacionamentos, também apresentados na imagem, finalizaremos a primeira versão do projeto, que se chamará acme_store. 
O projeto faz parte da disciplina 'Desenvolvimento de Aplicações Avançadas' e tem a segunda versão do projeto com regras de negócio específicas. Será desenvolvido nesse fork o cadastro de fornecedor, que por sua vez, depende do cadastro de produtos.

## Tecnologias e ferramentas
- [Spring Boot](https://start.spring.io/)
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
- [Java 8](https://www.java.com/pt_BR/download/)
- [Maven 3](https://maven.apache.org/download.cgi)
- [Eclipse IDE for Java EE](https://www.eclipse.org/downloads/packages/)
- [MySQL - SGBD](https://dev.mysql.com/downloads/mysql/)
- [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

## Diagrama de classes
[![Diagrama](https://raw.githubusercontent.com/natancardosodev/sd-admin-2/master/docs/diagrama.png)](https://github.com/natancardosodev/sd-admin-2/tree/master/src/main/java/br/com)

## Como executar o projeto

### *Usando o Git Bash*
- Navegue até o seu diretório de projetos de programação
- Faça o clone do projeto para a sua máquina local: ```git clone https://github.com/natancardosodev/sd-admin-2.git``` 

### *Atualização do Maven e compilação*
Pode ser feito tanto pelo terminal quanto por uma IDE Java, a seguir as duas opções, finalizando na execução.

#### Através do terminal ou CMD
- Entre na raiz do projeto, pelo CMD é o seguinte comando: ```cd sd-admin-2```
- Execute o comando via CMD ou terminal: ```mvn clean install```
- Execute o comando a seguir na raiz do projeto ```mvn spring-boot:run```

#### Usando a IDE
Através do Spring Tool Suite, Eclipse com o plugin STS ou outra IDE Java:
- Depois de importar o projeto deve atualizar as dependências do Maven clicando com o botão direito no projeto, buscando a opção ```Maven``` e clicar em ```Update Project```
- Na janela aberta selecione o projeto e clique no checkbox ```Force Update of Snapshots/Releases``` 
- Clique em ```Ok``` e aguarde
- Finalizada a atualização do Maven, deve clicar com o botão direito no projeto, buscar a opção ```Run As``` e clicar em ```Spring Boot App```

### *Executando no browser*
- Em ambos os casos, quanto a execução do Maven no terminal ou na IDE, resultarão após a compilação do projeto na renderização no navegador através do endereço: ```http://127.0.0.1:8090/```