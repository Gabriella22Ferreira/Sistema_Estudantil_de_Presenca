<%-- 
    Document   : prod_cons geral
    Created on : 30 de out. de 2026, 21:03:29
    Author     : Adilson Lima
--%>

<%@page import="model.Produtos"%>
<%@page import="model.DAO.ProdutosDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web App DELL</title>
        
        <link href="../style/tabela.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Controle de Produtos (CRTL) - Consultar Geral</h2>
        <table>
        <%
            request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"            

            //Consultar Geral
            ProdutosDAO prodDAO = new ProdutosDAO();

            // Instância obj.                   
            List<Produtos> lstProd = new ArrayList<>();
            lstProd = prodDAO.consultarGeral();                       
            out.println("<br> <b>Lista Simples</b> ");
        %>            
            <tr>
                <th>Id.</th>
                <th>Produto</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
        <%    
            int nreg=0;
            for(int i=0; i<=lstProd.size()-1 ;i++){ //index --> i  
        %>    
                <tr>
                    <td><%=lstProd.get(i).getCod()%></td>
                    <td><%=lstProd.get(i).getNome()%></td>
                    <td><%=lstProd.get(i).getValor()%></td>
                    <td><%=lstProd.get(i).getQtd()%></td>
                </tr>                                                   
        <%
                nreg++;
            }      
            out.println("<br><br> <b>Total de Registros</b>: " + nreg);  
        %>
        </table>
    </body>
</html>
