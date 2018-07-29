package br.com.softbank.academy.repository;

import br.com.softbank.academy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);

}
