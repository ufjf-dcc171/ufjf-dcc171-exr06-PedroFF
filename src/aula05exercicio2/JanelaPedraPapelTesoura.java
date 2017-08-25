package aula05exercicio2;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 Construa uma aplicação gráfica que simule um jogo pedra-papel-tesoura. Solicite:
Uma das opções entre pedra, papel e tesoura;
Acrescente um botão para realizar o cálculo.
A jogada da “máquina” de ser realizada pelo java.util.Random (As chances não precisam ser simétricas).
Exiba um placar final após 7 rodada
 */
public class JanelaPedraPapelTesoura extends JFrame {

    private final JLabel msgm = new JLabel("BEM VINDO AO PEDRA, PAPEL E TESOURA");
    private final JLabel msgm2 = new JLabel("");
    private int contaRodadas = 1;
    private int vitoriaP1 = 0;
    private int vitoriaP2 = 0;
    private JRadioButton pedra = new JRadioButton("Pedra");
    private JRadioButton papel = new JRadioButton("Papel");
    private JRadioButton tesoura = new JRadioButton("Tesoura");
    private final ButtonGroup jogoGrupo;
    private int valorEscolhido;

    public JanelaPedraPapelTesoura() throws HeadlessException {
        super("Pedra, papel e tesoura.");
        int[] valores = {1, 2, 3};
        Random random = new Random();
        valorEscolhido = random.nextInt(3);
        setLayout(new FlowLayout());
        add(msgm);
        add(pedra);
        add(papel);
        add(tesoura);
        add(msgm2);
        jogoGrupo = new ButtonGroup();
        jogoGrupo.add(pedra);
        jogoGrupo.add(papel);
        jogoGrupo.add(tesoura);

        int iPapel = 1;
        int iTesoura = 2;
        int iPedra = 3;

        pedra.addItemListener(new Jogo(iPedra));
        papel.addItemListener(new Jogo(iPapel));
        tesoura.addItemListener(new Jogo(iTesoura));
    }

    private class Jogo implements ItemListener {

        int i;

        private Jogo(int i) {
            this.i = i;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            while (contaRodadas < 8) {
                if (i == 1 && valorEscolhido == 3) {
                    vitoriaP1++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + " Computador: " + " Rodadas: " + contaRodadas);
                } else if (i > valorEscolhido) {
                    vitoriaP1++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + " Computador: " + " Rodadas: " + contaRodadas);
                } else if (i == valorEscolhido) {
                    contaRodadas++;
                    msgm2.setText("Jogador: " + " Computador: " + " Rodadas: " + contaRodadas);
                } else {
                    vitoriaP2++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + " Computador: " + " Rodadas: " + contaRodadas);
                }
            }
        }
    }

}
