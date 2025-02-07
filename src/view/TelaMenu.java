package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaMenu extends JFrame {
	
	public TelaMenu(String titulo) {
		setTitle(titulo);
		setSize(350,260);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLMenu();
		addBTBuscar();
		addBTListar();
		addBTSair();
		setVisible(true);

	}
	
	private void addJLMenu() {
		JLabel jlMenu = new JLabel("Menu Inicial");
		jlMenu.setBounds(0,20,350,30);
		jlMenu.setHorizontalAlignment(JLabel.CENTER);
		jlMenu.setFont(new Font("Arial",Font.BOLD,20));
		add(jlMenu);
	}
	
	private void addBTListar() {
		JButton jbListar=new JButton("Listar");
		jbListar.setBounds(15,80,140,50);		
		jbListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLista();
			}
		});
		add(jbListar);
	}
	
	private void addBTBuscar() {
		JButton jbBuscar = new JButton("Buscar");
		jbBuscar.setBounds(180,80,140,50);
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaBusca("");
			}
		});
		add(jbBuscar);
	}
	
	
	private void addBTSair() {
		JButton jbSair=new JButton("Sair");
		jbSair.setBounds(180,155,140,50);		
		jbSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		add(jbSair);
	}
	
	
	
}

