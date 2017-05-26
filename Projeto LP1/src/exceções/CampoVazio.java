package exceções;

/** Exceção de Campo de Texto Vazio
 *    descrição:
 *      Essa exceção é lançado quando um dos campos de texto de alguns dos
 *      paíneis está vazio.
 * 
 *    @author Grupo 06
 *      alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */

public class CampoVazio extends Exception{
    public CampoVazio(){
        super ("Um dos campos de texto não estava preenchido.");
    }
}