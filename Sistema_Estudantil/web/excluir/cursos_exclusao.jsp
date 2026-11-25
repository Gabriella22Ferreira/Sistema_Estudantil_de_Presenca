<%-- 
    Document   : cursos_exclusao.jsp
    Created on : 20 de nov. de 2026, 16:30:02
    Author     : thalita
--%>
<!--importação de utilitarios-->
<%@page import="model.DAO.CursosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escola</title>
    </head>
    <body>
        <h2> Excluir Id - cursos</h2>
        <%
            request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"
            
            // Entrada, resgate do id pelo formulario
            int id = Integer.parseInt( request.getParameter("id") );

            //Instanci do objeto da DAO
            CursosDAO cursoDAO = new CursosDAO();
                
              //verificando e executando o metodo de exclusão
            if (cursoDAO.excluir(id)== true){
                out.println("<br>Curso excluído ");
                out.println(id); 
            }else{
                out.println("<br> Curso Não excluído ");                                
            }
        %>
    </body>
</html>
