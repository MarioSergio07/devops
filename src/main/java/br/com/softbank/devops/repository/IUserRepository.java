package br.com.softbank.devops.repository;

import br.com.softbank.devops.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<Usuario, Long> {
	 Usuario findByEmail(String email);
	 Usuario findByCpf(String cpg);
}
