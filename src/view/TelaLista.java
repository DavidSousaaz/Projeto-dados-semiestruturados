
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaLista extends JFrame {

	protected JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;

	//private EspecieDAO especieDAO = EspecieDAO.getInstance();

	public TelaLista(String especies) {
		setTitle("");
		setSize(600, 480);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addTabelaEspecies();
		addBTVoltar();
		//popularTabela(especies);
		setVisible(true);
	}

	private void addTabelaEspecies() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome", "Nome Científico", "Categoria","Bioma"});
		tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN, 17));
		painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(30, 80, 530, 290);
		add(painelTabela);
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Listagem de espécies");
		jbTitulo.setBounds(0, 30, 600, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		add(jbTitulo);
	}
	
	private void addBTVoltar() {
		JButton jbVoltar=new JButton("Voltar");
		jbVoltar.setBounds(410,380,150,50);		
		jbVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMenu("");
			}
		});
		add(jbVoltar);
	}
	//ARRUMAR ESSA PARTE DE POPULAR
	private void popularTabela(String especies) {
		
		if(especies.equalsIgnoreCase("")) {
			for (Especie a : especieDAO.getEspecies()) {
				adicionarLinhaTabela(a);
			}
		} else if(especies.equalsIgnoreCase("deletados")) {
			for (Especie a : especieDAO.getEspeciesDeletados()) {
				adicionarLinhaTabela(a);
			}
		}

		

	}

	public void adicionarLinhaTabela(Especie especie) {

		Object[] linha = new Object[3];
		linha[0] = especie.getNome();
		linha[1] = especie.getNomeCientifico();
		linha[2] = especie.getCategoria();
		linha[3] = especie.getBioma();

		modelo.addRow(linha);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < modelo.getColumnCount(); i++) {
			tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

}


