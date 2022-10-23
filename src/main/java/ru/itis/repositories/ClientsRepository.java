package ru.itis.repositories;

import ru.itis.models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ClientsRepository implements Repository<User, String> {
    private final String url = "jdbc:postgresql://localhost:5432/ClientsDB";
    private final String login = "postgres";
    private final String pass = "dasdasgkgmdf";

    public ClientsRepository() {}

    @Override
    public void save(User user) {

        Map<String, Object> params = new HashMap<>();

        params.put("name", user.getName());
        params.put("password", user.getPassword());
        params.put("country", user.getCountry());
        params.put("sex", user.getSex());
        params.put("date_of_birth", user.getDateOfBirth());
        params.put("data_processing", user.getDateOfBirth());

        try {
            Connection connection = DriverManager.getConnection(url, login, pass);
            PreparedStatement statement =
                    connection.prepareStatement("insert into users " +
                            "(name, password, country, sex, dateofbirth, data_proccessing) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getCountry());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getDateOfBirth());
            statement.setString(6, String.valueOf(user.getDataProcessing()));
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException ex) {
            throw new IllegalArgumentException(ex);
        }

    }
}
