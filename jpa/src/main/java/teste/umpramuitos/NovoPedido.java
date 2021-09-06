package teste.umpramuitos;

import java.util.Date;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		
		DAO<Object> dao = new DAO<Object>();
		Produto produto = new Produto("Teclado",650.00);
		Pedido pedido = new Pedido(new Date());
		ItemPedido item = new ItemPedido(2, pedido, produto);
		
		dao.abrirTransacao().incluir(produto).incluir(pedido).incluir(item)
		.fecharTransacao().fechar();
		

	}

}
