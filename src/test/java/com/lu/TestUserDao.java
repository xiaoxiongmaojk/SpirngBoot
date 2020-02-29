package com.lu;

import com.lu.dao.UserDao;
import com.lu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppRun.class})
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Test
    public void test1(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user.getUsername());
        }
    }
}
