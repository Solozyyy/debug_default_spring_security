package s_sercurity.session.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s_sercurity.session.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    User findByUserName(String userName);

}
