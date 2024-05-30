Class fila: 
package br.unipar.ex1_filadepacientes;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Clinica {
    private Queue<String> filaDePacientes = new LinkedList<>();
    
    public void adicionarPacienteNaFila(String nomeDoPaciente) {
        if (filaDePacientes.size() < 20) {
            filaDePacientes.add(nomeDoPaciente);
        } else {
            JOptionPane.showMessageDialog(null, "A fila de pacientes está cheia para hoje.");
        }
    }
    
    public void chamarPacienteSeguinte(){
        if(!filaDePacientes.isEmpty()){
            String pacienteSeguinte = filaDePacientes.poll();
            JOptionPane.showMessageDialog(null, "Paciente seguinte: " + pacienteSeguinte);
        }else{
            JOptionPane.showMessageDialog(null, "Não há pacientes na fila.");
        }
    }
}


Main: 


package br.unipar.ex1_filadepacientes;

import javax.swing.JOptionPane;

public class Ex1_filadepacientes {

    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        
        while(true){
            String opcao = JOptionPane.showInputDialog("\n1 - Inserir paciente na fila\n2 "
                    + "- Convocar próximo paciente\n3 "
                    + "- Encerrar\nSelecione uma opção:");
            
            if(opcao.equals("1")){
                String nomeDoPaciente = JOptionPane.showInputDialog("Digite o nome do paciente");
                clinica.adicionarPacienteNaFila(nomeDoPaciente);
            } else if(opcao.equals("2")){
                clinica.chamarPacienteSeguinte();
            } else if (opcao.equals("3")){
                break;
            } else{
                JOptionPane.showConfirmDialog(null, "Opção não reconhecida. Por favor, tente novamente");
            }
        }
    }
}