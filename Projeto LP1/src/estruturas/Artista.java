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
    protected int registro;
    
   //Construtor:
    public Artista(String nome, int registro){
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
    
    public int getRegistro(){
        return registro;
    }
    public void setRegistro(int registro){
        this.registro = registro;
    }
    
    //Relatório dos Dados:
    public String toString(){
        return "Nome:" + nome + '\n' + "Registro Artístico:" + registro;
    }
}
