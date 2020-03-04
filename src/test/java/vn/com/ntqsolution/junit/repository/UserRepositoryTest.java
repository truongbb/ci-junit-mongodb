package vn.com.ntqsolution.junit.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import vn.com.ntqsolution.junit.repository.user.UserRepositoryJpa;

@DataMongoTest
@RunWith(SpringRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ActiveProfiles("unit-test")
public class UserRepositoryTest {

    @Autowired
    UserRepositoryJpa userRepositoryJpa;

    @Test
    public void countUserTest() {
        Assert.assertEquals(userRepositoryJpa.findAll().size(), 2);
    }


}
