package com.thoughtworks.jpaonetomany;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Rollback
@Slf4j
class JpaTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void removeContactForUser() {
        User user = UserBuilder.withDefault().persist();
        ContactBuilder.withDefault().withUser(user).persist();

        User userExist = userRepository.findById(1).get();
        userExist.getContacts().clear();
        userRepository.save(userExist);

        assertFalse(contactRepository.findById(1).isPresent());
    }

}
