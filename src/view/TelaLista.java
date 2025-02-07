package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.EspecieDAO;
import model.Especie;

public class TelaLista extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane painelTabela;
    private EspecieDAO especieDAO = new EspecieDAO();

    public TelaLista() {
        setTitle("Lista de Espécies");
        setSize(600, 480);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addJLabelTitulo();
        addTabelaEspecies();
        addBTVoltar();
        popularTabela();  // Agora carrega todas as espécies

        setVisible(true);
    }

    private void addTabelaEspecies() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Categoria", "Nome Científico", "Nome Comum", "Grupo", "Bioma"});
        tabela = new JTable(modelo);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        painelTabela = new JScrollPane(tabela);
        painelTabela.setBounds(30, 80, 530, 290);
        add(painelTabela);
    }

    private void addJLabelTitulo() {
        JLabel jbTitulo = new JLabel("Listagem de Todas as Espécies");
        jbTitulo.setBounds(0, 30, 600, 30);
        jbTitulo.setHorizontalAlignment(JLabel.CENTER);
        jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(jbTitulo);
    }

    private void addBTVoltar() {
        JButton jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(410, 380, 150, 50);
        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaMenu(""); // Volta ao menu principal
            }
        });
        add(jbVoltar);
    }

    private void popularTabela() {
        List<Especie> especies = especieDAO.buscarTodasEspecies();
        for (Especie especie : especies) {
            modelo.addRow(new Object[]{
                especie.getRiscoExtincao(),
                especie.getEspecie(),
                especie.getNomeComum(),
                especie.getGrupo(),
                especie.getBioma()
            });
        }
    }
}
