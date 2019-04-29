package com.jonas;

import com.google.common.collect.Lists;
import com.jonas.entity.Index;
import com.jonas.entity.User;
import com.jonas.mapper.UserMapper;
import com.jonas.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/04/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private IndexService indexService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void batchSaveIndex() {
        List<Index> indices = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Index index = new Index();
            index.setA(random.nextLong());
            index.setB(random.nextLong());
            index.setC(random.nextLong());
            Long d = random.nextLong();
            index.setD(d > 0 ? d : null);

            indices.add(index);
        }

        boolean flag = indexService.batchSave(indices);
        System.out.println("执行结果：" + flag);
    }

    @Test
    public void testListUser() {
        List<User> users = userMapper.listUser(1234L);
        users.forEach(System.out::println);
    }
}
