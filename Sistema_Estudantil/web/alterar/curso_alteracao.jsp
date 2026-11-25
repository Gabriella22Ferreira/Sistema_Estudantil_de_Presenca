<%-- 
    Document   : cursos_alteracao.jsp
    Created on : 21 de nov. de 2026, 10:17:05
    Author     : thalita
--%>

<!--importaçao de arquivos utilitarios-->
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

            // Recuperando o ID enviado pelo formulário
            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            // Convertendo as datas para java.sql.Date
            java.sql.Date data_inicio = java.sql.Date.valueOf(
                    request.getParameter("data_inicio")
            );

            java.sql.Date data_termino = java.sql.Date.valueOf(
                    request.getParameter("data_termino")
            );

            // Criando o objeto Curso com o ID original
            Cursos curso = new Cursos(
                    id,
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

            if (cursoDAO.alterar(curso)) {

                out.println("<br><b>Curso alterado com sucesso!</b>");

            } else {

                out.println("<br><b>Curso NÃO alterado!</b>");

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