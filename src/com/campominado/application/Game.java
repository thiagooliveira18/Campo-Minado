package com.campominado.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.campominado.application.util.Board;
import com.campominado.application.util.Position;

public class Game extends Commands {

	Scanner ler = new Scanner(System.in);
	Position pos = new Position();
	Board board = new Board();
	File arq = new File("save.txt");

	// Variaveis usadas na class Game;
	private int round = 0;
	private int i, j;
	int[][] table = new int[10][8];

	public Game() {

	}

	public void Apresentation() throws InterruptedException {

		while (true) {

			String decision;

			System.out.println("Bem vindo ao jogo");
			System.out.println("Deseja começar?");
			System.out.println(
					"|'Start' para Iniciar | 'Tutorial' para ver o Tutorial| 'Exit' para Sair|'Load' para carregar jogo salvo|");

			decision = ler.next().toLowerCase();

			switch (decision) {
			case "start":
				Start();
				break;
			case "tutorial":
				Tutorial();
				break;
			case "exit":
				System.out.println("Saindo do Jogo...");
				Thread.sleep(1000);
				System.out.println("..");
				Thread.sleep(1000);
				System.out.println(".");
				Exit();
				break;
			case "load":
				Load();
				Round();
				break;
			default:
				System.out.println("Digito inválido.");
			}

		}
	}

	public void Start() throws InterruptedException {

		int count = 0;

		// Quantidade de bombas
		System.out.print("Valor de bombas: ");
		int nbomb = ler.nextInt();
		ler.nextLine();
		board.setnBomb(nbomb);

		System.out.println("Jogo Iniciando...");
		Thread.sleep(1000);
		System.out.println("..");
		Thread.sleep(1000);
		System.out.println(".");

		// Criando o tabuleiro com as bombas
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 8; j++) {
				// contagem de bombas geradas
				if (count < board.getnBomb()) {
					// inserção de bombas nas posições geradas
					if (pos.posi(i) == i || pos.posj(j) == j) {
						count++;
						table[i][j] = 1;
						board.setTable(table);
					}
					// inserção de bombas nas posições geradas
					else if (count < board.getnBomb()) {
						if (pos.posi(i) == i || pos.posj(j) == j) {
							count++;
							table[i][j] = 1;
							board.setTable(table);
						}
					}
				}
			}
		}
		Round();
	}

	public void Round() throws InterruptedException {
		int countBomb = 0;
		int flag = 0;

		round++;
		System.out.println();
		System.out.println("Rodada: " + round);
		Thread.sleep(1000);

		for (i = 0; i < 10; i++) {
			for (j = 0; j < 8; j++) {

				if (board.getTable()[i][j] == 2) {
					// Verificação de bombas as redor
					// da célula aberta
					// Cima
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i - 1][j] == 1
							||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4 || i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Baixo
					if (i != 0 && j != 0 && i < 9 && board.getTable()[i + 1][j] == 1 || i != 0 && j != 0 && i < 9 && board.getTable()[i + 1][j] == 4
							||i != 0 && j != 0 && i < 9 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Esquerda
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i][j - 1] == 1 || i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4
							|| i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Direita
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i][j + 1] == 1 || i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4
							|| i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Diagonal Esquerda Cima
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i - 1][j - 1] == 1 || i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4
							||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Diagonal Esquerda Baixo
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j - 1] == 1
							||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4 ||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Diagonal Direita Cima
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i - 1][j + 1] == 1
							||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4 ||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					// Diagonal Direita Baixo
					if (i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j + 1] == 1
							||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 4 ||i != 0 && j != 0 && i < 9 && j < 7 && board.getTable()[i + 1][j] == 3) {
						countBomb++;
					}
					System.out.print(" [" + countBomb + "] ");
					// Fim da verificação

					countBomb = 0;

					// Abrindo células sem bombas ao redor
					// da célula selecionada
					// Cima
					if (i != 0 && j != 0 && board.getTable()[i - 1][j] == 0) {
						Open(i - 1, j);
					}
					// Baixo
					if (i != 0 && j != 0 && i < 9 && board.getTable()[i + 1][j] == 0) {
						Open(i + 1, j);
					}
					// Esquerda
					if (i != 0 && j != 0 && board.getTable()[i][j - 1] == 0) {
						Open(i, j - 1);
					}
					// Direita
					if (i != 0 && j != 0 && j < 7 && board.getTable()[i][j + 1] == 0) {
						Open(i, j + 1);
					}
					// Diagonal Esquerda Cima
					if (i != 0 && j != 0 && board.getTable()[i - 1][j - 1] == 0) {
						Open(i - 1, j - 1);
					}
					// Diagonal Esquerda Baixo
					if (i != 0 && j != 0 && i < 9 && board.getTable()[i + 1][j - 1] == 0) {
						Open(i + 1, j - 1);
					}
					// Diagonal Direita Cima
					if (i != 0 && j != 0 && j < 7 && board.getTable()[i - 1][j + 1] == 0) {
						Open(i - 1, j + 1);
					}
					// Diagonal Direita Baixo
					if (i != 0 && j != 0 && j < 7 && i < 9 && board.getTable()[i + 1][j - 1] == 0) {
						Open(i + 1, j - 1);
					}
					// Fim da verificação
				} else if (board.getTable()[i][j] == 3) {
					System.out.print(" [¶] ");
				} else if (board.getTable()[i][j] == 4) {
					flag++;
					System.out.print(" [¶] ");
				} else {
					System.out.print(" [ ] ");
				}
			}
			System.out.println("");
		}
		Win(flag);
		Save();
		Jogada();
	}

	public void Jogada() throws InterruptedException {
		String command;
		int n1 = 0;
		int n2 = 0;

		while (true) {

			System.out.println("");

			System.out.println("Comando ou Jogada: ");
			command = ler.nextLine().toLowerCase();

			String[] commands = command.split(" ");

			// System.out.println(commands.length);

			if (commands.length > 1) {
				n1 = Integer.parseInt(commands[1]);
				n2 = Integer.parseInt(commands[2]);
			}

			// Comando Mark
			if (commands[0].equals("mark")) {
				MarkPosition(n1, n2);
				Round();
			}
			// Comando Open
			else if (commands[0].equals("open")) {
				Open(n1, n2);
				Round();
			}
			// Comando Exit
			else if (commands[0].equals("exit")) {
				Exit();
			}
			// Comando Restart
			else if (commands[0].equals("restart")) {
				Reset();
				Start();
			}
			// Comando Inválido
			else {
				System.out.println("Comando Inválido.");
				System.out.println("Digite Novamente.");
			}

		}
	}

	public void Open(int posi, int posj) throws InterruptedException {

		pos.setPosi(posi);
		pos.setPosj(posj);

		if (board.getTable()[pos.getPosi()][pos.getPosj()] == 1) {
			Lost();
		} else if (board.getTable()[pos.getPosi()][pos.getPosj()] == 0
				|| board.getTable()[pos.getPosi()][pos.getPosj()] == 3) {
			table[pos.getPosi()][pos.getPosj()] = 2;
			board.setTable(table);

		}

	}

	public void MarkPosition(int posi, int posj) {
		pos.setPosi(posi);
		pos.setPosj(posj);

		if (board.getTable()[pos.getPosi()][pos.getPosj()] != 2
				&& board.getTable()[pos.getPosi()][pos.getPosj()] != 1) {
			table[pos.getPosi()][pos.getPosj()] = 3;
			board.setTable(table);
		}
		if (board.getTable()[pos.getPosi()][pos.getPosj()] == 1) {
			table[pos.getPosi()][pos.getPosj()] = 4;
			board.setTable(table);
		}
	}

	public void Win(int flag) {
		int flags = +flag;
		if (flags >= 10) {
			System.out.println("");
			System.out.println("Você Venceu o Jogo!!");
			System.exit(0);
		}
	}

	public void Save() {
		try (PrintWriter pr = new PrintWriter(arq)) {
			for (i = 0; i < 10; i++) {
				for (j = 0; j < 8; j++) {
					pr.print(board.getTable()[i][j]);
				}
				pr.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possivel criar o PrintWriter!");
		}
	}

	public void Load() throws InterruptedException {
		try {
			Scanner load = new Scanner(arq);

			String leitor;

			System.out.println("Carregando Jogo...");
			Thread.sleep(1000);
			System.out.println("..");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);

			for (i = 0; i < 10; i++) {
				// ler a linha do arquivo.
				leitor = load.nextLine();
				// convertendo o leitor para um array.
				char[] vects = leitor.toCharArray();

				int[] vect = new int[vects.length];

				for (j = 0; j < 8; j++) {
					// passando o array String para Int.
					vect[j] = Integer.parseInt(String.valueOf(vects[j]));
					table[i][j] = vect[j];
				}
				System.out.println();
			}
			board.setTable(table);

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possivel obter Dados do arquivo!");
		}
	}

}
