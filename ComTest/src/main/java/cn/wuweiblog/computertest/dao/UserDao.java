package cn.wuweiblog.computertest.dao;

import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.common.DateUtil;
import cn.wuweiblog.computertest.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jervain on 2016-11-18.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addUser(User user) throws Exception {
        String sql = "INSERT INTO USER (user_num,user_name,user_remark,user_status,user_lastlogin,user_creattime,user_role) VALUE (?,?,?,?,?,?,?)";
        String date = DateUtil.parseDate(user.getCreatetime());
        Object[] parameters = new Object[]{
                user.getNum(),user.getName(),user.getRemark(),user.getStatus(), date, date, user.getRole()
        };
        return jdbcTemplate.update(sql, parameters);
    }


    public List<User> getUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }


    public Long total() {
        String sql = "select count(*) as total from user";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        return (Long) map.get("total");
    }

    public List<User> getUsers(Integer start, Integer length, String where, List<Object> values) {
        String sql = "select * from user " + where + " limit ?,?";
        values.add(start);
        values.add(length);
        return jdbcTemplate.query(sql, values.toArray(), new UserRowMapper());
    }


    public Long countByFilter(String where, List<Object> values) {
        String sql = "select count(*) as count from user " + where;
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, values.toArray());
        return (Long) map.get("count");
    }


    public User getUserById(Integer id) {
        String sql = "select * from user where user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        }catch (Exception e) {
            return null;
        }
    }

    public Integer update(User user) throws Exception {
        String sql = "UPDATE user set user_num=?,user_name=?,user_password=?,user_remark=?,user_status=?,user_role=?,user_creattime=?,user_lastlogin=? where user_id = ?";
        Object[] argus = new Object[]{
                user.getNum(), user.getName(), user.getPassword(), user.getRemark(), user.getStatus(), user.getRole(), DateUtil.parseDate(user.getCreatetime()), DateUtil.parseDate(user.getLastlogintime()), user.getId()
        };
        return jdbcTemplate.update(sql, argus);
    }

    public Integer delete(Integer id) throws Exception {
        String sql = "delete from user where user_id = ?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    public User findByNum(String num) {
        String sql = "select * from user where user_num = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{num}, new UserRowMapper());
        }catch (Exception e) {
            return null;
        }
    }
}
