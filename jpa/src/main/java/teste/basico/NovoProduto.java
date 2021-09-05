package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		Produto p1 = new Produto("Notebook",1150);
		dao.abrirTransacao().incluir(p1).fecharTransacao();
		
	}
}
