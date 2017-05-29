package telas;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno

*/
import estruturas.Persistencia;
import estruturas.Arte;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;


public class PainelPrincipal extends javax.swing.JFrame {
    
    //CONSTRUTOR:
    /** Construtor do Painel Principal:
     *    Descrição:
     *      Painel padrão da interface.
     */
    public PainelPrincipal() {
        p.setupLer();
        if (p.getContinua() == true ){
            p.readRecords();
            p.cleanupLer();
            cad = p.getCad();
        }
        initComponents();
    }
    
    //MÉTODOS:
    /** Método de Testar se Existe na Lista
     *    Descrição:
     *      O método percorre a coleção e checa se existe o tombo enviado
     *      no parâmetro.     * 
     */
    private boolean existeNaLista(int tomb) {
        for (Arte a : cad) {
            if (a.getTombo() == tomb) {
               return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jTelaPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBarra = new javax.swing.JMenuBar();
        jMenuOpcoes = new javax.swing.JMenu();
        jMenuItemCadastrar = new javax.swing.JMenuItem();
        jMenuItemPesquisar = new javax.swing.JMenuItem();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTelaPrincipal.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No canto superior esquerdo, selecione sua opção.");
        jLabel1.setAutoscrolls(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  BEM VINDO AO SISTEMA DE CADASTRO DO MUSEU! ");
        jLabel2.setAutoscrolls(true);
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);

        jTelaPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTelaPrincipal.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jTelaPrincipalLayout = new javax.swing.GroupLayout(jTelaPrincipal);
        jTelaPrincipal.setLayout(jTelaPrincipalLayout);
        jTelaPrincipalLayout.setHorizontalGroup(
            jTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTelaPrincipalLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addGroup(jTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTelaPrincipalLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(330, 330, 330))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTelaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(267, 267, 267))))
        );
        jTelaPrincipalLayout.setVerticalGroup(
            jTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTelaPrincipalLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(626, 626, 626))
        );

        jLabel2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTelaPrincipal)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTelaPrincipal)
        );

        jMenuOpcoes.setMnemonic('c');
        jMenuOpcoes.setText("Opções");
        jMenuOpcoes.setToolTipText("Exibir Opções... (Alt + C)");

        jMenuItemCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_add.png"))); // NOI18N
        jMenuItemCadastrar.setText("Cadastrar Novas Obras");
        jMenuItemCadastrar.setToolTipText("Lançar o Obra de Arte no sistema");
        jMenuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastrar);

        jMenuItemPesquisar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_magnify.png"))); // NOI18N
        jMenuItemPesquisar.setText("Pesquisar Registros");
        jMenuItemPesquisar.setToolTipText("Pesquisa e exibe Obras de Arte.");
        jMenuItemPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemPesquisar);

        jMenuItemEditar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/application_form_edit.png"))); // NOI18N
        jMenuItemEditar.setText("Modificar Dados");
        jMenuItemEditar.setToolTipText("Pesquisa por Tombo e altera dados.");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemEditar);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.setToolTipText("Fecha o programa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItem1);

        jMenuBarra.add(jMenuOpcoes);

        setJMenuBar(jMenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /** Item de Menu Cadastrar Novas Obras
     *    Descrição:
     *      Abre uma janela que serve para registrar uma obra de arte no acervo
     *      pertencente ao museu.
     */
    private void jMenuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarActionPerformed
        PainelDeRegistro PainelC = new PainelDeRegistro();
        PainelC.setTitle("Cadastrar Obra de Arte");
        jTelaPrincipal.add(PainelC);
        PainelC.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarActionPerformed

    /** Item de Menu Pesquisar Registros
     *    Descrição:
     *      Abre uma janela que serve para buscar uma obra de arte no acervo
     *      daquelas que já foram cadastradas.
     */
    private void jMenuItemPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarActionPerformed
        PainelDePesquisa PainelP = new PainelDePesquisa();
        jTelaPrincipal.add(PainelP);
        PainelP.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
        
    }//GEN-LAST:event_formWindowClosing

    /** Item de Meno Sair
     *    Descrição:
     *      Encerra o programa.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /** Item de Menu Modificar Dados
     *    Descrição:
     *      Abre uma janela (JOptionPane) que pede o número de tombo e,
     *      com aquilo que for digitado nela, percorre a coleção para saber
     *      se esse tombo existe para logo em seguida abrir a janela de
     *      edição de obras.
     */
    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        PainelDePesquisaTombo PainelT = new PainelDePesquisaTombo();
        jTelaPrincipal.add(PainelT);
        PainelT.setVisible(true);
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBarra;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCadastrar;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemPesquisar;
    private javax.swing.JMenu jMenuOpcoes;
    private javax.swing.JPanel jPanelPrincipal;
    protected static javax.swing.JDesktopPane jTelaPrincipal;
    // End of variables declaration//GEN-END:variables

private static LinkedList<Arte> cad = new LinkedList<Arte>();
private static Persistencia p = new Persistencia();


}
