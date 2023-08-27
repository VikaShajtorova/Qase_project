package models;

import com.github.javafaker.Faker;
import pages.SignupPage;

public class EmailFactory {
    static Faker faker = new Faker();

    public static Email inputEmail(){
        return Email.builder()
                .e_mail(faker.internet().emailAddress())
                .build();
    }
}
