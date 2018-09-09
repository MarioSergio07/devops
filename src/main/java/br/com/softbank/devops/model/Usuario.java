package br.com.softbank.devops.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long id;
	@Email(message = "{message.error.email.invalid}")
	@NotEmpty(message = "{message.error.email.empty}")
	private String email;
	@Length(min = 11, message = "{message.error.cpf.invalid}")
	@NotEmpty(message = "{message.error.cpf.empty}")
	private String cpf;
	@Length(min = 5, message = "{message.error.password.invalid}")
	@NotEmpty(message = "{message.error.password.empty}")
	@Transient
	private String password;
	@NotEmpty(message = "{message.error.name.empty}")
	private String name;
	@NotEmpty(message = "{message.error.last.name.empty}")
	private String lastName;
	private int active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
