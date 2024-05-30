
Class banco:

package br.unipar.ex2_filabanco;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Banco {
    private Queue<Cliente> filaDeClientesNormais = new LinkedList<>();
    private Queue<Cliente> filaDeClientesPrioritarios = new LinkedList<>();
    private int contadorPrioritario = 0;
    
    public void registrarCliente(Cliente cliente){
        int idade = 2024 - cliente.anoNascimento;
        
        if(idade >= 65){
            filaDeClientesPrioritarios.add(cliente);
        }else{
            filaDeClientesNormais.add(cliente);
        }
    }
    
    public void convocarClienteSeguinte(){
        if(!filaDeClientesPrioritarios.isEmpty() && contadorPrioritario < 2){
            Cliente clienteSeguinte = filaDeClientesPrioritarios.poll();
            JOptionPane.showMessageDialog(null, "Cliente prioritário a ser atendido: "
                    + clienteSeguinte.nome);
            contadorPrioritario++;
        }else if(!filaDeClientesNormais.isEmpty()){
            Cliente clienteSeguinte = filaDeClientesNormais.poll();
            JOptionPane.showMessageDialog(null, "Cliente normal a ser atendido: "
            + clienteSeguinte.nome );
            contadorPrioritario = 0;
        }else{
            JOptionPane.showMessageDialog(null, "Não há mais clientes na fila");
        }
    }
}

Class Clientes:

package br.unipar.ex2_filabanco;

public class Cliente {
    int codigoDeAcesso;
    String nomeCompleto;
    int anoDeNascimento;
    
    Cliente(int codigoDeAcesso, String nomeCompleto, int anoDeNascimento){
        this.codigoDeAcesso = codigoDeAcesso;
        this.nomeCompleto = nomeCompleto; 
        this.anoDeNascimento = anoDeNascimento;
    }
}
Main:


package br.unipar.ex2_filabanco;

import javax.swing.JOptionPane;

public class Ex2_filabanco {

    public static void main(String[] args) {
        Banco banco = new Banco();
        
        while (true){
            String opcao = JOptionPane.showInputDialog("\n1 - Registrar cliente"
                    + "\n2 - Convocar próximo cliente"
                    + "\n3 - Encerrar"
                    + "\nSelecione uma opção");
            
            if(opcao.equals("1")){
                int codigoDeAcesso = Integer.parseInt(JOptionPane.showInputDialog(
                        "Informe o código de acesso do cliente"));
                String nomeCompleto = JOptionPane.showInputDialog("Informe o nome completo"
                        + "do cliente");
                int anoDeNascimento = Integer.parseInt(JOptionPane.showInputDialog(
                        "Informe o ano de nascimento do cliente"));
                Cliente cliente = new Cliente(codigoDeAcesso, nomeCompleto, anoDeNascimento);
                banco.registrarCliente(cliente);
            }else if(opcao.equals("2")){
                banco.convocarClienteSeguinte();
            }else if(opcao.equals("3")){
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Opção"
                        + "não reconhecida. Por favor, tente novamente");
            }
            
        }
        
    }
}