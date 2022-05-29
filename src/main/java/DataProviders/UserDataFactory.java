package DataProviders;

import com.github.javafaker.Faker;

import model.User;
import java.util.Locale;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.UUID;

public class UserDataFactory
{
    private final Faker faker;
    public UserDataFactory() { faker = new Faker(new Locale("en-GB")); }
    public User getUserInfo() {
        ProfileDataFactory profileDataFactory = new ProfileDataFactory();
        User user = new User();
        user.setProfile(profileDataFactory.getProfileInfo());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(8, 16, true, false, true));
        user.setStoreUUID(UUID.randomUUID());
        user.setLocale("en-GB");
        return user;
    }
}
