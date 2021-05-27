package com.campominado.application;

import com.campominado.application.util.Board;
import com.campominado.application.util.Position;

public class Commands{

	Position position = new Position();
	Board board = new Board();
	

	public void Exit() throws InterruptedException {
		System.out.println("Saindo do Jogo....");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println("..");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.exit(0);
	}

	public void Reset() throws InterruptedException {
		System.out.println("Reiniciando o Jogo....");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println("..");
		Thread.sleep(1000);
		System.out.println(".");
		System.out.println("");

	}

	public void Lost() throws InterruptedException {
		System.out.println("Havia uma bomba ali.");
		System.out.println("Game Over!");
		Thread.sleep(1000);
		System.exit(0);
	}
	public void Tutorial() throws InterruptedException {
		System.out.println();
		System.out.println("Como Jogar Campo Minado\n"
							+"\n"
							+"Tudo que voc� precisa saber � que cada n�mero indica quantas minas t�m ao seu lado, nas casas vizinhas.\n"
							+"Repito: isso � tudo que voc� precisa saber, o que segue � apenas uma classifica��o das varia��es do jogo, que voc� pode deduzir sozinho.\n"
							+"Classifica��o das Jogadas\n"
							+"Em ess�ncia, s� existem tr�s tipos de jogadas no Campo Minado:\n");
		Thread.sleep(4000);
		System.out.println("Dedu��o Direta:\n"
							+"\nQuando um n�mero no tabuleiro coincide com a quantidade de casas vizinhas fechadas \r\n"
							+"e quando um n�mero j� tem a quantidade correspondente de minas vizinhas confirmadas\r\n"
							+"\n"
							+"Nesses dois casos, basta contar e marcar as minas ou abrir as casinhas correspondentes, de\n"
							+"fato � direto! A dedu��o direta fica caracterizada pelo uso de apenas um n�mero do tabuleiro\n"
							+"para conhecer uma nova informa��o (ter certeza que numa casa fechada tem ou n�o uma bomba).\n"
							+"\n");
		Thread.sleep(4000);
		System.out.println("Dedu��o Indireta:\n"
							+"quando n�o � direta no sentido acima mas ainda assim podemos conhecer mais alguma\n"
							+"informa��o. � mais f�cil entender atrav�s de um exemplo do que uma conceitua��o exata (as n\n"
							+"casas ocultas da figura j� foram abertas e n�o influenciam na jogada):"
							+"\n");
		Thread.sleep(4000);
		System.out.println("Chute:\n"
							+"quando n�o � poss�vel conhecer mais alguma informa��o. Podemos, pelo menos, ter certeza\n"
							+"que n�o d� pra saber. Isso sempre acontece no in�cio do jogo e �s vezes em casos como os\n"
							+"das figuras abaixo e ao lado, onde s� resta chutar uma casa qualquer.\n"
							+"\n");
		Thread.sleep(4000);
		
	}
}
