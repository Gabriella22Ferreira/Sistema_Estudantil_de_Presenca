/*  
    autor: Thalita
 */
package model;
import java.sql.Date; //importação de DATE sql, para utilizar formatação de datas

/**
 *
 * @author thalita
 */
public class Cursos {
    //Atributos
    private int id;
    private String nome;
    private int carga_horaria;
    private Date data_inicio;
    private Date data_termino;
    private String nivel_curso;
    private String descricao;
    private String status;
    private float valor_mensalidade;
    private Date data_cadastro;
    private String area_conhecimento;
    
    // Métodos Construtores
    public Cursos(int c_id, String c_nome, int c_carga_horaria, Date c_data_inicio, Date c_data_termino,
          String c_nivel_curso,  
          String c_descricao,
          String c_status,
          Float c_valor_mensalidade,
//          Date c_data_cadastro,
          String c_area_conhecimento
    ){
        this.id = c_id;
        this.nome = c_nome;
        this.carga_horaria = c_carga_horaria;
        this.data_inicio = c_data_inicio;
        this.data_termino = c_data_termino;
        this.nivel_curso = c_nivel_curso;
        this.descricao = c_descricao;
        this.status = c_status;
        this.valor_mensalidade = c_valor_mensalidade;
        this.area_conhecimento = c_area_conhecimento;
    } 
    
    public Cursos(){        
    } 
    
    // M. Getters 
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public int getCarga_horaria() {
        return carga_horaria;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public String getNivel_curso() {
        return nivel_curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public float getValor_mensalidade() {
        return valor_mensalidade;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public String getArea_conhecimento() {
        return area_conhecimento;
    }
   
    
    // M. Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    public void setNivel_curso(String nivel_curso) {
        this.nivel_curso = nivel_curso;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValor_mensalidade(float valor_mensalidade) {
        this.valor_mensalidade = valor_mensalidade;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setArea_conhecimento(String area_conhecimento) {
        this.area_conhecimento = area_conhecimento;
    }
    
    
}
