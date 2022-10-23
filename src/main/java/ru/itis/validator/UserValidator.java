package ru.itis.validator;

import ru.itis.exceptions.InvalidFieldException;
import ru.itis.models.User;

import java.util.regex.Pattern;

public class UserValidator {

    public UserValidator() {}
    public static void checkUser(User user) throws InvalidFieldException {
       checkName(user.getName());
       checkPassword(user.getPassword());
       checkCountry(user.getCountry());
       checkSex(user.getSex());
       checkDateOfBirth(user.getDateOfBirth());
    }

    public static void checkName(String name) throws InvalidFieldException {
        String pattern = "[a-zA-Z]+|[а-яА-Я]+";
        if (name.isEmpty() || !Pattern.matches(pattern, name))
            throw new InvalidFieldException("name");
    }

    public static void checkPassword(String pass) throws InvalidFieldException {
        if (pass.isEmpty())
            throw new InvalidFieldException("password");
    }

    public static void checkCountry(String country) throws InvalidFieldException {
        String pattern = "/^[a-z ,.'-]+$/i";
        if (country.isEmpty() || !Pattern.matches(pattern, country))
            throw new InvalidFieldException("country");
    }

    public static void checkSex(String sex) throws InvalidFieldException {
        if (!sex.equals("male") || !sex.equals("female"))
            throw new InvalidFieldException("sex");
    }

    public static void checkDateOfBirth(String date) throws InvalidFieldException {
        String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        if (!Pattern.matches(pattern, date))
            throw new InvalidFieldException("date");
    }
}