package telas;

import estruturas.Persistencia;
import estruturas.Arte;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static telas.PainelPrincipal.jTelaPrincipal;

/** Painel de Pesquisa de Obras de Artes
 *    descrição:
 *      Esse painel possuí tudo acerca da pesquisa de uma obra de arte
 *      no acervo cadastrado.
 * 
 *    @author Grupo 06
 *      alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */
        
public class PainelDePesquisa extends javax.swing.JInternalFrame {
        
    //CONSTRUTOR:
    /** Construtor Padrão:
     *    Descrição:
     *      ELe executa o método atualiza_Arte que abre, lê o arquivo e atualiza
     *      a lista.
     */ 
    
    public PainelDePesquisa() {
        initComponents();
        atualiza_Arte();
            }
    
    /** Método que Fecha a Janela Aberta
     *    Descrição:
     *      O método simplesmente fecha por completo a janela aberta no momento
     *      em que ele é chamado.
     */
    private void fecha_Janela() {
        this.dispose();
    }

    /**
     * Metodo que pega varre a lista e
     * mostra todos os itens formatados de acordo com o modelo
     * do metodo obj
     */    
    private void atualiza_Arte() {
         p.setupLer();
        if (p.getContinua() == true ){
            p.readRecords();
            p.cleanupLer();
            cad = p.getCad();
        }
        
        for (Arte art : cad) {
            System.out.println(art.getTitulo());   
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        for (Arte a : cad) {
            model.addRow(obj(a));
        }
    }
    
    /**
     * Metodo que cria o modelo de exibição na tabela     *  
     */
    private Object[] obj(Arte a){
        try {
            Object[] arte = {a.getTitulo(), a.getAno(), a.getNome(), a.getCategoria(), a.getTombo()} ;
            return arte;
        } catch (Exception e) {
        }
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelSePesquisa = new javax.swing.JPanel();
        cbCategoriaPesquisa = new javax.swing.JComboBox<>();
        jSMostraPesquisa = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPesquisaNome = new javax.swing.JTextField();
        txtPesquisaArtista = new javax.swing.JTextField();
        lblTituloPainel = new javax.swing.JLabel();
        jBFecharPesquisa = new javax.swing.JButton();
        jBPesquisaRes = new javax.swing.JButton();
        botaoNomeArtista = new javax.swing.JRadioButton();
        botaoTitulo = new javax.swing.JRadioButton();
        botaoCategoria = new javax.swing.JRadioButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pesquisa de Obra de Arte");

        cbCategoriaPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Álbum", "Aquarela", "Colagem", "Desenho", "Escultura", "Foto", "Gravura", "Impressão", "Instalação", "Livro", "Múltiplo", "Objeto", "ObraDesinc", "Perform", "Pintura", "Relevo", "Tapeçaria", "Vídeo" }));
        cbCategoriaPesquisa.setToolTipText("Para pesquisar por Categoria, Selecione a Categoria da Obra e marque a caixa Categoria.");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ano de Produção", "Artista", "Categoria", "Tombo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jSMostraPesquisa.setViewportView(jTable1);

        txtPesquisaNome.setToolTipText("Para pesquisar por Título da Obra, digite o nome completo da obra e marque a caixa Titulo da Obra.");

        txtPesquisaArtista.setToolTipText("Para pesquisar por Nome do Artista, digite o nome completo do Artista e marque a caixa Nome do Artista.");

        lblTituloPainel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTituloPainel.setText("Pesquisar Registro");

        jBFecharPesquisa.setText("Cadastrar");
        jBFecharPesquisa.setToolTipText("Retorna para a aba de cadastro de obras de arte.");
        jBFecharPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBFecharPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharPesquisaActionPerformed(evt);
            }
        });

        jBPesquisaRes.setText("Pesquisar");
        jBPesquisaRes.setToolTipText("Pesquisar dados inseridos.");
        jBPesquisaRes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBPesquisaRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisaResActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoNomeArtista);
        botaoNomeArtista.setText("Nome do Artista:");
        botaoNomeArtista.setToolTipText("");
        botaoNomeArtista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoNomeArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNomeArtistaActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoTitulo);
        botaoTitulo.setText("Titulo da Obra:");
        botaoTitulo.setToolTipText("");
        botaoTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTituloActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoCategoria);
        botaoCategoria.setText("Categoria:");
        botaoCategoria.setToolTipText("É necessário confirmar a caixa de pesquisa por categoria.");
        botaoCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCategoriaActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Restaurar");
        jToggleButton1.setToolTipText("Retorna para a realização de uma nova pesquisa.");
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSePesquisaLayout = new javax.swing.GroupLayout(jPanelSePesquisa);
        jPanelSePesquisa.setLayout(jPanelSePesquisaLayout);
        jPanelSePesquisaLayout.setHorizontalGroup(
            jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSMostraPesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(botaoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNomeArtista)
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jToggleButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addComponent(txtPesquisaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(botaoCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addComponent(jBPesquisaRes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBFecharPesquisa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(lblTituloPainel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSePesquisaLayout.setVerticalGroup(
            jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSePesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPainel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoCategoria)
                                .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoNomeArtista)
                                .addComponent(txtPesquisaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBPesquisaRes)
                            .addComponent(jBFecharPesquisa)
                            .addComponent(jToggleButton1)))
                    .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoTitulo)
                        .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSMostraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("*Clique em cima da obra para vizualizar os detalhes e editar.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelSePesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanelSePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que abre o painelDeRegistro
    private void jBFecharPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharPesquisaActionPerformed
        PainelDeRegistro pcad = new PainelDeRegistro();
        jTelaPrincipal.add(pcad);
        pcad.setTitle("Editar Obra de Arte");
        pcad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBFecharPesquisaActionPerformed

    /** Método que Mostra a Tabela
     *    Descrição:
     *      O método abre uma tabela que apresenta os dados de cada obra
     *      registrada no acervo do museu. Isso ocorre logo após o usuário
     *      apertar o botão no menu relativo ao painel de pesquisa.
     */
    
    
    /**
     * Evento que pega o botão selecionado e o campo preencido, 
     * e de acordo com o que estava dentro deles, faz uma varredura na lista,
     * e mostra todas as Artes que cotem campos iguais aos pesquisado  
     */
    private void jBPesquisaResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisaResActionPerformed
       
        if (botaoTitulo.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (txtPesquisaNome.getText().equals(a.getTitulo())) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }
        if (botaoNomeArtista.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (txtPesquisaArtista.getText().equals(a.getNome())) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }
        if (botaoCategoria.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (a.getCategoria().equals(String.valueOf(cbCategoriaPesquisa.getSelectedItem()))) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }

        
    }//GEN-LAST:event_jBPesquisaResActionPerformed

    /** Evento do Clique do Mouse na Linha de Tabela
     *    Descrição:
     *      Após um clique em uma das linhas da tabela, é aberto em uma janela
     *      todas as informações sobre a obra de arte.
     */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        PainelDeAmostra frame = new PainelDeAmostra(p.getArte(jTable1.rowAtPoint(evt.getPoint())).getTombo());
        jTelaPrincipal.add(frame);
        frame.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        atualiza_Arte();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void botaoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTituloActionPerformed
        if(botaoTitulo.isSelected()){
        txtPesquisaNome.setEnabled(true);
        txtPesquisaArtista.setEnabled(false);
        cbCategoriaPesquisa.setEnabled(false);
        }if(botaoTitulo.isSelected() == false){
        txtPesquisaArtista.setEnabled(true);
        cbCategoriaPesquisa.setEnabled(true);
        }
    }//GEN-LAST:event_botaoTituloActionPerformed

    private void botaoNomeArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNomeArtistaActionPerformed
       if(botaoNomeArtista.isSelected()){
        txtPesquisaArtista.setEnabled(true);
        txtPesquisaNome.setEnabled(false);
        cbCategoriaPesquisa.setEnabled(false);
        }if(botaoNomeArtista.isSelected() == false){
        txtPesquisaNome.setEnabled(true);
        cbCategoriaPesquisa.setEnabled(true);
        }
    }//GEN-LAST:event_botaoNomeArtistaActionPerformed

    private void botaoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCategoriaActionPerformed
        if(botaoCategoria.isSelected()){
        cbCategoriaPesquisa.setEnabled(true);
        txtPesquisaArtista.setEnabled(false);
        txtPesquisaNome.setEnabled(false);
        }
        if(botaoCategoria.isSelected() == false){
        txtPesquisaArtista.setEnabled(true);
        txtPesquisaNome.setEnabled(true);
        }
    }//GEN-LAST:event_botaoCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botaoCategoria;
    private javax.swing.JRadioButton botaoNomeArtista;
    private javax.swing.JRadioButton botaoTitulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCategoriaPesquisa;
    private javax.swing.JButton jBFecharPesquisa;
    private javax.swing.JButton jBPesquisaRes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelSePesquisa;
    private javax.swing.JScrollPane jSMostraPesquisa;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblTituloPainel;
    private javax.swing.JTextField txtPesquisaArtista;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables
    
    private static Persistencia p = new Persistencia();
    private LinkedList<Arte> cad = new LinkedList<Arte>();
    
}
