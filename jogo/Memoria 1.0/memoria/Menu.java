package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame {
	
	public Menu(){
		initComponents();
		
		this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        /*JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        JMenu regraMenu = new JMenu("Como Jogar?");
        JMenu iniciarMenu = new JMenu("Iniciar");
        
        menuBar.add(regraMenu);
        menuBar.add(iniciarMenu);*/
        
	}public void showSplash() {
		
		JPanel content = (JPanel)getContentPane();
		content.setBackground(getForeground());
		
		int width = 460;
		int height = 460;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		
		setBounds(x,y,width,height);
		
		JLabel label = new JLabel(new ImageIcon("regras.png"));
        JLabel copyrt = new JLabel
                ("",JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        
        setVisible(true);
        
        try {
        	
        	Thread.sleep(10000);
        
        }catch(Exception e) {
        }
        
        setVisible(false);
	}
	
	
	
    @SuppressWarnings("unchecked")
    
    private void initComponents() {
    	
    	grupoLevel = new javax.swing.ButtonGroup();
        grupoquantia = new javax.swing.ButtonGroup();
        radioMuitoFacil = new javax.swing.JRadioButton();
        radioFacil = new javax.swing.JRadioButton();
        radioMedio = new javax.swing.JRadioButton();
        radioDificil = new javax.swing.JRadioButton();
        radioMuitoDificil = new javax.swing.JRadioButton();
        labelLevel = new javax.swing.JLabel();
        labelLevel1 = new javax.swing.JLabel();
        radioQuantia16 = new javax.swing.JRadioButton();
        radioQuantia20 = new javax.swing.JRadioButton();
        radioQuantia24 = new javax.swing.JRadioButton();
        radioQuantia36 = new javax.swing.JRadioButton();
        botaoAvancar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Memoria");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/memoria/imagemicone/icone.png")).getImage());

        grupoLevel.add(radioMuitoFacil);
        radioMuitoFacil.setSelected(true);
        radioMuitoFacil.setText("Muito facil");

        grupoLevel.add(radioFacil);
        radioFacil.setText("Facil");

        grupoLevel.add(radioMedio);
        radioMedio.setText("Medio");

        grupoLevel.add(radioDificil);
        radioDificil.setText("Dificil");

        grupoLevel.add(radioMuitoDificil);
        radioMuitoDificil.setText("Muito Dificil");

        labelLevel.setFont(new java.awt.Font("Tahoma", 1, 14));
        labelLevel.setForeground(new java.awt.Color(255, 0, 0));
        labelLevel.setText("Escolha o nivel:");

        labelLevel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        labelLevel1.setForeground(new java.awt.Color(255, 0, 0));
        labelLevel1.setText("Escolha quantos pares: ");

        grupoquantia.add(radioQuantia16);
        radioQuantia16.setSelected(true);
        radioQuantia16.setText("8 Pares");

        grupoquantia.add(radioQuantia20);
        radioQuantia20.setText("10 Pares");

        grupoquantia.add(radioQuantia24);
        radioQuantia24.setText("12 Pares");

        grupoquantia.add(radioQuantia36);
        radioQuantia36.setText("18 Pares");

        botaoAvancar.setText("Avançar");
        botaoAvancar.addActionListener(new java.awt.event.ActionListener(){
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAvancarActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
        		layout.createParallelGroup(
        				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        						layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMuitoFacil)
                                .addGap(39, 39, 39)
                                .addComponent(radioFacil)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioQuantia16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioQuantia20)
                                .addGap(33, 33, 33)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioMedio)
                            .addComponent(radioQuantia24))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioQuantia36)
                                .addGap(36, 36, 36)
                                .addComponent(botaoAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioDificil)
                                .addGap(40, 40, 40)
                                .addComponent(radioMuitoDificil)))))
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMuitoFacil)
                    .addComponent(radioFacil)
                    .addComponent(radioMedio)
                    .addComponent(radioDificil)
                    .addComponent(radioMuitoDificil))
                .addGap(29, 29, 29)
                .addComponent(labelLevel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioQuantia16)
                    .addComponent(radioQuantia20)
                    .addComponent(radioQuantia24)
                    .addComponent(radioQuantia36)
                    .addComponent(botaoAvancar))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        
        pack();
    }
    
    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt){
    	
    	Memoria1 objMemoriaJava;
    	
        try{
        	if(radioMuitoFacil.isSelected() && radioQuantia16.isSelected()){
        		
        		objMemoriaJava = new Memoria1(16, 1, "Muito facil");
        		objMemoriaJava.setVisible(true);
        		
        		this.hide();
        }
        
         if(radioMuitoFacil.isSelected() && radioQuantia20.isSelected()){
        	 
            objMemoriaJava = new Memoria1(20, 1, "Muito facil");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
         
          if(radioMuitoFacil.isSelected() && radioQuantia24.isSelected()){
            objMemoriaJava = new Memoria1(24, 1, "Muito facil");
            objMemoriaJava.setVisible(true);
            this.hide();
        }
          if(radioMuitoFacil.isSelected() && radioQuantia36.isSelected()){
        	   
        	   objMemoriaJava = new Memoria1(36, 1, "Muito facil");
        	   objMemoriaJava.setVisible(true);
        	   
        	   this.hide();
        }
          if(radioFacil.isSelected() && radioQuantia16.isSelected()){
        	  
        	  objMemoriaJava = new Memoria1(16, 3, "Facil");
        	  objMemoriaJava.setVisible(true);
        	  
        	  this.hide();
        }
         
         if(radioFacil.isSelected() && radioQuantia20.isSelected()){
        	 
        	 objMemoriaJava = new Memoria1(20, 5, "Facil");
        	 objMemoriaJava.setVisible(true);
        	 
             this.hide();
        }
         
        if(radioFacil.isSelected() && radioQuantia24.isSelected()){
        	
        	objMemoriaJava = new Memoria1(24, 5, "Facil");
        	objMemoriaJava.setVisible(true);
        	
        	this.hide();
        }
        
        if(radioFacil.isSelected() && radioQuantia36.isSelected()){
            
        	objMemoriaJava = new Memoria1(36, 7, "Facil");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
        if(radioMedio.isSelected() && radioQuantia16.isSelected()){
            
        	objMemoriaJava = new Memoria1(16, 5, "Medio");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
        if(radioMedio.isSelected() && radioQuantia20.isSelected()){
            
        	objMemoriaJava = new Memoria1(20, 6, "Medio");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
        if(radioMedio.isSelected() && radioQuantia24.isSelected()){
        	
        	objMemoriaJava = new Memoria1(24, 7, "Medio");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
       if(radioMedio.isSelected() && radioQuantia36.isSelected()){
    	   
    	   objMemoriaJava = new Memoria1(36, 11, "Medio");
           objMemoriaJava.setVisible(true);
           
           this.hide();
        }
       
        if(radioDificil.isSelected() && radioQuantia16.isSelected()){
            
        	objMemoriaJava = new Memoria1(16, 8, "Dificil");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
          if(radioDificil.isSelected() && radioQuantia20.isSelected()){
        	  
        	  objMemoriaJava = new Memoria1(20, 10, "Dificil");
              objMemoriaJava.setVisible(true);
              
              this.hide();
        }
          
       if(radioDificil.isSelected() && radioQuantia24.isSelected()){
    	   
    	   objMemoriaJava = new Memoria1(24, 12, "Dificil");
    	   objMemoriaJava.setVisible(true);
    	   
    	   this.hide();
        }
       
        if(radioDificil.isSelected() && radioQuantia36.isSelected()){
        	
        	objMemoriaJava = new Memoria1(36, 18, "Dificil");
            objMemoriaJava.setVisible(true);
            
            this.hide();
        }
        
          if(radioMuitoDificil.isSelected() && radioQuantia16.isSelected()){
        	  
        	  objMemoriaJava = new Memoria1(16, 13, "Muito Dificil");
              objMemoriaJava.setVisible(true);
              
              this.hide();
        }
          
           if(radioMuitoDificil.isSelected() && radioQuantia20.isSelected()){
        	   
        	   objMemoriaJava = new Memoria1(20, 16, "Muito Dificil");
               objMemoriaJava.setVisible(true);
               
               this.hide();
        }
           
         if(radioMuitoDificil.isSelected() && radioQuantia24.isSelected()){
        	 
        	 objMemoriaJava = new Memoria1(24, 20, "Muito Dificil");
             objMemoriaJava.setVisible(true);
             
             this.hide();
        }
         
         if(radioMuitoDificil.isSelected() && radioQuantia36.isSelected()){
        	 
        	 objMemoriaJava = new Memoria1(36, 29, "Muito Dificil");
             objMemoriaJava.setVisible(true);
             
             this.hide();
        }
         
         } catch (Exception ex) {
        
         }
    }
    
    public static void main(String args[]) {
    	
    	SplashScreen splash = new SplashScreen(10000);
		splash.showSplash();
    	
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
    	
    	catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    	
    	catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    	
    	catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    	
    	catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
        java.awt.EventQueue.invokeLater(new Runnable(){
        	
        	public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton botaoAvancar;
    private javax.swing.ButtonGroup grupoLevel;
    private javax.swing.ButtonGroup grupoquantia;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelLevel1;
    private javax.swing.JRadioButton radioDificil;
    private javax.swing.JRadioButton radioFacil;
    private javax.swing.JRadioButton radioMedio;
    private javax.swing.JRadioButton radioMuitoDificil;
    private javax.swing.JRadioButton radioMuitoFacil;
    private javax.swing.JRadioButton radioQuantia16;
    private javax.swing.JRadioButton radioQuantia20;
    private javax.swing.JRadioButton radioQuantia24;
    private javax.swing.JRadioButton radioQuantia36;
}