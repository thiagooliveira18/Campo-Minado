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
							+"Tudo que você precisa saber é que cada número indica quantas minas têm ao seu lado, nas casas vizinhas.\n"
							+"Repito: isso é tudo que você precisa saber, o que segue é apenas uma classificação das variações do jogo, que você pode deduzir sozinho.\n"
							+"Classificação das Jogadas\n"
							+"Em essência, só existem três tipos de jogadas no Campo Minado:\n");
		Thread.sleep(4000);
		System.out.println("Dedução Direta:\n"
							+"\nQuando um número no tabuleiro coincide com a quantidade de casas vizinhas fechadas \r\n"
							+"e quando um número já tem a quantidade correspondente de minas vizinhas confirmadas\r\n"
							+"\n"
							+"Nesses dois casos, basta contar e marcar as minas ou abrir as casinhas correspondentes, de\n"
							+"fato é direto! A dedução direta fica caracterizada pelo uso de apenas um número do tabuleiro\n"
							+"para conhecer uma nova informação (ter certeza que numa casa fechada tem ou não uma bomba).\n"
							+"\n");
		Thread.sleep(4000);
		System.out.println("Dedução Indireta:\n"
							+"quando não é direta no sentido acima mas ainda assim podemos conhecer mais alguma\n"
							+"informação. É mais fácil entender através de um exemplo do que uma conceituação exata (as n\n"
							+"casas ocultas da figura já foram abertas e não influenciam na jogada):"
							+"\n");
		Thread.sleep(4000);
		System.out.println("Chute:\n"
							+"quando não é possível conhecer mais alguma informação. Podemos, pelo menos, ter certeza\n"
							+"que não dá pra saber. Isso sempre acontece no início do jogo e às vezes em casos como os\n"
							+"das figuras abaixo e ao lado, onde só resta chutar uma casa qualquer.\n"
							+"\n");
		Thread.sleep(4000);
		
	}
}
