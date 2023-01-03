package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;

import controle.CClienteControl;
import controle.CVeiculoControl;
import modelo.MCliente;
import modelo.MVeiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class JCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField edNome;
	private JTextField edCnh;
	private JTextField edCpf;
	private JTextField edTelefone;
	private JTextField edGmail;
	private JTextField edData;
	private ArrayList<MCliente> Clientes;
	public boolean wEncontrou;

	JMenu menu = new JMenu();

	public JCadastroCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Labels

		JLabel lbStatus = new JLabel("<Aguardadando>");
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(383, 268, 125, 15);
		contentPane.add(lbStatus);

		JLabel lbTitulo = new JLabel("Cadastro Cliente");
		lbTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 12));
		lbTitulo.setBounds(174, 0, 158, 14);
		lbTitulo.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lbTitulo);

		JLabel lbCpf = new JLabel("CPF :  ");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(88, 59, 46, 14);
		contentPane.add(lbCpf);

		JLabel lbNome = new JLabel("Nome : ");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(79, 137, 55, 14);
		contentPane.add(lbNome);

		JLabel lbCnh = new JLabel("CNH :  ");
		lbCnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCnh.setBounds(88, 172, 46, 14);
		contentPane.add(lbCnh);

		JLabel lbTelefone = new JLabel("Telefone :  ");
		lbTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefone.setBounds(45, 208, 89, 14);
		contentPane.add(lbTelefone);

		JLabel lbGmail = new JLabel("Gmail :  ");
		lbGmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbGmail.setBounds(55, 243, 79, 14);
		contentPane.add(lbGmail);

		JLabel lbData = new JLabel("Dta. Nascimento: ");
		lbData.setHorizontalAlignment(SwingConstants.RIGHT);
		lbData.setBounds(-47, 92, 181, 14);
		contentPane.add(lbData);

		JLabel lbImg = new JLabel("New label");
		lbImg.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/visao/149071_resized.png")));
		lbImg.setBounds(393, 0, 102, 105);
		contentPane.add(lbImg);

		JLabel lbSexo = new JLabel("Sexo :");
		lbSexo.setBounds(88, 284, 46, 18);
		contentPane.add(lbSexo);

		// ComboBox
		JComboBox<String> cbSexo = new JComboBox();
		cbSexo.setBounds(147, 282, 148, 22);
		cbSexo.addItem("");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		contentPane.add(cbSexo);

		// TextFiel
		edNome = new JTextField();
		edNome.setBounds(147, 134, 222, 20);
		contentPane.add(edNome);
		edNome.setColumns(10);

		edCnh = new JTextField();
		edCnh.setColumns(10);
		try {
			edCnh = new JFormattedTextField(new MaskFormatter("###########"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edCnh.setBounds(147, 169, 220, 20);
		contentPane.add(edCnh);

		edCpf = new JTextField();
		edCpf.setColumns(10);
		try {
			edCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edCpf.setBounds(147, 56, 222, 20);
		contentPane.add(edCpf);

		edTelefone = new JTextField();
		edTelefone.setColumns(10);
		try {
			edTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edTelefone.setBounds(147, 205, 148, 20);
		contentPane.add(edTelefone);

		edGmail = new JTextField();
		edGmail.setColumns(10);
		try {
			edGmail = new JFormattedTextField(new MaskFormatter("UUUU@##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edGmail.setBounds(147, 240, 222, 20);
		contentPane.add(edGmail);

		edData = new JTextField();
		edData.setColumns(10);
		try {
			edData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edData.setBounds(147, 89, 148, 20);
		contentPane.add(edData);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		btnFechar.setBounds(393, 199, 102, 23);
		contentPane.add(btnFechar);

		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setFont(new Font("Dialog", Font.BOLD, 11));
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CClienteControl cC = new CClienteControl();
				ArrayList<MCliente> Clientes = cC.listaCliente();

				MCliente Mc = new MCliente();

				if (wEncontrou == false) {
					for (MCliente mCliente : Clientes) {
						if (edCpf.getText().equals(mCliente.getwCpf()) && wEncontrou == false) {
							JOptionPane.showMessageDialog(null,
									"Cliente já está cadastrado, você pode deletar " + "ou alterar os Dados dele");
							wEncontrou = true;
							lbStatus.setText("Alterando");
						}
					}

				}

				if (wEncontrou == true) {

					for (MCliente mCliente : Clientes) {
						if (edCpf.getText().equals(mCliente.getwCpf())) {
							edNome.setText(mCliente.getwNome());
							edCnh.setText(mCliente.getwCarteiraMotorista());
							cbSexo.setSelectedItem(mCliente.getwSexo());
							edGmail.setText(mCliente.getwGmail());
							edTelefone.setText(mCliente.getwNumeroTelefone());
							String wDate = String.valueOf(mCliente.getwDataNascimento());
							edData.setText(wDate);

						}

					}

					if (wEncontrou != true) {
						lbStatus.setText("Novo Cliente!");
					}
				}
			}
		});
		btnPreencher.setBounds(393, 117, 102, 23);
		contentPane.add(btnPreencher);

		JButton btGravar = new JButton("Gravar");
		btGravar.setFont(new Font("Dialog", Font.BOLD, 11));
		btGravar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CClienteControl cC = new CClienteControl();
				ArrayList<MCliente> Clientes = cC.listaCliente();
				MCliente Mc = new MCliente();

				String wCpf = edCpf.getText();
				String wNome = edNome.getText();
				String wCnh = edCnh.getText();
				String wSexo = cbSexo.getSelectedItem().toString();
				String wEmail = edGmail.getText();
				String wTelefone = edTelefone.getText();
				String wDataTest = edData.getText();
				LocalDate wData = LocalDate.parse(edData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				Integer contValidacao = 0;

				if (wEncontrou == false) {
					for (MCliente mCliente : Clientes) {
						if (edCpf.getText().equals(mCliente.getwCpf())){
							JOptionPane.showMessageDialog(null,
									"Cliente já está cadastrado, você pode deletar " + "ou alterar os Dados dele");
							wEncontrou = true;
							lbStatus.setText("Alterando");

							edCpf.setText("");

						}

					}
				}
				
				if (wEncontrou == false) {

					// Dados nome do Cliente
					if (wNome == null || wNome.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");

					} else {
						contValidacao++;
						Mc.setwNome(wNome);
					}
					// Dados do Cpf
					if (wCpf == null || wNome.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CPF");
					} else {

						/*
						 * Transformar o Cpf de String para long wCpf.replaceAll("[^0-9]", ""); Long
						 * wCpftest = Long.valueOf(wCpf);
						 */

						contValidacao++;
						Mc.setwCpf(wCpf);
					}

					// Dados da Cnh
					if (wCnh == null || wCnh.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CNH");

					} else {
						contValidacao++;
						Mc.setwCarteiraMotorista(wCnh);
					}
					// Dados do Email
					if (wEmail == null || wEmail.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Email");
					} else {
						contValidacao++;
						Mc.setwGmail(wEmail);
					}
					// Dados do telefone
					if (wTelefone == null || wTelefone.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preecha o Telefone");
					} else {
						contValidacao++;
						Mc.setwNumeroTelefone(wTelefone);
					}
					// Dados do Sexo
					if (wSexo == null || wSexo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Sexo");
					} else {
						contValidacao++;
						Mc.setwSexo(wSexo);
					}
					// Dados da Data
					if (wDataTest == null || wDataTest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Data");
					} else {
						contValidacao++;
						Mc.setwDataNascimento(wData);
					}

					CClienteControl TableCliente = CClienteControl.getInstancia();
					Boolean insert = TableCliente.inserir(Mc);

					// laço confirmação dos Dados

					if (contValidacao == 7) {

						JOptionPane.showMessageDialog(null, "Dados confirmados");
						contValidacao = 0;
						JMenu m = new JMenu();
						m.setLocationRelativeTo(null);
						m.setVisible(true);
						dispose();

					}
				} else {

					contValidacao = 0;
					// Dados nome do Cliente
					if (wNome == null || wNome.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");

					} else {
						contValidacao++;
						Mc.setwNome(wNome);
					}
					// Dados do Cpf
					if (wCpf == null || wNome.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CPF");
					} else {

						contValidacao++;
						Mc.setwCpf(wCpf);
					}

					// Dados da Cnh
					if (wCnh == null || wCnh.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CNH");

					} else {
						contValidacao++;
						Mc.setwCarteiraMotorista(wCnh);
					}
					// Dados do Email
					if (wEmail == null || wEmail.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Email");
					} else {
						contValidacao++;
						Mc.setwGmail(wEmail);
					}
					// Dados do telefone
					if (wTelefone == null || wTelefone.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preecha o Telefone");
					} else {
						contValidacao++;
						Mc.setwNumeroTelefone(wTelefone);
					}
					// Dados do Sexo
					if (wSexo == null || wSexo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Sexo");
					} else {
						contValidacao++;
						Mc.setwSexo(wSexo);
					}
					// Dados da Data
					if (wDataTest == null || wDataTest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Data");
					} else {
						contValidacao++;
						Mc.setwDataNascimento(wData);
					}
					
					CClienteControl TableCliente = CClienteControl.getInstancia();
					Boolean alterar = TableCliente.alterar(Mc, wCpf);

					if (contValidacao == 7) {

						JOptionPane.showMessageDialog(null, "Dados confirmados");
						contValidacao = 0;
						JMenu m = new JMenu();
						m.setLocationRelativeTo(null);
						m.setVisible(true);
						dispose();

					}

				
				}

			}
		});
		btGravar.setBounds(393, 145, 102, 23);
		contentPane.add(btGravar);

		JButton btVoltar = new JButton("<");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu m = new JMenu();
				m.setLocationRelativeTo(null);
				m.setVisible(true);
				dispose();
			}
		});
		btVoltar.setBounds(22, -5, 46, 25);
		contentPane.add(btVoltar);

		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edCpf.setText("");
				edCnh.setText("");
				edData.setText("");
				edGmail.setText("");
				edNome.setText("");
				edTelefone.setText("");
				cbSexo.setSelectedItem("");
			}
		});
		btLimpar.setFont(new Font("Dialog", Font.BOLD, 11));
		btLimpar.setBounds(393, 234, 102, 23);
		contentPane.add(btLimpar);

		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CClienteControl cC = new CClienteControl();
				ArrayList<MCliente> Clientes = cC.listaCliente();
				MCliente mC = new MCliente();
            	
				String wCpf = edCpf.getText();
				
            	for (MCliente mCliente : Clientes) {
					if (edCpf.getText().equals(mCliente.getwCpf())){
						
						cC.deletar(mC, wCpf);
						JOptionPane.showMessageDialog(null, "Os dados do CPF: " + wCpf  + " foi Excluido!");
						edCpf.setText("");
						edCnh.setText("");
						edData.setText("");
						edGmail.setText("");
						edNome.setText("");
						edTelefone.setText("");
						cbSexo.setSelectedItem("");
					}
				}
			}
			
		});
		btExcluir.setFont(new Font("Dialog", Font.BOLD, 11));
		btExcluir.setBounds(393, 172, 102, 23);
		contentPane.add(btExcluir);

	}
}
