package com.askedge.messaging.inmemoryactivemq.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="users")
public class MongoUserResource {

    @Id
    private Long id;

    @Field(value="first_name)")
    private String firstName;

    @Field(value = "last_name=")
    private String lastName;

    @Field (value = "phone_number")
    private String phoneNumber;

    @Field(value="email")
    private String email;

    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return  firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
