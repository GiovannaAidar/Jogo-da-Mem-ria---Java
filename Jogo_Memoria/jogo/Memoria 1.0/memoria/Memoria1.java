package memoria;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Memoria1 extends JFrame  implements ActionListener{

    Container JANELA;
    
    int totalLacunaTabela =0; 
    
    JButton[]  botoes;
    javax.swing.JLabel labelJogadasJogador ;
    javax.swing.JLabel labelAcertosJogador;
    javax.swing.JLabel labelAcertosComputador;
    javax.swing.JLabel labelJogadasComputador;
    
    String path1 = Memoria1.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    String path = new File(".").getAbsolutePath() ;
    String brancoCard ="memoria\\imagem\\default\\card_blank.png";
    String diretorioCartas ="memoria\\imagem\\carta\\";
    ArrayList<String> array_Card = new ArrayList<String>();
    ArrayList<String> array_CardGame = new ArrayList<String>();
    ArrayList<Integer> array_PossibilidadeCardGame = new ArrayList<Integer>();
    ArrayList<String> array_MemoriaComputador = new ArrayList<String>();
   
    Timer timer;
    Timer timerShower;
    Timer timerComparador;
    
    boolean boolComparando =false;
    boolean opcaoEscolhaComputador =false;
    
    int statusMostrarOculta =0;
    
    int primeiraEscolha =-1;
    int segundaEscolha =-1;
    
    int contadorJogadasJogador =0;
    int contadorJogadasAcertadasJogador =0;
    
    int contadorJogadasComputador =0;
    int contadorJogadasAcertadasComputador =0;
    
    int controlaMemoriaComputador =0;
    int intControleFimJogo =0;
    int levelMemoria =0;
    
    Arquivos objListaArquivos =new Arquivos();
    Som objTocadorSom =new Som();
    
    public Memoria1 (int ptotalLacunaTabela, int pLevelMemoria, String level){

    	try{ 
    		
    		path = path.substring(0, path.length()-1);
    		
    		objTocadorSom.tocaSom(path+ "memoria\\som\\Inicio.wav");
         
            totalLacunaTabela = ptotalLacunaTabela;
            levelMemoria = pLevelMemoria;
            
            JANELA = getContentPane();
            JANELA.setLayout(null);
            
            setSize(400,300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            labelJogadasJogador = new javax.swing.JLabel();
            labelAcertosJogador = new javax.swing.JLabel();
            labelAcertosComputador = new javax.swing.JLabel();
            labelJogadasComputador = new javax.swing.JLabel();
            labelJogadasJogador.setText("Numero de Jogadas Jogador :");
            labelAcertosJogador.setText("Numero de Acertos Jogador :");
            labelAcertosComputador.setText("Numero de Acertos Computador :");
            labelJogadasComputador.setText("Numero de Jogadas Computador :");
            
            JANELA.add(labelJogadasJogador);
            JANELA.add(labelAcertosJogador);
            JANELA.add(labelAcertosComputador);
            JANELA.add(labelJogadasComputador);
            
            labelJogadasJogador.setBounds(2,2,300,20);
            labelAcertosJogador.setBounds(2,20,300,20);
            
            labelJogadasComputador.setBounds(300,2,300,20);
            labelAcertosComputador.setBounds(300,20,300,20);
            
            this.setResizable(false);
            
            botoes=new JButton[totalLacunaTabela];
            
            for(int index=0;index<totalLacunaTabela;index++){  
            	
            	botoes[index]=new JButton();
                botoes[index].setIcon(new ImageIcon(path + brancoCard));
                
                JANELA.add(botoes[index]);
                
                botoes[index].setVisible(true);
                botoes[index].setEnabled(true);
            } 
            
            if(totalLacunaTabela ==16){
            	
            	this.setSize(528,551);
                
            	botoes[0].setBounds(40,40,100,100);  
                botoes[1].setBounds(160,40,100,100);
                botoes[2].setBounds(280,40,100,100); 
                botoes[3].setBounds(400,40,100,100);
                botoes[4].setBounds(40,160,100,100);
                botoes[5].setBounds(160,160,100,100);
                botoes[6].setBounds(280,160,100,100);
                botoes[7].setBounds(400,160,100,100);
                botoes[8].setBounds(40,280,100,100);
                botoes[9].setBounds(160,280,100,100);
                botoes[10].setBounds(280,280,100,100);
                botoes[11].setBounds(400,280,100,100);
                botoes[12].setBounds(40,400,100,100);
                botoes[13].setBounds(160,400,100,100);
                botoes[14].setBounds(280,400,100,100);
                botoes[15].setBounds(400,400,100,100);
                
            }
            
            else if(totalLacunaTabela ==20){
            	
            	this.setSize(660,600);
               
                botoes[0].setBounds(40,40,100,100);  
                botoes[1].setBounds(160,40,100,100);
                botoes[2].setBounds(280,40,100,100); 
                botoes[3].setBounds(400,40,100,100);
                botoes[4].setBounds(520,40,100,100);
                botoes[5].setBounds(40,160,100,100);
                botoes[6].setBounds(160,160,100,100);
                botoes[7].setBounds(280,160,100,100);
                botoes[8].setBounds(400,160,100,100);
                botoes[9].setBounds(520,160,100,100);
                botoes[10].setBounds(40,280,100,100);
                botoes[11].setBounds(160,280,100,100);
                botoes[12].setBounds(280,280,100,100);
                botoes[13].setBounds(400,280,100,100);
                botoes[14].setBounds(520,280,100,100);
                botoes[15].setBounds(40,400,100,100);
                botoes[16].setBounds(160,400,100,100);
                botoes[17].setBounds(280,400,100,100);
                botoes[18].setBounds(400,400,100,100);
                botoes[19].setBounds(520,400,100,100);
            }
            
            else if(totalLacunaTabela ==24){
            	
            	this.setSize(780,600);
               
                botoes[0].setBounds(40,40,100,100);  
                botoes[1].setBounds(160,40,100,100);
                botoes[2].setBounds(280,40,100,100); 
                botoes[3].setBounds(400,40,100,100);
                botoes[4].setBounds(520,40,100,100);
                botoes[5].setBounds(640,40,100,100);
                botoes[6].setBounds(40,160,100,100);
                botoes[7].setBounds(160,160,100,100);
                botoes[8].setBounds(280,160,100,100);
                botoes[9].setBounds(400,160,100,100);
                botoes[10].setBounds(520,160,100,100);
                botoes[11].setBounds(640,160,100,100);
                botoes[12].setBounds(40,280,100,100);
                botoes[13].setBounds(160,280,100,100);
                botoes[14].setBounds(280,280,100,100);
                botoes[15].setBounds(400,280,100,100);
                botoes[16].setBounds(520,280,100,100);
                botoes[17].setBounds(640,280,100,100);
                botoes[18].setBounds(40,400,100,100);
                botoes[19].setBounds(160,400,100,100);
                botoes[20].setBounds(280,400,100,100);
                botoes[21].setBounds(400,400,100,100);
                botoes[22].setBounds(520,400,100,100);
                botoes[23].setBounds(640,400,100,100); 
            }
            
            else if(totalLacunaTabela ==36){
            	
            	this.setSize(780,760);
                
            	botoes[0].setBounds(30,40,100,100);  
                botoes[1].setBounds(150,40,100,100);
                botoes[2].setBounds(270,40,100,100); 
                botoes[3].setBounds(390,40,100,100);
                botoes[4].setBounds(510,40,100,100);
                botoes[5].setBounds(630,40,100,100);
                botoes[6].setBounds(30,150,100,100);
                botoes[7].setBounds(150,150,100,100);
                botoes[8].setBounds(270,150,100,100);
                botoes[9].setBounds(390,150,100,100);
                botoes[10].setBounds(510,150,100,100);
                botoes[11].setBounds(630,150,100,100);
                botoes[12].setBounds(30,260,100,100);
                botoes[13].setBounds(150,260,100,100);
                botoes[14].setBounds(270,260,100,100);
                botoes[15].setBounds(390,260,100,100);
                botoes[16].setBounds(510,260,100,100);
                botoes[17].setBounds(630,260,100,100);
                botoes[18].setBounds(30,370,100,100);
                botoes[19].setBounds(150,370,100,100);
                botoes[20].setBounds(270,370,100,100);
                botoes[21].setBounds(390,370,100,100);
                botoes[22].setBounds(510,370,100,100);
                botoes[23].setBounds(630,370,100,100);
                botoes[24].setBounds(30,480,100,100);
                botoes[25].setBounds(150,480,100,100);
                botoes[26].setBounds(270,480,100,100);
                botoes[27].setBounds(390,480,100,100);
                botoes[28].setBounds(510,480,100,100);
                botoes[29].setBounds(630,480,100,100);
                botoes[30].setBounds(30,590,100,100);
                botoes[31].setBounds(150,590,100,100);
                botoes[32].setBounds(270,590,100,100);
                botoes[33].setBounds(390,590,100,100);
                botoes[34].setBounds(510,590,100,100);
                botoes[35].setBounds(630,590,100,100);
           }
            
            this.setLocationRelativeTo(null);
            
            System.out.println(path);
            
            totalLacunaTabela = ptotalLacunaTabela;
            levelMemoria = pLevelMemoria;
            
           
     
            labelJogadasJogador.setText(labelJogadasJogador.getText().substring(0, labelJogadasJogador.getText().indexOf(":")+1) +" "+ contadorJogadasJogador); 
            labelAcertosJogador.setText(labelAcertosJogador.getText().substring(0, labelAcertosJogador.getText().indexOf(":")+1) +" "+ contadorJogadasAcertadasJogador); 
            
            labelJogadasComputador.setText(labelJogadasComputador.getText().substring(0, labelJogadasComputador.getText().indexOf(":")+1) +" "+ contadorJogadasComputador); 
            labelAcertosComputador.setText(labelAcertosComputador.getText().substring(0, labelAcertosComputador.getText().indexOf(":")+1) +" "+ contadorJogadasAcertadasComputador); 

            array_Card = objListaArquivos.listagemArquivo(path + diretorioCartas);
            
            Collections.shuffle(array_Card);
            
            for(int index =0; index < totalLacunaTabela /2; index++){
            	
            	array_CardGame.add(array_Card.get(index));
                array_CardGame.add(array_Card.get(index));
            }
            
            Collections.shuffle(array_CardGame);
            
            criaImagensPadrao();
            
            this.setTitle(this.getTitle() +"      Level :"+ level);
            this.setResizable(false);
           
            memoriaComputador();
            
            timerComparador = new Timer(2300, new Memoria1.TemporizadorInicial());         
    	}
    	
    	catch(Exception ex){ 
    	
    	}     
    }
    
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < botoes.length; i++) {
            if (e.getSource() == botoes[i]) {
            
                if(boolComparando ==false){ 
                	
                    exibeEscolhas(i);
                    comparaEscolhas();
                    
                    timerComparador.restart();
                }    
            }
       }
    }
    
    private void criaImagensPadrao() {
    	
    	timer = new javax.swing.Timer(1200, new Memoria1.TemporizadorInicial());
        timer.start();
 
        int controladorTempo = 400 * totalLacunaTabela;
            
        timerShower = new javax.swing.Timer(controladorTempo, new Memoria1.TemporizadorInicial());
        timerShower.start();
    }
    
    public class TemporizadorInicial implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		try{   
                if(statusMostrarOculta ==0){ 
    
                    mostraImagens();
                    statusMostrarOculta =1;
        
                }else if(statusMostrarOculta ==1){  
                	
                    retornaImagensBranco();
                    statusMostrarOculta =2; 
                }
                
                timer.stop();
                
                if(statusMostrarOculta ==2){        
                
                	timerShower.stop();
           
                }
                
                if(statusMostrarOculta == 2 || statusMostrarOculta == 5){
                
                	controlaFimJogo();
                }
                
                if(statusMostrarOculta ==3){   
                    
                	statusMostrarOculta = 4;
                    ocultaEscolhaErrada();   
                 }
           
           
                if(statusMostrarOculta ==5){
                    
                	verificaPossibilidadeJogadasComputador();
                    sorteiaPossibilidadeJogadasComputador();
                    escolhePossibilidadeJogadasComputador();
                }
                
                if(statusMostrarOculta ==6){
                     
                	exibeEscolhasComputador();
                     comparaEscolhasComputador();
                }
           
                if(statusMostrarOculta ==7){
                    
                	ocultaEscolhaErradaComputador();  
                } 
           
                if(statusMostrarOculta ==6){
                    
                	statusMostrarOculta = 7; 
                }
    		}
    		
    		catch(Exception ex){
            
    			System.out.println("Erro Thread "+ ex.toString());
         }
       }
    }
    
    public void mostraImagens() {
    	
    	try{ 
            for(int index=0;index<totalLacunaTabela;index++){   
                 
            	botoes[index].setIcon(new ImageIcon(array_CardGame.get(index)));    	
            }
         }
    	
    	catch(Exception ex){
               
        }
    }
    
    public void retornaImagensBranco() {
        
    	try{ 
            
    		for(int index=0;index<totalLacunaTabela;index++){   
            	
                botoes[index].setIcon(new ImageIcon(path + brancoCard));
                botoes[index].addActionListener(this);  
            }
        }
    	
    	catch(Exception ex){
        
    		System.out.println("Erro Mostra Imagem "+ ex.toString());    
        }  
     }
    
    public void exibeEscolhas(int i) {
    
    	try{
    		if(primeiraEscolha ==-1){
                   
    			primeiraEscolha = i;
                botoes[primeiraEscolha].setIcon(new ImageIcon(array_CardGame.get(primeiraEscolha)));   
    		}
    		
    		else if(primeiraEscolha != -1 && primeiraEscolha != i){
    			
    			segundaEscolha =i;
                botoes[segundaEscolha].setIcon(new ImageIcon(array_CardGame.get(segundaEscolha)));
            }
         
           }catch(Exception ex){
                System.out.println("Erro Exibe Escolha "+ ex.toString());
           }
    }
    
    public void comparaEscolhas(){
    	
    	try{
    		
    		if(primeiraEscolha !=-1 && segundaEscolha !=-1){
    			
    			boolComparando =true;
                
                contadorJogadasJogador = contadorJogadasJogador +1;
                labelJogadasJogador.setText(labelJogadasJogador.getText().substring(0, labelJogadasJogador.getText().indexOf(":")+1) +" "+ contadorJogadasJogador);        
                
                if(botoes[primeiraEscolha].getIcon().toString().equals(botoes[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha){
                	
                	botoes[primeiraEscolha].setEnabled(false);
                    botoes[segundaEscolha].setEnabled(false);
                        
                    objTocadorSom.tocaSom(path+ "memoria\\som\\Correto.wav");
                      
                    contadorJogadasAcertadasJogador  = contadorJogadasAcertadasJogador +1;
                    labelAcertosJogador.setText(labelAcertosJogador.getText().substring(0, labelAcertosJogador.getText().indexOf(":")+1) +" "+ contadorJogadasAcertadasJogador);        
             
                    primeiraEscolha =-1;
                    segundaEscolha =-1;
                    statusMostrarOculta =2; 
                      
                    boolComparando =false;
                }
                
                else{
                	
                	objTocadorSom.tocaSom(path+ "memoria\\som\\errou.WAV");
                    
                	statusMostrarOculta =3;
                    
                	timerComparador.restart();
                }
            } 
    	}
    	
    	catch(Exception ex){
        
    		System.out.println("Erro Compara Escolhas "+ ex.toString());	
    	}         
    }
    
    public void ocultaEscolhaErrada() {
    	
    	try{
    		
    		adicionaOpcaoErradaMemoriaComputador();
                
            if(statusMostrarOculta ==4){
            	
            	botoes[primeiraEscolha].setIcon(new ImageIcon(path + brancoCard)); 
                botoes[segundaEscolha].setIcon(new ImageIcon(path + brancoCard));
                  
                primeiraEscolha =-1;
                segundaEscolha =-1;
                  
                statusMostrarOculta =5;
                boolComparando =false;
            } 
    	}
    	
    	catch(Exception ex){
        
    		System.out.println("Erro oculta Escolha Errada "+ ex.toString());   
    	}
    }
    
    public void verificaPossibilidadeJogadasComputador(){
            
    	try{ 
    		
    		boolComparando =true;
              
            array_PossibilidadeCardGame.clear();
             
            for(int index =0; index< array_CardGame.size(); index++){
                    
            	if(!array_CardGame.get(index).toString().equals(botoes[index].getIcon().toString()) 
                       && (botoes[index].getIcon().toString().equals(path+ brancoCard))
                         && botoes[index].isEnabled()){ 
            		
            		array_PossibilidadeCardGame.add(index);
            	}
            }
    	}
    	
    	catch(Exception ex){
              
    		System.out.println("Erro verificaPossibilidade Computador "+ ex.toString());
    	}

    }
    
    private void memoriaComputador(){
    	
    	int valor =0;
    	
    	for(int index =0; index < totalLacunaTabela; index++ ){
                  
    		array_MemoriaComputador.add("");
    	}
    	
    	int index1 =0;
    	
    	while(index1 <  levelMemoria){
    		
    		valor = (int) (Math.random()* totalLacunaTabela );
    		
    		if(array_MemoriaComputador.get(valor).equals("")){
                        
    			index1++;
    		}
    		
    		array_MemoriaComputador.set(valor , array_CardGame.get(valor)); 		
    	}
    	
    	for(int index =0; index < totalLacunaTabela; index++ ){
                  
    		System.out.println( index+ array_MemoriaComputador.get(index));	
    	}
    }
    
    public void sorteiaPossibilidadeJogadasComputador(){
            
    	try{
    		
    		Collections.shuffle(array_PossibilidadeCardGame);
    	}
    	
    	catch(Exception ex){
               
    		System.out.println("Erro Sorteia Possibilidade Computador "+ ex.toString());
    	} 
    }
    
    public void escolhePossibilidadeJogadasComputador(){
            
    	try{
    		
    		opcaoEscolhaComputador = false;
            
    		for(int index1 =0; index1 < totalLacunaTabela; index1++){
                   for(int index2 =  index1 +1; index2 < totalLacunaTabela; index2++){
                	   for(int index3 =0; index3 < array_PossibilidadeCardGame.size(); index3++){
                		   for(int index4 =index3 +1; index4 < array_PossibilidadeCardGame.size(); index4++){
                			   
                			   if((array_MemoriaComputador.get(index1).equals(array_MemoriaComputador.get(index2)) 
                					   && index1 != index2  && opcaoEscolhaComputador == false) && 
                					   (!array_MemoriaComputador.get(index1).equals("") && !array_MemoriaComputador.get(index2).equals(""))
                					   && index1 == array_PossibilidadeCardGame.get(index3) && index2 == array_PossibilidadeCardGame.get(index4)){
                				   
                				   primeiraEscolha = index1;
                                   segundaEscolha = index2;
                                   opcaoEscolhaComputador =true;
                                   
                                   System.out.println("passou");
                                   System.out.println("C1 "+primeiraEscolha);
                                   System.out.println("C2 "+segundaEscolha );
                   
                                   statusMostrarOculta =6;
                   
                                   break;
                                }
                           }
                       }
                   }
               } 
    		
    		if(opcaoEscolhaComputador ==false){
    			
    			primeiraEscolha = array_PossibilidadeCardGame.get(0);
                segundaEscolha = array_PossibilidadeCardGame.get(1);
                
                System.out.println("Comp1 random "+primeiraEscolha);
                System.out.println("Comp2 random "+segundaEscolha );
                
                opcaoEscolhaComputador =true;
                statusMostrarOculta =6;
    		}
    	}
    	
    	catch(Exception ex){
                 
    		System.out.println("Erro Escolhe Possibilidade Computador "+ ex.toString());
    	}    
    }
    
    public void exibeEscolhasComputador() {
    	try{
            
            botoes[primeiraEscolha].setIcon(new ImageIcon(array_CardGame.get(primeiraEscolha)));
            botoes[segundaEscolha].setIcon(new ImageIcon(array_CardGame.get(segundaEscolha)));
        }
    	
    	catch(Exception ex){
            
        	System.out.println("Erro exibe escolhas Computador"+ ex.toString());
        }    
  }
    
    public void comparaEscolhasComputador(){
    	
        try{
        	
            if(primeiraEscolha !=-1 && segundaEscolha !=-1){

                contadorJogadasComputador = contadorJogadasComputador +1;
                labelJogadasComputador.setText(labelJogadasComputador.getText().substring(0, labelJogadasComputador.getText().indexOf(":")+1) +" "+ contadorJogadasComputador);        

                if(botoes[primeiraEscolha].getIcon().toString().equals(botoes[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha){
                 
                    botoes[primeiraEscolha].setEnabled(false);
                    botoes[segundaEscolha].setEnabled(false);
                    
                    objTocadorSom.tocaSom(path+ "memoria\\som\\CorretoComputador.wav");
                   
                    contadorJogadasAcertadasComputador  = contadorJogadasAcertadasComputador +1;
                    labelAcertosComputador.setText(labelAcertosComputador.getText().substring(0, labelAcertosComputador.getText().indexOf(":")+1) +" "+ contadorJogadasAcertadasComputador);        
         
                    primeiraEscolha =-1;
                    segundaEscolha =-1;
                    statusMostrarOculta =5;
                }
                
                else{
                	
                  objTocadorSom.tocaSom(path + "memoria\\som\\errou.wav");
                  statusMostrarOculta = 6;
               
                  timerComparador.restart();
                }
            }
        }
        
        catch(Exception ex){
        
        	System.out.println("Erro Compara escolha Computador "+ ex.toString());
        }
    }
    
    public void ocultaEscolhaErradaComputador() {
           
    	try{
    		
    		adicionaOpcaoErradaMemoriaComputador();
               
               
            if(statusMostrarOculta ==7){
                        
                    
            botoes[primeiraEscolha].setIcon(new ImageIcon(path+ brancoCard)); 
            botoes[segundaEscolha].setIcon(new ImageIcon(path+ brancoCard));
            
            primeiraEscolha =-1;
            segundaEscolha =-1;
            boolComparando =false;
            
            statusMostrarOculta =2;
            
            }
    	}
    	
    	catch(Exception ex){
                 
    		System.out.println("Oculta Escolhas Computador "+ ex.toString());
    	} 
    }
    
    public void  adicionaOpcaoErradaMemoriaComputador(){
    	
    	array_MemoriaComputador.set(primeiraEscolha , array_CardGame.get(primeiraEscolha));
        array_MemoriaComputador.set(segundaEscolha , array_CardGame.get(segundaEscolha));    
    }
    
    public void controlaFimJogo() {
          
    	try{
    		
    		int contadorFinal =0;
    		
    		String rendimento = null;
          
            for(int index =0; index < totalLacunaTabela; index++ ){
            	
            	if(!botoes[index].getIcon().toString().equals(path+ brancoCard)){
            		
            		contadorFinal = contadorFinal +1;
            	}
            	
            	if(totalLacunaTabela ==contadorFinal){
            		
            		String vencedor =null;
            		
            		System.out.println("Total Jogadas " +contadorJogadasJogador +" Total Jogadas Acertadas  " +contadorJogadasAcertadasJogador);
                    
            		Jogador objRendimentoJogador =new Jogador();
                        
                    vencedor = objRendimentoJogador.vencedorJogo(contadorJogadasAcertadasJogador, contadorJogadasAcertadasComputador);
                    
                    if(contadorJogadasAcertadasJogador >  contadorJogadasAcertadasComputador){
                    	
                    	objTocadorSom.tocaSom(path+ "memoria\\som\\Vitoria.wav");
                    }
                    else{
                    	objTocadorSom.tocaSom(path+ "memoria\\som\\Derrota.wav");
                    }
                    
                    statusMostrarOculta =8;
                    
                    int resp = JOptionPane.showConfirmDialog(null, vencedor+"\nPontos do Jogador: " +contadorJogadasAcertadasJogador+"\nPontos do Computador: "+contadorJogadasAcertadasComputador+" \n","Fim de Jogo!! \nDeseja Reiniciar o Jogo",  JOptionPane.INFORMATION_MESSAGE);
                    
                    if (resp == JOptionPane.YES_OPTION){  
                    	
                    	this.dispose();
                    	
                    	new Menu().show(); 
                    }
                    
                    else{
                    	
                    	this.dispose();
                    }  
            	}
            }
    	}
    	
    	catch(Exception ex){
                 
    		System.out.println("Erro Controla Fim de Jogo "+ ex.toString());
    	}       
    }
} 