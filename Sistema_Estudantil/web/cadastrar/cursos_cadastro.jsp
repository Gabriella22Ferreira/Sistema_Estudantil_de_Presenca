<%-- 
    Document   : cursos_cadastro.jsp
    Created on : 20 de nov. de 2026, 19:04:51
    Author     : thalita
--%>
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

        <h2>Alterar Cursos</h2>

        <%
            request.setCharacterEncoding("UTF-8");

            // Convertendo as datas para java.sql.Date
            java.sql.Date data_inicio = java.sql.Date.valueOf(
                    request.getParameter("data_inicio")
            );

            java.sql.Date data_termino = java.sql.Date.valueOf(
                    request.getParameter("data_termino")
            );

            // Criando o objeto Curso com o ID original
            Cursos curso = new Cursos(
                    0,
                    request.getParameter("nome"),
                    Integer.parseInt(request.getParameter("carga_horaria")),
                    data_inicio,
                    data_termino,
                    request.getParameter("nivel_curso"),
                    request.getParameter("descricao"),
                    request.getParameter("status"),
                    Float.parseFloat(request.getParameter("valor_mensalidade")),
                    request.getParameter("area_conhecimento")
            );

            // Executando a alteração
            CursosDAO cursoDAO = new CursosDAO();

            if (cursoDAO.cadastrar(curso)) {

                out.println("<br><b>Curso criado com sucesso!</b>");

            } else {

                out.println("<br><b>Curso NÃO criado!</b>");

            }

            // Exibindo os dados do curso
            out.println("<br><b>Identificador:</b> " + curso.getId());
            out.println("<br><b>Nome:</b> " + curso.getNome());
            out.println("<br><b>Carga horária:</b> " + curso.getCarga_horaria());
            out.println("<br><b>Início:</b> " + curso.getData_inicio());
            out.println("<br><b>Término:</b> " + curso.getData_termino());
            out.println("<br><b>Nível:</b> " + curso.getNivel_curso());
            out.println("<br><b>Descrição:</b> " + curso.getDescricao());
            out.println("<br><b>Status:</b> " + curso.getStatus());
            out.println("<br><b>Mensalidade:</b> " + curso.getValor_mensalidade());
            out.println("<br><b>Área de conhecimento:</b> " + curso.getArea_conhecimento());

        %>

    </body>
</html>