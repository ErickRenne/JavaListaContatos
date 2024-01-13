package br.edu.ifrn.lista.contatos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

public class TesteGUI extends JFrame {

	private static final long serialVersionUID = 6921201311238470254L;

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPhoneNumber;
	private JTextField txtPhoneNumber;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblBloodType;
	private JComboBox<Object> comboBoxBloodType;
	private JButton btnSaveOfAddContact;
	private JButton btnReturnBack;
	private JTextField txtNameView;
	private JTextField txtPhoneNumberView;
	private JTextField txtAddressView;
	private JTextField txtBloodTypeView;
	boolean Verificado;
	private JPanel panelMain;
	private JButton btnAdd;
	private JButton btnSearch;
	private JTextField txtFieldSearch;
	private JList<Contato> list;
	private JScrollPane scrollPane;
	DefaultListModel<Contato> model = new DefaultListModel<>();

	/**
	 * @wbp.nonvisual location=377,69
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteGUI frame = new TesteGUI();
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

	public TesteGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TesteGUI.class.getResource("/br/edu/ifrn/icones/telephone.png")));
		setTitle("LISTA DE CONTATOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		Agenda ctt = new Agenda();


		panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBackground(Color.WHITE);
		contentPane.add(panelMain, "name_1202661602300");

		btnAdd = new JButton("Add to list");
		btnAdd.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/add.png")));
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(198, 25, 80, 20);
		panelMain.add(btnAdd);

		JButton btnAtoZ = new JButton("A - Z");
		btnAtoZ.setBackground(new Color(255, 255, 255));

		btnAtoZ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAtoZ.setBounds(198, 49, 80, 20);
		panelMain.add(btnAtoZ);

		btnSearch = new JButton("search");
		btnSearch.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/magnifier.png")));
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(198, 2, 80, 20);
		panelMain.add(btnSearch);

		txtFieldSearch = new JTextField();
		txtFieldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFieldSearch.setColumns(10);
		txtFieldSearch.setBounds(10, 2, 180, 43);
		panelMain.add(txtFieldSearch);

		JScrollPane scrollPaneofList = new JScrollPane();
		scrollPaneofList.setBounds(0, 95, 284, 266);
		panelMain.add(scrollPaneofList);

		list = new JList<>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(null);
		list.setSelectionBackground(new Color(255, 255, 255));
		scrollPaneofList.setViewportView(list);

		JToggleButton btnDarkandLight = new JToggleButton("Dark Mode");

		btnDarkandLight.setBackground(new Color(255, 255, 255));
		btnDarkandLight.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/lightbulb_off.png")));
		btnDarkandLight.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDarkandLight.setBounds(10, 49, 90, 20);

		panelMain.add(btnDarkandLight);

		JButton btnLoad = new JButton("Load list");
		btnLoad.setBackground(new Color(255, 255, 255));
		btnLoad.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctt.carregar();
				for(int i = 0; i < ctt.getQuant(); i++) {
					model.addElement(ctt.getContato(i));
				}
			}
		});
		btnLoad.setBounds(108, 49, 80, 20);
		panelMain.add(btnLoad);

		JButton btnSave = new JButton("Save list");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctt.salvar("Teste");
			}
		});
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(198, 74, 80, 20);

		panelMain.add(btnSave);

		JPanel panelAddContact = new JPanel();
		panelAddContact.setBackground(new Color(255, 255, 255));
		contentPane.add(panelAddContact, "name_33262492965899");
		panelAddContact.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setBounds(12, 97, 262, 14);
		panelAddContact.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(12, 112, 262, 20);
		txtName.setColumns(10);
		panelAddContact.add(txtName);

		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(12, 153, 262, 14);
		panelAddContact.add(lblPhoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(12, 168, 262, 20);
		txtPhoneNumber.setColumns(10);
		panelAddContact.add(txtPhoneNumber);

		lblAddress = new JLabel("Address (optional)");
		lblAddress.setBounds(12, 209, 262, 14);
		panelAddContact.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(12, 224, 262, 20);
		txtAddress.setColumns(10);
		panelAddContact.add(txtAddress);

		lblBloodType = new JLabel("Blood type (optional)");
		lblBloodType.setBounds(12, 265, 262, 14);
		panelAddContact.add(lblBloodType);

		comboBoxBloodType = new JComboBox<Object>();
		comboBoxBloodType.setName("TIPOS");
		comboBoxBloodType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Types", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBoxBloodType.setBounds(12, 280, 262, 22);
		panelAddContact.add(comboBoxBloodType);

		JPanel panelViewContact = new JPanel();
		panelViewContact.setBackground(new Color(255, 255, 255));
		contentPane.add(panelViewContact, "name_33262520780200");
		panelViewContact.setLayout(null);

		// Botão Procurar Pagina Inicial para ViewContato
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ctt.getQuantContatos(); i++) {
					if (model.elementAt(i) != null ) {
						panelMain.setVisible(false);
						panelViewContact.setVisible(true);
						String nnn = model.elementAt(i).getNome();
						txtPhoneNumberView.setText((String) ctt.buscar(nnn).getNumero());
						txtNameView.setText(model.elementAt(i).getNome());
						txtAddressView.setText((String) ctt.buscar(nnn).getEndereco());
						txtBloodTypeView.setText((String) ctt.buscar(nnn).getTipoSanguineo());
					} 				
				}
			}
		});

		btnAtoZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctt.ordernar();
				for (int i = 0; i < ctt.getQuantContatos(); i++) {
					model.remove(i);
					model.add(i, ctt.getContato(i)) ;
					System.out.println(ctt.getContato(i).getNome());
				}
				Verificado = true;
				panelMain.setVisible(false);
				panelMain.setVisible(true);
			}
		});

		// botão adicionar
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtAddress.setText("");
				txtNameView.setText("");
				comboBoxBloodType.setSelectedIndex(0);
				panelMain.setVisible(false);
				panelAddContact.setVisible(true);
			}
		});
		
		// Botão Salvar NovoContato
		btnSaveOfAddContact = new JButton("Salvar");
		btnSaveOfAddContact.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/folder_add.png")));
		btnSaveOfAddContact.setBackground(new Color(255, 255, 255));
		btnSaveOfAddContact.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSaveOfAddContact.setBounds(198, 313, 76, 23);
		panelAddContact.add(btnSaveOfAddContact);
		btnSaveOfAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txtName.getText();
				String numero = txtPhoneNumber.getText();
				String endereco = txtAddress.getText();
				String tipoSanguineo = (String) comboBoxBloodType.getSelectedItem();
				ctt.inserir(nome, numero, endereco, tipoSanguineo);
				model.addElement(ctt.buscar(nome));
				JOptionPane.showMessageDialog(null, "Tudo Certo!!!");
				if (Verificado == true) {
					ctt.ordernar();
					for (int i = 0; i < ctt.getQuantContatos(); i++) {
						model.remove(i);
						model.add(i, ctt.getContato(i)) ;
						System.out.println(ctt.getContato(i).getNome());
					}
				}
				panelMain.setVisible(true);
				panelAddContact.setVisible(false);
			}
		});

		// Botão voltar para tela inicial vindo do ADDcontato
		JButton btnReturnToBack = new JButton("Return");
		btnReturnToBack.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/arrow_turn_left.png")));
		btnReturnToBack.setBackground(new Color(255, 255, 255));
		btnReturnToBack.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnReturnToBack.setBounds(10, 11, 63, 23);
		panelAddContact.add(btnReturnToBack);

		// Voltar para tela inicial na ViewContato
		btnReturnBack = new JButton("Return");
		btnReturnBack.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/arrow_turn_left.png")));
		btnReturnBack.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnReturnBack.setBackground(Color.WHITE);
		btnReturnBack.setBounds(10, 11, 75, 23);
		panelViewContact.add(btnReturnBack);
		btnReturnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelViewContact.setVisible(false);
			}
		});

		txtNameView = new JTextField();
		txtNameView.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtNameView.setBackground(new Color(255, 255, 255));
		txtNameView.setEditable(false);
		txtNameView.setBounds(10, 149, 262, 20);
		panelViewContact.add(txtNameView);
		txtNameView.setColumns(10);

		txtPhoneNumberView = new JTextField();
		txtPhoneNumberView.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtPhoneNumberView.setBackground(new Color(255, 255, 255));
		txtPhoneNumberView.setEditable(false);
		txtPhoneNumberView.setColumns(10);
		txtPhoneNumberView.setBounds(10, 205, 262, 20);
		panelViewContact.add(txtPhoneNumberView);

		txtAddressView = new JTextField();
		txtAddressView.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtAddressView.setBackground(new Color(255, 255, 255));
		txtAddressView.setEditable(false);
		txtAddressView.setColumns(10);
		txtAddressView.setBounds(10, 261, 262, 20);
		panelViewContact.add(txtAddressView);

		txtBloodTypeView = new JTextField();
		txtBloodTypeView.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtBloodTypeView.setBackground(new Color(255, 255, 255));
		txtBloodTypeView.setEditable(false);
		txtBloodTypeView.setColumns(10);
		txtBloodTypeView.setBounds(10, 317, 264, 20);
		panelViewContact.add(txtBloodTypeView);

		// Botão para Deletar o Contato
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(TesteGUI.class.getResource("/br/edu/ifrn/icones/user_delete.png")));
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(197, 11, 75, 23);
		panelViewContact.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contato = txtNameView.getText();
				for (int i = 0; i < ctt.getQuantContatos(); i++) {
					if (ctt.getContato(i).getNome().equals(contato)) {
						ctt.remover(contato);
						model.remove(i);
						JOptionPane.showMessageDialog(null, "Contato Excluido!! ");
						panelMain.setVisible(true);
						panelViewContact.setVisible(false);
					}
				}
			}
		});

		//Botão para Ligar e desligar o DarkMode
		btnDarkandLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnDarkandLight.isSelected() == true) {
					btnDarkandLight.setText("Light mode");

					// Botões

					btnSave.setBackground(new Color(53, 50, 48));
					btnSave.setForeground(Color.WHITE);

					btnLoad.setBackground(new Color(53, 50, 48));
					btnLoad.setForeground(Color.WHITE);

					btnAdd.setBackground(new Color(53, 50, 48));
					btnAdd.setForeground(Color.WHITE);

					btnSearch.setBackground(new Color(53, 50, 48));
					btnSearch.setForeground(Color.WHITE);

					btnSaveOfAddContact.setBackground(new Color(53, 50, 48));
					btnSaveOfAddContact.setForeground(Color.WHITE);

					btnReturnToBack.setBackground(new Color(53, 50, 48));
					btnReturnToBack.setForeground(Color.WHITE);

					btnReturnBack.setBackground(new Color(53, 50, 48));
					btnReturnBack.setForeground(Color.WHITE);

					btnDelete.setBackground(new Color(53, 50, 48));
					btnDelete.setForeground(Color.WHITE);

					btnAtoZ.setBackground(new Color(53, 50, 48));
					btnAtoZ.setForeground(Color.WHITE);

					btnDarkandLight.setBackground(new Color(53, 50, 48));
					btnDarkandLight.setForeground(Color.WHITE);

					// Paineis
					panelMain.setBackground(new Color(53, 50, 48));
					panelMain.setForeground(Color.WHITE);

					panelAddContact.setBackground(new Color(53, 50, 48));
					panelAddContact.setForeground(Color.WHITE);

					panelViewContact.setBackground(new Color(53, 50, 48));
					panelViewContact.setForeground(Color.WHITE);

					// Campo De texto
					txtName.setBackground(new Color(94, 89, 85));
					txtName.setForeground(Color.WHITE);

					txtPhoneNumber.setBackground(new Color(94, 89, 85));
					txtPhoneNumber.setForeground(Color.WHITE);

					txtAddress.setBackground(new Color(94, 89, 85));
					txtAddress.setForeground(Color.WHITE);

					txtNameView.setBackground(new Color(94, 89, 85));
					txtNameView.setForeground(Color.WHITE);

					txtPhoneNumberView.setBackground(new Color(94, 89, 85));
					txtPhoneNumberView.setForeground(Color.WHITE);

					txtAddressView.setBackground(new Color(94, 89, 85));
					txtAddressView.setForeground(Color.WHITE);

					txtBloodTypeView.setBackground(new Color(94, 89, 85));
					txtBloodTypeView.setForeground(Color.WHITE);

					txtFieldSearch.setBackground(new Color(94, 89, 85));
					txtFieldSearch.setForeground(Color.WHITE);

					// lista
					list.setBackground(new Color(94, 89, 85));
					list.setForeground(Color.WHITE);

					list.setSelectionBackground(new Color(94, 89, 85));
					list.setSelectionForeground(Color.WHITE);

				} else {
					btnDarkandLight.setText("Dark mode");

					// Botões

					btnSave.setBackground(Color.WHITE);
					btnSave.setForeground(Color.BLACK);

					btnLoad.setBackground(Color.WHITE);
					btnLoad.setForeground(Color.BLACK);

					btnAdd.setBackground(Color.WHITE);
					btnAdd.setForeground(Color.BLACK);

					btnSearch.setBackground(Color.WHITE);
					btnSearch.setForeground(Color.BLACK);

					btnSaveOfAddContact.setBackground(Color.WHITE);
					btnSaveOfAddContact.setForeground(Color.BLACK);

					btnReturnToBack.setBackground(Color.WHITE);
					btnReturnToBack.setForeground(Color.BLACK);

					btnReturnBack.setBackground(Color.WHITE);
					btnReturnBack.setForeground(Color.BLACK);

					btnDelete.setBackground(Color.WHITE);
					btnDelete.setForeground(Color.BLACK);

					btnAtoZ.setBackground(Color.WHITE);
					btnAtoZ.setForeground(Color.BLACK);

					btnDarkandLight.setBackground(Color.WHITE);
					btnDarkandLight.setForeground(Color.BLACK);

					// Paineis
					panelMain.setBackground(Color.WHITE);
					panelMain.setForeground(Color.BLACK);

					panelAddContact.setBackground(Color.WHITE);
					panelAddContact.setForeground(Color.BLACK);

					panelViewContact.setBackground(Color.WHITE);
					panelViewContact.setForeground(Color.BLACK);

					// Campo De texto
					txtName.setBackground(Color.WHITE);
					txtName.setForeground(Color.BLACK);

					txtPhoneNumber.setBackground(Color.WHITE);
					txtPhoneNumber.setForeground(Color.BLACK);

					txtAddress.setBackground(Color.WHITE);
					txtAddress.setForeground(Color.BLACK);

					txtNameView.setBackground(Color.WHITE);
					txtNameView.setForeground(Color.BLACK);

					txtPhoneNumberView.setBackground(Color.WHITE);
					txtPhoneNumberView.setForeground(Color.BLACK);

					txtAddressView.setBackground(Color.WHITE);
					txtAddressView.setForeground(Color.BLACK);

					txtBloodTypeView.setBackground(Color.WHITE);
					txtBloodTypeView.setForeground(Color.BLACK);

					txtFieldSearch.setBackground(Color.WHITE);
					txtFieldSearch.setForeground(Color.BLACK);

					// lista
					list.setBackground(Color.WHITE);
					list.setForeground(Color.BLACK);

					list.setSelectionBackground(Color.WHITE);
					list.setSelectionForeground(Color.BLACK);
				}

			}
		});
		
		// Ao clicar na lista abrir Viewr do contato
		list.addListSelectionListener(e -> {

			int indece = list.getAnchorSelectionIndex();
			if (indece == -1) {
				indece++;
			}
			txtNameView.setText(model.elementAt(indece).getNome());

			if (model.elementAt(indece) != null) {
				String nnn = model.elementAt(indece).getNome();
				panelMain.setVisible(false);
				panelViewContact.setVisible(true);
				txtPhoneNumberView.setText((String) ctt.buscar(nnn).getNumero());
				txtAddressView.setText((String) ctt.buscar(nnn).getEndereco());
				txtBloodTypeView.setText((String) ctt.buscar(nnn).getTipoSanguineo());

			} else {
				JOptionPane.showMessageDialog(null, "Contato inválido!!");
			}
		});
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
