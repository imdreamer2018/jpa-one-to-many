package com.thoughtworks.jpaonetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JpaOneToManyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JpaTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        UserBuilder.withDefault().persist();
        User user = userRepository.findById(1).get();
        user.getContacts().add(ContactBuilder.withDefault().build());
        userRepository.save(user);
    }
}
