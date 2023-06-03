package com.mycompany.servlets;

import com.mycompany.models.Activity;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/AddActivityServlet")
public class AddActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os dados da requisição
        String id = request.getParameter("id");
        String subject = request.getParameter("subject");
        String topic = request.getParameter("topic");
        String professor = request.getParameter("teacher");
        String professorEmail = request.getParameter("email");
        String dueDate = request.getParameter("dueDate");
        String observations = request.getParameter("notes");

        // Obtenha a lista de atividades do contexto da aplicação
        List<Activity> activityList = (List<Activity>) getServletContext().getAttribute("activityList");

        // Se a lista ainda não foi inicializada, crie uma nova lista
        if (activityList == null) {
            activityList = new ArrayList<>();
        }

        // Adicione a nova atividade à lista
        activityList.add(new Activity(id, subject, topic, professor, professorEmail, dueDate, observations));

        // Armazene a lista atualizada de atividades no contexto da aplicação
        getServletContext().setAttribute("activityList", activityList);

        // Redirecione de volta para a página inicial após adicionar a atividade
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
