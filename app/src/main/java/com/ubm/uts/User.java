package com.ubm.uts;

public class User {
    public String id;
    public String userName;
    public String email;
    public String password;
    public String jenisKelamin;

    public User(String id, String userName, String email, String password, String jenisKelamin){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
    }
}