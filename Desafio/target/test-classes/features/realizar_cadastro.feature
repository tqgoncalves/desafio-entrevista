#language: pt
Funcionalidade: Cadastro de usuarios

	COMO usuario do sistema 
	GOSTARIA realizar o cadastro de novos usuários
	PARA QUE seja possível armazenar e gerenciar seus dados.
	

Cenário: Deve inserir um usuário com sucesso
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário é inserido com sucesso "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                     |
	|José Beltrano   |       josebeltrano@gmail.com    |     1234567890            |    Usuários cadastrados         |

	

Cenário: Realizar cadastro sem o nome preenchido
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário recebe o aviso: O Campo Nome é obrigatório "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                      |
	|                |       josebeltrano@gmail.com    |     1234567890            |    O campo Nome é obrigatório.   |
	
	
	
Cenário: Realizar cadastro sem o e-mail preenchido
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário recebe o aviso: O Campo E-mail é obrigatório "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                           |
	|José Beltrano   |                                    |     1234567890            |    O campo E-mail é obrigatório.      |
	

Cenário: Realizar cadastro sem a senha preenchida
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário recebe o aviso: O Campo Senha é obrigatório "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                           |
	|José Beltrano   |          josebeltrano@gmail.com |                           |    O campo Senha é obrigatório.       |
	
	
	Cenário: Realizar cadastro sem o e-mail válido
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário recebe o aviso: Insira um e-mail válido "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                           |
	|José Beltrano   |    josebeltrano.com             |      1234567890           |   Por favor, insira um e-mail válido. |



Cenário: Realizar cadastro com senha com menos de 8 caracteres
	Dado que estou acessando a aplicação
	Quando informo o nome <nome>
	E o e-mail <email>
	E a senha <senha>
	Quando seleciono Cadastrar
	Então o usuário recebe o aviso: A senha deve conter ao menos oito caracteres. <mensagem>

	
	Exemplos:	
	|nome            |          email                     |     senha              |    mensagem                           |
	|"José Beltrano"   |    "josebeltrano@gmail.com"       |      "1234567"           |   "A senha deve conter ao menos 8 caracteres." |



Cenário: Realizar cadastro de dois usuários ao mesmo tempo
	Dado que estou acessando a aplicação
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário é inserido com sucesso "<mensagem>"
	Quando informo o nome "<nome>"
	E o e-mail "<email>"
	E a senha "<senha>"
	Quando seleciono Cadastrar
	Então o usuário é inserido com sucesso "<mensagem>"
	
	Exemplos:	
	|nome            |          email                     |     senha                 |    mensagem                           |nome            |          email                     |     senha                 |    mensagem                           |
	|José Beltrano   |    beltranopadinha@gmail.com       |      1234567890           |   Usuários cadastrados                |Maria Fernanda  |            mariafernanda@gmail.com |    123456789              |   Usuários cadastrados                 |
	

