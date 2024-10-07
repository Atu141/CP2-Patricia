package br.com.Cp5.model;

public class Cliente {
	private String nome;
	private String cpf;
	private String whatsapp;
	private double totalGasto;
	private boolean aptoParaOferta;

	// Construtor
	public Cliente(String nome, String cpf, String whatsapp, double totalGasto) {
		this.nome = nome;
		this.cpf = cpf;
		this.whatsapp = whatsapp;
		this.totalGasto = totalGasto;
		this.aptoParaOferta = true; // Inicialmente, apto para a oferta
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public double getTotalGasto() {
		return totalGasto;
	}

	public boolean isAptoParaOferta() {
		return aptoParaOferta;
	}

	public void setAptoParaOferta(boolean aptoParaOferta) {
		this.aptoParaOferta = aptoParaOferta;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", CPF: " + cpf + ", Whatsapp: " + whatsapp + ", Total gasto: " + totalGasto;
	}
}
