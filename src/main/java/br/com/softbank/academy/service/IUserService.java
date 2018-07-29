package br.com.softbank.academy.service;

import br.com.softbank.academy.model.User;

public interface IUserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
