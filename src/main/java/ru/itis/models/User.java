package ru.itis.models;

public class User {
    private Long id;
    private String name;
    private String password;
    private String country;
    private String sex;
    private String dateOfBirth;
    private boolean dataProcessing;

    public User(String name, String password, String country,
                String sex, String dateOfBirth, boolean dataProcessing) {
        this.name = name;
        this.password = password;
        this.country = country;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dataProcessing = dataProcessing;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getDataProcessing() {
        return dataProcessing;
    }

    public void setDataProcessing(boolean dataProcessing) {
        this.dataProcessing = dataProcessing;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
