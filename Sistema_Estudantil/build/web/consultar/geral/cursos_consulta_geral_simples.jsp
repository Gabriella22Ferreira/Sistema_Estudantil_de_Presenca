<%-- 
    Document   : cursos_consulta_geral_simples
    Created on : 22 de nov. de 2026, 13:18:45
    Author     : thalita
--%>
<!--importação de utilitarios-->
<%@page import="model.Cursos"%>
<%@page import="model.DAO.CursosDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escola</title>
    </head>
    <body>
        <h2>Cursos Cadastrados - simplificado</h2>
        <table>
            <%
                request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"            

                //instancia da classe DAO
                CursosDAO cursoDAO = new CursosDAO();

                // Instancia de um array list, como parametro a classe cursos                 
                List<Cursos> lista_cursos = new ArrayList<>();
                // utilizando o metodo de consulta e armazenando em 1 variavel ;
                lista_cursos = cursoDAO.consultarGeral();
                out.println("<br> <b>Lista Simplificada em tabela</b> ");
            %>  

            <!--            INICIO tabela-->
            <tr>
                <th>Id.</th>
                <th>Nome</th>
                <th>Carga horária</th>
                <th>Data Inicio</th>
                <th>Data Termino</th>
                <th>Nivel de formação</th>
                <th>Descrição</th>
                <th>Status</th>
                <th>Valor da Mensalidade (R$)</th>
                <th>Area de conhecimento</th>
            </tr>
            <%
                int nreg = 0; // inicialização da variavel  de contagem 
                for (int i = 0; i <= lista_cursos.size() - 1; i++) { // for que percorre por tds os cursos  
%>    
            <tr>
                <!--            SAIDA-->
                <td><%= lista_cursos.get(i).getId()%></td>
                <td><%=lista_cursos.get(i).getNome()%></td>
                <td><%=lista_cursos.get(i).getCarga_horaria()%></td>
                <td><%=lista_cursos.get(i).getData_inicio()%></td>
                <td><%=lista_cursos.get(i).getData_termino()%></td>
                <td><%=lista_cursos.get(i).getDescricao()%></td>
                <td><%=lista_cursos.get(i).getStatus()%></td>
                <td><%=lista_cursos.get(i).getValor_mensalidade()%></td>
                <td><%=lista_cursos.get(i).getArea_conhecimento()%></td>
            </tr>                                                   
            <%
                    nreg++;// acrescentando no ciclo do contador
                }
                out.println("<br><br> <b>Total de Cursos</b>: " + nreg);
            %>
        </table>
        <!--  FIM tabela-->
    </body>
</html>
