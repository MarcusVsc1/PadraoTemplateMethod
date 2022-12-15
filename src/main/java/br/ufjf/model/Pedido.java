package br.ufjf.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public abstract class Pedido {

    private String produto;
    private Float preco;
    private static HashMap<String, Cliente> clientes = new HashMap<>();

    public final String realizarPedido(Cliente cliente) {
        try {
            cadastrarCliente(cliente);
            relizarPagamento(cliente);
            return concluirPedido(cliente);
        } catch (Exception e) {
            return "Erro no pedido: " + e.getMessage();
        }
    }

    private String concluirPedido(Cliente cliente) {
        return "Pedido a seguir concluído: \n" +
                "Cliente: " + cliente.getNome() + "\n" +
                "Produto: " + this.produto + "\n" +
                "Preço: " + this.preco;
    }

    private void cadastrarCliente(Cliente cliente) {
        clientes.putIfAbsent(cliente.getNome(), cliente);
    }


    public abstract void relizarPagamento(Cliente pessoa);

}
