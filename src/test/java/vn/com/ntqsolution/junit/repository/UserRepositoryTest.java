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


}
