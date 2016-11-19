package cn.wuweiblog.computertest.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Jervain on 2016-11-19.
 */
public class SQLParseUtil {

    public static String generateWhere(List<Object> values, String search, String date, Integer role) {
        StringBuilder sb = new StringBuilder();
        if (search != null && !search.equals("")) {
            sb.append("(user_num like ? or user_name like ?) and ");
            String tmp = "%" + search + "%";
            values.add(tmp);
            values.add(tmp);
        }
        if (date != null && !date.equals("")) {
            String[] dates = date.split(" - ");
            if (dates.length == 2) {
                String start = dates[0].trim();
                String end = dates[1].trim();
                String tmp = "user_creattime > ? and user_creattime < ? and ";
                sb.append(tmp);
                SimpleDateFormat sdf = new SimpleDateFormat();
                values.add(DateUtil.parseString(start));
                values.add(DateUtil.parseString(end));
            }
        }
        if (role == 0 || role == 1 || role == 2) {
            sb.append("user_role = ? and ");
            values.add(role);
        }
        if (sb.equals( "")) {
            sb.append("where 1=1");
        }else {
            sb.delete(sb.length()-4, sb.length());
            sb.insert(0, "where ");
        }
        return sb.toString().trim();
    }

}
