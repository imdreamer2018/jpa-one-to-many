package com.thoughtworks.jpaonetomany;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {
    private User user = new User();


    public static UserBuilder withDefault() {
        return new UserBuilder()
                .withUsername("yagnqian")
                .withPassword("pwd");
    }

    public UserBuilder withId(int id) {
        user.setId(id);
        return this;
    }

    public UserBuilder withUsername(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder withPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public User build() {
        return user;
    }

    public User persist() {
        UserRepository repository = SpringApplicationContext.getBean(UserRepository.class);
        return repository.saveAndFlush(user);
    }
}
