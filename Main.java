import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField txt01;
	private JTextField txt02;
	private JTextField txt03;
	private JTextField txt04;
	private Double totalC = 0.00;
	private static DecimalFormat form= new DecimalFormat("#.00");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 786, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		lblNewLabel_1.setBounds(95, 111, 124, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cost: $");
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(95, 161, 124, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(95, 211, 124, 29);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 329, 565, 160);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea(3, 3);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Add Item To The Sales List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CalcTotal temp = new CalcTotal(txt01.getText(), txt02.getText(), txt03.getText());
				
				textArea.append(temp.itemD + "\t $" + form.format(temp.itemC) + "\t" + temp.quant + "\n");
				totalC += (temp.itemC * temp.quant);
					
				txt04.setText("$" + (form.format(totalC)));
					
				txt01.setText("");
				txt02.setText("");
				txt03.setText("");
					
				
				
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		btnNewButton.setBounds(95, 260, 565, 43);
		frame.getContentPane().add(btnNewButton);
		
		txt01 = new JTextField();
		txt01.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		txt01.setBounds(257, 111, 403, 29);
		frame.getContentPane().add(txt01);
		txt01.setColumns(10);
		
		txt02 = new JTextField();
		txt02.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		txt02.setColumns(10);
		txt02.setBounds(257, 161, 403, 29);
		frame.getContentPane().add(txt02);
		
		txt03 = new JTextField();
		txt03.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		txt03.setColumns(10);
		txt03.setBounds(257, 211, 403, 29);
		frame.getContentPane().add(txt03);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Total Sales: ");
		lblNewLabel_1_2_1.setFont(new Font("MS UI Gothic", Font.BOLD, 21));
		lblNewLabel_1_2_1.setBounds(95, 508, 124, 29);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		txt04 = new JTextField();
		txt04.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		txt04.setColumns(10);
		txt04.setBounds(257, 508, 403, 29);
		frame.getContentPane().add(txt04);
	}
}
