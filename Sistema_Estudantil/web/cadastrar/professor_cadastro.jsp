<%-- 
    Document   : professor_cadastro
    Created on : 27 de nov. de 2026, 22:13:00
    Author     : ferre
--%>

<%@page import="model.Professor"%>
<%@page import="model.DAO.ProfessorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h2>Cadastro Professor</h2>

        <%
            request.setCharacterEncoding("UTF-8");

            // Convertendo as datas para java.sql.Date
            java.sql.Date data_Cadastro = java.sql.Date.valueOf(
                    request.getParameter("data_Cadastro")
            );

            java.sql.Date data_Nascimento = java.sql.Date.valueOf(
                    request.getParameter("data_Nascimento")
            );

            // Criando o objeto Professor com o ID original
           Professor prof = new Professor(
                    0,
                    request.getParameter("nome"),
                    request.getParameter("cpf"),
                    request.getParameter("email_Institucional"),
                    request.getParameter("telefone"),
                    request.getParameter("sexo"),
                    data_Cadastro,
                    data_Nascimento,
                    request.getParameter("endereco"),
                    request.getParameter("especialidade"),
                    request.getParameter("formacao")
            );

            // Executando a alteração
            ProfessorDAO profDAO = new ProfessorDAO();

            if (profDAO.cadastrar(prof)) {

                out.println("<br><b>Professor cadastrado com sucesso!</b>");

            } else {

                out.println("<br><b>Professor não cadastrado!</b>");

            }

            // Exibindo os dados do professor
            out.println("<br><b>Identificador:</b> " +prof.getId());
            out.println("<br><b>Nome Completo:</b> " + prof.getNome());
            out.println("<br><b>CPF:</b> " + prof.getCpf());
            out.println("<br><b>E-mail Institucional:</b> " + prof.getEmail_Institucional());
            out.println("<br><b>Telefone:</b> " + prof.getTelefone());
            out.println("<br><b>Sexo:</b> " + prof.getSexo());
            out.println("<br><b>Data de Cadastro:</b> " + prof.getData_Cadastro());
            out.println("<br><b>Data de Nascimento:</b> " + prof.getData_Nascimento());
            out.println("<br><b>Endereço:</b> " +prof.getEndereco());
            out.println("<br><b>Especialidade:</b> " + prof.getEspecialidade());
            out.println("<br><b>Formação:</b> " + prof.getFormacao());

        %>    
    </body>
</html>
