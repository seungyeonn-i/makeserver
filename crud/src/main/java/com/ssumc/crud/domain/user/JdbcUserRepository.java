package com.ssumc.crud.domain.user;

import com.ssumc.crud.web.user.GetUserRes;
import com.ssumc.crud.web.user.UserReq;
import com.ssumc.crud.web.user.UserRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.swing.text.html.Option;
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



    public int save(UserReq user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("userTest").usingGeneratedKeyColumns("userId");
        // UserTest가 맞는데 그거 하면 왜 안됨?
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("userName", user.getUserName());
        parameters.put("userEmail", user.getUserEmail());
        parameters.put("password", user.getPassword());
        parameters.put("userPhone", user.getUserPhone());


        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        user.setUserId(key.intValue());

        return key.intValue();
    }

    public Optional<User> findById(int userId) {
        List<User> result = jdbcTemplate.query("select * from userTest where userId = ?", userRowMapper(), userId);
        return Optional.ofNullable(result.get(userId));
    }


    public List<GetUserRes> findAll() {

        return jdbcTemplate.query("select * from userTest",
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userId"),
                        rs.getString("userEmail"),
                        rs.getString("userName")
                ));
    }

    public Optional<User> findByUserEmail(String userEmail) {
        return jdbcTemplate.query("select * from userTest", userRowMapper()).stream()
                .filter(m -> m.getUserEmail().equals(userEmail))
                .findFirst();
//        return new Optional.ofNullable(UserRes);
//        return findAll().stream()
//                .filter(m -> m.getUserEmail().equals(userEmail))
//                .findFirst();
    }

    private RowMapper<User> userRowMapper() {
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
