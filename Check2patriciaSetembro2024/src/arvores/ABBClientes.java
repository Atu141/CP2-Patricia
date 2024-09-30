package arvores;

import br.com.Check2patriciaSetembro2024.model.Cliente;

public class ABBClientes {

	public class ABBINT {
		private class ARVORE {
			Cliente dado;
			ARVORE esq;
			ARVORE dir;
		}

		public ARVORE root = null;

		public ARVORE inserir(ARVORE p, Cliente info) {
			// insere elemento em uma ABB
			if (p == null) {
				p = new ARVORE();
				p.dado = info;
				p.esq = null;
				p.dir = null;
			} else if (info.getCpf().compareTo(p.dado.getCpf())<0)
				p.esq = inserir(p.esq, info);
			else
				p.dir = inserir(p.dir, info);
			return p;
		}
		public void show(ARVORE p) {
			if (p!=null) {
				show(p.esq);
				System.out.print("\t" + p.dado);
				show(p.dir);
			}
		}
		
		public int contaNos(ARVORE p, int cont) {
			if(p!=null) {
				cont++;
				cont = contaNos(p.esq, cont);
				cont = contaNos(p.dir, cont);
			}
			return cont;
		}
	}


}