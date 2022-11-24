package com.ssumc.crud.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public User save(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("userTest").usingGeneratedKeyColumns("userId");
        // UserTest가 맞는데 그거 하면 왜 안됨?
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("userName", user.getUserName());
        parameters.put("userEmail", user.getUserEmail());
        parameters.put("password", user.getPassword());
        parameters.put("userPhone", user.getUserPhone());


        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        user.setUserId(key.intValue());

        return user;
    }

    public Optional<User> findById(int userId) {
        List<User> result = jdbcTemplate.query("select * from userTest where userId = ?", userRowMapper(), userId);
        return Optional.ofNullable(result.get(userId));
    }


    public List<User> findAll() {

        return jdbcTemplate.query("select * from userTest", userRowMapper());

    }

    public Optional<User> findByUserEmail(String userEmail) {
        return findAll().stream()
                .filter(m -> m.getUserEmail().equals(userEmail))
                .findFirst();
    }

    private RowMapper<User>userRowMapper() {
        return (rs, rowNum) -> {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserPhone(rs.getString("userPhone"));
                user.setUserId(rs.getInt("userId"));
                user.setPassword(rs.getString("password"));
//            user.setUserStatus(rs.getC);
//            user.setUserGrade(rs.getString("1"));
                return user;
            };

    }




}
