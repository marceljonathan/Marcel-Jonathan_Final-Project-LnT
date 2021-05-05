import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import dao.BobacoolMenuDAO;

public class UpdateMenu extends JFrame implements ActionListener, MouseListener {
	
	public UpdateMenu() {
		initMenuBar();
		initFrame();
		addUpdateButton();
	}
	
	JMenuItem back, exitMenu;
	JTextField txtHarga, txtStok;
	JButton update;
	JTable table;
	String code = "";
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");
		
		back = new JMenuItem("Main Menu");
		exitMenu = new JMenuItem("Exit");

		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Update Menu");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 100);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
		initMenuUpdate();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stok Menu");
		BobacoolMenuDAO bobacoolmenuDAO = new BobacoolMenuDAO();
		table = new JTable(bobacoolmenuDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		table.addMouseListener(this);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}
	
	public void initMenuUpdate() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel harga = new JLabel("Harga Menu :");
		txtHarga = new JTextField();
		panel.add(harga);
		panel.add(txtHarga);
		
		JLabel stok = new JLabel("Stok Menu :");
		txtStok = new JTextField();
		panel.add(stok);
		panel.add(txtStok);
		
		add(panel);
	}
	
	public void addUpdateButton() {
		update = new JButton("Update Menu");
		update.addActionListener(this);
		add(update);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}else if(e.getSource().equals(update)) {
			if(code.equals("")) {
				JOptionPane.showMessageDialog(null, "Please select the row you want to update!");
			}else {
				BobacoolMenuDAO bobacoolmenuDAO = new BobacoolMenuDAO();
				bobacoolmenuDAO.updateMenu(code, txtHarga.getText(), txtStok.getText());
				JOptionPane.showMessageDialog(null, "Success to Update Menu!");
				new UpdateMenu();
				setVisible(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = table.getSelectedRow();
		code = table.getValueAt(selectedRow, 0).toString();
		String name = table.getValueAt(selectedRow, 1).toString();
		String price = table.getValueAt(selectedRow, 2).toString();
		String stock = table.getValueAt(selectedRow, 3).toString();
		txtHarga.setText(price);
		txtStok.setText(stock);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
