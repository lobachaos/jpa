package teste.muitospramuitos;

import infra.DAO;
import modelo.muitopramuitos.Ator;
import modelo.muitopramuitos.Filme;

public class NovoFilmeAtor {
	public static void main(String[] args) {
		
		Filme film1 = new Filme("HP", 10.0);
		Filme film2 = new Filme("HP 2", 9.8);
		
		
		Ator atorA = new Ator("Joaozim");
		Ator atrizA = new Ator("Maria");
		
		film1.adicionarAtor(atorA);
		film1.adicionarAtor(atrizA);
		film2.adicionarAtor(atorA);
		film2.adicionarAtor(atrizA);
		
		DAO<Filme> dao = new DAO<>();
		dao.abrirTransacao().incluir(film1).incluir(film2).fecharTransacao().fechar();
		// nao precisa adicionar atores , pois esta em cascata.
		
		
		
	}

}
