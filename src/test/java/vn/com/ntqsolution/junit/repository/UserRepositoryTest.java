package vn.com.ntqsolution.junit.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import vn.com.ntqsolution.junit.entity.UserEntity;
import vn.com.ntqsolution.junit.repository.user.UserRepositoryJpa;

@DataMongoTest
@ComponentScan
@RunWith(SpringRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRepositoryTest {

    @Autowired
    UserRepositoryJpa userRepositoryJpa;

    @Test
    public void countUserTest() {
        Assert.assertEquals(userRepositoryJpa.findAll().size(), 2);
    }

    @Test
    public void insertUserTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("3");
        userEntity.setUsername("unit_test");
        userEntity.setPassword("123456");
        userEntity.setBir("20011225");

        userRepositoryJpa.save(userEntity);

        UserEntity foundUser = userRepositoryJpa.findByUsername("unit_test");

        Assert.assertEquals(userEntity.getUserId(), foundUser.getUserId());
    }

    @Test
    public void updateUserTest() {
        UserEntity foundUser = userRepositoryJpa.findByUsername("unit_test");
        foundUser.setBir("19980101");

        UserEntity savedUser = userRepositoryJpa.save(foundUser);

        UserEntity foundUser2 = userRepositoryJpa.findById(savedUser.getId());

        Assert.assertEquals(foundUser.getBir(), foundUser2.getBir());
    }

}
