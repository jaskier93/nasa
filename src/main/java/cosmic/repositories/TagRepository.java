package cosmic.repositories;

import cosmic.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Planet, Long> {

}
