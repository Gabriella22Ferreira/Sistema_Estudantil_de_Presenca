/*  
    autor: Gabriella
 */



package model.DAO;

//importação de arquivos utilitarios
import model.Professor;
import java.sql.*;
import config.ConectaBanco;
import java.util.List;
import java.util.ArrayList;


public class ProfessorDAO {
    
    

//Métodos 
// metodo cadasrar
    public boolean cadastrar(Professor prof) throws ClassNotFoundException {

        //definindo a conexão como nula
        Connection conexao = null;

        //bloco try e catch para conexão com o banco de dados
        try {
            conexao = ConectaBanco.conectar();

            // comando sql para inserção na tabela
            String sql = "INSERT INTO professor ("
                    + "nome, "
                    + "cpf, "
                    + "email_Institucional, "
                    + "telefone, "
                    + "sexo, "
                    + "data_Cadastro, "
                    + "data_Nascimento, "
                    + "endereco, "
                    + "especialidade,"
                    + "formacao"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
             // Prepara o comando SQL para execução no banco e recuperao a chave id do objeto
            PreparedStatement pstm = conexao.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
            );

            //definição dos paramestros
            pstm.setString(1, prof.getNome());
            pstm.setString(2, prof.getCpf());
            pstm.setString(3, prof.getEmail_Institucional());
            pstm.setString(4, prof.getTelefone());
            pstm.setString(5, prof.getSexo());
            pstm.setDate(6, prof.getData_Cadastro());
            pstm.setDate(7, prof.getData_Nascimento());
            pstm.setString(8, prof.getEndereco());
            pstm.setString(9, prof.getEspecialidade());
            pstm.setString(10, prof.getFormacao());

            //executa o comando SQL
            int resultado = pstm.executeUpdate();

            //verifica se um pelo menos registro foi alterado
            if (resultado > 0) {

                // Recupera o id gerado pelo mysql
                ResultSet rs = pstm.getGeneratedKeys();

                // Verifica se existe um resultado e recupera o id
                if (rs.next()) {
                    prof.setId(rs.getInt(1));
                }

                rs.close(); //fecha conexão

                // Recupera a data de cadastro gerada pelo banco ( (CURRENT_DATE) )
                String sqlData = "SELECT data_Cadastro FROM professor WHERE id = ?";

                //preparando a consulta sql para consulta do cadastro
                PreparedStatement pstmData = conexao.prepareStatement(sqlData);

                //defnicao do id, para a consulta
                pstmData.setInt(1, prof.getId());

                // Executa a consulta e armazena
                ResultSet rsData = pstmData.executeQuery();

                //verifica se houve registro
                if (rsData.next()) {

                    prof.setData_Cadastro(
                            rsData.getDate("data_Cadastro")
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
    
    
   
        public Professor consultarId(int p_id) throws ClassNotFoundException {

            Connection conexao = null;//definindo a conexão como nula

            //bloco try e catch para conexão com o banco de dados
            try {
                conexao = ConectaBanco.conectar();// abrindo a conexão
                String sql = "SELECT * FROM professor WHERE id = ?"; //string da consulta por id

                // Prepara o comando SQL para execução no banco
                PreparedStatement pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, p_id);
                ResultSet rs = pstm.executeQuery(); //execuntando o sql  

                Professor prof = new Professor(); // instanciando o objeto

                //recuperando os atributos atráves da consulta, caso tenha tido resultado
                if (rs.next()) {
                    prof.setId(Integer.parseInt(rs.getString("id")));
                    prof.setNome(rs.getString("nome"));
                    prof.setCpf(rs.getString("cpf"));
                    prof.setEmail_Institucional(rs.getString("email_Institucional"));
                    prof.setTelefone(rs.getString("telefone"));
                    prof.setSexo(rs.getString("sexo"));
                    prof.setData_Cadastro(rs.getDate("data_cadastro"));
                    prof.setData_Nascimento(rs.getDate("data_nascimento"));
                    prof.setEndereco(rs.getString("endereco"));
                    prof.setEspecialidade(rs.getString("especialidade"));
                    prof.setFormacao(rs.getString("formacao"));
                }

                pstm.close(); //fechando conexao
                return prof; //retornando o objeto consultado e preenchido
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

        public Professor consultarNome(String p_nome) throws ClassNotFoundException {

            Connection conexao = null; //definindo a conexão como nula

            try {
                conexao = ConectaBanco.conectar();// abrindo a conexão
                String sql = "SELECT * FROM professor WHERE nome = ?"; // definindo a string de consulta atraves do nome

                // Prepara o comando SQL para execução no banco
                PreparedStatement pstm = conexao.prepareStatement(sql);
                pstm.setString(1, p_nome);
                ResultSet rs = pstm.executeQuery();  // execução da string sql

                Professor prof = new Professor(); //instancia de 1 obj curso

                //recuperando os atributos atráves da consulta, caso tenha tido resultado
                if (rs.next()) {
                    prof.setId(Integer.parseInt(rs.getString("id")));
                    prof.setNome(rs.getString("nome"));
                    prof.setCpf(rs.getString("cpf"));
                    prof.setEmail_Institucional(rs.getString("email_Institucional"));
                    prof.setTelefone(rs.getString("telefone"));
                    prof.setSexo(rs.getString("sexo"));
                    prof.setData_Cadastro(rs.getDate("data_cadastro"));
                    prof.setData_Nascimento(rs.getDate("data_nascimento"));
                    prof.setEndereco(rs.getString("endereco"));
                    prof.setEspecialidade(rs.getString("especialidade"));
                    prof.setFormacao(rs.getString("formacao"));
                }

                pstm.close(); //fechando conexão
                return prof;//retorno de um obj curso
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

        public boolean excluir(int p_id) throws ClassNotFoundException {

            Connection conexao = null;//definindo a conexão como nula

            try {
                conexao = ConectaBanco.conectar();// abrindo a conexão
                String sql = "DELETE FROM professor WHERE id = ?";  // definindo a string DELETE pelo id

                // Prepara o comando SQL para execução no banco
                PreparedStatement pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, p_id);
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
        
        public boolean alterar(Professor prof) throws ClassNotFoundException {

        Connection conexao = null;

        try {
            conexao = ConectaBanco.conectar();

            String sql = "UPDATE professor SET "  // definindo a string de UPDATE atraves do id
                    + "nome=?, "
                    + "cpf=?, "
                    + "email_Institucional=?, "
                    + "telefone=?, "
                    + "sexo=?, "
                    + "data_Cadastro=?, "
                    + "data_Nascimento=?, "
                    + "endereco=?, "
                    + "especialidade=?, "
                    + "formacao=? "
                    + "WHERE id=?";
        

            PreparedStatement pstm = conexao.prepareStatement(sql);// Prepara o comando SQL para execução no banco

            pstm.setString(1, prof.getNome());
            pstm.setString(2, prof.getCpf());
            pstm.setString(3, prof.getEmail_Institucional());
            pstm.setString(4, prof.getTelefone());
            pstm.setString(5, prof.getSexo());
            pstm.setDate(6, prof.getData_Cadastro());
            pstm.setDate(7, prof.getData_Nascimento());
            pstm.setString(8, prof.getEndereco());
            pstm.setString(9, prof.getEspecialidade());
            pstm.setString(10, prof.getFormacao());

            // Identifica qual professor será atualizado
            pstm.setInt(11, prof.getId());

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
          
        public List consultarGeral() throws ClassNotFoundException {
        List lista_cursos = new ArrayList<>(); // criação de uma array lista, para armazenar a consulta
        Connection conexao = null;
        try {
            conexao = ConectaBanco.conectar();// abrindo a conexão
            String sql = "SELECT * FROM professor"; // definiçao da string, selecionando todos os registros
            PreparedStatement pstm = conexao.prepareStatement(sql);// Prepara o comando SQL para execução no banco
            ResultSet rs = pstm.executeQuery(); // execução do SELECT

            int nreg = 0; //definindo a variavel contador como zero
            while (rs.next()) { // enquanto estiver resgando registros, acrescentar um objeto na lista
                Professor prof = new Professor();
                prof.setId(Integer.parseInt(rs.getString("id")));
                prof.setNome(rs.getString("nome"));
                prof.setCpf(rs.getString("cpf"));
                prof.setEmail_Institucional(rs.getString("email_Institucional"));
                prof.setTelefone(rs.getString("telefone"));
                prof.setSexo(rs.getString("sexo"));
                prof.setData_Cadastro(rs.getDate("data_cadastro"));
                prof.setData_Nascimento(rs.getDate("data_nascimento"));
                prof.setEndereco(rs.getString("endereco"));
                prof.setEspecialidade(rs.getString("especialidade"));
                prof.setFormacao(rs.getString("formacao"));

                lista_cursos.add(prof);
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
