package com.tione.tiona.Models;

public class Admin {
    private String admin_id,first_name,last_name,email;

    public Admin(String admin_id, String first_name, String last_name, String email) {
        this.admin_id = admin_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
