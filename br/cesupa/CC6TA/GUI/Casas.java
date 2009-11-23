package br.cesupa.CC6TA.GUI;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Casas {
    
    int excluidos = 0;
    int cont=0;
    public boolean exApaga=false;
    
    public ComboBoxModel criaModel(){
        ArrayList al = new ArrayList();
        al.add("Selecione...");
        al.add("Wumpus");
        al.add("Ouro");
        al.add("Buraco");
        Object[] lista = al.toArray();
        ComboBoxModel modelo = new DefaultComboBoxModel(lista);
        return modelo;
    }
    
    public Object[] replicaModel(String objeto){
        
        ArrayList al = new ArrayList();
        
        if(objeto.equals("Selecione...")){
        }else if(objeto.equals("Wumpus")){
            excluidos+=1;
        }else if(objeto.equals("Ouro")){
            excluidos+=2;
        }else if(objeto.equals("Buraco")){
            cont++;
            if(cont>=3){
                excluidos+=4;
            }
        }
        
        switch(excluidos){
            case 0:{   
                al.add("Selecione...");
                al.add("Wumpus");
                al.add("Ouro");
                al.add("Buraco");
                break;}
            case 1:{
                al.add("Selecione...");
                al.add("Ouro");
                al.add("Buraco");
                break;}
            case 2:{
                al.add("Selecione...");
                al.add("Wumpus");
                al.add("Buraco");
                break;}
            case 3:{
                al.add("Selecione...");
                al.add("Buraco");
                break;}
            case 4:{
                al.add("Selecione...");
                al.add("Wumpus");
                al.add("Ouro");
                break;}
            case 5:{
                al.add("Selecione...");
                al.add("Ouro");
                break;}
            case 6:{
                al.add("Selecione...");
                al.add("Wumpus");
                break;}
            case 7:{
                al.add("Sem Opções");
                exApaga=true;
                break;}
        }
        
        Object[] lista = al.toArray();
        ComboBoxModel modelo = new DefaultComboBoxModel(lista);
        return lista;
    }

    public boolean isExApaga() {
        return exApaga;
    }

    

}
