package estruturas;

import estruturas.Arte;
import java.io.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/** Classe Persistência
 *    Descrição:
 *      Essa classe vai prover métodos que auxilie a todos os objetos que
 *      forem declarados como pertencentes a ela.
 * 
 *    @author Grupo 06
 *      Alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */

public class Persistencia implements Serializable{ 
  //ATRIBUTOS:
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean continua = true;
    private boolean moreRecords = true;
    private LinkedList<Arte> cad = new LinkedList<Arte>();

    
   //MÉTODOS:
     /** Método que Retorna a Coleção
      *    Descrição:
      *      O Metodo retorna aquilo que está salvo na coleção 
      *      em determinado momento.
      */
    public LinkedList<Arte> getCad() {
        return cad;
    }
    
     /** Método que Retorna o Estado do Arquivo
      *    Descrição:
      *     O Metodo retorna se é possível ou não ler algum arquivo.
      */
    public boolean getContinua() {
        return continua;
    }    
    
     /** Método que Habilita o Modo de Leitura
      *    Descrição:
      *      O Metodo abre o arquivo e habilita a stream para que nos retorne os
      *      dados gravados no arquivo.
      */
    public void setupLer() {
        try {
            FileInputStream leitura = new FileInputStream("Arte.ser");
            input = new ObjectInputStream(leitura);
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo de salvamento inexistente," + "\n" +
                                                "foi criado um novo arquivo.", "Informe", JOptionPane.INFORMATION_MESSAGE);
            setupGravar();
            addRecords(cad);
            cleanupGravar();
        } catch (EOFException eof) {
            continua = false;           //Se o arquivo estiver vazio.
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }

    }

     /** Método que Salva o Arquivo na Coleção
      *    Descrição:
      *      O Metodo pega aquilo que está sendo lido no arquivo e transcreve
      *      na nossa coleção cad.
      */
    public void readRecords() {


       try{
           cad = (LinkedList<Arte>) input.readObject();
        } catch(NullPointerException a){
        }catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        } catch (ClassNotFoundException c) {
            System.err.println("Erro durante leitura do arquivo - Objeto Inválido\n" + c.toString());
        }
    }

     /** Método que Fecha o Arquivo
      *    Descrição:
      *      O Metodo permite fechar o arquivo após o seu uso em modo 
      *      de leitura.
      */
    public void cleanupLer() {

        try {
            input.close();
        }catch(NullPointerException a){
        }catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo durante Leitura\n" + e.toString());
            System.exit(1);
        }
    }
    
     /** Método Habilita o Modo de Escrita
      *    Descrição:
      *      O método permite abrir o arquivo e habilitar a stream para que
      *      seja possível escrever no arquivo.
      */
    public void setupGravar() {

        try {
            FileOutputStream escrita = new FileOutputStream("Arte.ser");
            output = new ObjectOutputStream(escrita);
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

     /** Método que Salva a Coleção no Arquivo
      *    Descrição:
      *      O método escreve no arquivo, que deve estar em modo de leitura,
      *      a coleção de objetos de arte do museu.
      *    
      */
    public void addRecords(LinkedList<Arte> cad) {

        try {
                output.writeObject(cad);
        } catch (IOException e) {
            System.err.println("Erro durante gravação no arquivo\n" + e.toString());
            System.exit(1);
        }
    }

     /** Método que Fecha o Arquivo
      *    Descrição:
      *      O método permite fechar o arquivo e isso apenas deve ocorrer quando
      *      todos os objetos tiverem sido gravados.
      */
    public void cleanupGravar() {

        try {
            output.flush();
            output.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo – Durante Gravação!!\n" + e.toString());
            System.exit(1);
        }

    }

     /** Método que Retorna um Objeto de Arte
      *    Descrição:
      *      O método permite que seja retornado para o programa um objeto de
      *      arte da coleção cad em uma determinada posição "x".
      */
    public Arte getArte(int x) {
        return cad.get(x);
    }
    
}
