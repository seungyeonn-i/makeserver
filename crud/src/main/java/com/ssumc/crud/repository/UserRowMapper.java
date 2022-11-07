//package com.ssumc.crud.repository;
//
//import com.ssumc.crud.domain.User;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserRowMapper implements RowMapper<User> {
//
//    @Override
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User();
//        user.setUserName(rs.getString("userName"));
//        user.setUserEmail(rs.getString("userEmail"));
//        user.setUserPhone(rs.getString("userPhone"));
////            user.setUserStatus(rs.getC);
////            user.setUserGrade(rs.getString("1"));
//        return user;
//    }
//}
