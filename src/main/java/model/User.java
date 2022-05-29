package model;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.UUID;

public class User {
    private Profile profile;
    private String email;
    private String password;

    private UUID storeUUID;
    private String locale;

    public User() {}

    public User(Profile profile, String email, String password, UUID storeUUID, String locale){
        this.profile = profile;
        this.email = email;
        this.password = password;
        this.storeUUID = storeUUID;
        this.locale = locale;
    }

    public Profile getProfile() {return profile;}
    public void setProfile(Profile profile) { this.profile = profile;}

    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password;}

    public UUID getStoreUUID() {return storeUUID;}
    public void setStoreUUID(UUID storeUUID) { this.storeUUID = storeUUID;}

    public String getLocale() {return locale;}
    public void setLocale(String locale) { this.locale = locale;}

    public String toString() {return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);}
}
