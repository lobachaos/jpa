package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("jpa");
		}catch (Exception e) {
			// logar -> log4j
		}
	}
	
	public DAO() {
		this(null);
	}
	// toda vez que for criado um DAO , sera estabelicida a conexao
	// recebe como parametro a Entidade que é uma classe.
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public List<E> obterTodos(int limite, int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "select e from " + classe.getName() + " e" ;
		TypedQuery<E> query = em.createQuery(jpql , classe);
		query.setMaxResults(limite);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public void excluir(int ID) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		em.remove(em.find(classe, ID));
	}
	
}
