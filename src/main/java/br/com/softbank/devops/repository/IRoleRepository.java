package br.com.softbank.devops.repository;

import br.com.softbank.devops.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Long>{
    Role findByRole(String role);

}