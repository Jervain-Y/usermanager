package cn.wuweiblog.computertest.service;

import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.dao.UserDao;
import cn.wuweiblog.computertest.exception.TransactionRollBackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jervain on 2016-11-18.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(rollbackFor = TransactionRollBackException.class)
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            throw new TransactionRollBackException();
        }
    }

    public List<User> getUsers() {
        userDao.total();
        return userDao.getUsers();
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }


    @Transactional(rollbackFor = TransactionRollBackException.class)
    public Integer saveUser(User user) {
        User tmp = userDao.getUserById(user.getId());
        if (user.getCreatetime() == null)
            user.setCreatetime(tmp.getCreatetime());
        if (user.getLastlogintime() == null)
            user.setLastlogintime(tmp.getLastlogintime());
        try {
            return userDao.update(user);
        } catch (Exception e) {
            throw new TransactionRollBackException();
        }
    }

    @Transactional(rollbackFor = TransactionRollBackException.class)
    public Integer changeStatus(Integer id) {
        User user = getUserById(id);
        user.setStatus(user.getStatus() == 0?1:0);
        try {
            return userDao.update(user);
        } catch (Exception e) {
            return 0;
        }
    }

    @Transactional(rollbackFor = TransactionRollBackException.class)
    public Integer deleteUserById(Integer id) {
        try {
            return userDao.delete(id);
        } catch (Exception e) {
            return 0;
        }
    }

    public User getUserByNum(String num) {
        return userDao.findByNum(num);
    }
}
