package DataProviders;

import com.github.javafaker.Faker;
import model.Profile;
import java.util.Locale;

public class ProfileDataFactory {
    private final Faker faker;
    public ProfileDataFactory() { faker = new Faker(new Locale("en-GB")); }

    public Profile getProfileInfo() {
        Profile profile = new Profile();
        profile.setFirstName(faker.name().firstName());
        return profile;
    }
}
