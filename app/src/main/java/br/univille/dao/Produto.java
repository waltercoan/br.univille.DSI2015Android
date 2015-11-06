package br.univille.dao;

import java.io.Serializable;

public class Produto implements Serializable {
	private long oid;
	private int codigo;
	private String descricao;
	private float valor;
	
	//Segue abaixo código dos métodos GETs e SETs...
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

    public String toString(){
        return String.format("%d - %s", codigo, descricao);
    }
	
}
