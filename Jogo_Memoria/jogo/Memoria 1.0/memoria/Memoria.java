package memoria;

import java.awt.event.ActionListener; 
import javax.swing.Timer;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

class Memoria extends JFrame{ 
	
	//Estância o array
	JButton[] botoes;
    Container tela; 
    JLabel labelfimjogo, labelquemjoga, labelacertaerra;
     
     Timer timer;
     
     int totalLacunaTabela =16;
     
     //Armazena os caracteres sorteados
     String tabela1[] = new String[totalLacunaTabela];
     
     //Array auxiliar
     String tabela2[] = new String[totalLacunaTabela];
     
     int index2 =0;
     int intTimeSegundo = 0;
     
     //Sorteia quem começa jogando
     int quemJoga =-1;
     
     String primeiraEscolha =null;
     String segundaEscolha =null;
     
     //Método construtor
     public Memoria(){
    	 
    	 abstrato();
    	 
    	 this.setSize(400,400);
         
         tela = getContentPane();
         tela.setLayout(null);
         
         this.setTitle ("Jogo da Memoria");   
         
         labelfimjogo = new JLabel("Fim de Jogo!");
         labelquemjoga = new JLabel("");
         labelacertaerra = new JLabel("");
         
         tela.add(labelfimjogo);
         tela.add(labelquemjoga);
         tela.add(labelacertaerra);
         
         setLocationRelativeTo(null);
   
         //Quantidade de botões no array
         botoes = new JButton[totalLacunaTabela];
         
         for(int index = 0; index < totalLacunaTabela; index++){
        	 
        	 botoes[index]=new JButton(("*"));
        	 tela.add(botoes[index]); 
       } 
         
         labelacertaerra.setBounds(50,20,200,20); 
         botoes[0].setBounds(40,40,50,50);  
         botoes[1].setBounds(100,40,50,50);
         botoes[2].setBounds(160,40,50,50); 
         botoes[3].setBounds(220,40,50,50);
         botoes[4].setBounds(40,100,50,50);
         botoes[5].setBounds(100,100,50,50);
         botoes[6].setBounds(160,100,50,50);
         botoes[7].setBounds(220,100,50,50);
         botoes[8].setBounds(40,160,50,50);
         botoes[9].setBounds(100,160,50,50);
         botoes[10].setBounds(160,160,50,50);
         botoes[11].setBounds(220,160,50,50);
         botoes[12].setBounds(40,220,50,50);
         botoes[13].setBounds(100,220,50,50);
         botoes[14].setBounds(160,220,50,50);
         botoes[15].setBounds(220,220,50,50);
         labelfimjogo.setBounds(130,280,100,30);
         labelquemjoga.setBounds(130,320,150,30);
         
         labelfimjogo.setVisible(false);
         
         mostrarTabela();
         defineQuemJoga();
    }
     
     //Define quem joga primeiro (jogador ou computador)
     public void defineQuemJoga(){
    	 
        quemJoga =(int)(Math.random() *2); 
   }
     
     public void mostrarTabela(){	 
    	 
        timer = new javax.swing.Timer(1500, new ClockListener());
        timer.start();	
    } 
    
    class ClockListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
            try{
                    botoes[intTimeSegundo].setText(tabela1[intTimeSegundo]);
                    botoes[(totalLacunaTabela-1)-intTimeSegundo].setText(
                    		tabela1[(totalLacunaTabela-intTimeSegundo-1)-intTimeSegundo]);
                    intTimeSegundo=intTimeSegundo+1;
            }
            
            catch(Exception ex){
            	
               intTimeSegundo =16; 
            }
            
            if(intTimeSegundo== totalLacunaTabela){
            	
            	timer.stop(); 
            	intTimeSegundo=0;
            	
            	for(int index =0; index < totalLacunaTabela; index++){
                  botoes[index].setText("*");
                  
                  }
            	
            	//Mostra quem começa jogando
            	if(quemJoga ==1){
                  quemJoga =0;
                  labelquemjoga.setText("Eu começo Jogando!!");
                  
               }else{
                  quemJoga =1;	
                  labelquemjoga.setText("Voce começa Jogando!!");
               }	
           }     	  
    	}
    }
    
    public void verificaFimJogo(){ 
    	
      informaAcerto();
      int contadorFim =1;
      
      for(int index =0; index< totalLacunaTabela; index++){
         String comparafim =botoes[index].getText();
         
         if( comparafim.equals(tabela2[index])){
            contadorFim +=1; 
            
            if(contadorFim==totalLacunaTabela){  
             labelfimjogo.setVisible(true);
             
            }
         }	
      }	
   }	
   
   public void comparaEscolhas(int a, int b){
	   
      if(!tabela1[a].equals(tabela1[b])){
    	  
         mostraEscolha();
         informaErro();
         avisaQuemJoga();	
         
      }else{
    	  
      verificaFimJogo();
      
      botoes[a].setEnabled(false);
      botoes[b].setEnabled(false);
      } 	 
   }
   
   public void avisaQuemJoga(){
	   
     if(quemJoga ==1){
          quemJoga =0;
             labelquemjoga.setText("Minha mez!!");
          }else{
          quemJoga =1;	
             labelquemjoga.setText("Sua vez!!");
          }	
   }
   
   public void informaAcerto(){
	   
   	 if(quemJoga ==0){
   		 
         labelacertaerra.setText("Eu acertei, continuo jogando!!");
      }
   	 
   	 else{
   		 
   		 labelacertaerra.setText("Voce acertou, continua jogando!!");
      }	
   }	
   
   public void informaErro(){
	   
      if(quemJoga ==1){
    	  
        labelacertaerra.setText("Voce errou, minha vez!!");
      }
      
      else{
    	  
        labelacertaerra.setText("Eu errei, sua vez!!");
      }		
   }			
    public void mostraEscolha(){
    	
       timer = new javax.swing.Timer(1000, new mostraEscolha());
       timer.start();	
    }
    
    class mostraEscolha implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		intTimeSegundo= intTimeSegundo+1;
    		
    		if(intTimeSegundo ==2){
    			
    			timer.stop(); 
        	    intTimeSegundo=0;
           }	
         }     	  
       }
    
    public void abstrato(){
    	
      sortear();
      duplicar();
      embaralhar();
   }   

   public void sortear(){
	   
     for(int index = 0; index < totalLacunaTabela/2; index++){
    	 
        tabela1[index]=""+(char)(Math.random()*26+65);
        
        for(int index1 = 0; index1 < index; index1++){
        	
     	   if(tabela1[index].equals(tabela1[index1])){
     		   index =index -1;
     	   }	   
        }
     } 
   }
   
   public void duplicar(){
	   
     for(int index = 0; index < totalLacunaTabela/2; index++){
        tabela1[(index)+ totalLacunaTabela/2]=tabela1[index]; 
     }
   }
   
   public void embaralhar(){
	   
      int auxSorteio;
      String aux;
      
      for(int index = 0; index < totalLacunaTabela/2; index++){ 
    	  
    	  auxSorteio =(int)(Math.random() * totalLacunaTabela-1);
    	  aux = tabela1[index];
    	  
          tabela1[index]= tabela1[auxSorteio];
          tabela1[auxSorteio] =aux;
     }
      
     for(int index = 0; index < totalLacunaTabela; index++){ 
        tabela2[index]= tabela1[index];
     }   
   }
}