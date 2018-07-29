package br.com.softbank.academy.service;

import java.util.Arrays;
import java.util.HashSet;

import br.com.softbank.academy.model.Role;
import br.com.softbank.academy.model.User;
import br.com.softbank.academy.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private br.com.softbank.academy.repository.IUserRepository IUserRepository;
	@Autowired
    private IRoleRepository IRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return IUserRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = IRoleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		IUserRepository.save(user);
	}
}
