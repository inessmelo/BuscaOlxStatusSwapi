#language:pt

@teste
Funcionalidade: efetuar uma busca no site da OLX
	Como um usuario
	Quando eu acessar o site da olx
	Devo efetuar uma busca de produto
	
	@produtoOLX
	Cenario: efetuar o login, buscar um produto e efetuar o logout
		Dado que acesso o site OLX
		Quando preencher o campo nome com "teste@teste.com"
		E preencher o campo senha com "teste123456"
		E clicar no botão Entrar 
		Entao efetuará o login do usuario
		Quando preencho o campo busca com "Tracker 20/21"
		E seleciono o estado "Paraná"
		Entao exibira o produto selecionado	
		Quando clicar no nome do usuario
		E clicar em sair
		Entao efetuara o logout