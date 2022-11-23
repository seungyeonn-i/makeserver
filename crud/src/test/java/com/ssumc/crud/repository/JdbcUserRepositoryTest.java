package com.ssumc.crud.repository;

import com.ssumc.crud.domain.user.JdbcUserRepository;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;


public class JdbcUserRepositoryTest {

    @Autowired
    private DataSource dataSource ;

    public JdbcUserRepositoryTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    UserRepository jdbcUserRepository = new JdbcUserRepository(dataSource);

    @Test
    public void findByEmail() {
        User result = jdbcUserRepository.findByUserEmail("abc@aaa.com").get();
        Assertions.assertThat(result.getUserEmail()).isEqualTo("abc@aaa.com");
    }
}
