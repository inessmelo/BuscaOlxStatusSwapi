#language:pt

Funcionalidade: acessar o site olx
	Como um usuario
	Quando eu acessar o site da olx
	Devo efetuar uma busca de produto
	
	@login
	Cenario: efetuar o login no site
		Dado que acesso a tela de login
		Quando preencher os campos email e senha
		E clicar no botao entrar
		Entao o login sera efetuado
		
	@busca
	Cenario: selecionar estado
		Dado que acesso o site olx
		Quando buscar o produto
		E selecionar o estado
		Entao exibira o produto
		
	@logout
	Cenario: sair do login
		Dado que acesso o site olx
		Quando clicar em sair
		Entao efetuara o lougout 