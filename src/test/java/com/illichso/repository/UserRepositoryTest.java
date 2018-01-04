package com.illichso.repository;

import com.illichso.model.User;
import com.illichso.repository.impl.UserRepositoryJPA;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.List;

import static com.illichso.repository.TestDBUtil.getEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    private static UserRepository userRepository;

    private User user;
    private static String userName;

    @BeforeClass
    public static void init() {
        userRepository = new UserRepositoryJPA(getEntityManager());
        userName = "name1";
    }

    @Before
    public void reinit() {
        user = new User(userName);
    }

    @Test
    public void saveNewUser() {

        userRepository.save(user);

        List<User> foundUserList = userRepository.findAll();
        assertThat(foundUserList.size()).isEqualTo(2);
        assertThat(foundUserList.get(1).getName()).isEqualTo(userName);
    }

    @Test
    @Transactional
    @Ignore
    public void testDeleteAll() throws Exception {
        userRepository.deleteAll();
        List<User> foundUserList = userRepository.findAll();
        assertThat(foundUserList.size()).isEqualTo(0);
    }

//    @After
    public void cleanup() {
        userRepository.deleteAll();
    }
}
