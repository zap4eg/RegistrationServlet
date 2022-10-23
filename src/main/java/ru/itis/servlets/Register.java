package ru.itis.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import ru.itis.exceptions.InvalidFieldException;
import ru.itis.repositories.ClientsRepository;
import ru.itis.models.User;
import ru.itis.validator.UserValidator;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String country = request.getParameter("country");
        String sex = request.getParameter("sex");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String dataProcessing = request.getParameter("dataProcessing");
        UserValidator userValidator = new UserValidator();
        try {
            userValidator.checkUser(new User(name, pass, country, sex, dateOfBirth, dataProcessing.equals("true")));
            ClientsRepository clientsRepository = new ClientsRepository();
            try {
                clientsRepository.save(new User(name, pass, country,
                        sex, dateOfBirth, dataProcessing.equals("true")));
            }
            catch (Exception ex) {
                out.println("Couldn't save user");
            }
        } catch (InvalidFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
