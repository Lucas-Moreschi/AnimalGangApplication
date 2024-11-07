package br.com.animalgang.dto;

public class PetDto {

    private String nome;
    private String sexo;
    private String idade;
    private String tipo;
    private String descricao;
    private String imagemUrl;

    public PetDto() {
    }

    public PetDto(String nome, String sexo, String idade, String tipo, String descricao, String imagemUrl) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.tipo = tipo;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    // Getters e Setters
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    @Override
    public String toString() {
        return "PetDto{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                '}';
    }
}

