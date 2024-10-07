package br.com.Cp5.app;

import java.util.Scanner;

import arvores.ABBCliente;
import br.com.Cp5.model.Cliente;
import filas.fila;

public class DivulgaOferta {
	/*
	 * Check Point 5 - Codigos de Alta Perfomance
	 * 
	 * RM 99831 - Arthur Badu Reis
	 * RM 97826 - Guilherme Korus Daoud
	 * RM 98561 - Marcos Henrique Ribeiro de Santana
	 * RM 98845 - Rafael Jun Miura
	 * RM 94947 - Vinicius Oliveira Ferreira
	 * 
	 */
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		ABBCliente cadastro = new ABBCliente();
		ABBCliente oferta = new ABBCliente();
		fila filaOferta = new fila();
		cadastro.root = null;
		
		int opcao, op;
		String nome, whatsapp, cpf;
		double totalGasto;
		
		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscricao um cliente");
			System.out.println(" 2 - Oferta de novo produto/promocao");
			System.out.println(" 3 - Entrar no Submenu ");
			System.out.println(" 4 - Remove um cliente do cadastro");
			opcao = le.nextInt();
			
			switch (opcao) {
				case 0:
					System.out.println("\n\n Clientes que não aceitaram ou não estavam adequados para a oferta");
					cadastro.imprimirNaoAceitaramOferta(cadastro.root);
					break;
					
				case 1:
					System.out.print("Digite nome: ");
					le.nextLine();
					nome = le.nextLine();
					System.out.print("Digite CPF: ");
					cpf = le.next();
					System.out.print("Whatsapp: ");
					whatsapp = le.next();
					System.out.print("Informe total gasto do cliente R$: ");
					totalGasto = le.nextDouble();
					Cliente cliente = new Cliente(nome, cpf, whatsapp, totalGasto);
					cadastro.root = cadastro.inserir(cadastro.root, cliente);
					break;
					
				case 2:
					System.out.print("Qual o valor de saldo minimo exigido: R$ ");
					totalGasto = le.nextDouble();
					filaOferta.init();
					// Percorre a árvore e gera a fila de clientes com saldo mínimo
					oferta.root = null; // Esvazia a ABB de oferta
					cadastro.gerarFilaOferta(cadastro.root, totalGasto, filaOferta);
					break;
					
				case 3:
					do {
						System.out.println("\t 1) Consulta cliente buscando pelo CPF");
						System.out.println("\t 2) Apresenta o total de gasto de todos os clientes");
						System.out.println("\t 3) Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
						System.out.println("\t 4) Volta menu principal");
						op = le.nextInt();
						
						switch (op) {
							case 1:
								System.out.print("Informe CPF para consulta: ");
								cpf = le.next();
								Cliente clienteConsultado = cadastro.buscarCliente(cadastro.root, cpf);
								if (clienteConsultado != null) {
									System.out.println(clienteConsultado);
								} else {
									System.out.println("CPF não encontrado.");
								}
								break;
								
							case 2:
								double totalGastos = cadastro.somarGastos(cadastro.root);
								System.out.println("Total de gastos de todos os clientes: R$ " + totalGastos);
								break;
								
							case 3:
								System.out.print("Qual valor minimo de gastos para consulta? R$ ");
								double minimo = le.nextDouble();
								int quantidade = cadastro.contarClientesAcimaDe(cadastro.root, minimo);
								System.out.println("Quantidade de clientes com saldo acima de R$ " + minimo + ": " + quantidade);
								break;
								
							case 4:
								break;
								
							default:
								System.out.println("Opcao invalida");
						}
					} while (op != 4);
					break;
					
				case 4:
					System.out.print("Informe CPF do cliente que deseja ser retirado do cadastro: ");
					cpf = le.next();
					cadastro.root = cadastro.remover(cadastro.root, cpf);
					System.out.println("Cliente removido do cadastro.");
					break;
					
				default:
					System.out.println("Opcao invalida");
			}
		} while (opcao != 0);
		le.close();
	}
}
