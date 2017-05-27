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
import estruturas.Arte;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Persistencia implements Serializable{

    private FileInputStream fileStream;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean continua = true;
    private boolean moreRecords = true;
    private LinkedList<Arte> cad = new LinkedList<Arte>();

   
    
    
    
   
    public LinkedList<Arte> getCad() {
        return cad;
    }

    public boolean getContinua() {
        return continua;
    }

    public void setupLer() {
        //Abre arquivo para leitura
        try {

            input = new ObjectInputStream(new FileInputStream("Arte.ser"));
        } catch (EOFException eof) {
            continua = false;  //arquivo está vazio
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }

    }

    public void readRecords() {
//Carrega todo o conteúdo do arquivo na Coleção cad

    

       try{
           cad = (LinkedList<Arte>) input.readObject();
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        } catch (ClassNotFoundException c) {
            System.err.println("Erro durante leitura do arquivo - Objeto Inválido\n" + c.toString());
        }
    }

    public void cleanupLer() {
        //Fechar o arquivo, após ter sido descarregado na coleção

        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo durante Leitura\n" + e.toString());
            System.exit(1);
        }
    }

    public void setupGravar() {
        //Abre arquivo para gravar

        try {
            output = new ObjectOutputStream(new FileOutputStream("Arte.ser", false));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

    public void addRecords(LinkedList<Arte> cad) {
        //Carrega toda a coleção no arquivo

        try {
                output.writeObject(cad);
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

    public void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public Arte getArte(int x) {
        return cad.get(x);
    }


}
