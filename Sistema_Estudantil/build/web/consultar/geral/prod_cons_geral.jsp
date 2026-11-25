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
            <%
                request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"            

                //Consultar Geral
                ProdutosDAO prodDAO = new ProdutosDAO();

                // Instância obj.                   
                List<Produtos> lstProd = new ArrayList<>();
                lstProd = prodDAO.consultarGeral();                       

                out.println("<br> <b>Lista Simples Geral (Registros)</b> ");

                int nreg=0;
                for(int i=0; i<=lstProd.size()-1 ;i++){ //index --> i            
                    out.println("<br><br> <b>#</b> " + (i+1));
                    out.println("<br> <b>Identificador.....:</b> " + lstProd.get(i).getCod());
                    out.println("<br> <b>Nome do Produto...:</b> " + lstProd.get(i).getNome());
                    out.println("<br> <b>Valor do Produto..:</b> " + lstProd.get(i).getValor());
                    out.println("<br> <b>Quantidade........:</b> " + lstProd.get(i).getQtd());
                    out.println("<br> <b>Valor Total.......:</b> " + (lstProd.get(i).getValor() * lstProd.get(i).getQtd()) ); 
                    nreg++;
                }      
                out.println("<br><br> <b>Total de Registros</b>: " + nreg);  
            %>
    
    </body>
</html>
