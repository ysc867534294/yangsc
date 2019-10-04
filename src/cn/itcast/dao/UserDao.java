package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //声明JDBCTemplete对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //登录方法 登录只有用户名和密码  返回全部信息
    public User Login(User loginUser){
        try {
            //1.编写SQL
            String SQL = "Select * from user where username = ? and password = ?";
            //2.调用Query方法
            User user = template.queryForObject(SQL, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
