#language:pt

@teste
Funcionalidade: efetuar uma busca no site da OLX
	Como um usuario
	Quando eu acessar o site da olx
	Devo efetuar uma busca de produto
	
	@buscar
	Cenario: buscar um produto logado e após deslogar
		Dado que acesso o site OLX
		Quando logar no sistema
		E procurar um produto
		Entao exibira o produto selecionado
	
	
#	#@login
#	Cenario: efetuar o login no site
#		Dado que acesso a tela de login
#		Quando preencher os campos email e senha
#		E clicar no botao entrar
#		Entao o login sera efetuado
	#	
#	@logout
#	Cenario: sair do login
#		Dado que acesso o site olx
#		Quando clicar em sair
#		Entao usuario efetuara o logout 
#		
#	@busca
#	Cenario: selecionar estado
#		Dado que acesso o site olx
#		Quando buscar o produto
#		E selecionar o estado
#		Entao exibira o produto selecionado