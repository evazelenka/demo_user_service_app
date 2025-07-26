package com.example.demo.repositories;

import com.example.demo.model.MagicProperties;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    private MagicProperties magicProperties;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = magicProperties.getFindAll();
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = magicProperties.getSave();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public User getUserById(int id){
        String sql = magicProperties.getGetById()+id;
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        List<User> user = jdbc.query(sql,userRowMapper);
        if (!user.isEmpty()){
            return user.get(0);
        }
        return null;
    }

    public User updateUser(int id, User user){
        String sql;
        if (user.getFirstName().isEmpty() && user.getLastName().isEmpty()){
            deleteUser(id);
        } else if (user.getFirstName().isEmpty()) {
            sql = magicProperties.getUpdateLastName()+id;
            jdbc.update(sql, user.getLastName());
        } else if (user.getLastName().isEmpty()) {
            sql = magicProperties.getUpdateFirstName()+id;
            jdbc.update(sql,user.getFirstName());
        } else{
            sql = magicProperties.getUpdateUser()+id;
            jdbc.update(sql,user.getFirstName(), user.getLastName());
        }
        return user;
    }

    public void deleteUser(int id){
        String sql = magicProperties.getDelete()+id;
        jdbc.update(sql);
    }
}
