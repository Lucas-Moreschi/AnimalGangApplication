package br.com.animalgang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
    private String sexo;
    private String idade;
    private String tipo;
    private String imagemURL;
    private String descricao;
    
    public Pet(Long id, String nome, String sexo, String idade, String tipo, String imagemURL, String descricao) {
		super();
		Id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.tipo = tipo;
		this.imagemURL = imagemURL;
		this.descricao = descricao;
	}
    
	public Pet() {

	}

	public String getImagemURL() {
		return imagemURL;
	}
	public void setImagemURL(String imagemUrl) {
		this.imagemURL = imagemUrl;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
    

}
