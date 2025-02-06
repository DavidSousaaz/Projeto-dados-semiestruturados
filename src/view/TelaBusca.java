package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaBusca extends JFrame {
	public TelaBusca(String titulo) {
		setTitle(titulo);
		setSize(400,350);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLBusca();
        addCampoBusca();
        addBTBuscar();
        addResultado();
        addBTVoltar();
		setVisible(true);

	}
	
	private JTextField campoBusca;
    private JTextArea resultado;
    
	private void addJLBusca() {
        JLabel jlBusca = new JLabel("Digite o nome da espécie:");
        jlBusca.setBounds(20, 20, 200, 30);
        add(jlBusca);
    }

    private void addCampoBusca() {
        campoBusca = new JTextField();
        campoBusca.setBounds(20, 50, 250, 30);
        add(campoBusca);
    }

    private void addBTBuscar() {
        JButton jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(280, 50, 90, 30);
        jbBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEspecie();
            }
        });
        add(jbBuscar);
    }

    private void addResultado() {
        resultado = new JTextArea();
        resultado.setBounds(20, 100, 350, 150);
        resultado.setEditable(false);
        add(resultado);
    }

    private void buscarEspecie() {
        String nomeEspecie = campoBusca.getText().trim();
        if (nomeEspecie.isEmpty()) {//botar pra se for diferente dos que estao registrados no banco dar invalido
            resultado.setText("Digite um nome válido!");
            return;
        } //arrumar else 

    }
	
    private void addBTVoltar() {
		JButton jbVoltar=new JButton("Voltar");
		jbVoltar.setBounds(280,265,90,30);		
		jbVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu("");
			}
		});
		add(jbVoltar);
	}
}
