package modelo.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.basico.Produto;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int qtd;
	@Column(nullable = false)
	private Double preco;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		if(produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());
		}
	}
	public ItemPedido() {
	}
	public ItemPedido(int qtd, Pedido pedido, Produto produto) {
		this.qtd = qtd;
		this.setPedido(pedido); 
		this.setProduto(produto);
	}
	

	
	
}
