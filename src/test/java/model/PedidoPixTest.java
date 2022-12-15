package model;

import br.ufjf.model.CartaoDeCredito;
import br.ufjf.model.Cliente;
import br.ufjf.model.ContaCorrente;
import br.ufjf.model.PedidoPix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoPixTest {

    @Test
    public void pedidoPixConcluidoTest() {
        PedidoPix pedidoPix = new PedidoPix();
        pedidoPix.setPreco(200.0f);
        pedidoPix.setProduto("Alexa");
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(200f);
        Cliente cliente = new Cliente(contaCorrente, "José da Silva");
        assertEquals("Pedido a seguir concluído: \n" +
                "Cliente: José da Silva\n" +
                "Produto: Alexa\n" +
                "Preço: 200.0", pedidoPix.realizarPedido(cliente));
        assertEquals(0f, contaCorrente.getSaldo());
    }

    @Test
    public void pedidoPixSaldoIndisponivelTest() {
        PedidoPix pedidoPix = new PedidoPix();
        pedidoPix.setPreco(300.0f);
        pedidoPix.setProduto("Alexa");
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(200f);
        Cliente cliente = new Cliente(contaCorrente, "José da Silva");
        assertEquals("Erro no pedido: Cliente com Conta corrente com saldo abaixo do necessário para o pedido.", pedidoPix.realizarPedido(cliente));
    }

    @Test
    public void pedidoPixComCartaoTest() {
        PedidoPix pedidoPix = new PedidoPix();
        pedidoPix.setPreco(300.0f);
        pedidoPix.setProduto("Alexa");
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.setLimiteGasto(200f);
        cartaoDeCredito.setLimiteMensal(400f);
        Cliente cliente = new Cliente(cartaoDeCredito, "José da Silva");
        assertEquals("Erro no pedido: Cliente sem conta corrente disponível.", pedidoPix.realizarPedido(cliente));
    }

}
