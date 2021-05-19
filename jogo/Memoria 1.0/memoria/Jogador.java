package memoria;

public class Jogador {
	
	public String redimentoTotal(int contadorJogadas, int contadorJogadasAcertadas){
		
		double doubleRendimentoPorcentagem =0;
        String strRendimentoPorcentagem =null;
        
        doubleRendimentoPorcentagem =(double) contadorJogadasAcertadas / contadorJogadas *100;
        strRendimentoPorcentagem = String.format("%.2f", doubleRendimentoPorcentagem);
        
        if(doubleRendimentoPorcentagem >= 90){
            return "Voce foi excelente " + strRendimentoPorcentagem+ " %";
        }
        
        else if(doubleRendimentoPorcentagem < 90 && doubleRendimentoPorcentagem >= 75){
             return "Voce foi muito bem " + strRendimentoPorcentagem + " %";
       }
        
        else if(doubleRendimentoPorcentagem < 75 && doubleRendimentoPorcentagem >= 40){
             return "Seu rendimento no jogo foi Regular " + strRendimentoPorcentagem + " %";
        }
        
        else if(doubleRendimentoPorcentagem < 40 && doubleRendimentoPorcentagem >= 0){
             return "Tente outra vez, voce nao foi muito bem " + strRendimentoPorcentagem + " %";
        }
        
        return null;
   }
    
    public String vencedorJogo(int pontosJogador, int pontosComputador){
        
        if(pontosJogador == pontosComputador){
            return "Empate!!!";
        
        }else if(pontosJogador > pontosComputador){
            return "Parebens, voce venceu!!!";
        
        }else if(pontosJogador < pontosComputador){
            return "Voce perdeu, tente novamente!!!";  
        }
        
        return null;
    }
}
