
Class biblioteca:

package br.unipar.ex3_pilhadelivros;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Biblioteca {
    private Stack<String> pilhaDeLivros = new Stack<>();
    
    public void inserirLivro(String livro){
        pilhaDeLivros.push(livro);
    }
    
    public void exibirLivros(){
        JOptionPane.showMessageDialog(null, "Livros na pilha: "+
                pilhaDeLivros);
    }
    
    public void retirarLivro(){
        if(!pilhaDeLivros.isEmpty()){
            String livro = pilhaDeLivros.pop();
            JOptionPane.showMessageDialog(null, "Livro retirado: "
            + livro);
        }else{
            JOptionPane.showMessageDialog(null, "Não existem "
                    + "livros para retirar");
        }
    }
}

main:


package br.unipar.ex3_pilhadelivros;

import javax.swing.JOptionPane;

public class Ex3_pilhadelivros {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        
        while(true){
            String opcao = JOptionPane.showInputDialog("\n1 - Inserir livro"
                    + "\n2 - Exibir livros"
                    + "\n3 - Retirar livro"
                    + "\nSelecione uma opção");
            
            if(opcao.equals("1")){
                String livro = JOptionPane.showInputDialog("Informe o título do livro");
                biblioteca.inserirLivro(livro);
            }else if(opcao.equals("2")){
                biblioteca.exibirLivros();
            }else if(opcao.equals("3")){
                biblioteca.retirarLivro();
            }else{
                JOptionPane.showMessageDialog(null, "Opção não reconhecida. Por favor, tente novamente.");
            }
            
        }
    }
}