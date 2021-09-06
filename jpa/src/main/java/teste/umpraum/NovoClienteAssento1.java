package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	public static void main(String[] args) {
		
		Assento assento = new Assento("2A");
		Cliente cliente = new Cliente("Daniel", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao().incluir(assento).incluir(cliente).fecharTransacao().fechar();
		
		
		
	}

}
