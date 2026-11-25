/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.*; //importando sql do java

//classe publica de conexao com o banco
public class ConectaBanco {

    //metodo conectar
    // ClassNotFoundException caso o driver não seja encontrado
    // SQLException caso ocorra algum erro na conexão sql
    public static Connection conectar() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver"); // carrega o driver JDBC do MySQL, para que o java se comunique com o db

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/escola",
                "root",
                ""
        ); //estabelecendo a conexão, utilizando o DriverManager

        return conn; // retornando a conexão
    }
}
