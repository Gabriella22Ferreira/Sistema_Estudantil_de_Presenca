<%-- 
    Document   : curso_consultar.jsp
    Created on : 21 de nov. de 2026, 16:06:45
    Author     : thalita
--%>
<!--importação de utilitarios-->
<%@page import="model.Cursos"%>
<%@page import="model.DAO.CursosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escola</title>
    </head>
    <body>
        <h2>Resultado da consulta</h2>
        <%
            request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"

            // armazenando o nome consultado e resgatado pelo form
            String nome = request.getParameter("curso_nome");

            //instancia da classe DAO
            CursosDAO cursoDAO = new CursosDAO();

            // Instancia de um obj curso e a chamada do metodo consultar pelo nome
            Cursos curso = cursoDAO.consultarNome(nome);

            if (curso.getId() == 0) { // verificando se houve alguma linha de resultado
                out.println("<br> <b>Não encontrado</b> ");
            } else {
                out.println("<br> Localizado ");
                // Saída , caso tenha resultado
                out.println("<br><br> <b>Id.....:</b> " + curso.getId());
                out.println("<br> <b>Nome do Curso...:</b> " + curso.getNome());
                out.println("<br> <b>Carga Horária...:</b> " + curso.getCarga_horaria());
                out.println("<br> <b>Data de Início...:</b> " + curso.getData_inicio());
                out.println("<br> <b>Data de Término...:</b> " + curso.getData_termino());
                out.println("<br> <b>Nível de Formação...:</b> " + curso.getNivel_curso());
                out.println("<br> <b>Descrição...:</b> " + curso.getDescricao());
                out.println("<br> <b>Status...:</b> " + curso.getStatus());
                out.println("<br> <b>Valor da Mensalidade R$...:</b> " + curso.getValor_mensalidade());
                out.println("<br> <b>Data de cadastro...:</b> " + curso.getData_cadastro());
                out.println("<br> <b>Área de Conhecimento...:</b> " + curso.getArea_conhecimento());

            }
        %>
    </body>
</html>
