package com.thoughtworks.jpaonetomany;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactBuilder {
    private Contact contact = new Contact();

    public static ContactBuilder withDefault() {
        return new ContactBuilder()
                .withPhoneNumber("17607114747")
                .withAddress("武汉");
    }

    public ContactBuilder withId(int id) {
        contact.setId(id);
        return this;
    }

    public ContactBuilder withPhoneNumber(String phoneNumber) {
        contact.setPhoneNumber(phoneNumber);
        return this;
    }

    public ContactBuilder withAddress(String address) {
        contact.setAddress(address);
        return this;
    }

    public Contact build() {
        return contact;
    }

    public Contact persist() {
        ContactRepository repository = SpringApplicationContext.getBean(ContactRepository.class);
        return repository.saveAndFlush(contact);
    }
}
