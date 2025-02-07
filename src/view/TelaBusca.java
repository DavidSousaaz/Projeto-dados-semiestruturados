package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import Dao.EspecieDAO;
import model.Especie;

public class TelaBusca extends JFrame {
    private JComboBox<String> comboBoxGrupos;
    private JTextArea resultado;
    private JScrollPane scrollPane;

    public TelaBusca(String titulo) {
        setTitle(titulo);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addJLBusca();
        addComboBoxGrupos();
        addBTBuscar();
        addResultado();
        addBTVoltar();
        setVisible(true);
    }

    private void addJLBusca() {
        JLabel jlBusca = new JLabel("Selecione o grupo de espécies:");
        jlBusca.setBounds(20, 20, 250, 30);
        add(jlBusca);
    }

    private void addComboBoxGrupos() {
        String[] grupos = {"Invertebrados Terrestres", "Tubarões e Raias", "Aves", "Invertebrados de Água Doce", "Peixes Continentais", "Anfíbios", "Mamíferos", "Invertebrados Marinhos", "Répteis", "Peixes Marinhos (ósseos)"};
        comboBoxGrupos = new JComboBox<>(grupos);
        comboBoxGrupos.setBounds(20, 50, 250, 30);
        add(comboBoxGrupos);
    }

    private void addBTBuscar() {
        JButton jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(280, 50, 90, 30);
        jbBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEspecies();
            }
        });
        add(jbBuscar);
    }

    private void addResultado() {
        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        
        scrollPane = new JScrollPane(resultado);
        scrollPane.setBounds(20, 100, 350, 150);
        add(scrollPane);
    }

    private void buscarEspecies() {
        String grupoSelecionado = (String) comboBoxGrupos.getSelectedItem();
        List<Especie> especies = EspecieDAO.buscarEspeciesPorGrupo(grupoSelecionado);

        if (especies.isEmpty()) {
            resultado.setText("Nenhuma espécie encontrada para esse grupo.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Especie especie : especies) {
                sb.append("\nEspécie: ").append(especie.getEspecie()).append("\n");
                sb.append("Nome Comum: ").append(especie.getNomeComum()).append("\n");
                sb.append("Bioma: ").append(especie.getBioma()).append("\n");
                sb.append("Categoria: ").append(especie.getRiscoExtincao()).append("\n");
                sb.append("-------------------------------------------------------------------\n");
            }
            resultado.setText(sb.toString());
        }
    }

    private void addBTVoltar() {
        JButton jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(280, 265, 90, 30);
        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaMenu("");
            }
        });
        add(jbVoltar);
    }
}
