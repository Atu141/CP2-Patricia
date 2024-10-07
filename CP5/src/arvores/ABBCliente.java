package arvores;

import br.com.Cp5.model.Cliente;
import filas.fila;

public class ABBCliente {
	
	private class ARVORE {
		Cliente dado;
		ARVORE esq;
		ARVORE dir;
	}

	public ARVORE root = null;

	// Método para inserir um cliente na ABB
	public ARVORE inserir(ARVORE p, Cliente info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info.getCpf().compareTo(p.dado.getCpf()) < 0) {
			p.esq = inserir(p.esq, info);
		} else {
			p.dir = inserir(p.dir, info);
		}
		return p;
	}

	// Método para buscar um cliente pelo CPF
	public Cliente buscarCliente(ARVORE p, String cpf) {
		if (p == null) return null;
		if (cpf.compareTo(p.dado.getCpf()) < 0) return buscarCliente(p.esq, cpf);
		if (cpf.compareTo(p.dado.getCpf()) > 0) return buscarCliente(p.dir, cpf);
		return p.dado;
	}

	// Método para imprimir os clientes que não aceitaram a oferta
	public void imprimirNaoAceitaramOferta(ARVORE p) {
		if (p != null) {
			imprimirNaoAceitaramOferta(p.esq);
			if (p.dado.isAptoParaOferta()) {
				System.out.println(p.dado);
			}
			imprimirNaoAceitaramOferta(p.dir);
		}
	}

	// Método para somar os gastos de todos os clientes
	public double somarGastos(ARVORE p) {
		if (p == null) return 0;
		return p.dado.getTotalGasto() + somarGastos(p.esq) + somarGastos(p.dir);
	}

	// Método para contar os clientes com saldo acima de um valor
	public int contarClientesAcimaDe(ARVORE p, double minimo) {
		if (p == null) return 0;
		int count = (p.dado.getTotalGasto() >= minimo) ? 1 : 0;
		return count + contarClientesAcimaDe(p.esq, minimo) + contarClientesAcimaDe(p.dir, minimo);
	}

	// Método para remover um cliente pelo CPF
	public ARVORE remover(ARVORE p, String cpf) {
		if (p == null) return null;
		if (cpf.compareTo(p.dado.getCpf()) < 0) {
			p.esq = remover(p.esq, cpf);
		} else if (cpf.compareTo(p.dado.getCpf()) > 0) {
			p.dir = remover(p.dir, cpf);
		} else {
			if (p.esq == null) return p.dir;
			if (p.dir == null) return p.esq;
			ARVORE sucessor = getMin(p.dir);
			p.dado = sucessor.dado;
			p.dir = remover(p.dir, sucessor.dado.getCpf());
		}
		return p;
	}

	private ARVORE getMin(ARVORE p) {
		while (p.esq != null) p = p.esq;
		return p;
	}
	
	// Novo método para gerar a fila de clientes que aceitam a oferta
	public void gerarFilaOferta(ARVORE p, double saldoMinimo, fila filaOferta) {
	    if (p == null) return;

	    // Percorrer em ordem decrescente, começando pela subárvore direita
	    gerarFilaOferta(p.dir, saldoMinimo, filaOferta);

	    if (p.dado.getTotalGasto() >= saldoMinimo && p.dado.isAptoParaOferta()) {
	        // Insere o cliente na fila de ofertas
	        filaOferta.enqueue(p.dado); // Agora insere o objeto Cliente
	    }

	    gerarFilaOferta(p.esq, saldoMinimo, filaOferta);
	}

		
	
}
