import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import dao.BobacoolMenuDAO;

public class GetTable extends JFrame implements ActionListener{

	JMenuItem back = new JMenuItem("Main Menu");
	JMenuItem exitMenu = new JMenuItem("Exit");
	
	public GetTable() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");

		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("View Menu");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 100);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		initTable();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stok Menu");
		BobacoolMenuDAO bobacoolmenuDAO = new BobacoolMenuDAO();
		JTable table = new JTable(bobacoolmenuDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}
	}

}
