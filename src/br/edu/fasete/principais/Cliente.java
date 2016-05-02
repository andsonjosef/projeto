package br.edu.fasete.principais;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	protected String CPF;
	private String RG;
	private String telefone;
	private int codPessoa;
	private String estado;
	private String cidade;
	private String bairro;
	private String endereco;
	private String numero;
	
	
	
	public Cliente(){}
	
	ArrayList<Cliente> pessoas = new ArrayList<Cliente>();
	
	public Cliente(String nome,String CPF, String RG,String telefone, int codPessoa,String estado, String cidade, String bairro, String endereco, String numero){
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
		this.telefone = telefone;
		this.codPessoa = codPessoa;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.endereco = endereco;
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public ArrayList<Cliente> getPessoas() {
		return pessoas;
	}
	public void setPessoas(ArrayList<Cliente> pessoas) {
		this.pessoas = pessoas;
	}
	public int getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}


		
	@Override
	public String toString(){
		return "nome: " + nome + " // " + "CPF: " + CPF + " // " + "RG: " + RG + " // " + "tel: " + telefone  ;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

		
	}
