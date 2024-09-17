package br.com.projetoPoo.testemain;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.projetoPoo.entity.Arquivo;
import br.com.projetoPoo.entity.Funcionario;

public class Ler extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	static Ler ler = new Ler();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static List<Funcionario> lista = new ArrayList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ler.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create theler.
	 */
	public Ler() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Leitura de arquivos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(138, 60, 300, 25);
		contentPane.add(lblNewLabel);
		
		//-----------------------------------------
		
		JButton btnNewButton = new JButton("Entra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caminho = textField.getText();
				try {
					Arquivo a = new Arquivo();

					a.lerArquivo(caminho);

					for (Funcionario f : a.getFuncionarios()) {

						f.calcularInss();
						f.calcularIR();
					}
					
					lista.addAll(a.getFuncionarios());
					
					JOptionPane.showMessageDialog(null, "Arquivo lido com sucesso!");
					ler.setVisible(false);
					MenuInicial.menu.setVisible(true);
					MenuInicial.menu.btnVerificar.setEnabled(true);
					MenuInicial.menu.btnImprimir.setEnabled(true);
					
					
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Valor nulo!");
					npe.printStackTrace();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro!");
					ex.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(242, 260, 100, 30);
		contentPane.add(btnNewButton);
		
		//-----------------------------------------
		
		textField = new JTextField();
		textField.setBounds(142, 224, 300, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//-----------------------------------------
		
		JLabel lblNewLabel_1 = new JLabel("Digite o local do arquivo:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(142, 188, 300, 25);
		contentPane.add(lblNewLabel_1);
	}
}
//C:/curso/listaFuncionarios.csv