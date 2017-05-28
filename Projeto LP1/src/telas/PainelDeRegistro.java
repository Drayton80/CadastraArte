package telas;

import estruturas.Persistencia;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import estruturas.Arte;
import estruturas.ManipularImagem;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import exceções.*;
import java.util.LinkedList;

/** Painel de Cadastro de Obras de Artes
 *    descrição:
 *      Esse painel possuí tudo acerca do cadastro de uma obra de arte
 *      efetuado no acervo do museu.
 * 
 *    @author Grupo 06
 *      alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */

public class PainelDeRegistro extends javax.swing.JInternalFrame {

    //CONSTRUTORES:
    /** Construtor para o Painel de Cadastro
     *    Descrição:
     *      Abre o arquivo para Cadastrar uma nova obra de arte no acervo do 
     *      museu. 
     */
    public PainelDeRegistro() {
        p.setupLer();
        if (p.getContinua() == true ){
            p.readRecords();
            p.cleanupLer();
            cad = p.getCad();
        }
        initComponents();
    }
    
    /** Construtor para o Painel de Edição
     *    Descrição:
     *      Abre o arquivo para Editar uma obra de arte do acervo do museu.
     * 
     *    Observação:
     *      Foi feito através de um construtor sobrecarregado para que o
     *      programa ficasse mais eficiente ao reduzir en um painel o que
     *      seria feito em dois (Painel de Cadastro e Painel de Edição
     *      tornaram-se o Painel de Registro.
     */
    public PainelDeRegistro(int tombo) {        
        p.setupLer();
        if(p.getContinua() == true){
            p.readRecords();
            p.cleanupLer();
            cad = p.getCad();
            
        }
        painelEditor = true;
        t = tombo;
        initComponents();
        preenche_campos(tombo);
    }
    
    
  //MÉTODOS QUE PERCORREM A COLEÇÃO:
    /** Método que Checa se há Números de Tombos Repetidos
     *    Descrição:
     *      O método verifica se o número de tombo de uma obra de arte que
     *      vai ser cadastrada é igual ao de outra. Se o número for igual
     *      ela retorna um valor true do tipo boolean.
     */
    private boolean existeNaListaTombo(int tomb) {
        for (Arte a : p.getCad()) {
            if (a.getTombo() == tomb) {
                return true;
            }
        }
        return false;
    }
    
    /** Método que Checa se há Título de Obras Repetidos
     *    Descrição:
     *      O método verifica se o título de uma obra de arte que
     *      vai ser cadastrada é igual ao de outra. Se o nome for igual
     *      ela retorna um valor true do tipo boolean.
     */
    private boolean existeNaListaTitulo(String titulo) {
        for (Arte a : p.getCad()) {
            if (a.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }
    
    /** Método que Checa se há Registros Repetidos
     *    Descrição:
     *      O método percorre toda a coleção em busca de se há algum registro
     *      igual ao que será registrado, se sim ele verificará se esse registro
     *      pertence a um artista com o nome diferente daquele que será 
     *      cadastrado. Se ambas as condições forem verdades o método
     *      retornará um valor true do tipo boolean.
     * 
     *    Observação:
     *      Dois artistas diferentes podem conter o mesmo nome, mas não o mesmo
     *      registro, ou seja, o registro é o que diferencia cada artista.
     */
    private boolean registro_repetido(String a, String b){
        for (Arte c : cad){
            if( (a.equals(c.getRegistro())) && (!b.equals(c.getNome())) ){
                return true;
            }
        } return false;
    }
    
    
  //MÉTODOS RELATIVOS AOS CAMPOS DE CADASTRO:
    /** Método que Testa os Campos de Texto
     *    Descrição:
     *      O método avalia todos os campos obrigatórios para checar 
     *      se há algum aonde o usuário não digitou ou selecionou qualquer
     *      coisa e retorna um valor do tipo boolean: 
     *        - true  (caso tenha algum campo obrigatório sem algo)
     *           ou
     *        - false (caso todos estejam preenchidos ou selecionados)
     *    Observação:
     *      Os campos obrigatórios foram marcados com asteriscos ( * ) na 
     *      interface.
     */
    private boolean teste_dos_campos(){
        String txtTitulo = txtTituloObra.getText();
        String txtAno = formatTxtAno.getText();
        String txtNome = txtNomeArtista.getText();
        String txtRegistro = txtResArtista.getText();
        String txtOrigem = txtOrigemProcedencia.getText();
        String txtCategoria = (String) cbCategoria.getSelectedItem();
        String txtProcedencia = (String) cbProcedencia.getSelectedItem();
        
        if(txtTitulo.equals("")   || txtAno.equals("")    || txtNome.equals("")               ||
           txtRegistro.equals("") || txtOrigem.equals("") || txtCategoria.equals("Selecione") ||
           labelImagem1.getIcon().equals(null) || txtProcedencia.equals("Selecione")){    
           return true;
        }else{
            return false;
        }
    }
    
    /** Método que Limpa todos os Campos
     *    Descrição:
     *      O método retorna todos os campos de texto (TextField), 
     *      campos formatados (FormattedTextField), caixas de combinação (ComboBox)
     *      e caixas de seleção (CheckBox) da janela para o estado inicial aonde
     *      todas estavam em sem qualquer detalhe selecionado e/ou marcado.
     */
    private void limpa_campos(){
        txtNomeArtista.setText("");
        txtOrigemProcedencia.setText("");
        txtResArtista.setText("");
        txtTempoPeriodoProducao.setText("");
        txtTituloObra.setText("");
        formatTxtAno.setText("");
        checkbIndeterminado.setSelected(false);
        cbCategoria.setSelectedIndex(0);
        cbProcedencia.setSelectedIndex(0);
    }
    
    /** Método que Preenche todos os Campos
     *    Descrição:
     *      O método preenche todos os campos de texto (TextField), 
     *      campos formatados (FormattedTextField), caixas de combinação 
     *      (ComboBox) e caixas de seleção (CheckBox) da janela com os 
     *      dados da Obra de Arte que será editada no acervo do museu.
     */
    private void preenche_campos(int tombo){
        for (Arte a : cad) {
            if (a.getTombo() == tombo) {
                txtNomeArtista.setText(a.getNome());
                txtOrigemProcedencia.setText(a.getOrigem());
                txtResArtista.setText(a.getRegistro());
                txtTituloObra.setText(a.getTitulo());
                formatTxtAno.setText(String.valueOf(a.getAno()));
                checkbIndeterminado.setSelected(a.getValorIndeterminado());
                cbCategoria.setSelectedIndex(a.getIndiceCategoria());
                cbProcedencia.setSelectedIndex(a.getIndiceProcedencia());
                ManipularImagem.exibiImagemLabel(a.getImagem(),labelImagem1);
                
                if(a.getValorIndeterminado()){
                    txtTempoPeriodoProducao.setText("");
                }else{
                    txtTempoPeriodoProducao.setText(a.getPeriodoProducao());
                }
            }
        }
    }
    
    
  //MÉTODOS DE EDIÇÃO DE FORMATO:
    /** Método que Edita o Formato do Ano
     *    Descrição:
     *      O método cria um formato que limita o que será escrito em um
     *      campo de texto para que restrinja-o a apenas 4 caracteres
     *      onde será apenas possível digitar números.
     *    Créditos:
     *      O código original foi disponibilizado pela professora Daniela Coelho
     *      no programa da aula prática da lista de exercícios número 4.
     */
    public static DefaultFormatterFactory setFormatoAno() {  
        MaskFormatter comFoco = null;  
        
        try{   
            comFoco = new MaskFormatter("####");  
        }catch (Exception pe) { }
        
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);  
        return factory;  
    }
    
    /** Método que Edita o Formato do Registro
     *    Descrição:
     *      O método cria um formato que limita o que será escrito em um
     *      campo de texto para que restrinja-o a apenas 8 caracteres
     *      onde será apenas possível digitar números.
     *    Créditos:
     *      O código original foi disponibilizado pela professora Daniela Coelho
     *      no programa da aula prática da lista de exercícios número 4.
     */
    public static DefaultFormatterFactory setFormatoRegistro() {  
        MaskFormatter comFoco = null;  
        
        try{   
            comFoco = new MaskFormatter("########");  
        }catch (Exception pe) { }
        
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);  
        return factory;  
    }
    
    
  //OUTROS MÉTODOS:
    /** Método que Retorna um Objeto do tipo Arte
     *    Descrição:
     *      O método pega todos os dados registrados pelo usuário nos campos
     *      dispostos para tal e retorna um objeto do tipo Arte aonde esses
     *      dados estarão guardados.
     */
    private Arte retorna_arte(){    
        String txtPeriodo = txtTempoPeriodoProducao.getText();
        
        try {
            if(teste_dos_campos()){
                throw new CampoVazio();
            }
            
            if(registro_repetido(txtResArtista.getText(), txtNomeArtista.getText())){
                throw new DadoRepetido();
            }
            
            if(txtPeriodo.equals("") || checkbIndeterminado.isSelected()){
                txtPeriodo = "Indeterminado";
            }
            
            Arte obra = new Arte(txtTituloObra.getText(), txtNomeArtista.getText(),
                                txtResArtista.getText(), Integer.parseInt(formatTxtAno.getText()), 
                                 String.valueOf(cbCategoria.getSelectedItem()), txtPeriodo,
                                 String.valueOf(cbProcedencia.getSelectedItem()),
                                 txtOrigemProcedencia.getText(), ManipularImagem.getImgBytes(img));
            
            obra.setIndiceCategoria(cbCategoria.getSelectedIndex());
            obra.setIndiceProcedencia(cbProcedencia.getSelectedIndex());
            obra.setValorIndeterminado(checkbIndeterminado.isSelected());
            
            return obra;
            
        }catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível registrar a obra de arte, pois um dos" + "\n" +
                                                    "valores cadastrados não é válido.                     "        ,
                                                    "Aviso", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch (CampoVazio n){
            JOptionPane.showMessageDialog(rootPane, "Não foi possível registrar a obra de arte, pois um dos" + "\n" +
                                                    "Campos Obrigatórios não foi preenchido ou selecionado."        ,
                                                    "Aviso", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch (DadoRepetido n){
            JOptionPane.showMessageDialog(rootPane, "Não foi possível registrar a obra de arte, pois o" + "\n" +
                                                    "Registro do Artista já foi Cadastrado no nome de " + "\n" +
                                                    "de outro artista.", "Aviso", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /** Método que Fecha a Janela Aberta
     *    Descrição:
     *      O método simplesmente fecha por completo a janela aberta no momento
     *      em que ele é chamado.
     */
    private void fecha_janela() {
        this.dispose();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jRadioButton1 = new javax.swing.JRadioButton();
        labelImagem = new javax.swing.JLabel();
        jPanelCadastro = new javax.swing.JPanel();
        lblTituloPainel = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAnoProducao = new javax.swing.JLabel();
        lblTempoProducao = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblTituloPainel2 = new javax.swing.JLabel();
        lblNomeArtista = new javax.swing.JLabel();
        lblResArtista = new javax.swing.JLabel();
        lblTituloPainel3 = new javax.swing.JLabel();
        lblTipoProcedencia = new javax.swing.JLabel();
        lblOrigemProcedencia = new javax.swing.JLabel();
        txtTituloObra = new javax.swing.JTextField();
        txtNomeArtista = new javax.swing.JTextField();
        txtOrigemProcedencia = new javax.swing.JTextField();
        txtTempoPeriodoProducao = new javax.swing.JTextField();
        formatTxtAno = new javax.swing.JFormattedTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        cbProcedencia = new javax.swing.JComboBox<>();
        checkbIndeterminado = new javax.swing.JCheckBox();
        jBSelectImagem = new javax.swing.JButton();
        jBCancelarCadastro = new javax.swing.JButton();
        jBSalvarCadastro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtResArtista = new javax.swing.JFormattedTextField();
        labelImagem1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        labelImagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setClosable(true);

        lblTituloPainel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTituloPainel.setText("Informações da Obra");

        lblTitulo.setText("Título da Obra:*");

        lblAnoProducao.setText("Ano de Produção:*");

        lblTempoProducao.setText("Período de Produção:");

        lblCategoria.setText("Categoria:*");

        lblTituloPainel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTituloPainel2.setText("Informações do Artista");

        lblNomeArtista.setText("Nome do Artista:*");

        lblResArtista.setText("Registro do Artista:*");

        lblTituloPainel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTituloPainel3.setText("Informações da Procedência");

        lblTipoProcedencia.setText("Tipo de Procedência:*");

        lblOrigemProcedencia.setText("Origem da Procedência:*");

        txtTituloObra.setToolTipText("Digite o Título da Obra.");

        txtNomeArtista.setToolTipText("Nome do Artista que produziu a Obra de Arte.");

        txtOrigemProcedencia.setToolTipText("Digite o Local de onde a obra de arte foi adquirida.");

        txtTempoPeriodoProducao.setToolTipText("Digite quantos anos foram necessário para a conclusão da Obra.");
        txtTempoPeriodoProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoPeriodoProducaoActionPerformed(evt);
            }
        });

        formatTxtAno.setFormatterFactory(setFormatoAno());
        formatTxtAno.setToolTipText("Coloque o ano em que a Obra foi produzida.");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Álbum", "Aquarela", "Colagem", "Desenho", "Escultura", "Foto", "Gravura", "Impressão", "Instalação", "Livro", "Múltiplo", "Objeto", "ObraDesinc", "Perform", "Pintura", "Relevo", "Tapeçaria", "Vídeo" }));
        cbCategoria.setToolTipText("Selecione a Categoria em que a Obra se encaixa.");

        cbProcedencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Aquisição", "Comodato", "Doação", "Espólio", "Legado", "Prêmio" }));
        cbProcedencia.setToolTipText("Selecione a forma como essa Obra de Arte foi adquirida.");
        cbProcedencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProcedenciaActionPerformed(evt);
            }
        });

        checkbIndeterminado.setText("Indeterminado");
        checkbIndeterminado.setToolTipText("Selecione está caixa caso não possua dados do tempo necessário para a produção da Obra.");
        checkbIndeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbIndeterminadoActionPerformed(evt);
            }
        });

        jBSelectImagem.setText("Selecionar Imagem");
        jBSelectImagem.setToolTipText("Importar imagem da Obra.");
        jBSelectImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelectImagemActionPerformed(evt);
            }
        });

        jBCancelarCadastro.setText("Cancelar");
        jBCancelarCadastro.setToolTipText("Cancelar cadastro de Obra de Arte.");
        jBCancelarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCancelarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarCadastroActionPerformed(evt);
            }
        });

        jBSalvarCadastro.setBackground(new java.awt.Color(0, 102, 102));
        jBSalvarCadastro.setText("Salvar");
        jBSalvarCadastro.setToolTipText("Confirmar dados.");
        jBSalvarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSalvarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarCadastroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setText("* são campos que devem ser preenchidos ou selecionados obrigatoriamente.");

        txtResArtista.setFormatterFactory(setFormatoRegistro());
        txtResArtista.setToolTipText("Digite o Registro Profissional do artista.");

        labelImagem1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setText("N/A imagem dispovivel");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Atribuir Imagem");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblResArtista)
                                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(lblNomeArtista))
                                        .addComponent(lblTipoProcedencia, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtResArtista, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbProcedencia, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE))
                                    .addComponent(txtNomeArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTituloPainel)
                                    .addComponent(lblTituloPainel2)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(lblOrigemProcedencia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtOrigemProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTituloPainel3)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblTempoProducao)
                                            .addComponent(lblCategoria))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                                                .addComponent(checkbIndeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTempoPeriodoProducao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)))))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jBSalvarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBCancelarCadastro)
                                .addGap(170, 170, 170))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblAnoProducao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formatTxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTituloObra, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadastroLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBSelectImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(labelImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSelectImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloPainel)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTituloObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatTxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnoProducao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoProducao)
                    .addComponent(checkbIndeterminado)
                    .addComponent(txtTempoPeriodoProducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria))
                .addGap(18, 18, 18)
                .addComponent(lblTituloPainel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeArtista)
                    .addComponent(txtNomeArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResArtista)
                    .addComponent(txtResArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTituloPainel3)
                .addGap(29, 29, 29)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoProcedencia)
                    .addComponent(cbProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigemProcedencia)
                    .addComponent(txtOrigemProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvarCadastro)
                    .addComponent(jBCancelarCadastro))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /** Botão de Selecionar Imagem
     *    Descrição:
     *     Abre a janela de pesquisa para a busca da imagem que será salva
     *     junto aos demais dados da obra de arte.
     */
    private void jBSelectImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelectImagemActionPerformed
        if(jCheckBox1.isSelected() == false){
            if(jBusca.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){ //Verifica se o formato do arquivo é valido
                File imagem = jBusca.getSelectedFile();
                try{
                    /*Salvamos esses dados 
                    como uma imagem dentro 
                    do java que estará presente em todo o cadastro*/
                    img = ManipularImagem.setImagemDimensao(imagem.getAbsolutePath(), 160, 160); 
                    labelImagem1.setIcon(new ImageIcon(img));//Coloca a imagem salva no label "ImgMostrada" para receber imagem aqui
                    
             } catch (Exception ex) {//Exceção gerada caso o arquvo selecionado seja inválido
                JOptionPane.showMessageDialog(rootPane, "Arquivo Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } 
            
            else {//Caso não selecione nenhum arquivo jCheckBox1.isSelected 
            JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo.");
            img = ManipularImagem.setImagemDimensao("src\\imagens\\Not_available.jpg", 160, 160);
            labelImagem1.setIcon(new ImageIcon(img));
        }
        }
    }//GEN-LAST:event_jBSelectImagemActionPerformed

    /** Botão de Cancelar
     *    Descrição:
     *     Ao apertar o botão o procedimento será cancelado.
     */
    private void jBCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarCadastroActionPerformed
        fecha_janela();
    }//GEN-LAST:event_jBCancelarCadastroActionPerformed
    
    /** Botão de Salvar
     *    Descrição:
     *     Ao apertar o botão o objeto será salvo no arquivo.
     */
    private void jBSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarCadastroActionPerformed
    if(painelEditor ==  false){
        Arte verifica = retorna_arte();
        if (null != verifica) {
                Arte a = verifica; 
                System.out.println(a.toString());
                if (!existeNaListaTombo(a.getTombo())) {
                    p.getCad().add(a);
                    p.setupGravar();
                    p.addRecords(cad); // Adciona um produto a lista.
                    p.cleanupGravar();        // Fecha o arquivo           

                    JOptionPane.showMessageDialog(rootPane, "Arte Cadastrada com Sucesso.");
                    limpa_campos();                
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tombo da Arte já Cadastrado.", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
                } 
    }
            
            if(painelEditor == true){
                for(Arte e : cad){
                     if (t == e.getTombo()) {
                        e.setTitulo(txtTituloObra.getText()); //Tá pegando o título
                        e.setAno(Integer.parseInt(formatTxtAno.getText()));
                        e.setPeriodoProducao(txtTempoPeriodoProducao.getText());
                        e.setCategoria(String.valueOf(cbCategoria.getSelectedItem()));
                        e.setNome(txtNomeArtista.getText());
                        e.setRegistro(txtResArtista.getText());
                        e.setProcedencia(String.valueOf(cbProcedencia.getSelectedItem()));
                        e.setOrigem(txtOrigemProcedencia.getText());
                        e.setImagem(ManipularImagem.getImgBytes(img));
                        p.setupGravar();
                        p.addRecords(cad);          // Adciona um produto a lista.
                        p.cleanupGravar();          // Fecha o arquivo           

                        JOptionPane.showMessageDialog(rootPane, "Produto Cadastrado com Sucesso.");
                        limpa_campos();
                    }
                }
                painelEditor = false;
            }
    }//GEN-LAST:event_jBSalvarCadastroActionPerformed

    private void checkbIndeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbIndeterminadoActionPerformed
        if(checkbIndeterminado.isSelected()){
            txtTempoPeriodoProducao.setEnabled(false);
        }
        else{
            txtTempoPeriodoProducao.setEnabled(true);
        }
    }//GEN-LAST:event_checkbIndeterminadoActionPerformed

    private void cbProcedenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProcedenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProcedenciaActionPerformed

    private void txtTempoPeriodoProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoPeriodoProducaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoPeriodoProducaoActionPerformed

//Fazer comentário
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            img = ManipularImagem.setImagemDimensao("src\\imagens\\Not_available.jpg", 160, 160);
            labelImagem1.setIcon(new ImageIcon(img));
            jBSelectImagem.setEnabled(false);
        }
        else{
            jBSelectImagem.setEnabled(true);
            labelImagem1.setIcon(null);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbProcedencia;
    private javax.swing.JCheckBox checkbIndeterminado;
    private javax.swing.JFormattedTextField formatTxtAno;
    private javax.swing.JButton jBCancelarCadastro;
    private javax.swing.JButton jBSalvarCadastro;
    private javax.swing.JButton jBSelectImagem;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelImagem1;
    private javax.swing.JLabel lblAnoProducao;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNomeArtista;
    private javax.swing.JLabel lblOrigemProcedencia;
    private javax.swing.JLabel lblResArtista;
    private javax.swing.JLabel lblTempoProducao;
    private javax.swing.JLabel lblTipoProcedencia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloPainel;
    private javax.swing.JLabel lblTituloPainel2;
    private javax.swing.JLabel lblTituloPainel3;
    private javax.swing.JTextField txtNomeArtista;
    private javax.swing.JTextField txtOrigemProcedencia;
    private javax.swing.JFormattedTextField txtResArtista;
    private javax.swing.JTextField txtTempoPeriodoProducao;
    private javax.swing.JTextField txtTituloObra;
    // End of variables declaration//GEN-END:variables
    //Outros Atributos:
    private static Persistencia p = new Persistencia();
    private LinkedList<Arte> cad = new LinkedList<Arte>();
    private static boolean painelEditor = false;
    private static int t = 0;
    private BufferedImage img;
    JFileChooser jBusca = new JFileChooser();
  //Passamos os dados dessa imagem a uma variável do tipo File
    //Fim dos Atribudos;
}
