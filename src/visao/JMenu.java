package visao;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controle.CClienteControl;
import modelo.MCliente;

import controle.CVeiculoControl;
import modelo.MVeiculo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;

public class JMenu extends JFrame {

	private JPanel contentPane;
	private JTable tbCliente;
	// private JComboBox<MCliente> comboBox;
	private JTable tbVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu();
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
	public JMenu() {

		// comboBox = new JComboBox<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btCadastrarCliente = new JButton("Clientes");
		btCadastrarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCadastroCliente jcc = new JCadastroCliente();
				jcc.setLocationRelativeTo(null);
				jcc.setVisible(true);
				dispose();
			}
		});
		btCadastrarCliente.setBounds(12, 12, 180, 25);
		contentPane.add(btCadastrarCliente);

		JButton btCadastrarVeiculo = new JButton("Veiculos");
		btCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroVeiculo jcv = new JCadastroVeiculo();
				jcv.setLocationRelativeTo(null);
				jcv.setVisible(true);
				dispose();
			}
		});
		btCadastrarVeiculo.setBounds(204, 12, 180, 25);
		contentPane.add(btCadastrarVeiculo);

		JButton btExit = new JButton("Exit");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setBounds(396, 12, 180, 25);
		contentPane.add(btExit);

		JLabel lbTitulo = new JLabel("Pessoas Cadastradas");
		lbTitulo.setBounds(12, 66, 180, 14);
		contentPane.add(lbTitulo);

		JScrollPane spCliente = new JScrollPane();
		spCliente.setBounds(12, 94, 904, 119);
		contentPane.add(spCliente);

		CClienteControl cC = CClienteControl.getInstancia();
		ArrayList<MCliente> listaClientes = cC.listaCliente();
		tbCliente = new JTable();
		tbCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modeloCliente = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Data Nasc.", "CNH", "Sexo", "Telefone", "Gmail" });
		for (MCliente Cliente : listaClientes) {
			modeloCliente.addRow(new Object[] { Cliente.getwNome(), Cliente.getwCpf(), Cliente.getwDataNascimento(),
				    Cliente.getwCarteiraMotorista(), Cliente.getwSexo(), Cliente.getwNumeroTelefone(),
					Cliente.getwGmail() });
		}
		tbCliente.setModel(modeloCliente);
		spCliente.setViewportView(tbCliente);

	
		JScrollPane spVeiculo = new JScrollPane();
		spVeiculo.setBounds(12, 258, 904, 119);
		contentPane.add(spVeiculo);

		CVeiculoControl cV = CVeiculoControl.getInstacia();
		ArrayList<MVeiculo> listaVeiculo = cV.listaVeiculos();

		tbVeiculo = new JTable();
		tbVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modeloVeiculo = new DefaultTableModel(new Object[][] {}, new String[] { "IDVeiculo","Dono Veiculo",
				"Tipo Veiculo", "Marca", "Placa", "Ano Modelo", "Combustivel", "Cor", "Nacional" });
		for (MVeiculo Veiculo : listaVeiculo) {
			modeloVeiculo.addRow(new Object[] { 
					Veiculo.getwIDVeiculo(),Veiculo.getwDonoVeiculo(),Veiculo.getwTipoVeiculo(), Veiculo.getwMarca(),
					Veiculo.getwPlaca(), Veiculo.getwAnoModelo(), Veiculo.getwCombustivel(), 
					Veiculo.getwCor(), Veiculo.getwNacional()});
		};
		tbVeiculo.setModel(modeloVeiculo);
		spVeiculo.setViewportView(tbVeiculo);

		JLabel lblPessoaConsultada = new JLabel("Veiculos Cadastrados");
		lblPessoaConsultada.setBounds(12, 232, 180, 14);
		contentPane.add(lblPessoaConsultada);
	
	}

	
}
