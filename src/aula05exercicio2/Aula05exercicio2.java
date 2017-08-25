package aula05exercicio2;

import javax.swing.JFrame;

public class Aula05exercicio2 {

    public static void main(String[] args) {
        JanelaPedraPapelTesoura janela = new JanelaPedraPapelTesoura();
        janela.setSize(300, 200);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        
    }

}
