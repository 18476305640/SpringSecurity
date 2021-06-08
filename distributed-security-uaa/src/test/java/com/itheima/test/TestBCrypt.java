package com.itheima.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void test1() {
        //对原始密码加密
        String hashpw = BCrypt.hashpw("secret",BCrypt.gensalt());
        System.out.println(hashpw);
//校验原始密码和BCrypt密码是否一致
        boolean checkpw = BCrypt.checkpw("3333",
                "$2a$10$sZ8wGx4y/pmB3X8BAFelS.jjGc6LO0x9n1asGW/XEOOeP0auvadJq");
        System.out.println(checkpw);
    }

}