package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	private static List<Candidato> lista = new ArrayList<Candidato>();
	private static int num = 10;
	private static int totalVotos = 0;	

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int opcao = -1;		
		while(opcao!=0) {
			opcao = mostrarMenu(teclado);			
			
			switch( opcao) {
			case 1:				
				cadastroCandidato(teclado);
				break;
			case 2:				
				selecionarCandidato(teclado);				
				break;
			case 3:				
				apurarVotos();				
				break;
			}			
		}
	}


	private static void selecionarCandidato(Scanner teclado) {
		for(Candidato c: lista) {
			System.out.println(c);
		}
		
		System.out.println("Digite o numero do candidato selecionado: ");
		int escolha = teclado.nextInt();
		
		for(Candidato c: lista) {
			if(c.getNumero() == escolha) {
				c.votar();
				totalVotos++;									
				System.out.println("Voto com Sucesso: " + c.getNome());
			}
		}
	}


	private static void apurarVotos() {
		Collections.sort(lista);
		System.out.println(totalVotos);
		for(Candidato c: lista) {
			c.porcentagemVotacao(totalVotos);
			System.out.println(c.exibirPorcentagem(totalVotos));
		}
		
		System.out.println("");
		System.out.println("Candidato mais votado foi: " + lista.get(0).exibirPorcentagem(totalVotos));
	}


	private static void cadastroCandidato(Scanner teclado) {
		Candidato candidato = new Candidato();	
		candidato.setNumero(num);
		num++;
		System.out.println("Digite o nome do Candidato: ");
		candidato.setNome(teclado.next());
		
		System.out.println("Digite a idade do Candidato: ");
		candidato.setIdade(teclado.nextInt());
		
		lista.add(candidato);
	}


	private static int mostrarMenu(Scanner teclado) {
		int opcao;
		System.out.println("\n0 - Sair");
		System.out.println("1 - Cadastrar Candidato");
		System.out.println("2 - iniciar Votacao");
		System.out.println("3 - Apurar Votacao");
		System.out.println("Digite a opcao: ");
		opcao = teclado.nextInt();
		return opcao;
	}

}
