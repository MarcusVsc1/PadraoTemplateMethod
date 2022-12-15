package br.ufjf.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PedidoCartao extends Pedido{

    @Override
    public void relizarPagamento(Cliente cliente) {
        if (cliente.getCanalPagamento().getClass().equals(CartaoDeCredito.class)){
            cliente.pagar(this.getPreco());
        } else {
            throw new RuntimeException("Cliente sem cartão de crédito disponível.");
        }
    }
}
