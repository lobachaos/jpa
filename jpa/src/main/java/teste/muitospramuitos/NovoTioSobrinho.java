package teste.muitospramuitos;

import infra.DAO;
import modelo.muitopramuitos.Sobrinhos;
import modelo.muitopramuitos.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {
		
		
		Tio tio1 = new Tio("Anabelle");
		Tio tio2 = new Tio("Maria");
		Sobrinhos sob1 = new Sobrinhos("Joaozim");
		Sobrinhos sob2 = new Sobrinhos("Junior");
		
		// estabelecendo relacionamento bi-direcional
		tio1.getSobrinhos().add(sob1);
		sob1.getTios().add(tio1);
		
		tio1.getSobrinhos().add(sob2);
		sob1.getTios().add(tio1);
		
		tio2.getSobrinhos().add(sob1);
		sob2.getTios().add(tio1);
		
		tio2.getSobrinhos().add(sob2);
		sob2.getTios().add(tio2);
		
		
		DAO<Object> dao = new DAO<>();
		dao.abrirTransacao().incluir(tio1).incluir(tio2).incluir(sob1).incluir(sob2).fecharTransacao().fechar();
	}

}
