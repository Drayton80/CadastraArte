package estruturas;

/**
 *Descrição:
 * 
 */
import java.util.*;
import java.io.*;

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
