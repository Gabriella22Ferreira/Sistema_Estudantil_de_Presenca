<%-- 
    Document   : cursos_alterar_por_id.jsp
    Created on : 21 de nov. de 2026, 13:27:14
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
        <h2>Alteração curso</h2>
        <%
            request.setCharacterEncoding("UTF-8"); //Encoding "UTF-8"

            //resganto o id atraves do parametro do form
            int id = Integer.parseInt(request.getParameter("id"));
            
            CursosDAO cursoDAO = new CursosDAO(); //instancia da DAO

            Cursos curso = new Cursos(); //instancia de um curso
            curso = cursoDAO.consultarId(id); //execução do metodo de consulta por id

            if (curso.getId() == 0) { //verificando se obteve algum registro
                out.println("<br> <b>Curso não cadastrado</b> ");
            } else {
                out.println("<br> Curso encontrado! ");
            }
        %>   
        
<!--    formulario preenchido com os campos preenchidos, de acordo com obj resgatado-->
        <form method="post" action="curso_alteracao.jsp">
            <p>ID <input type="number" name="id" value="<%=curso.getId()%>" readonly="true" > </p> 
            <p>Nome do Curso <input type="text" name="nome" value="<%=curso.getNome()%>"> </p>
            <p>Carga Horária <input type="number" name="carga_horaria" value="<%=curso.getCarga_horaria()%>"> </p>
            <p>Data de Início <input type="date" name="data_inicio" value="<%=curso.getData_inicio()%>"> </p>
            <p>Data de Término <input type="date" name="data_termino" value="<%=curso.getData_termino()%>"> </p>


            <label>Nível de formação*</label>
            <select name="nivel_curso">
                <option value="<%=curso.getNivel_curso()%>"><%=curso.getNivel_curso()%> - Atual</option>
                <option value="Profissionalizante">Profissionalizante</option>
                <option value="Técnico">Técnico</option>
            </select>
            <br>

            <label>Descrição e mais detalhes (opcional)</label>
            <textarea  name="descricao" rows="5" cols="10"><%=curso.getDescricao()%></textarea>
            <br>

            <label>Status*</label>
            <select name="status">
                <option value="<%=curso.getStatus()%>"><%=curso.getStatus()%> - Atual</option>
                <option value="ativo">ativo</option>
                <option value="inativo">inativo</option>
            </select>
            <br>

            <label>Valor da mensalidade (R$)*</label>
            <input type="number" name="valor_mensalidade" value="<%=curso.getValor_mensalidade()%>"> 
            <br>

            <label>Área de conhecimento*</label>
            <select name="area_conhecimento">
                <option value="<%=curso.getArea_conhecimento()%>"><%=curso.getArea_conhecimento()%> - Atual</option>
                <option value="Costura">Costura</option>
                <option value="Informática">Informática</option>
                <option value="Nutrição">Nutrição</option>
                <option value="Desenho">Desenho</option>
                <option value="Idiomas">Idiomas</option>
                <option value="Mecânica">Mecânica</option>
                <option value="Contabilidade">Contabilidade</option>
            </select>
            <br>

            <p> <input type="submit" value="Alterar">
                <input type="reset" value="Limpar">
            </p>
        </form>   
<!--    fim do formulario-->
    </body>
</html>
