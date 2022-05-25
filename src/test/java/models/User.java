package models;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class User {
    private String name;
    private String email;
    private String psw;

    public User(String name, String email, String psw) {
        this.name = name;
        this.email = email;
        this.psw = psw;
    }
    public User () {
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder().append(name, user.name).append(email, user.email).append(psw, user.psw).isEquals();
    }


}
