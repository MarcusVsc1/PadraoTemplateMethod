package br.ufjf.model;

import br.ufjf.interfaces.CanalPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDeCredito implements CanalPagamento {

    private Float limiteMensal;
    private Float limiteGasto;

    @Override
    public void verificarValorCompra(Float preco) {
        if(limiteGasto + preco <= limiteMensal) {
            limiteGasto = limiteGasto + preco;
        } else{
            throw new RuntimeException("Cliente sem limite disponível.");
        }
    }

}
