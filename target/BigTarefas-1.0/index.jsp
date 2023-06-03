<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.models.Activity" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Big Tarefas | Organize suas atividades escolares</title>
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico">
  <link rel="stylesheet" type="text/css" href="css/styles.css"/>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter&family=Russo+One&display=swap" rel="stylesheet">
</head>
<body>
    <div class="logo">
      <img src="assets/logo.png" width="100px" height="50px" />
  </div>
  <div class="container">
    <div class="activity-form">
      <form action="AddActivityServlet" method="post">
        <h2>Nova <br>Atividade</h2>
        <hr size="1">
        <label for="subject">Matéria:</label><br>
        <input type="text" name="subject" required><br>

        <label for="topic">Tema:</label><br>
        <input type="text" name="topic" required><br>

        <label for="teacher">Professor:</label><br>
        <input type="text" name="teacher" required><br>

        <label for="email">E-mail do professor:</label><br>
        <input type="email" name="email" required><br>

        <label for="dueDate">Data de entrega:</label><br>
        <input type="date" name="dueDate" required><br>

        <label for="notes">Observações:</label><br>
        <textarea name="notes"></textarea><br>

        <input class="btn-registrar" type="submit" value="Registrar">
      </form>
    </div>
      
      
      <div class="lista-atividades">
          <ul class="activity-list">
        <h1>Tarefas Pendentes</h1>
      <%-- Recupere as atividades registradas --%>
      <%
  // Obtenha a lista de atividades do contexto da aplicação
  List<Activity> activityList = (List<Activity>) getServletContext().getAttribute("activityList");

  // Verifique se a lista não é nula e contém atividades antes de exibi-las
  if (activityList != null && !activityList.isEmpty()) {
    for (Activity activity : activityList) {
%>
  <div class="activity-item">
    <p class="tema-atividade"><strong><%= activity.getTheme() %></strong></p>
    <div class="registro">
        <div class="info-atividade">
            <p><strong>Matéria:</strong> <%= activity.getSubject() %></p>
            <p><strong>Professor:</strong> <%= activity.getTeacher() %></p>
        </div>
        <div class="info-atividade">
            <p><strong>E-mail do Professor:</strong> <%= activity.getEmail() %></p>
            <p><strong>Data de Entrega:</strong> <%= activity.getDueDate() %></p>
        </div>
    </div>
    <p class="observacoes"><strong>Observações:</strong> <%= activity.getNotes() %></p>
    
    <form class="form-excluir-tarefa" action="DeleteActivityServlet" method="post">
        <input type="hidden" name="activityId" value="<%= activity.getId() %>">
        <input class="btn-excluir" type="submit" value="Finalizar Tarefa">
    </form>
  </div>
<%
    }
  }
%>
    </ul>
      </div>
  </div>
    <footer>
        Sistema Web desenvolvido para <a href="https://github.com/DanielGTI/2023-1-T51-N" target="blank">fins acadêmicos</a>
    </footer>
</body>
</html>
