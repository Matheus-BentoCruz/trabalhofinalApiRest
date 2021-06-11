package org.serratec.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Double nPedido;
	
	@OneToMany(mappedBy = "pedido")
	private List<PedidoProdutoEntity> produtos= new ArrayList<>();
	
	private Double valorTotal;

	private LocalDate dataPedido;

	private String status;
	
	@ManyToOne()
	@JoinColumn(name="cliente_id", referencedColumnName = "id")
	private ClienteEntity clienteId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getnPedido() {
		return nPedido;
	}

	public void setnPedido(Double nPedido) {
		this.nPedido = nPedido;
	}

	public List<PedidoProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClienteEntity getClienteId() {
		return clienteId;
	}

	public void setClienteId(ClienteEntity clienteId) {
		this.clienteId = clienteId;
	}
	
	
	
}