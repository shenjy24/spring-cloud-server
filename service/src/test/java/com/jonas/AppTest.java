package com.jonas;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.collect.Lists;
import com.jonas.entity.Index;
import com.jonas.entity.User;
import com.jonas.enums.AgeEnum;
import com.jonas.mapper.UserMapper;
import com.jonas.service.IndexService;
import com.jonas.service.UserService;
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
    private UserService userService;

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
        List<User> users = userService.listUser(null, null);
        users.forEach(e -> {
            AgeEnum ageEnum = e.getAge();
            System.out.println(ageEnum.getCode() + ":" + ageEnum.getMessage());
        });
    }

    @Test
    public void testDeleteUser() {
        userMapper.deleteById(1);
    }

    @Test
    public void testSaveUser() {
        User user = new User()
                .setId(6L).setName("Tom").setAge(AgeEnum.ONE)
                .setEmail("13662405749@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User().setId(6L).setAge(AgeEnum.TWO);
        userMapper.updateById(user);
    }

    @Test
    public void testSaveOrUpdate() {
        User user = new User()
                .setId(6L).setName("Tom").setAge(AgeEnum.THREE)
                .setEmail("13662405749@qq.com");
        userService.saveOrUpdate(user);
    }

    @Test
    public void testUpdate() {
        LambdaUpdateWrapper<User> wrapper = new UpdateWrapper<User>().lambda();
        wrapper.set(User::getAge, 50);
        wrapper.eq(User::getName, "Tom");

        userService.update(new User(), wrapper);
    }

    @Test
    public void testLock() {
        User user = new User();
        user.setId(1L);
        user.setBalance(10L);

        userService.updateById(user);
    }
}
