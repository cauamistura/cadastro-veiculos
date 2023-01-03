package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import controle.CClienteControl;
import controle.CVeiculoControl;
import modelo.MCliente;
import modelo.MVeiculo;
import visao.JCadastroCliente;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class JCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField edPlaca;
	private JTextField edMarca;
	private JTextField edFabricacao;
	private JTextField edID;
	Boolean wEncontrou = false;

	public JCadastroVeiculo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 339);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Labels
		
		JLabel lbStatus = new JLabel("<Aguardadando>");
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(365, 258, 125, 15);
		contentPane.add(lbStatus);
		
		JLabel lbTitulo = new JLabel("Cadastro de Veiculo");
		lbTitulo.setBounds(182, 0, 142, 15);
		contentPane.add(lbTitulo);
		
		JLabel lbNome = new JLabel("Dono do Veiculo:");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(25, 69, 132, 15);
		contentPane.add(lbNome);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlaca.setBounds(77, 96, 80, 15);
		contentPane.add(lblPlaca);
		
		JLabel lbTipoVeiculo = new JLabel("Tipo de Veiculo:");
		lbTipoVeiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTipoVeiculo.setBounds(25, 123, 132, 15);
		contentPane.add(lbTipoVeiculo);
		
		JLabel lbCor = new JLabel("Cor:");
		lbCor.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCor.setBounds(118, 156, 39, 15);
		contentPane.add(lbCor);
		
		JLabel lbID = new JLabel("ID do Veiculo:");
		lbID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbID.setBounds(25, 26, 132, 15);
		contentPane.add(lbID);
		
		JLabel lbMarca = new JLabel("Marca:");
		lbMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMarca.setBounds(105, 181, 53, 15);
		contentPane.add(lbMarca);
		
		JLabel lbCombustivel = new JLabel("Tipo de Combustivel:");
		lbCombustivel.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCombustivel.setBounds(0, 210, 157, 15);
		contentPane.add(lbCombustivel);
		
		JLabel lbAnoFabricacao = new JLabel("Ano de Frabricação:");
		lbAnoFabricacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAnoFabricacao.setBounds(12, 243, 145, 15);
		contentPane.add(lbAnoFabricacao);
		
		JLabel lbImg = new JLabel("New label");
		lbImg.setIcon(new ImageIcon(JCadastroVeiculo.class.getResource("/visao/2277327-200_resized.png")));
		lbImg.setBounds(378, 5, 102, 83);
		contentPane.add(lbImg);
		
		// ComboBox e CheckBox
		JComboBox<String> cbTipoVeiculo = new JComboBox();
		cbTipoVeiculo.setBounds(202, 119, 114, 23);
		cbTipoVeiculo.addItem("");
		cbTipoVeiculo.addItem("Carro");
		cbTipoVeiculo.addItem("Moto");
		cbTipoVeiculo.addItem("Caminhão");
		contentPane.add(cbTipoVeiculo);
		
		JComboBox<String> cbCombustivel= new JComboBox();
		cbCombustivel.setBounds(202, 206, 114, 23);
		cbCombustivel.addItem("");
		cbCombustivel.addItem("Gasolina");
		cbCombustivel.addItem("Etanol");
		cbCombustivel.addItem("Elétrico");
		contentPane.add(cbCombustivel);
		
		CClienteControl cC = CClienteControl.getInstancia();
		ArrayList<MCliente> listaClientes = cC.listaCliente();
		
		JComboBox cbDonoVeiculo = new JComboBox();
		cbDonoVeiculo.addItem("");
		if (listaClientes.size() > 0 && listaClientes != null) {
			for (MCliente cCliente : listaClientes) {
				cbDonoVeiculo.addItem((cCliente));
		}
		}
		cbDonoVeiculo.setBounds(202, 65, 114, 23);
		contentPane.add(cbDonoVeiculo);
		
		JComboBox<String> cbCorVeiculo = new JComboBox();
		cbCorVeiculo.setBounds(202, 152, 114, 23);
		cbCorVeiculo.addItem("");
		cbCorVeiculo.addItem("Preto");
		cbCorVeiculo.addItem("Branco");
		cbCorVeiculo.addItem("Vermelho");
		cbCorVeiculo.addItem("Cinza");
		cbCorVeiculo.addItem("Azul");
		cbCorVeiculo.addItem("Outros");
		contentPane.add(cbCorVeiculo);
		
		JCheckBox ckFabicacao = new JCheckBox("Fabricação Nacional");
		ckFabicacao.setFont(new Font("FreeSans", Font.BOLD, 10));
		ckFabicacao.setBounds(202, 268, 133, 23);
		contentPane.add(ckFabicacao);
	
		// TextFiel
		
		edPlaca = new JTextField();
		edPlaca.setColumns(10);
		try{

			edPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		}
		catch(ParseException excp){
		} 
		edPlaca.setBounds(202, 94, 114, 19);
		contentPane.add(edPlaca);
		
		edMarca = new JTextField();
		edMarca.setColumns(10);
		edMarca.setBounds(203, 179, 114, 19);
		contentPane.add(edMarca);
		
		edID = new JTextField();
		edID.setColumns(10);
		edID.setBounds(202, 27, 114, 19);
		contentPane.add(edID);
		
		edFabricacao = new JTextField();
		edFabricacao.setColumns(10);
		try {
			edFabricacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edFabricacao.setBounds(202, 241, 114, 19);
		contentPane.add(edFabricacao);
		edFabricacao.setColumns(10);
		
		// Botões 
		
		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setFont(new Font("Dialog", Font.BOLD, 11));
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer wIDVei = Integer.valueOf(edID.getText());

				if (wIDVei != null) {

					CVeiculoControl cv = new CVeiculoControl();
					ArrayList<MVeiculo> Veiculos = cv.listaVeiculos();
					MVeiculo mv = new MVeiculo();

					if (wEncontrou == false) {
						for (MVeiculo v : Veiculos) {
							if (wIDVei.equals(v.getwIDVeiculo())) {
								JOptionPane.showMessageDialog(null,
										"Veiculo já está cadastrado, você pode deletar ou alterar os Dados dele");
								wEncontrou = true;
								lbStatus.setText("Alterando");
							}
						}
					}
					if (wEncontrou == true) {
						for (MVeiculo v : Veiculos) {
							if (wIDVei.equals(v.getwIDVeiculo())) {
								edPlaca		 .setText		 (v.getwPlaca());
				        		cbCorVeiculo.setSelectedItem (v.getwCor());
				        		edMarca		 .setText		 (v.getwMarca());
				        		cbTipoVeiculo.setSelectedItem(v.getwTipoVeiculo());
				        		cbCombustivel.setSelectedItem(v.getwCombustivel());
				        		cbDonoVeiculo.setSelectedItem(v.getwDonoVeiculo());
				        		
				        		if(v.getwNacional() == "Sim") {
				        			ckFabicacao.setSelected(true);
				        		}
				        		else {
				        			ckFabicacao.setSelected(false);
				        		}
				        		wEncontrou = true;
				        		lbStatus.setText("Alterando");	
				        		
				        		for (MCliente c: listaClientes) {
									
								}
							}
							
						}
						if (wEncontrou != true) {
							lbStatus.setText("Novo veiculo!");
						}
					}
				}
			}
		});
		btnPreencher.setBounds(378, 92, 102, 25);
		contentPane.add(btnPreencher);
		
		JButton btGravar = new JButton("Gravar");
		btGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CVeiculoControl cv = new CVeiculoControl();
				ArrayList<MVeiculo> Veiculos = cv.listaVeiculos();
				MVeiculo mv = new MVeiculo();
				
				Integer wID    = Integer.valueOf(edID.getText());
				String  wPlaca = edPlaca.getText();
				String  wCor   = cbCorVeiculo.getSelectedItem().toString();
				String  wMarca = edMarca.getText();
				String  wCombustivel = cbCombustivel.getSelectedItem().toString();
				String  wTipoVeiculo = cbTipoVeiculo.getSelectedItem().toString();
				String  wDonoVeiculo = cbDonoVeiculo.getSelectedItem().toString();
				String Fabricação; 
				LocalDate wAnoModelo = LocalDate.parse(edFabricacao.getText(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				Integer contValidacao = 0;
				
				if (wEncontrou == false) {
					
					if (wPlaca == null || wPlaca .isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Placa");

					} else {
						mv.setwPlaca(wPlaca);
						contValidacao++;
					}
					
					if (wID == null) {
						JOptionPane.showMessageDialog(null, "Preencha o ID");

					} else {
						mv.setwIDVeiculo(wID);
						contValidacao++;
					}
					if (wMarca == null || wMarca.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Marca do carro");

					} else {
						mv.setwMarca(wMarca);
						contValidacao++;
					}
					if (wCombustivel == null || wCombustivel.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Combustivel");

					} else {
						mv.setwCombustivel(wCombustivel);
						contValidacao++;
					}
					
					if (wTipoVeiculo == null || wTipoVeiculo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Tipo do veiculo");

					} else {
						mv.setwTipoVeiculo(wTipoVeiculo);
						contValidacao++;

					}
					if (wDonoVeiculo == null || wDonoVeiculo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Dono do veiculo");

					} else {
						mv.setwDonoVeiculo(wDonoVeiculo);
						contValidacao++;
					}
					
					if (wAnoModelo  == null) {
						JOptionPane.showMessageDialog(null, "Preencha o Ano do modelo");

					} else {
						mv.setwAnoModelo(wAnoModelo);
						contValidacao++;
					
					}
					if (wCor == null || wCor .isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a cor do veiculo");

					} else {
						mv.setwCor(wCor);
						contValidacao++;
					
					}

					
					if (ckFabicacao.isSelected() == true) {
						Fabricação = "Sim";
						mv.setwNacional(Fabricação);
						contValidacao++;
					}else {
						Fabricação = "Não";
						mv.setwNacional(Fabricação);
						contValidacao++;
					}
						
					CVeiculoControl TableVeiculo = CVeiculoControl.getInstacia();
					Boolean insert = TableVeiculo.inserir(mv);

					if (contValidacao == 9) {
						JOptionPane.showMessageDialog(null, "Dados confirmados");
						JMenu m = new JMenu();
						m.setLocationRelativeTo(null);
						m.setVisible(true);
						dispose();
						contValidacao = 0;
					}
						
			
				} else {

					if (wPlaca == null || wPlaca .isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Placa");
					} else {
						mv.setwPlaca(wPlaca);
						contValidacao++;
					}
					
					if (wID == null) {
						JOptionPane.showMessageDialog(null, "Preencha o ID");
					} else {
						mv.setwIDVeiculo(wID);
						contValidacao++;
					}
					
					if (wMarca == null || wMarca.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Marca do carro");
					} else {
						mv.setwMarca(wMarca);
						contValidacao++;
					}
					
					if (wCombustivel == null || wCombustivel.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Combustivel");
					} else {
						mv.setwCombustivel(wCombustivel);
						contValidacao++;
					}
					
					if (wTipoVeiculo == null || wTipoVeiculo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Tipo do veiculo");
					} else {
						mv.setwTipoVeiculo(wTipoVeiculo);
						contValidacao++;
						
					}
					if (wDonoVeiculo == null || wDonoVeiculo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Dono do veiculo");
					} else {
						mv.setwDonoVeiculo(wDonoVeiculo);
						contValidacao++;
					}
					
					if (wAnoModelo  == null ) {
						JOptionPane.showMessageDialog(null, "Preencha o Ano do modelo");
					} else {
						mv.setwAnoModelo(wAnoModelo);
						contValidacao++;
					}
					
					if (wCor == null || wCor .isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a cor do veiculo");
					} else {
						mv.setwCor(wCor);
						contValidacao++;
					}
					
					if (ckFabicacao.isSelected() == true) {
						
						Fabricação = "Sim";
						mv.setwNacional(Fabricação);
						contValidacao++;
					}else {
						Fabricação = "Não";
						mv.setwNacional(Fabricação);
						contValidacao++;
					}
						

					CVeiculoControl TableVeiculo = CVeiculoControl.getInstacia();
					Boolean alterar = TableVeiculo.alterar(mv, wID) ;

					if (contValidacao == 9) {
						JOptionPane.showMessageDialog(null, "Dados confirmados");
						JMenu m = new JMenu();
						m.setLocationRelativeTo(null);
						m.setVisible(true);
						dispose();
						contValidacao = 0;
					}
						
				}
			}
		});
		btGravar.setBounds(378, 121, 102, 23);
		contentPane.add(btGravar);
			
		JButton btLimpar = new JButton("Limpar");
		btLimpar.setBounds(378, 181, 102, 23);
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				edID		 .setText("");
				cbCombustivel.setSelectedItem("");
				cbTipoVeiculo.setSelectedItem("");
				cbCorVeiculo. setSelectedItem("");
				edFabricacao. setText("");
				edMarca.      setText("");
				edPlaca.      setText("");	
			}
		});
		contentPane.add(btLimpar);
		
		JButton btvoltar = new JButton("<");
		btvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu m = new JMenu();
				m.setLocationRelativeTo(null);
				m.setVisible(true);
				dispose();
			}
		});		
		btvoltar.setBounds(12, -5, 44, 25);
		contentPane.add(btvoltar);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btFechar.setBounds(378, 212, 102, 23);
		contentPane.add(btFechar);
		
		JButton btExcluir = new JButton("Excuir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	Integer wIDVei = Integer.valueOf(edID.getText());
            	
            	CVeiculoControl cv = new CVeiculoControl();
            	ArrayList<MVeiculo> Veiculos = cv.listaVeiculos();
            	MVeiculo mv = new MVeiculo();
            	
				for (MVeiculo v : Veiculos) {
					if (wIDVei.equals(v.getwIDVeiculo())) {
						cv.deletar(mv, wIDVei);
						JOptionPane.showMessageDialog(null, "Veiculo " + wIDVei + " Excluido!");
						edID		 .setText("");
						cbCombustivel.setSelectedItem("");
						cbTipoVeiculo.setSelectedItem("");
					    cbCorVeiculo .setSelectedItem("");
						edFabricacao. setText("");
						edMarca.      setText("");
						edPlaca.      setText("");	
					}
				}
			}
		});
		btExcluir.setBounds(378, 152, 102, 23);
		contentPane.add(btExcluir);
		
	

	}
}
