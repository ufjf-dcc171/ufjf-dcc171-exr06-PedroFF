package aula05exercicio2;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final JLabel msgm3 = new JLabel("");
    private final JLabel msgm4 = new JLabel("");
    private int contaRodadas = 0;
    private int vitoriaP1 = 0;
    private int vitoriaP2 = 0;
    private JRadioButton pedra = new JRadioButton("Pedra");
    private JRadioButton papel = new JRadioButton("Papel");
    private JRadioButton tesoura = new JRadioButton("Tesoura");
    private final ButtonGroup jogoGrupo;
    private int valorEscolhido;
    private Random random = new Random();
    private int[] valores = {1, 2, 3};

    public JanelaPedraPapelTesoura() throws HeadlessException {
        super("Pedra, papel e tesoura.");
        valorEscolhido = random.nextInt(valores.length);
        setLayout(new FlowLayout());
        add(msgm);
        add(pedra);
        add(papel);
        add(tesoura);
        add(msgm2);
        add(msgm3);
        add(msgm4);
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
            if (contaRodadas < 8) {
                valorEscolhido = random.nextInt(valores.length);
                if (papel.isSelected()) {
                    if (valorEscolhido == 3) {
                        vitoriaP1++;
                        msgm2.setText("Você ganhou essa rodada.");
                        contaRodadas++;
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else if (valorEscolhido == 2) {
                        vitoriaP2++;
                        contaRodadas++;
                        msgm2.setText("Você perdeu essa rodada.(tesoura)");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else {
                        contaRodadas++;
                        msgm2.setText("Empate");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    }
                }
                if (tesoura.isSelected()) {
                    if (valorEscolhido == 1) {
                        vitoriaP1++;
                        msgm2.setText("Você ganhou essa rodada.");
                        contaRodadas++;
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else if (valorEscolhido == 3) {
                        vitoriaP2++;
                        contaRodadas++;
                        msgm2.setText("Você perdeu essa rodada.(pedra)");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else {
                        contaRodadas++;
                        msgm2.setText("Empate");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    }
                }
                if (pedra.isSelected()) {
                    if (valorEscolhido == 2) {
                        vitoriaP1++;
                        msgm2.setText("Você ganhou essa rodada.");
                        contaRodadas++;
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else if (valorEscolhido == 1) {
                        vitoriaP2++;
                        contaRodadas++;
                        msgm2.setText("Você perdeu essa rodada.(papel)");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    } else {
                        contaRodadas++;
                        msgm2.setText("Empate");
                        msgm3.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                    }
                }
                /*if (i == 3 && valorEscolhido == 1) {
                    vitoriaP2++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                } else if (i > valorEscolhido) {
                    vitoriaP1++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                } else if (i == valorEscolhido) {
                    contaRodadas++;
                    msgm2.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                } else if (i == 1 && valorEscolhido == 3) {
                    vitoriaP1++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                } else if(i<valorEscolhido) {
                    vitoriaP2++;
                    contaRodadas++;
                    msgm2.setText("Jogador: " + vitoriaP1 + " Computador: " + vitoriaP2 + " Rodadas: " + contaRodadas);
                }*/
            } else {
                msgm3.setSize(35, 35);
                msgm4.setSize(35, 35);
                msgm3.setText("ACABOU O JOGO!");
                if (vitoriaP1 > vitoriaP2) {
                    msgm4.setText("Você ganhou!! Parabéns!");
                } else {
                    msgm4.setText("Você perdeu, boa sorte da próxima vez!");
                }
            }
        }
    }

}
