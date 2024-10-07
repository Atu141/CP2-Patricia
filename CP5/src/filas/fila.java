package filas;

import br.com.Cp5.model.Cliente;

public class fila {
    private class NO {
        Cliente dado; // Altera para armazenar objetos Cliente
        NO prox;
    }

    NO ini, fim;

    // Inicializa a fila
    public void init() {
        ini = fim = null;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return ini == null && fim == null;
    }

    // Adiciona um cliente à fila (enqueue)
    public void enqueue(Cliente cliente) {
        NO novo = new NO();
        novo.dado = cliente; // Insere o objeto Cliente
        novo.prox = null;
        if (isEmpty()) {
            ini = novo;
        } else {
            fim.prox = novo;
        }
        fim = novo;
    }

    // Retorna o primeiro cliente da fila
    public Cliente first() {
        if (!isEmpty()) {
            return ini.dado;
        }
        return null; // Retorna null se a fila estiver vazia
    }

    // Remove o primeiro cliente da fila (dequeue)
    public Cliente dequeue() {
        if (isEmpty()) {
            return null;
        }
        Cliente cliente = ini.dado;
        ini = ini.prox;
        if (ini == null) {
            fim = null;
        }
        return cliente;
    }
}
