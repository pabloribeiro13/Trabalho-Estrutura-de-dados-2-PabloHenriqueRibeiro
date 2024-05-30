Class Item:

package br.unipar.ex4_transportes;

public class Item {
    String codigoDoItem;
    String descricaoDoItem;
    String dataDeRecebimento;
    String estadoDeOrigem;
    String estadoDeDestino;

    Item(String codigoDoItem, String descricaoDoItem, String dataDeRecebimento, 
            String estadoDeOrigem, String estadoDeDestino){
        this.codigoDoItem = codigoDoItem;
        this.descricaoDoItem = descricaoDoItem;
        this.dataDeRecebimento = dataDeRecebimento;
        this.estadoDeOrigem = estadoDeOrigem;
        this.estadoDeDestino = estadoDeDestino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{");
        sb.append("codigoDoItem=").append(codigoDoItem);
        sb.append(", descricaoDoItem=").append(descricaoDoItem);
        sb.append(", dataDeRecebimento=").append(dataDeRecebimento);
        sb.append(", estadoDeOrigem=").append(estadoDeOrigem);
        sb.append(", estadoDeDestino=").append(estadoDeDestino);
        sb.append('}');
        return sb.toString();
    }
}
classe Armazém:

package br.unipar.ex4_transportes;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Armazem {
    private Stack<Item> pilhaDeItens = new Stack<>();
    
    public void adicionarItem(Item item){
        if(pilhaDeItens.size() < 10){
            pilhaDeItens.push(item);
        }else{
            JOptionPane.showMessageDialog(null, "A pilha de itens "
            +"está cheia.");
        }
    }
    
    public void listarItens(){
        JOptionPane.showMessageDialog(null, "Itens na pilha: "
                + pilhaDeItens);
    }
    
    public void despacharItem(){
        if(!pilhaDeItens.isEmpty()){
            Item item = pilhaDeItens.pop();
            JOptionPane.showMessageDialog(null, "Item despachado: "
                    + item);
        }
    }
    
}
main:


package br.unipar.ex4_transportes;

import javax.swing.JOptionPane;

public class Ex4_transportes {

    public static void main(String[] args) {
        Armazem armazem = new Armazem();
        
        while(true){
            String opcao = JOptionPane.showInputDialog("\n1 - Inserir item"
                    + "\n2 - Exibir itens"
                    + "\n3 - Retirar item"
                    + "\nSelecione uma opção");
            
            if(opcao.equals("1")){
                String codigoDoItem = 
                        JOptionPane.showInputDialog("Informe o código do item");
                
                String descricaoDoItem = 
                        JOptionPane.showInputDialog("Informe a descrição do item");
                
                String dataDeRecebimento = 
                        JOptionPane.showInputDialog("Informe a data de recebimento do item");
                
                String estadoDeOrigem = 
                        JOptionPane.showInputDialog("Informe o estado de origem");
                
                String estadoDeDestino = 
                        JOptionPane.showInputDialog("Informe o estado de destino");
                
                Item item = new Item(codigoDoItem, descricaoDoItem, 
                        dataDeRecebimento, estadoDeOrigem, estadoDeDestino);
                armazem.adicionarItem(item);
            }else if(opcao.equals("2")){
                armazem.exibirItens();
            }else if(opcao.equals("3")){
                armazem.retirarItem();
            }else{
                JOptionPane.showMessageDialog(null, "Opção não reconhecida. Por favor, tente novamente.");
            }
        }
    }
}