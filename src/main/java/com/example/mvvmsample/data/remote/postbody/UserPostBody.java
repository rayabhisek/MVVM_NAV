package com.example.mvvmsample.data.remote.postbody;

public class UserPostBody {

    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserPostBody{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserPostBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
