package teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProduto {
	public static void main(String[] args) {
		
		ProdutoDAO produto = new ProdutoDAO();
		List<Produto> produtos = produto.obterTodos(3, 0);
		
		for(Produto produtodao: produtos) {
			System.out.println("ID : " +  produtodao.getId()+ " Nome  : " + produtodao.getNome());
		}
		
		double precoTotal = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (total,p) -> total + p).doubleValue();
		System.out.println("O preço total R$ : " + precoTotal);
	}

}
