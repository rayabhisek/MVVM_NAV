package com.example.mvvmsample.data.remote.response;

public class LoginResponse {

    private boolean isSuccessful;
    private String message;
    private UserBean user;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    public LoginResponse(boolean isSuccessful, String message, UserBean user) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.user = user;
    }

    public boolean isIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {

        @Override
        public String toString() {
            return "UserBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", email_verified_at=" + email_verified_at +
                    ", created_at='" + created_at + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    '}';
        }

        private int id;
        private String name;
        private String email;
        private Object email_verified_at;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(Object email_verified_at) {
            this.email_verified_at = email_verified_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
