package modelo.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ObterUsuarios {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql= "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(3);
		
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println("ID : " + usuario.getId() + " Nome : " + usuario.getNome());
		}
		
		
		
		em.close();
		emf.close();
	}

}
