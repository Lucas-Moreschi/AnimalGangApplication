package br.com.animalgang.dto;

import br.com.animalgang.entity.users.UserRole;

public class UsuarioDto {
	
	private String usuario;
	private String senha;
	private UserRole cargo;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UserRole getCargo() {
		return cargo;
	}
	public void setCargo(UserRole cargo) {
		this.cargo = cargo;
	}
}
