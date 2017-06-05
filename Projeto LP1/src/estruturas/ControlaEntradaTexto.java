
package estruturas;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
public class ControlaEntradaTexto extends PlainDocument
{
   /** Aceita apenas letras:
      *    Descrição:
      *      Método que força o JtextField a aceitar apenas letras,sejam elas
      *      maiúsculas ou minúsculas.     
      */
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
    {
        if(Character.isLetter(str.charAt(0)))
            super.insertString(offs, str, a);
    }
    
    public void insertInt(int offs, String str, AttributeSet a) throws BadLocationException
    {
        if(!Character.isLetter(str.charAt(0)))
            super.insertString(offs, str, a);
    }
}

