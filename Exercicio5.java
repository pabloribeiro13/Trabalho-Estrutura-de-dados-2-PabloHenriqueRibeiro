
Class Armazém:

package br.unipar.ex5_transportes;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Armazem {
    private Stack<Item>[] pilhaDeItens = new Stack[5];
    
    public Armazem(){
        for(int i = 0; i < pilhaDeItens.length; i++){
            pilhaDeItens[i] = new Stack<>();
        }
    }
    
    public void inserirItem(int pilha, Item item){
        if(pilhaDeItens[pilha].size() < 10){
            pilhaDeItens[pilha].push(item);
        }else{
            JOptionPane.showMessageDialog(null, "A pilha de itens "
            +"está cheia.");
        }
    }
    
    public void exibirItens(int pilha){
        StringBuilder itens = new StringBuilder();
        for (Item item : pilhaDeItens[pilha]) {
            itens.append(item.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Itens na pilha:\n" + itens);
    }
    
    public void retirarItem(int pilha){
        if(!pilhaDeItens[pilha].isEmpty()){
            Item item = pilhaDeItens[pilha].pop();
            JOptionPane.showMessageDialog(null, "Item retirado: "
                    + item);
        }
    }
    
}
class Item:

package br.unipar.ex5_transportes;

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
Main:


package br.unipar.ex5_transportes;

import javax.swing.JOptionPane;

public class Ex5_transportes {

    public static void main(String[] args) {
        Armazem armazem = new Armazem();

        while (true) {
            String opcao = JOptionPane.showInputDialog("\n1 - Inserir item"
                    + "\n2 - Exibir itens"
                    + "\n3 - Retirar item"
                    + "\nSelecione uma opção");

            if (opcao.equals("1")) {
                int pilha = Integer.parseInt(JOptionPane.showInputDialog
                    ("Informe a pilha (0-4):"));
                
                String codigoDoItem = JOptionPane.showInputDialog
                    ("Informe o código do item:");
                
                String descricaoDoItem = JOptionPane.showInputDialog
                    ("Informe a descrição do item:");
                
                String dataDeRecebimento = JOptionPane.showInputDialog
                    ("Informe a data de recebimento do item:");
                
                String estadoDeOrigem = JOptionPane.showInputDialog
                    ("Informe o estado de origem:");
                
                String estadoDeDestino = JOptionPane.showInputDialog
                    ("Informe o estado de destino:");
                
                Item item = new Item(codigoDoItem, descricaoDoItem, dataDeRecebimento, 
                    estadoDeOrigem, estadoDeDestino);
                
                    armazem.inserirItem(pilha, item);
                    
            } else if (opcao.equals("2")) {
                int pilha = Integer.parseInt(JOptionPane.showInputDialog
                ("Informe a pilha (0-4):"));
                armazem.exibirItens(pilha);
                
            } else if (opcao.equals("3")) {
                int pilha = Integer.parseInt
                (JOptionPane.showInputDialog("Informe a pilha (0-4):"));
                armazem.retirarItem(pilha);
                
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Opção não reconhecida. Por favor, tente novamente.");
            }
        }
    }
}