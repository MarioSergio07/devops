package br.com.softbank.devops.service;

import java.util.Arrays;
import java.util.HashSet;

import br.com.softbank.devops.model.Role;
import br.com.softbank.devops.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.softbank.devops.repository.IRoleRepository;
import br.com.softbank.devops.repository.IUserRepository;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserRepository IUserRepository;
	@Autowired
	private IRoleRepository IRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Usuario findUserByEmail(String email) {
		return IUserRepository.findByEmail(email);
	}

	@Override
	public Usuario findUserByCpf(String cpf) {
		return IUserRepository.findByCpf(cpf);
	}

	@Override
	public void saveUser(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActive(1);
		Role userRole = IRoleRepository.findByRole("ADMIN");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		IUserRepository.save(usuario);
	}
}
