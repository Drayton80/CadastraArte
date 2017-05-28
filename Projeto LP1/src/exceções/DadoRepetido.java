package exceções;

/** Exceção de Campo de Texto Vazio
 *    Descrição:
 *      Essa exceção é lançado quando algum dos campos recebe um dado que já
 *      existe em alguma das obras no acervo do museu.
 *      
 *    Observação:
 *      Há certos campos em que isso não é um problema, pois eles podem ser
 *      repetidos.      
 * 
 *    @author Grupo 06
 *      alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */

public class DadoRepetido extends Exception{
    public DadoRepetido(){
        super ("Um dos campos de texto estava com um nome repetido.");
    }
}