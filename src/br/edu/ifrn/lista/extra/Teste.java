package br.edu.ifrn.lista.extra;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580929850092633146L;
	private JLabel imagemLabel;

	public Teste() {
		// Configuração básica do JFrame
		setTitle("Carregar Imagem");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Criação do seletor de arquivos
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(filter);

		// Criação do painel para exibir a imagem
		imagemLabel = new JLabel();
		imagemLabel.setHorizontalAlignment(JLabel.CENTER);

		// Criação do botão para abrir o seletor de arquivos
		JButton abrirBotao = new JButton("Abrir Imagem");
		abrirBotao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(Teste.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					java.io.File selectedFile = fileChooser.getSelectedFile();
					exibirImagem(selectedFile.getPath());
				}
			}
		});

		// Adiciona componentes ao painel principal
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(imagemLabel, BorderLayout.CENTER);
		panel.add(abrirBotao, BorderLayout.SOUTH);

		// Adiciona o painel ao JFrame
		add(panel);

		// Torna o JFrame visível
		setVisible(true);
	}

	private void exibirImagem(String caminhoArquivo) {
		ImageIcon imagemIcon = new ImageIcon(caminhoArquivo);
		imagemLabel.setIcon(imagemIcon);
	}

	public static void main(String[] args) {
		new Teste();
	}
}