package br.com.modelo;


import java.util.Date;


public class Pessoa {
	
	private Integer id;
	private String nome;
	private Date data = new Date();
	private String sexo;
	
	
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pessoa(String nome, Date data, String sexo) {
		super();
		this.nome = nome;
		this.data = data;
		this.sexo = sexo;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	

}
