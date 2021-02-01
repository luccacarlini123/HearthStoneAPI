<h1>Projeto HearthStone</h1>
<p>O projeto é composto por duas APIs feitas em Spring Boot que atuam com o mesmo propósito, tem os mesmos endopints, mesmas classes... A diferença entre essas aplicações é que 
uma foi feita seguindo a especificação JAX-RS implementada pelo Jersey e a outra em Spring Rest usando a maioria dos módulos do Spring Framework.</p> 

<h1>Como compilar</h1>

<p>Para compilar o projeto é preciso ter instalados o Java 8, uma IDE(Spring Tool Suite(STS), IntelliJ IDEA, Eclipse...) que suporte o Java 
e a ferramenta Postman para fazermos nossas requisições as APIs. A porta do servidor usada por ambas as aplicações é '8083', então tenha certeza que está porta não esteja 
em uso no seu computador ou se preciso altere a porta, pois as aplicações não irão funcionar ao mesmo tempo.</p>

<h4>1° Faça o download zip do projeto aqui no GitHub, com os arquivos em mãos extraia-os
em algum diretório. Com a IDE aberta importe o nosso projeto Maven que pode ser tanto o HearthStone_SpringReste quanto o HearthStone_JAX-RS(Jersey)
ambos estão rodando na mesma porta.</h4>

<h4>2° Rode algum dos projetos, certifque-se que esteja rodando como uma aplicação Spring Boot.</h4>

<h4>3° Com o Postman aberto importe a coleção de requests que veio na pasta zip que contém os dois projetos, esta coleção possui todos os requests possíveis para nossa api.</h4> 

<p>"Note que para enviarmos um request que buscará uma carta por Tipo ou Classe ou para cadastrar uma carta estaremos passando os ids de Tipo e Classe, 
então foram criados dois endpoints adicionais nos quais retornam todas as Classes e Tipos para facilitar."<p>

<h4>Tendo tudo isso em vista basta apenas fazer os requests e consumir os endpoints da nossa API.</h4>
