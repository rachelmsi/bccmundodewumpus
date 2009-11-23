package br.cesupa.CC6TA.GUI;

public class Agente {
    public int[] encontra(String[][] matriz,String objeto){
       int[] posicao = new int[2];
        for(int x=0; x<matriz.length;x++){
            for(int y=0; y<matriz.length ;y++){
                if(matriz[x][y].equalsIgnoreCase(objeto)){
                    posicao[0]=x;
                    posicao[1]=y;
                }
            }
        }
        
        return posicao;
    }
}
