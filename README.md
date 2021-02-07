# BuscaOlxStatusSwapi

Ferramentas utilizadas para o teste
1) eclipse com o maven instalado
2) jdk11 instalado na máquina
3) driver utilizado para os teste foi o Chrome. Este driver está inserido na pasta driver do próprio projeto. Caso não seja executado, favor inserir o driver na pasta windows da maquina que está utilizando ou inserir nas configurações PATH do Sistema.
4) Os dois teste (Busca do OLX e Get do Swapi) estão no mesmo projeto porém em pacotes diferentes.

Para efetuar o teste no site OLX deve ser verificado
1) deverá o usuário inserir o email e senha na classe Steps para conseguir efetuar o teste com sucesso
2) deverá mudar o nome do usuario para efetuar os Assert. Os locais estão informados na classe

OBS: ao efetuar enúmeras vezes o teste no site da OLX com o usuário, o mesmo será bloqueado.

Para efetuar o teste da API do site Swapi
1) apenas efetuar o teste em JUnit
