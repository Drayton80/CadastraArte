package estruturas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CI
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Persistencia {
    
    private FileInputStream fileStream;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean continua = true;
    private boolean moreRecords = true;
    private LinkedList<Arte> cad = new LinkedList<Arte>();
    
    
    public LinkedList<Arte> getCad(){
        return cad;
    }
    
    public boolean getContinua(){
        return continua;
    }
    
    public void setupLer(String arquivo) {
        //Abre arquivo para leitura
        try {
            
            input = new ObjectInputStream(new FileInputStream(arquivo));
        }
        catch (EOFException eof) {
           continua = false;  //arquivo está vazio
        } 
        catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }
        
    }

    public void readRecords() {
//Carrega todo o conteúdo do arquivo na Coleção cadcel
        
        try {
            while (moreRecords) {
                cad.add((Arte)(input.readObject()));
            }
        } catch (EOFException eof) {
            moreRecords = false;
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        }catch(ClassNotFoundException c){
            System.err.println("Erro durante leitura do arquivo - Objeto Inválido\n" + c.toString());
        }   
    }

    public void cleanupLer() {
  //Fechar o arquivo, após ter sido descarregado na coleção

        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo durante Leitura\n"  + e.toString());
            System.exit(1);
        }
    }

    public void setupGravar(String arquivo) {
 //Abre arquivo para gravar

   try{
       output = new ObjectOutputStream(new    
                FileOutputStream(arquivo, false));
      } catch (IOException e) {
           System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
           System.exit(1);
       }
    }

    public void addRecords(LinkedList<Arte> cad) {
 //Carrega toda a coleção no arquivo

        try {
            for (Arte a : cad) {
                output.writeObject(a);
            }
        } catch (IOException e) {
            System.err.println("Erro durante gravação no arquivo\n" + e.toString());
            System.exit(1);
        }
    }

    public void cleanupGravar() {
//Fechar o arquivo, após todos os objetos terem sido gravados

        try {
            output.flush();
            output.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo – Durante Gravação!!\n" + e.toString());
            System.exit(1);
        }
        
    }

    
    
}
