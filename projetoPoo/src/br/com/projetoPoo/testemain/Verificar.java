package br.com.projetoPoo.testemain;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Verificar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static Verificar verifica = new Verificar();
	@SuppressWarnings("rawtypes")
	private final JList list = new JList();
	private final JButton btnNewButton = new JButton("Voltar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					verifica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	@SuppressWarnings("unchecked")
	public Verificar() {
		@SuppressWarnings("rawtypes")
		DefaultListModel dlm = new DefaultListModel();
		dlm.addAll(Ler.lista);
		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		list.setModel(dlm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		list.setBounds(0, 0, 564, 300);
		
		panel.add(list);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuInicial.menu.setVisible(true);
				verifica.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(242, 322, 100, 30);
		
		contentPane.add(btnNewButton);
	}
}
