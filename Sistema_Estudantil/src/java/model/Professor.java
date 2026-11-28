/*  
    autor: Gabriella
 */

package model;
import java.sql.Date; //importação de DATE sql, para utilizar formatação de datas

public class Professor {
    
    private int id;
    private String nome;
    private String cpf;
    private String email_Institucional;
    private String telefone;
    private String sexo;
    private Date data_Cadastro;
    private Date data_Nascimento;
    private String endereco;
    private String especialidade;
    private String formacao;

    public Professor(
            int id, String nome, String cpf, String email_Institucional, 
            String telefone, String sexo, Date data_Cadastro, Date data_Nascimento,
            String endereco, String especialidade, String formacao) 
    {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email_Institucional = email_Institucional;
        this.telefone = telefone;
        this.sexo = sexo;
        this.data_Cadastro = data_Cadastro;
        this.data_Nascimento = data_Nascimento;
        this.endereco = endereco;
        this.especialidade = especialidade;
        this.formacao = formacao;
    }

    public Professor() {
    }

    
       // Getters 

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail_Institucional() {
        return email_Institucional;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getData_Cadastro() {
        return data_Cadastro;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getFormacao() {
        return formacao;
    }
    
    
     // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail_Institucional(String email_Institucional) {
        this.email_Institucional = email_Institucional;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setData_Cadastro(Date data_Cadastro) {
        this.data_Cadastro = data_Cadastro;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
    
}
