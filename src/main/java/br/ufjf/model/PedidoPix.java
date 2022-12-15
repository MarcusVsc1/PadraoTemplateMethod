package br.ufjf.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PedidoPix extends Pedido {

    @Override
    public void relizarPagamento(Cliente cliente) {
        if (cliente.getCanalPagamento().getClass().equals(ContaCorrente.class)){
            cliente.pagar(this.getPreco());
        } else {
            throw new RuntimeException("Cliente sem conta corrente disponível.");
        }
    }
}
