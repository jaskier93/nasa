package cosmic.commons.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository  extends JpaRepository<UserApp, Integer> {

    Optional<UserApp> findUserAppByName(String name);

}
