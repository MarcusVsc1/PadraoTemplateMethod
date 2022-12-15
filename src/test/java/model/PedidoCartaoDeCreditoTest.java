package model;

import br.ufjf.model.CartaoDeCredito;
import br.ufjf.model.Cliente;
import br.ufjf.model.ContaCorrente;
import br.ufjf.model.PedidoCartao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoCartaoDeCreditoTest {

    @Test
    public void pedidoCartaoConcluidoTest() {
        PedidoCartao pedidoCartao = new PedidoCartao();
        pedidoCartao.setPreco(200.0f);
        pedidoCartao.setProduto("Alexa");
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.setLimiteMensal(300f);
        cartaoDeCredito.setLimiteGasto(100f);
        Cliente cliente = new Cliente(cartaoDeCredito, "José da Silva");
        assertEquals("Pedido a seguir concluído: \n" +
                "Cliente: José da Silva\n" +
                "Produto: Alexa\n" +
                "Preço: 200.0", pedidoCartao.realizarPedido(cliente));
        assertEquals(300f, cartaoDeCredito.getLimiteGasto());
    }

    @Test
    public void pedidoCartaoSaldoIndisponivelTest() {
        PedidoCartao pedidoCartao = new PedidoCartao();
        pedidoCartao.setPreco(300.0f);
        pedidoCartao.setProduto("Alexa");
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.setLimiteMensal(300f);
        cartaoDeCredito.setLimiteGasto(200f);
        Cliente cliente = new Cliente(cartaoDeCredito, "José da Silva");
        assertEquals("Erro no pedido: Cliente sem limite disponível.", pedidoCartao.realizarPedido(cliente));
    }

    @Test
    public void pedidoCartaoComContaCorrenteTest() {
        PedidoCartao pedidoCartao = new PedidoCartao();
        pedidoCartao.setPreco(300.0f);
        pedidoCartao.setProduto("Alexa");
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(200f);
        Cliente cliente = new Cliente(contaCorrente, "José da Silva");
        assertEquals("Erro no pedido: Cliente sem cartão de crédito disponível.", pedidoCartao.realizarPedido(cliente));
    }

}
