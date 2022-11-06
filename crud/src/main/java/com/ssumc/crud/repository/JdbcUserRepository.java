package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class JdbcUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public User save(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("userId");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", user.getUserName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        user.setUserId(key.intValue());
        return user;
    }

    public Optional<User> findById(int userId) {
        List<User> result = jdbcTemplate.query("select * from user where id = ?", userRowMapper(), userId);
        return result.stream().findAny();
    }


    public List<User> findAll() {

        return jdbcTemplate.query("select * from user", userRowMapper());


    }

    private RowMapper<User>userRowMapper() {
        return (rs, rowNum) -> {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("aaa@aaa.com"));
                user.setUserPhone(rs.getString("010-3423-2342"));
//            user.setUserStatus(rs.getC);
//            user.setUserGrade(rs.getString("1"));
                return user;
            };

    }




}
