package model;

import java.io.Serializable;

public class Candidato implements Serializable, Comparable<Candidato>{	
	
	private int numero;
	private String nome;
	private int idade;
	private int qntVotos;
	
	public Candidato() {
		qntVotos = 0;
	}
	public int getNumero() {
		return numero;
	}	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void votar() {
		qntVotos++;
	}	
	
	public int getQntVotos() {
		return qntVotos;
	}
	
	public double porcentagemVotacao(int totalVotos) {	
		double porc = (getQntVotos() / totalVotos) * 100.0;
		return porc;		
	}
	@Override
	public String toString() {
		return "Candidato numero: " + numero + ", nome: " + nome + ", idade: " + idade + ", qntVotos: " + qntVotos;
	}	
	
	public String exibirPorcentagem(int totalVotos) {
		return "Candidato :" + nome + ", teve: " + qntVotos + ", e porcentagem de: " + porcentagemVotacao(totalVotos) + "%";
	}
	
	@Override
	public int compareTo(Candidato outro) {
		int compare = (outro.getQntVotos() > this.getQntVotos()) ? 1 : 0;
		if(compare == 0){
		    compare = (this.getQntVotos() == outro.getQntVotos()) ? 0 : -1;
		}		
		return compare;
	}

}
