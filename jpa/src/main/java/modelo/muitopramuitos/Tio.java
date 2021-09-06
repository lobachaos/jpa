package modelo.muitopramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@ManyToMany
	private List<Sobrinhos> sobrinhos = new ArrayList<>();

	public Tio(String nome) {
		this.nome = nome;
	}

	public Tio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Sobrinhos> getSobrinhos() {
		return sobrinhos;
	}

	public void setSobrinhos(List<Sobrinhos> sobrinhos) {
		this.sobrinhos = sobrinhos;
	}

}
