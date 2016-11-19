package cn.wuweiblog.computertest.service;

import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.common.BeanUtil;
import cn.wuweiblog.computertest.common.DateUtil;
import cn.wuweiblog.computertest.common.SQLParseUtil;
import cn.wuweiblog.computertest.dao.UserDao;
import cn.wuweiblog.computertest.structs.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jervain on 2016-11-18.
 */
@Service
public class AjaxUserService {

    @Autowired
    private UserDao userDao;


    public ResponseMsg responseMsg() {
        ResponseMsg msg = new ResponseMsg();
        List users = userDao.getUsers();
        msg.setData(BeanUtil.list(users));
        msg.setRecordsTotal(Long.valueOf(100));
        msg.setRecordsFiltered(Long.valueOf(1000));
        msg.setDraw(2);
        return msg;
    }


    public ResponseMsg responseMsg(Integer draw, Integer start, Integer length, String search, String date, Integer role) {
        ResponseMsg msg = new ResponseMsg();
        msg.setDraw(draw);
        List<Object> argus = new ArrayList<>();
        String where = SQLParseUtil.generateWhere(argus, search, date, role);
        msg.setRecordsFiltered(userDao.countByFilter(where, argus));
        msg.setRecordsTotal(userDao.total());
        List<User> users = userDao.getUsers(start, length, where, argus);
        msg.setData(BeanUtil.list(users));


        return msg;
    }

}
