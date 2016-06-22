package br.edu.fasete.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Pagamento;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

public class JRelatorio extends JInternalFrame {
	private JTable tabelaCategoria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRelatorio frame = new JRelatorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JRelatorio() {
		setBounds(100, 100, 596, 459);
		
		JPanel exibirpanel = new JPanel();
		getContentPane().add(exibirpanel, BorderLayout.CENTER);
		
		
		tabelaCategoria = new JTable(new RelatorioTableModel());
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
		});
		exibirpanel.setLayout(new MigLayout("", "[521px,grow]", "[344px,grow]"));
		
		tabelaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane_1 = new JScrollPane(tabelaCategoria);
		exibirpanel.add(scrollPane_1, "cell 0 0,grow");

	}
	public void carregarTabelanome() {
		RelatorioTableModel tableModel = (RelatorioTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Pagamento cat : Fachada.getInstancia().listarPagamentos()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
