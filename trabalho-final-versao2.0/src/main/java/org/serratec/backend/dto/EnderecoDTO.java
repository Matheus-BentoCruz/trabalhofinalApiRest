package org.serratec.backend.dto;

import com.sun.istack.NotNull;

public class EnderecoDTO {

	@NotNull
	private String cep;

	@NotNull
	private String bairro;
	
	@NotNull
	private String rua;
	
	@NotNull
	private String cidade;
	
	@NotNull
	private Integer numero;
	
	@NotNull
	private String complemento;
	
	@NotNull
	private String estado;
	
	@NotNull
	private String tipoEndereco;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	
}
