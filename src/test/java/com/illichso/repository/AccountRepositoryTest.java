package com.illichso.repository;

import com.illichso.model.entity.Account;
import com.illichso.model.entity.User;
import com.illichso.repository.impl.AccountRepositoryJPA;
import com.illichso.repository.impl.UserRepositoryJPA;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.illichso.repository.TestDBUtil.getEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest {

    private static AccountRepository accountRepository;
    private static UserRepository userRepository;

    private static Account account;
    private static String accountNumber;

    private static User user1;
    private static User user2;
    private static String userName;

    @BeforeClass
    public static void init() {
        accountRepository = new AccountRepositoryJPA(getEntityManager());
        userRepository = new UserRepositoryJPA(getEntityManager());

        accountNumber = "1234567890";
        user1 = new User(userName);
        account = new Account(accountNumber, user1);
    }

    @Test
    public void saveAccount() {
        userRepository.save(user1);

        accountRepository.save(account);

        List<Account> foundAccountList = accountRepository.findAll();
        assertThat(foundAccountList.size()).isEqualTo(1);
        assertThat(foundAccountList.get(0).getNumber()).isEqualTo(accountNumber);
    }

    @Test
    public void testDeleteAll() throws Exception {
        accountRepository.deleteAll();
        List<Account> foundAccountList = accountRepository.findAll();
        assertThat(foundAccountList.size()).isEqualTo(0);
    }

    @After
    public void cleanup() {
        accountRepository.deleteAll();
        userRepository.deleteAll();
    }
}
