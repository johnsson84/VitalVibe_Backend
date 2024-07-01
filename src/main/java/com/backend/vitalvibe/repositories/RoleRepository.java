package repositories;

import com.backend.vitalvibe.models.ERole;
import com.backend.vitalvibe.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);

}
