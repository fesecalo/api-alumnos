package fesecalo.github.com.apialumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fesecalo.github.com.apialumnos.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	boolean existsByUsername(String username);
	User findByUsername(String username);
}