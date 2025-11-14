/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ativ_notafinal;
import javax.swing.JOptionPane;
/**
 *
 * @author fatec-dsm2
 */
public class Ativ_notaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno aluno = null;

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha uma opção:\n" +
                "1 - Cadastro de Aluno\n" +
                "2 - Lançamento de Notas\n" +
                "3 - Cálculo da Média\n" +
                "4 - Avaliação de Desempenho\n" +
                "5 - Sair\n\n" 
            ));

            switch (opcao) {

                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
                    aluno = new Aluno(nome);
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
                    break;

                case 2:
                    if (aluno == null) {
                        JOptionPane.showMessageDialog(null, "Cadastre um aluno");
                        break;
                    }

                    aluno.getNotas().clear();

                    for (int i = 1; i <= 3; i++) {
                        double nota = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite a nota TP" + i + ":")
                        );
                        aluno.adicionarNota(nota);
                    }

                    JOptionPane.showMessageDialog(null, "Notas lançadas!");
                    break;

                case 3:
                    if (aluno == null || aluno.getNotas().size() < 3) {
                        JOptionPane.showMessageDialog(null, "Cadstre o aluno e suas notas");
                        break;
                    }

                    double media = aluno.calcularMedia();
                    JOptionPane.showMessageDialog(
                        null,
                        "Média do aluno " + aluno.getNome() + ": " + String.format("%.2f", media)
                    );
                    break;

                case 4:
                    if (aluno == null || aluno.getNotas().size() < 3) {
                        JOptionPane.showMessageDialog(null, "Cadstre o aluno e suas notas");
                        break;
                    }

                    String resultado =
                        "Aluno: " + aluno.getNome() +
                        "\nNotas: " + aluno.getNotas() +
                        "\nMédia: " + String.format("%.2f", aluno.calcularMedia()) +
                        "\nDesempenho: " + aluno.avaliarDesempenho();

                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }

        } while (opcao != 5);
    }
    
}
