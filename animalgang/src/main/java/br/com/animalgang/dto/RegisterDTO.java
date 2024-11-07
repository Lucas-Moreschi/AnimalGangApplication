package br.com.animalgang.dto;

import br.com.animalgang.entity.users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}