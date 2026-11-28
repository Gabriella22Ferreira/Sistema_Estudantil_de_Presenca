package model.DAO;

/*  
    autor: Thalita
 */


//importação de arquivos utilitarios
import model.Cursos;
import java.sql.*;
import config.ConectaBanco;
import java.util.List;
import java.util.ArrayList;

//classe publica DAO (CRUD) para cursos
public class CursosDAO {

//Métodos 
// metodo cadasrar
    public boolean cadastrar(Cursos p_cursos) throws ClassNotFoundException {

        //definindo a conexão como nula
        Connection conexao = null;

        //bloco try e catch para conexão com o banco de dados
        try {
            conexao = ConectaBanco.conectar();

            // comando sql para inserção na tabela
            String sql = "INSERT INTO cursos ("
                    + "nome, "
                    + "carga_horaria, "
                    + "data_inicio, "
                    + "data_termino, "
                    + "nivel_curso, "
                    + "descricao, "
                    + "status, "
                    + "valor_mensalidade, "
                    + "area_conhecimento"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepara o comando SQL para execução no banco e recuperao a chave id do objeto
            PreparedStatement pstm = conexao.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
            );

            //definição dos paramestros
            pstm.setString(1, p_cursos.getNome());
            pstm.setInt(2, p_cursos.getCarga_horaria());
            pstm.setDate(3, p_cursos.getData_inicio());
            pstm.setDate(4, p_cursos.getData_termino());
            pstm.setString(5, p_cursos.getNivel_curso());
            pstm.setString(6, p_cursos.getDescricao());
            pstm.setString(7, p_cursos.getStatus());
            pstm.setFloat(8, p_cursos.getValor_mensalidade());
            pstm.setString(9, p_cursos.getArea_conhecimento());

            //executa o comando SQL
            int resultado = pstm.executeUpdate();

            //verifica se um pelo menos registro foi alterado
            if (resultado > 0) {

                // Recupera o id gerado pelo mysql
                ResultSet rs = pstm.getGeneratedKeys();

                // Verifica se existe um resultado e recupera o id
                if (rs.next()) {
                    p_cursos.setId(rs.getInt(1));
                }

                rs.close(); //fecha conexão

                // Recupera a data de cadastro gerada pelo banco ( (CURRENT_DATE) )
                String sqlData = "SELECT data_cadastro FROM cursos WHERE id = ?";

                //preparando a consulta sql para consulta do cadastro
                PreparedStatement pstmData = conexao.prepareStatement(sqlData);

                //defnicao do id, para a consulta
                pstmData.setInt(1, p_cursos.getId());

                // Executa a consulta e armazena
                ResultSet rsData = pstmData.executeQuery();

                //verifica se houve registro
                if (rsData.next()) {

                    p_cursos.setData_cadastro(
                            rsData.getDate("data_cadastro")
                    ); // recupera a data cadastrada no banco e atribui no objeto curso
                }

                //fechando as conexoes
                rsData.close();
                pstmData.close();
                pstm.close();

                return true;
            }

            pstm.close();
            return false;

        } catch (SQLException ex) { //bloco catch para tratamento de erros

            System.out.println("Erro SQL: " + ex.getMessage()); // exibindo. o erro sql

            return false;

        } finally { //bloco finally ocorrendo de forma independente do retorno try, para garantir que  a conexao feche

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    //////////////////////////////////////

    //Metodo de consulta por id
    public Cursos consultarId(int p_id) throws ClassNotFoundException {

        Connection conexao = null;//definindo a conexão como nula

        //bloco try e catch para conexão com o banco de dados
        try {
            conexao = ConectaBanco.conectar();// abrindo a conexão
            String sql = "SELECT * FROM cursos WHERE id = ?"; //string da consulta por id

            // Prepara o comando SQL para execução no banco
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, p_id);
            ResultSet rs = pstm.executeQuery(); //execuntando o sql  

            Cursos curso = new Cursos(); // instanciando o objeto

            //recuperando os atributos atráves da consulta, caso tenha tido resultado
            if (rs.next()) {
                curso.setId(Integer.parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setCarga_horaria(Integer.parseInt(rs.getString("carga_horaria")));
                curso.setData_inicio(rs.getDate("data_inicio"));
                curso.setData_termino(rs.getDate("data_termino"));
                curso.setNivel_curso(rs.getString("nivel_curso"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setStatus(rs.getString("status"));
                curso.setValor_mensalidade(Float.parseFloat(rs.getString("valor_mensalidade")));
                curso.setArea_conhecimento(rs.getString("area_conhecimento"));
            }

            pstm.close(); //fechando conexao
            return curso; //retornando o objeto consultado e preenchido
        } catch (SQLException ex) { //catch para tratamento derros
            System.out.println("Erro - SQL: " + ex);
            return null;
        } finally { //bloco finally ocorrendo de forma independente do retorno try, para garantir que  a conexao feche

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    //metodo de consulta por nome
    public Cursos consultarNome(String p_nome) throws ClassNotFoundException {

        Connection conexao = null; //definindo a conexão como nula

        try {
            conexao = ConectaBanco.conectar();// abrindo a conexão
            String sql = "SELECT * FROM cursos WHERE nome = ?"; // definindo a string de consulta atraves do nome

            // Prepara o comando SQL para execução no banco
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, p_nome);
            ResultSet rs = pstm.executeQuery();  // execução da string sql

            Cursos curso = new Cursos(); //instancia de 1 obj curso

            //recuperando os atributos atráves da consulta, caso tenha tido resultado
            if (rs.next()) {
                curso.setId(Integer.parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setCarga_horaria(Integer.parseInt(rs.getString("carga_horaria")));
                curso.setData_inicio(rs.getDate("data_inicio"));
                curso.setData_termino(rs.getDate("data_termino"));
                curso.setNivel_curso(rs.getString("nivel_curso"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setStatus(rs.getString("status"));
                curso.setValor_mensalidade(Float.parseFloat(rs.getString("valor_mensalidade")));
                curso.setArea_conhecimento(rs.getString("area_conhecimento"));
            }

            pstm.close(); //fechando conexão
            return curso;//retorno de um obj curso
        } catch (SQLException ex) {
            System.out.println("Erro - SQL: " + ex);
            return null;
        } finally { //bloco finally ocorrendo de forma independente do retorno try, para garantir que  a conexao feche

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

// metodo para excluir um curso por id
    public boolean excluir(int c_id) throws ClassNotFoundException {

        Connection conexao = null;//definindo a conexão como nula

        try {
            conexao = ConectaBanco.conectar();// abrindo a conexão
            String sql = "DELETE FROM cursos WHERE id = ?";  // definindo a string DELETE pelo id

            // Prepara o comando SQL para execução no banco
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, c_id);
            int result = pstm.executeUpdate();  //execução do comando sql

            if (result == 1) { // verificação se obteve resultado
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) { //tratamento de erros através do catch
            System.out.println("Erro - SQL: " + ex);

            return false;
        } finally { //bloco finally ocorrendo de forma independente do retorno try, para garantir que  a conexao feche

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    //metodo de alteração
    public boolean alterar(Cursos p_curso) throws ClassNotFoundException {

        Connection conexao = null;

        try {
            conexao = ConectaBanco.conectar();

            String sql = "UPDATE cursos SET "  // definindo a string de UPDATE atraves do id
                    + "nome=?, "
                    + "carga_horaria=?, "
                    + "data_inicio=?, "
                    + "data_termino=?, "
                    + "nivel_curso=?, "
                    + "descricao=?, "
                    + "status=?, "
                    + "valor_mensalidade=?, "
                    + "area_conhecimento=? "
                    + "WHERE id=?";

            PreparedStatement pstm = conexao.prepareStatement(sql);// Prepara o comando SQL para execução no banco

            pstm.setString(1, p_curso.getNome());
            pstm.setInt(2, p_curso.getCarga_horaria());
            pstm.setDate(3, p_curso.getData_inicio());
            pstm.setDate(4, p_curso.getData_termino());
            pstm.setString(5, p_curso.getNivel_curso());
            pstm.setString(6, p_curso.getDescricao());
            pstm.setString(7, p_curso.getStatus());
            pstm.setFloat(8, p_curso.getValor_mensalidade());
            pstm.setString(9, p_curso.getArea_conhecimento());

            // Identifica qual curso será atualizado
            pstm.setInt(10, p_curso.getId());

            // Executa a atualização
            int resultado = pstm.executeUpdate();

            pstm.close();

            // Verifica se algum registro foi alterado
            return resultado > 0;

        } catch (SQLException ex) {

            System.out.println("Erro - SQL: " + ex.getMessage());

            return false;

        } finally { 

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    //metodo de consulta de todos os cursos da tabela
    public List consultarGeral() throws ClassNotFoundException {
        List lista_cursos = new ArrayList<>(); // criação de uma array lista, para armazenar a consulta
        Connection conexao = null;
        try {
            conexao = ConectaBanco.conectar();// abrindo a conexão
            String sql = "SELECT * FROM cursos"; // definiçao da string, selecionando todos os registros
            PreparedStatement pstm = conexao.prepareStatement(sql);// Prepara o comando SQL para execução no banco
            ResultSet rs = pstm.executeQuery(); // execução do SELECT

            int nreg = 0; //definindo a variavel contador como zero
            while (rs.next()) { // enquanto estiver resgando registros, acrescentar um objeto na lista
                Cursos curso = new Cursos();
                curso.setId(Integer.parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setCarga_horaria(Integer.parseInt(rs.getString("carga_horaria")));
                curso.setData_inicio(rs.getDate("data_inicio"));
                curso.setData_termino(rs.getDate("data_termino"));
                curso.setNivel_curso(rs.getString("nivel_curso"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setStatus(rs.getString("status"));
                curso.setValor_mensalidade(Float.parseFloat(rs.getString("valor_mensalidade")));
                curso.setArea_conhecimento(rs.getString("area_conhecimento"));

                lista_cursos.add(curso);
                nreg++;
            }

            pstm.close();//echando conexão

            if (nreg == 0) { // caso o resultado seja zero definir como nulo
                return null;
            } else {
                return lista_cursos;
            }
        } catch (SQLException ex) {
            System.out.println("Erro - SQL: " + ex);
            return null;
        } finally { //bloco finally ocorrendo de forma independente do retorno try, para garantir que  a conexao feche

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }
}
