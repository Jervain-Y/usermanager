package cn.wuweiblog.computertest.rowmapper;

import cn.wuweiblog.computertest.bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jervain on 2016-11-18.
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setNum(resultSet.getString("user_num"));
        user.setName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("user_password"));
        user.setRemark(resultSet.getString("user_remark"));
        user.setStatus(resultSet.getInt("user_status"));
        user.setRole(resultSet.getInt("user_role"));
        user.setLastlogintime(resultSet.getDate("user_lastlogin"));
        user.setCreatetime(resultSet.getDate("user_creattime"));
        return user;
    }
}
