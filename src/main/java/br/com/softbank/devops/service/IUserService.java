package br.com.softbank.devops.service;

import br.com.softbank.devops.model.Usuario;

public interface IUserService {
	public Usuario findUserByEmail(String email);
	public Usuario findUserByCpf(String cpf);
	public void saveUser(Usuario usuario);
}
