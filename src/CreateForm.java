import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import dao.BobacoolMenuDAO;

public class CreateForm extends JFrame implements ActionListener {

	JButton save = new JButton("Save");
	JButton cancel = new JButton("Back");
	
	public String coderender() {
		String numeric = "0123456789";
		String code = "BC-";
		StringBuilder sb1 = new StringBuilder(3);
		for (int i = 0; i < 3; i++) { 
			int index = (int)(numeric.length() * Math.random()); 
			sb1.append(numeric.charAt(index)); 
		}
		String angka = sb1.toString();
		code = code.concat(angka);
		return code;
	}
	
	JLabel txtKode = new JLabel(coderender());
	JTextField txtName = new JTextField();
	JTextField txtHarga = new JTextField();
	JTextField txtStok = new JTextField();
	
	JMenuItem exit = new JMenuItem("Exit");
	
	public CreateForm() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");
		
		exit.addActionListener(this);
		menu1.add(exit);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Insert New Menu");
		setSize(400, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 100);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		setVisible(true);
		
		initComponent();
	}
	
	public void initComponent() {
		String numeric = "0123456789";
		String code = "BC-";
		StringBuilder sb1 = new StringBuilder(3);
		for (int i = 0; i < 3; i++) { 
			int index = (int)(numeric.length() * Math.random()); 
			sb1.append(numeric.charAt(index)); 
		}
		String angka = sb1.toString();
		code = code.concat(angka);
		
		JLabel kode = new JLabel("Kode Menu :");
		add(kode);
		add(txtKode);
		
		JLabel name = new JLabel("Nama Menu :");
		add(name);
		add(txtName);
		
		JLabel harga = new JLabel("Harga Menu :");
		add(harga);
		add(txtHarga);
		
		JLabel stok = new JLabel("Stok Menu :");
		add(stok);
		add(txtStok);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		add(save);
		add(cancel);
	}

	public boolean dataValidation() {
		if(txtName.getText().isEmpty() || txtHarga.getText().isEmpty() || txtStok.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(dataValidation() == false) {
				JOptionPane.showMessageDialog(null, "Please insert every data needed and correctly");
			}else {
				BobacoolMenuDAO bobacoolmenuDAO = new BobacoolMenuDAO();
				bobacoolmenuDAO.insertData(txtKode.getText(), txtName.getText(), txtHarga.getText(), txtStok.getText());
				JOptionPane.showMessageDialog(null, "Success insert new data");
			}
		}else if(e.getSource().equals(cancel)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}

}
