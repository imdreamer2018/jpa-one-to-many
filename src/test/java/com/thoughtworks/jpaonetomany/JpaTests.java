package com.thoughtworks.jpaonetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Rollback
class JpaTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void createContactForUser() {
        UserBuilder.withDefault().persist();
        User user = userRepository.findById(1).get();
        user.getContacts().add(ContactBuilder.withDefault().build());
        userRepository.save(user);
    }

    @Test
    void updateContactForUser() {
        User user = UserBuilder.withDefault().persist();
        ContactBuilder.withDefault().withUser(user).persist();

        User userExist = userRepository.findById(1).get();
        userExist.getContacts().get(0).setAddress("Beijing");
        userRepository.save(userExist);
    }

    @Test
    void removeContactForUser() {
        User user = UserBuilder.withDefault().persist();
        ContactBuilder.withDefault().withUser(user).persist();

        User userExist = userRepository.findById(1).get();
        userExist.getContacts().clear();
        userRepository.save(userExist);
    }

    @Test
    void removeContactForUserAgain() {
        User user = UserBuilder.withDefault().persist();
        ContactBuilder.withDefault().withUser(user).persist();

        User userExist = userRepository.findById(1).get();
        assertEquals(1, userExist.getContacts().size());

        contactRepository.delete(userExist.getContacts().get(0));
        userExist.getContacts().clear();
        userRepository.save(userExist);

        User userExistAgain = userRepository.findById(1).get();
        assertEquals(0, userExistAgain.getContacts().size());

    }

}
