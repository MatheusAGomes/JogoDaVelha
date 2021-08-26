import java.util.Arrays;
import java.util.Scanner;
public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] tabuleiro = new int[3][3];
		int tiro;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = 0;
			}
			
		}
		
		int acabou = 0;
		
	
		Scanner input = new Scanner(System.in);
		
		while(acabou == 0)
		{	
			
			mostrar_tabuleiro(tabuleiro);
			System.out.print("Vez do jogador A: ");
			tiro = input.nextInt();
			colocar_tiro(tabuleiro,tiro,1);
			
			 verifica_vencedor(tabuleiro,1);
			
			mostrar_tabuleiro(tabuleiro);
			System.out.print("Vez do jogador B: ");
			tiro = input.nextInt();
			colocar_tiro(tabuleiro,tiro,2);
			
			 verifica_vencedor(tabuleiro,2);
			
		}
		
		
		
	}
	
	public static void verifica_vencedor(int[][]tabuleiro,int jogador){
		int soma = 0;
		int diferente = 0;
		if(jogador == 1) {
			//verifica a soma das linhas
			for (int i = 0; i <= 2; i++) {
			
				for (int j = 0; j <= 2; j++) {
					soma = soma + tabuleiro[i][j] ;
				}
				if(soma == 3)
				{
					mostrar_tabuleiro(tabuleiro);
					System.out.print("Vencedor -> Jogador A");
					System.exit(0);
					
				}
				else{
					soma = 0;
				}
			}
			//verificar a soma das colunas
			for (int i = 0; i <= 2; i++) {
				
				for (int j = 0; j <= 2; j++) {
					soma = soma + tabuleiro[j][i] ;
				}
				if(soma == 3)
				{
					mostrar_tabuleiro(tabuleiro);
					System.out.print("Vencedor -> Jogador A");
					System.exit(0);
				}
				else{
					soma = 0;
				}
			}
			// verifica em diagonal
			for (int i = 0; i <= 2; i++) {
				soma = soma + tabuleiro[i][i] ;
			}
			if(soma == 3)
			{
				mostrar_tabuleiro(tabuleiro);
				System.out.print("Vencedor -> Jogador A");
				System.exit(0);
			}
			else{
				soma = 0;
			}
			
		}
		if(jogador == 2) {
			//verifica a soma das linhas
			for (int i = 0; i <= 2; i++) {
			
				for (int j = 0; j <= 2; j++) {
					soma = soma + tabuleiro[i][j] ;
				}
				if(soma == -3)
				{
					mostrar_tabuleiro(tabuleiro);
					System.out.print("Vencedor -> Jogador B");
					System.exit(0);
				}
				else{
					soma = 0;
				}
			}
			//verificar a soma das colunas
			for (int i = 0; i <= 2; i++) {
				
				for (int j = 0; j <= 2; j++) {
					soma = soma + tabuleiro[j][i] ;
				}
				if(soma == -3)
				{
					mostrar_tabuleiro(tabuleiro);
					System.out.print("Vencedor -> Jogador B");
					System.exit(0);
				}
				else{
					soma = 0;
				}
			}
			// verifica em diagonal
			for (int i = 0; i <= 2; i++) {
				soma = soma + tabuleiro[i][i] ;
			}
			if(soma == -3)
			{
				mostrar_tabuleiro(tabuleiro);
				System.out.print("Vencedor -> Jogador B");
				System.exit(0);
			}
			else{
				soma = 0;
			}
			
		}
for (int i = 0; i <= 2; i++) {
			
			for (int j = 0; j <= 2; j++) {
				if(tabuleiro[i][j]!= 0)
				{
					diferente = diferente + 1 ;
				}
			}
		}
			if(diferente == 9)
			{
				mostrar_tabuleiro(tabuleiro);
				System.out.print("Sem vencedores -> Velha");
				System.exit(0);
				
			}
			else{
				diferente = 0;
			}
		
	}
	public static void mostrar_tabuleiro(int[][] tabuleiro){
		for (int i = 0; i < 3; i++) {
			System.out.print(" \n ");
			for (int j = 0; j < 3; j++) {
				if(tabuleiro[i][j]== 0) {
					if(j<2)
					{
						System.out.print("   |");
					}
					else
					{
						System.out.print("   ");
					}
						
				}
				if(tabuleiro[i][j]== -1) {
					if(j<2)
					{
						System.out.print(" X |");
					}
					else
					{
						System.out.print(" X ");
					}
						
				}
				if(tabuleiro[i][j]== 1) {
					if(j<2)
					{
						System.out.print(" O |");
					}
					else
					{
						System.out.print(" O ");
					}
						
				}
			}
		}
		
		
	}
	
	public static void colocar_tiro(int[][] tabuleiro,int tiro,int jogador) {
	Scanner input = new Scanner(System.in);
	int novoTiro;
	int verifica=0;
	
	if(((tiro<0)||(tiro>8))) 
	{
		System.out.print("(Posição não existente, TENTE NOVAMENTE !): ");
		novoTiro = input.nextInt();
		colocar_tiro(tabuleiro,novoTiro,jogador);
		
	}
	
	
	switch (jogador) {
	case 1:
			
for (int i = 0; i <= 2; i++) {
			
			for (int j = 0; j <= 2; j++) {
				if(verifica == tiro)
				{
						if(tabuleiro[i][j]!=0) {
							System.out.print("(Posição selecionada já está sendo utilizada, TENTE NOVAMENTE !) Vez do jogador A: ");
							novoTiro = input.nextInt();
						colocar_tiro(tabuleiro,novoTiro,jogador);
					}
					else {
						tabuleiro[i][j] = 1;	
					}
					
				}
				verifica = verifica + 1;
			}
		}
			
		break;

	case 2:
		
for (int i = 0; i <= 2; i++) {
			
			for (int j = 0; j <= 2; j++) {
				if(verifica == tiro)
				{
					
					if(tabuleiro[i][j]!=0) {
						System.out.print("(Posição selecionada já está sendo utilizada, TENTE NOVAMENTE !) Vez do jogador B: ");
						novoTiro = input.nextInt();
						colocar_tiro(tabuleiro,novoTiro,jogador);
					}
					else {
						tabuleiro[i][j] = -1;	
					}
				}
				verifica = verifica + 1;
			}
		}
		
		
		break;
	}
	
	}
}

		
	
	
	
	
	