package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;

import hh.backend.bookstore.domain.User;
import hh.backend.bookstore.domain.UserRepository;

@DataJpaTest 
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /* Search */

    @Test
    public void findByUsernameShouldReturnUser() {
        User users = userRepository.findByUsername("testUser");
        assertThat(users.getEmail()).isEqualTo("testUser@user.com");

    }

    /* Create */

    @Test 
    public void createNewUser() {
        User user = new User("demoUser", "$2a$12$MDE5jJId2TAEASKwc4J0vujt.GUYFzR2O9SZDNIUy7YRhCaiCobAC", "demoUser@user.com", "USER");
        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    /* Delete */

    @Test 
    public void deleteNewUser() {
        User user = userRepository.findByUsername("testUser");
        userRepository.delete(user);

        User newUser = userRepository.findByUsername("testUser");
        assertThat(newUser).isNull();
    }

}
