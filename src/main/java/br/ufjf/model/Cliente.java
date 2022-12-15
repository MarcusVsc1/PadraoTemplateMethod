package br.ufjf.model;

import br.ufjf.interfaces.CanalPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {

    private CanalPagamento canalPagamento;
    private String nome;

    public void pagar(Float preco) {
        canalPagamento.verificarValorCompra(preco);
    }
}
