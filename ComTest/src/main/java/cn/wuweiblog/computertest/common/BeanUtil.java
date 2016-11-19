package cn.wuweiblog.computertest.common;

import cn.wuweiblog.computertest.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jervain on 2016-11-18.
 */
public class BeanUtil {


    public static Map<String, String> map(User user) {
        Map<String, String> map = new HashMap<>();
        String[] status = {"冻结", "可用"};
        String[] roles = {"普通会员", "VIP", "SVIP"};
        map.put("DT_RowId", "row_" + user.getId().toString());
        map.put("num", user.getNum()==null?"":user.getNum());
        map.put("name", user.getName()==null?"":user.getName());
        map.put("remark", user.getRemark()==null?"":user.getRemark());
        map.put("status", status[user.getStatus()]);
        map.put("status", user.getStatus().toString());
        map.put("create", DateUtil.parseDate(user.getCreatetime()));
        map.put("login", DateUtil.parseDate(user.getLastlogintime()));
        map.put("role", roles[user.getRole()]);
        map.put("role", user.getRole().toString());
        return map;
    }


    public static List<Map<String, String>> list(List<User> users) {
        List<Map<String, String>> maps = new ArrayList<>();
        for (User user : users)
            maps.add(map(user));
        return maps;
    }



}
