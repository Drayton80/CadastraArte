package estruturas;

/**
 * Descrição:
 *  Classe de instância dos objetos Obras de Artes
 */
import java.io.*;
import java.util.LinkedList;


public class Arte extends Artista implements Serializable {
   //Atributos Essenciais:
    private String titulo;
    private int ano;
    private String categoria;
    private String PeriodoProducao;
    private String procedencia;
    private String origem;
    private int tombo = 0;
    //Atributos Auxiliares:
    //private int indiceCategoria = 0;
    //private int indiceProcedencia = 0;
    //private boolean valorIndeterminado;
    private static int tomboAUX = 1;
    
   //Construtor:
    public Arte(String titulo, String nome, String registro, int ano, 
                String categoria, String PeriProducao, String procedencia, 
                String origem){
        super(nome, registro);
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.PeriodoProducao = PeriProducao;
        this.procedencia = procedencia;
        this.origem = origem;
        
        TomboSalvo tomboSalvo = new TomboSalvo();
        
        if(tomboSalvo.getTombo() > tomboAUX){
            tomboAUX = tomboSalvo.getTombo();
        }
        
        this.tombo = tomboAUX;
        
        tomboAUX ++;
    }

  
   //Métodos:
    //Leitura e Escrita:
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPeriodoProducao() {
        return PeriodoProducao;
    }
    public void setPeriodoProducao(String periProducao) {
        this.PeriodoProducao = periProducao;
    }

    public String getProcedencia() {
        return procedencia;
    }
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
  //public int getIndiceCategoria(){
  //    return indiceCategoria;
  //}
  //
  //public void setIndiceCategoria(int indiceCategoria){
  //    this.indiceCategoria = indiceCategoria;
  //}
  //
  //public int getIndiceProcedencia(){
  //    return indiceProcedencia;
  //}
  //
  //public void setIndiceProcedencia(int indiceProcedencia){
  //    this.indiceProcedencia = indiceProcedencia;
  //}
  //
  //public boolean getValorIndeterminado(){
  //    return valorIndeterminado;
  //}
  //
  //public void setValorIndeterminado(boolean valorIndeterminado){
  //    this.valorIndeterminado = valorIndeterminado;
  //}

    public int getTombo() {
        return tombo;
    }
    
    
    //Relatório dos Dados:
    public String toString(){
        return "Título da Obra:" + titulo + '\n' + super.toString() + '\n' + "Ano de Produção:" + ano + '\n' + "Categoria:" + categoria + '\n' +
               "Período de Produção:" + PeriodoProducao + '\n' + "Procedência" + procedencia + '\n' + "Origem da Procedência:" + origem + '\n' + "Número de Tombo:" + tombo;
    }
}

