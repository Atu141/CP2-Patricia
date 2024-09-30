package br.com.Check2patriciaSetembro2024.model;

public class Cliente {

	private String nome;
	private String cpf;
	private String whatsapp;
	private double comprasTotais;
	private double aptoApromocao;

	public Cliente(String nome, String cpf, String whatsapp, double comprasTotais) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.whatsapp = whatsapp;
		this.comprasTotais = comprasTotais;
		
	}
	
	public Cliente(String nome, String cpf, String whatsapp, double comprasTotais, double aptoApromocao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.whatsapp = whatsapp;
		this.comprasTotais = comprasTotais;
		this.aptoApromocao = aptoApromocao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public double getComprasTotais() {
		return comprasTotais;
	}

	public void setComprasTotais(double comprasTotais) {
		this.comprasTotais = comprasTotais;
	}

	public double getAptoApromocao() {
		return aptoApromocao;
	}

	public void setAptoApromocao(double aptoApromocao) {
		this.aptoApromocao = aptoApromocao;
	}

}
