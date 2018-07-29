package br.com.softbank.academy.repository;

import br.com.softbank.academy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
