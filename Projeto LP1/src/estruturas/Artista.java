package estruturas;

import java.io.*;

/** Classe Artista
 *    Descrição:
 *      Contém os métodos e atributos relativos ao artista sendo a Superclasse
 *      da classe Arte.
 * 
 *    @author Grupo 06
 *      Alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */

public class Artista implements Serializable {
   //Atributos
    protected String nome;
    protected String registro;
    
   //Construtor:
    public Artista(String nome, String registro){
        this.nome = nome;
        this.registro = registro;
    }
    
   //Métodos de Leitura e Escrita:
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getRegistro(){
        return registro;
    }
    public void setRegistro(String registro){
        this.registro = registro;
    }
    
   //Relatório dos Dados:
    public String toString(){
        return "Nome:" + nome + '\n' + "Registro Artístico:" + registro;
    }
}
