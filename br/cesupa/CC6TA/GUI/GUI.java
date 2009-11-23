package br.cesupa.CC6TA.GUI;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
        jPanda.setVisible(false);
        jPseta.setVisible(false);
        for(int x=0; x<4;x++){
            for(int y=0; y<4;y++){
                jogo[x][y]="nada";
            }
        }
        jogo[0][0]="Personagem";
    }
    
    public void cima(){
        int[] posicao = new int[2];
        posicao=agente.encontra(jogo, "Personagem");
        if(posicao[1]+1>=0&&posicao[1]+1<=3){
        mudaCasas(posicao[0],posicao[1]+1);
        }else{
            JOptionPane.showMessageDialog(null, "Ação Impossivel!!");
        }
    }
    
    public void baixo(){
        int[] posicao = new int[2];
        posicao=agente.encontra(jogo, "Personagem");
        if(posicao[1]-1>=0&&posicao[1]-1<=3){
        mudaCasas(posicao[0],posicao[1]-1);
        }else{
            JOptionPane.showMessageDialog(null, "Ação Impossivel!!");
        }
    }
    
    public void esquerda(){
        int[] posicao = new int[2];
        posicao=agente.encontra(jogo, "Personagem");
        if(posicao[0]-1>=0&&posicao[0]-1<=3){
        mudaCasas(posicao[0]-1,posicao[1]);
        }else{
            JOptionPane.showMessageDialog(null, "Ação Impossivel!!");
        }
    }
    
    public void direita(){
        int[] posicao = new int[2];
        posicao=agente.encontra(jogo, "Personagem");
        if(posicao[0]+1>=0&&posicao[0]+1<=3){
        mudaCasas(posicao[0]+1,posicao[1]);
        }else{
            JOptionPane.showMessageDialog(null, "Ação Impossivel!!");
        }
    }
    
    Casas casas = new Casas();
    Agente agente = new Agente();
    int cont=0;
    String[][] jogo = new String[4][4];
    
    public void andaGente(String objeto, int x, int y){
        jogo[x][y]=objeto;
        ImageIcon imagem = new ImageIcon("C:\\Users\\Roberto Franco\\Documents\\NetBeansProjects\\wumpus\\src\\br\\cesupa\\CC6TA\\GUI\\imagens\\"+objeto+".jpg");
        int uniao = Integer.parseInt(""+x+""+y);
        switch(uniao){
            case 00:{
                jL00.setIcon(imagem);
                break;
            }
            case 01:{
                jL01.setIcon(imagem);
                break;
            }
            case 02:{
                jL02.setIcon(imagem);
                break;
            }
            case 03:{
                jL03.setIcon(imagem);
                break;
            }
            case 10:{
                jL10.setIcon(imagem);
                break;
            }
            case 11:{
                jL11.setIcon(imagem);
                break;
            }
            case 12:{
                jL12.setIcon(imagem);
                break;
            }
            case 13:{
                jL13.setIcon(imagem);
                break;
            }
            case 20:{
                jL20.setIcon(imagem);
                break;
            }
            case 21:{
                jL21.setIcon(imagem);
                break;
            }
            case 22:{
                jL22.setIcon(imagem);
                break;
            }
            case 23:{
                jL23.setIcon(imagem);
                break;
            }
            case 30:{
                jL30.setIcon(imagem);
                break;
            }
            case 31:{
                jL31.setIcon(imagem);
                break;
            }
            case 32:{
                jL32.setIcon(imagem);
                break;
            }
            case 33:{
                jL33.setIcon(imagem);
                break;
            }
        }
    }
    
    public void mudaCasas(int x, int y){
        int[] posicao = new int[2];
        posicao=agente.encontra(jogo, "Personagem");
        if(jogo[x][y].equalsIgnoreCase("nada")){
            andaGente("Personagem",x,y);
            andaGente("nada",posicao[0],posicao[1]);
        }else if(jogo[x][y].equalsIgnoreCase("Wumpus")){
            JOptionPane.showMessageDialog(null, "iiiiiiiiii o WUMPUS comeu você!!!");
        }else if(jogo[x][y].equalsIgnoreCase("Ouro")){
            JOptionPane.showMessageDialog(null, "ebaaaaaaaa!!! Você encontrou o ouro!!!");
        }else if(jogo[x][y].equalsIgnoreCase("Buraco")){
            JOptionPane.showMessageDialog(null, "aaaaaaaaaah!!! Você caiu no buraco!!!");
        }
    }
    
    public void apagaJCB(int y){
        cont++;
        JOptionPane.showMessageDialog(null, "Você já inseriu todos o personagens!");
        jCB03.setVisible(false);
        jCB02.setVisible(false);
        jCB01.setVisible(false);
        jCB13.setVisible(false);
        jCB12.setVisible(false);
        jCB11.setVisible(false);
        jCB10.setVisible(false);
        jCB23.setVisible(false);
        jCB22.setVisible(false);
        jCB21.setVisible(false);
        jCB20.setVisible(false);
        jCB33.setVisible(false);
        jCB32.setVisible(false);
        jCB31.setVisible(false);
        jCB30.setVisible(false);
        
        jPanda.setVisible(true);
        jPseta.setVisible(true);
    }
    
    public ComboBoxModel geraJCB(Object[] objeto){
        ComboBoxModel newlista = new DefaultComboBoxModel(objeto);
        return newlista;
    }
    
    public ImageIcon recarregaJCB(int x, int y, String objeto){
        jogo[x][y]=objeto;
        ImageIcon imagem = new ImageIcon("C:\\Users\\Roberto Franco\\Documents\\NetBeansProjects\\wumpus\\src\\br\\cesupa\\CC6TA\\GUI\\imagens\\"+objeto+".jpg");
        Object[] newlista = casas.replicaModel(objeto);
        
        jCB01.setModel(geraJCB(newlista));
        jCB02.setModel(geraJCB(newlista));
        jCB03.setModel(geraJCB(newlista));
        jCB10.setModel(geraJCB(newlista));
        jCB11.setModel(geraJCB(newlista));
        jCB12.setModel(geraJCB(newlista));
        jCB13.setModel(geraJCB(newlista));
        jCB20.setModel(geraJCB(newlista));
        jCB21.setModel(geraJCB(newlista));
        jCB22.setModel(geraJCB(newlista));
        jCB23.setModel(geraJCB(newlista));
        jCB30.setModel(geraJCB(newlista));
        jCB31.setModel(geraJCB(newlista));
        jCB32.setModel(geraJCB(newlista));
        jCB33.setModel(geraJCB(newlista));
        
        return imagem;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP33 = new javax.swing.JPanel();
        jL33 = new javax.swing.JLabel();
        jCB33 = new javax.swing.JComboBox();
        jP03 = new javax.swing.JPanel();
        jL03 = new javax.swing.JLabel();
        jCB03 = new javax.swing.JComboBox();
        jP02 = new javax.swing.JPanel();
        jL02 = new javax.swing.JLabel();
        jCB02 = new javax.swing.JComboBox();
        jP01 = new javax.swing.JPanel();
        jL01 = new javax.swing.JLabel();
        jCB01 = new javax.swing.JComboBox();
        jP00 = new javax.swing.JPanel();
        jL00 = new javax.swing.JLabel();
        jP10 = new javax.swing.JPanel();
        jL10 = new javax.swing.JLabel();
        jCB10 = new javax.swing.JComboBox();
        jP11 = new javax.swing.JPanel();
        jL11 = new javax.swing.JLabel();
        jCB11 = new javax.swing.JComboBox();
        jP12 = new javax.swing.JPanel();
        jL12 = new javax.swing.JLabel();
        jCB12 = new javax.swing.JComboBox();
        jP13 = new javax.swing.JPanel();
        jL13 = new javax.swing.JLabel();
        jCB13 = new javax.swing.JComboBox();
        jP20 = new javax.swing.JPanel();
        jL20 = new javax.swing.JLabel();
        jCB20 = new javax.swing.JComboBox();
        jP21 = new javax.swing.JPanel();
        jL21 = new javax.swing.JLabel();
        jCB21 = new javax.swing.JComboBox();
        jP22 = new javax.swing.JPanel();
        jL22 = new javax.swing.JLabel();
        jCB22 = new javax.swing.JComboBox();
        jP23 = new javax.swing.JPanel();
        jL23 = new javax.swing.JLabel();
        jCB23 = new javax.swing.JComboBox();
        jP30 = new javax.swing.JPanel();
        jL30 = new javax.swing.JLabel();
        jCB30 = new javax.swing.JComboBox();
        jP31 = new javax.swing.JPanel();
        jL31 = new javax.swing.JLabel();
        jCB31 = new javax.swing.JComboBox();
        jP32 = new javax.swing.JPanel();
        jL32 = new javax.swing.JLabel();
        jCB32 = new javax.swing.JComboBox();
        jPanda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCBx = new javax.swing.JComboBox();
        jCBy = new javax.swing.JComboBox();
        jPseta = new javax.swing.JPanel();
        jBc = new javax.swing.JButton();
        jBe = new javax.swing.JButton();
        jBd = new javax.swing.JButton();
        jBb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(70, 70));
        setResizable(false);

        jP33.setBackground(new java.awt.Color(255, 255, 255));
        jP33.setAlignmentX(0.0F);
        jP33.setAlignmentY(0.0F);
        jP33.setMaximumSize(new java.awt.Dimension(100, 100));
        jP33.setMinimumSize(new java.awt.Dimension(100, 100));
        jP33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL33.setMaximumSize(new java.awt.Dimension(70, 70));
        jL33.setMinimumSize(new java.awt.Dimension(70, 70));
        jL33.setPreferredSize(new java.awt.Dimension(70, 70));
        jP33.add(jL33, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB33.setModel(casas.criaModel());
        jCB33.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB33.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB33.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB33ActionPerformed(evt);
            }
        });
        jP33.add(jCB33, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP03.setBackground(new java.awt.Color(255, 255, 255));
        jP03.setAlignmentX(0.0F);
        jP03.setAlignmentY(0.0F);
        jP03.setMaximumSize(new java.awt.Dimension(100, 100));
        jP03.setMinimumSize(new java.awt.Dimension(100, 100));
        jP03.setPreferredSize(new java.awt.Dimension(100, 100));
        jP03.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL03.setMaximumSize(new java.awt.Dimension(70, 70));
        jL03.setMinimumSize(new java.awt.Dimension(70, 70));
        jL03.setPreferredSize(new java.awt.Dimension(70, 70));
        jP03.add(jL03, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB03.setModel(casas.criaModel());
        jCB03.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB03.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB03.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB03ActionPerformed(evt);
            }
        });
        jP03.add(jCB03, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP02.setBackground(new java.awt.Color(255, 255, 255));
        jP02.setAlignmentX(0.0F);
        jP02.setAlignmentY(0.0F);
        jP02.setMaximumSize(new java.awt.Dimension(100, 100));
        jP02.setMinimumSize(new java.awt.Dimension(100, 100));
        jP02.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL02.setMaximumSize(new java.awt.Dimension(70, 70));
        jL02.setMinimumSize(new java.awt.Dimension(70, 70));
        jL02.setPreferredSize(new java.awt.Dimension(70, 70));
        jP02.add(jL02, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB02.setModel(casas.criaModel());
        jCB02.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB02.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB02.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB02ActionPerformed(evt);
            }
        });
        jP02.add(jCB02, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP01.setBackground(new java.awt.Color(255, 255, 255));
        jP01.setAlignmentX(0.0F);
        jP01.setAlignmentY(0.0F);
        jP01.setMaximumSize(new java.awt.Dimension(100, 100));
        jP01.setMinimumSize(new java.awt.Dimension(100, 100));
        jP01.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL01.setMaximumSize(new java.awt.Dimension(70, 70));
        jL01.setMinimumSize(new java.awt.Dimension(70, 70));
        jL01.setPreferredSize(new java.awt.Dimension(70, 70));
        jP01.add(jL01, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB01.setModel(casas.criaModel());
        jCB01.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB01.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB01.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB01ActionPerformed(evt);
            }
        });
        jP01.add(jCB01, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP00.setBackground(new java.awt.Color(255, 255, 255));
        jP00.setAlignmentX(0.0F);
        jP00.setAlignmentY(0.0F);
        jP00.setMaximumSize(new java.awt.Dimension(100, 100));
        jP00.setMinimumSize(new java.awt.Dimension(100, 100));
        jP00.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL00.setIcon(new javax.swing.ImageIcon("C:\\Users\\Roberto Franco\\Documents\\NetBeansProjects\\wumpus\\src\\br\\cesupa\\CC6TA\\GUI\\imagens\\Personagem.jpg")); // NOI18N
        jL00.setMaximumSize(new java.awt.Dimension(70, 70));
        jL00.setMinimumSize(new java.awt.Dimension(70, 70));
        jL00.setPreferredSize(new java.awt.Dimension(70, 70));
        jP00.add(jL00, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jP10.setBackground(new java.awt.Color(255, 255, 255));
        jP10.setAlignmentX(0.0F);
        jP10.setAlignmentY(0.0F);
        jP10.setMaximumSize(new java.awt.Dimension(100, 100));
        jP10.setMinimumSize(new java.awt.Dimension(100, 100));
        jP10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL10.setMaximumSize(new java.awt.Dimension(70, 70));
        jL10.setMinimumSize(new java.awt.Dimension(70, 70));
        jL10.setPreferredSize(new java.awt.Dimension(70, 70));
        jP10.add(jL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB10.setModel(casas.criaModel());
        jCB10.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB10.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB10.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB10ActionPerformed(evt);
            }
        });
        jP10.add(jCB10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP11.setBackground(new java.awt.Color(255, 255, 255));
        jP11.setAlignmentX(0.0F);
        jP11.setAlignmentY(0.0F);
        jP11.setMaximumSize(new java.awt.Dimension(100, 100));
        jP11.setMinimumSize(new java.awt.Dimension(100, 100));
        jP11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL11.setMaximumSize(new java.awt.Dimension(70, 70));
        jL11.setMinimumSize(new java.awt.Dimension(70, 70));
        jL11.setPreferredSize(new java.awt.Dimension(70, 70));
        jP11.add(jL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB11.setModel(casas.criaModel());
        jCB11.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB11.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB11.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB11ActionPerformed(evt);
            }
        });
        jP11.add(jCB11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP12.setBackground(new java.awt.Color(255, 255, 255));
        jP12.setAlignmentX(0.0F);
        jP12.setAlignmentY(0.0F);
        jP12.setMaximumSize(new java.awt.Dimension(100, 100));
        jP12.setMinimumSize(new java.awt.Dimension(100, 100));
        jP12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL12.setMaximumSize(new java.awt.Dimension(70, 70));
        jL12.setMinimumSize(new java.awt.Dimension(70, 70));
        jL12.setPreferredSize(new java.awt.Dimension(70, 70));
        jP12.add(jL12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB12.setModel(casas.criaModel());
        jCB12.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB12.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB12.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB12ActionPerformed(evt);
            }
        });
        jP12.add(jCB12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP13.setBackground(new java.awt.Color(255, 255, 255));
        jP13.setAlignmentX(0.0F);
        jP13.setAlignmentY(105.0F);
        jP13.setMaximumSize(new java.awt.Dimension(100, 100));
        jP13.setMinimumSize(new java.awt.Dimension(100, 100));
        jP13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL13.setMaximumSize(new java.awt.Dimension(70, 70));
        jL13.setMinimumSize(new java.awt.Dimension(70, 70));
        jL13.setPreferredSize(new java.awt.Dimension(70, 70));
        jP13.add(jL13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB13.setModel(casas.criaModel());
        jCB13.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB13.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB13.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB13ActionPerformed(evt);
            }
        });
        jP13.add(jCB13, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP20.setBackground(new java.awt.Color(255, 255, 255));
        jP20.setAlignmentX(0.0F);
        jP20.setAlignmentY(0.0F);
        jP20.setMaximumSize(new java.awt.Dimension(100, 100));
        jP20.setMinimumSize(new java.awt.Dimension(100, 100));
        jP20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL20.setMaximumSize(new java.awt.Dimension(70, 70));
        jL20.setMinimumSize(new java.awt.Dimension(70, 70));
        jL20.setPreferredSize(new java.awt.Dimension(70, 70));
        jP20.add(jL20, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB20.setModel(casas.criaModel());
        jCB20.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB20.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB20.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB20ActionPerformed(evt);
            }
        });
        jP20.add(jCB20, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP21.setBackground(new java.awt.Color(255, 255, 255));
        jP21.setAlignmentX(0.0F);
        jP21.setAlignmentY(0.0F);
        jP21.setMaximumSize(new java.awt.Dimension(100, 100));
        jP21.setMinimumSize(new java.awt.Dimension(100, 100));
        jP21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL21.setMaximumSize(new java.awt.Dimension(70, 70));
        jL21.setMinimumSize(new java.awt.Dimension(70, 70));
        jL21.setPreferredSize(new java.awt.Dimension(70, 70));
        jP21.add(jL21, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB21.setModel(casas.criaModel());
        jCB21.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB21.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB21.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB21ActionPerformed(evt);
            }
        });
        jP21.add(jCB21, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP22.setBackground(new java.awt.Color(255, 255, 255));
        jP22.setAlignmentX(0.0F);
        jP22.setAlignmentY(0.0F);
        jP22.setMaximumSize(new java.awt.Dimension(100, 100));
        jP22.setMinimumSize(new java.awt.Dimension(100, 100));
        jP22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL22.setMaximumSize(new java.awt.Dimension(70, 70));
        jL22.setMinimumSize(new java.awt.Dimension(70, 70));
        jL22.setPreferredSize(new java.awt.Dimension(70, 70));
        jP22.add(jL22, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB22.setModel(casas.criaModel());
        jCB22.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB22.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB22.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB22ActionPerformed(evt);
            }
        });
        jP22.add(jCB22, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP23.setBackground(new java.awt.Color(255, 255, 255));
        jP23.setAlignmentX(0.0F);
        jP23.setAlignmentY(0.0F);
        jP23.setMaximumSize(new java.awt.Dimension(100, 100));
        jP23.setMinimumSize(new java.awt.Dimension(100, 100));
        jP23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL23.setMaximumSize(new java.awt.Dimension(70, 70));
        jL23.setMinimumSize(new java.awt.Dimension(70, 70));
        jL23.setPreferredSize(new java.awt.Dimension(70, 70));
        jP23.add(jL23, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB23.setModel(casas.criaModel());
        jCB23.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB23.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB23.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB23ActionPerformed(evt);
            }
        });
        jP23.add(jCB23, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP30.setBackground(new java.awt.Color(255, 255, 255));
        jP30.setAlignmentX(0.0F);
        jP30.setAlignmentY(0.0F);
        jP30.setMaximumSize(new java.awt.Dimension(100, 100));
        jP30.setMinimumSize(new java.awt.Dimension(100, 100));
        jP30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL30.setMaximumSize(new java.awt.Dimension(70, 70));
        jL30.setMinimumSize(new java.awt.Dimension(70, 70));
        jL30.setPreferredSize(new java.awt.Dimension(70, 70));
        jP30.add(jL30, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB30.setModel(casas.criaModel());
        jCB30.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB30.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB30.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB30ActionPerformed(evt);
            }
        });
        jP30.add(jCB30, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP31.setBackground(new java.awt.Color(255, 255, 255));
        jP31.setAlignmentX(0.0F);
        jP31.setAlignmentY(0.0F);
        jP31.setMaximumSize(new java.awt.Dimension(100, 100));
        jP31.setMinimumSize(new java.awt.Dimension(100, 100));
        jP31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL31.setMaximumSize(new java.awt.Dimension(70, 70));
        jL31.setMinimumSize(new java.awt.Dimension(70, 70));
        jL31.setPreferredSize(new java.awt.Dimension(70, 70));
        jP31.add(jL31, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB31.setModel(casas.criaModel());
        jCB31.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB31.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB31.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB31ActionPerformed(evt);
            }
        });
        jP31.add(jCB31, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jP32.setBackground(new java.awt.Color(255, 255, 255));
        jP32.setAlignmentX(0.0F);
        jP32.setAlignmentY(0.0F);
        jP32.setMaximumSize(new java.awt.Dimension(100, 100));
        jP32.setMinimumSize(new java.awt.Dimension(100, 100));
        jP32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL32.setMaximumSize(new java.awt.Dimension(70, 70));
        jL32.setMinimumSize(new java.awt.Dimension(70, 70));
        jL32.setPreferredSize(new java.awt.Dimension(70, 70));
        jP32.add(jL32, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jCB32.setModel(casas.criaModel());
        jCB32.setMaximumSize(new java.awt.Dimension(90, 20));
        jCB32.setMinimumSize(new java.awt.Dimension(90, 20));
        jCB32.setPreferredSize(new java.awt.Dimension(90, 20));
        jCB32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB32ActionPerformed(evt);
            }
        });
        jP32.add(jCB32, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, -1, -1));

        jPanda.setBackground(new java.awt.Color(255, 255, 255));
        jPanda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Anda Agente");
        jPanda.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel2.setText("x:");
        jPanda.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setText("y:");
        jPanda.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jButton1.setText("Andar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanda.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jCBx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));
        jPanda.add(jCBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jCBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));
        jPanda.add(jCBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPseta.setBackground(new java.awt.Color(204, 255, 255));
        jPseta.setMaximumSize(new java.awt.Dimension(100, 100));
        jPseta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBc.setText("C");
        jBc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcActionPerformed(evt);
            }
        });
        jPseta.add(jBc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jBe.setText("E");
        jBe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeActionPerformed(evt);
            }
        });
        jPseta.add(jBe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jBd.setText("D");
        jBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdActionPerformed(evt);
            }
        });
        jPseta.add(jBd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jBb.setText("B");
        jBb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbActionPerformed(evt);
            }
        });
        jPseta.add(jBb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP03, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP02, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP01, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP00, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP23, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP22, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP21, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP20, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP33, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP31, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP32, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jP30, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanda, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPseta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jP03, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP02, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP01, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP00, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jP13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jP33, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jP23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jP32, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jP22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jP31, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jP21, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jP30, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jP20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPseta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB03ActionPerformed
        jL03.setIcon(recarregaJCB(0,3,jCB03.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(1);
        }else{
            jCB03.setVisible(false);
        }
}//GEN-LAST:event_jCB03ActionPerformed

    private void jCB02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB02ActionPerformed
        jL02.setIcon(recarregaJCB(0,2,jCB02.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(2);
        }else {
            jCB02.setVisible(false);
        }
}//GEN-LAST:event_jCB02ActionPerformed

    private void jCB01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB01ActionPerformed
        jL01.setIcon(recarregaJCB(0,1,jCB01.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(3);
        }else {
        jCB01.setVisible(false);
        }
}//GEN-LAST:event_jCB01ActionPerformed

    private void jCB10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB10ActionPerformed
        jL10.setIcon(recarregaJCB(1,0,jCB10.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(4);
        }else {
        jCB10.setVisible(false);
    }
}//GEN-LAST:event_jCB10ActionPerformed

    private void jCB11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB11ActionPerformed
        jL11.setIcon(recarregaJCB(1,1,jCB11.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(5);
        }else {
        jCB11.setVisible(false);
        }
}//GEN-LAST:event_jCB11ActionPerformed

    private void jCB12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB12ActionPerformed
        jL12.setIcon(recarregaJCB(1,2,jCB12.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(6);
        }else {
        jCB12.setVisible(false);
        }
}//GEN-LAST:event_jCB12ActionPerformed

    private void jCB13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB13ActionPerformed
        jL13.setIcon(recarregaJCB(1,3,jCB13.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(7);
        }else {
        jCB13.setVisible(false);
        }
}//GEN-LAST:event_jCB13ActionPerformed

    private void jCB20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB20ActionPerformed
        jL20.setIcon(recarregaJCB(2,0,jCB20.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(8);
        }else {
        jCB20.setVisible(false);
        }
}//GEN-LAST:event_jCB20ActionPerformed

    private void jCB21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB21ActionPerformed
        jL21.setIcon(recarregaJCB(2,1,jCB21.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(9);
        }else {
        jCB21.setVisible(false);
        }
}//GEN-LAST:event_jCB21ActionPerformed

    private void jCB22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB22ActionPerformed
        jL22.setIcon(recarregaJCB(2,2,jCB22.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(10);
        }else {
        jCB22.setVisible(false);
        }
}//GEN-LAST:event_jCB22ActionPerformed

    private void jCB23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB23ActionPerformed
        jL23.setIcon(recarregaJCB(2,3,jCB23.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(11);
        }else {
        jCB23.setVisible(false);
        }
}//GEN-LAST:event_jCB23ActionPerformed

    private void jCB30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB30ActionPerformed
        jL30.setIcon(recarregaJCB(3,0,jCB30.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(12);
        }else {
        jCB30.setVisible(false);
        }
}//GEN-LAST:event_jCB30ActionPerformed

    private void jCB31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB31ActionPerformed
        jL31.setIcon(recarregaJCB(3,1,jCB31.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(13);
        }else {
        jCB31.setVisible(false);
        }
}//GEN-LAST:event_jCB31ActionPerformed

    private void jCB32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB32ActionPerformed
        jL32.setIcon(recarregaJCB(3,2,jCB32.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(14);
        }else {
        jCB32.setVisible(false);
        }
}//GEN-LAST:event_jCB32ActionPerformed

    private void jCB33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB33ActionPerformed
        jL33.setIcon(recarregaJCB(3,3,jCB33.getModel().getSelectedItem().toString()));
        if(casas.isExApaga()){
            apagaJCB(14);
        }else {
        jCB33.setVisible(false);
        }
}//GEN-LAST:event_jCB33ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x =Integer.parseInt(jCBx.getModel().getSelectedItem().toString());
        int y =Integer.parseInt(jCBy.getModel().getSelectedItem().toString());
        mudaCasas(x,y);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcActionPerformed
        cima();
}//GEN-LAST:event_jBcActionPerformed

    private void jBeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeActionPerformed
        esquerda();
    }//GEN-LAST:event_jBeActionPerformed

        private void jBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdActionPerformed
        direita();
        }//GEN-LAST:event_jBdActionPerformed

        private void jBbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbActionPerformed
        baixo();
}//GEN-LAST:event_jBbActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBb;
    private javax.swing.JButton jBc;
    private javax.swing.JButton jBd;
    private javax.swing.JButton jBe;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCB01;
    private javax.swing.JComboBox jCB02;
    private javax.swing.JComboBox jCB03;
    private javax.swing.JComboBox jCB10;
    private javax.swing.JComboBox jCB11;
    private javax.swing.JComboBox jCB12;
    private javax.swing.JComboBox jCB13;
    private javax.swing.JComboBox jCB20;
    private javax.swing.JComboBox jCB21;
    private javax.swing.JComboBox jCB22;
    private javax.swing.JComboBox jCB23;
    private javax.swing.JComboBox jCB30;
    private javax.swing.JComboBox jCB31;
    private javax.swing.JComboBox jCB32;
    private javax.swing.JComboBox jCB33;
    private javax.swing.JComboBox jCBx;
    private javax.swing.JComboBox jCBy;
    private javax.swing.JLabel jL00;
    private javax.swing.JLabel jL01;
    private javax.swing.JLabel jL02;
    private javax.swing.JLabel jL03;
    private javax.swing.JLabel jL10;
    private javax.swing.JLabel jL11;
    private javax.swing.JLabel jL12;
    private javax.swing.JLabel jL13;
    private javax.swing.JLabel jL20;
    private javax.swing.JLabel jL21;
    private javax.swing.JLabel jL22;
    private javax.swing.JLabel jL23;
    private javax.swing.JLabel jL30;
    private javax.swing.JLabel jL31;
    private javax.swing.JLabel jL32;
    private javax.swing.JLabel jL33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jP00;
    private javax.swing.JPanel jP01;
    private javax.swing.JPanel jP02;
    private javax.swing.JPanel jP03;
    private javax.swing.JPanel jP10;
    private javax.swing.JPanel jP11;
    private javax.swing.JPanel jP12;
    private javax.swing.JPanel jP13;
    private javax.swing.JPanel jP20;
    private javax.swing.JPanel jP21;
    private javax.swing.JPanel jP22;
    private javax.swing.JPanel jP23;
    private javax.swing.JPanel jP30;
    private javax.swing.JPanel jP31;
    private javax.swing.JPanel jP32;
    private javax.swing.JPanel jP33;
    private javax.swing.JPanel jPanda;
    private javax.swing.JPanel jPseta;
    // End of variables declaration//GEN-END:variables

}
