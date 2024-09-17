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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.projetoPoo.entity.Funcionario;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	static MenuInicial menu = new MenuInicial();
	@SuppressWarnings("unused")
	private List<Funcionario> funcionarios = new ArrayList<>();
	JButton btnImprimir = new JButton("Imprimir");
	JButton btnVerificar = new JButton("Verificar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo a calculadora de salários!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(92, 60, 400, 25);
		contentPane.add(lblNewLabel);
		
		//-----------------------------------------
		
		JLabel lblNewLabel_1 = new JLabel("Selecione um arquivo!");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 96, 400, 25);
		contentPane.add(lblNewLabel_1);
		
		//-----------------------------------------
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ler.ler.setVisible(true);
				menu.setVisible(false);
			}
		});
		btnSelecionar.setBackground(new Color(128, 128, 128));
		btnSelecionar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSelecionar.setBounds(92, 260, 100, 30);
		contentPane.add(btnSelecionar);
		
		//-----------------------------------------
		
		btnVerificar.setEnabled(false);
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Verificar.verifica.setVisible(true);
				menu.setVisible(false);
				
			}
		});
		btnVerificar.setBackground(new Color(128, 128, 128));
		btnVerificar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnVerificar.setBounds(242, 260, 100, 30);
		contentPane.add(btnVerificar);
		
		//-----------------------------------------
		
		btnImprimir.setEnabled(false);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Imprimir.imprimir.setVisible(true);
				menu.setVisible(false);
				
			}
			});
		btnImprimir.setBackground(new Color(128, 128, 128));
		btnImprimir.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnImprimir.setBounds(392, 260, 100, 30);
		contentPane.add(btnImprimir);
		
	}
	
}
//C:/curso/listaFuncionarios.csv