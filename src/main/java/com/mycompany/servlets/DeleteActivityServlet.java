package com.mycompany.servlets;


import com.mycompany.models.Activity;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/DeleteActivityServlet")
public class DeleteActivityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID da atividade a ser excluída a partir dos parâmetros da requisição
        String activityId = request.getParameter("activityId");

        // Obtenha a lista de atividades do contexto da aplicação
        List<Activity> activityList = (List<Activity>) getServletContext().getAttribute("activityList");

        // Procure a atividade com o ID correspondente na lista
        Activity activityToRemove = null;
        for (Activity activity : activityList) {
            if (activity.getId().equals(activityId)) {
                activityToRemove = activity;
                break;
            }
        }

        // Remova a atividade da lista, se ela for encontrada
        if (activityToRemove != null) {
            activityList.remove(activityToRemove);
        }

        // Atualize a lista de atividades no contexto da aplicação
        getServletContext().setAttribute("activityList", activityList);

        // Redirecione de volta para a página inicial após excluir a atividade
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
