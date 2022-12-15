package br.ufjf.model;

import br.ufjf.interfaces.CanalPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente  implements CanalPagamento {

    private Float saldo;

    @Override
    public void verificarValorCompra(Float preco) {
        if(preco <= saldo){
            saldo = saldo - preco;
        } else {
            throw new RuntimeException("Cliente com Conta corrente com saldo abaixo do necessário para o pedido.");
        }
    }
}
