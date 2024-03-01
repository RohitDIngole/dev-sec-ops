package dnyanyog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dnyanyog.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    // Corrected method to find users by username and password
    List<Users> findByUsernameAndPassword(String username, String password);
    
    @Query(value="SELECT u FROM Users u WHERE u.email= :email AND u.username= :username")
    List<Users> findByUsernameAndEmail(String email,String username);
    
    @Query(value="SELECT u.user_id FROM Users u", nativeQuery=true)
    List<Long> findByAllUserId();

}
