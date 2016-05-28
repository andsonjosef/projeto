package br.edu.fasete.principais;

import java.util.ArrayList;



public class Roupa {
	private String tipo;
	private String modelo;
	private String tamanho;
	private String genero;
	private String cor;
	private boolean disponibilidade;
	private float preco;
	private int codRoupa;
	
	public Roupa(){}
	ArrayList<Roupa> roupas = new ArrayList<Roupa>();
	
	public Roupa(String tipo,String modelo,String tamanho,String genero,String cor,Boolean disponibilidade,float preco,int CodRoupa, int codRoupa){
		this.tipo = tipo;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.genero = genero;
		this.cor = cor;
		this.disponibilidade = disponibilidade;
		this.preco = preco;
		this.codRoupa = codRoupa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}	
	
	
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public int getCodRoupa(){
		return codRoupa;
	}
	
	public void setCodRoupa(int codRoupa){
		this.codRoupa =  codRoupa;
	}
	
	public String tofloat(){
		return "preco: " + preco  ;
	}
	
	@Override
	public String toString(){
		return "tipo: " + tipo + " // " + "modelo: " + modelo + " // " + "tamanho" + tamanho + " // " + "genero: " + genero + " // " + "cor: " + cor + " // " + "preco: " + preco  ;
	}
	
}

