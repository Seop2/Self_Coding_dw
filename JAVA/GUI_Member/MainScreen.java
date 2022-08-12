package 자바27_윈도우프로그래밍_member;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainScreen extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("메인화면");


	Button btnList = new Button("회원목록");
	Button btnModi = new Button("회원수정");
	Button btnDel = new Button("회원삭제");
	Button btnJoin = new Button("회원가입");
	Button btnEnd = new Button("종료");
	
	
	
	MainScreen()
	{
		super("메인화면");
		this.setSize(500,700);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
	}
	void init() {		
		this.setLayout(null);
		this.add(lbTitle);this.add(btnList);
		this.add(btnModi);this.add(btnDel);this.add(btnJoin);		
		this.add(btnEnd);

		
		lbTitle.setBounds(170, 50, 200, 30);lbTitle.setFont(font30);
		
		btnList.setBounds(100, 150, 300, 70);btnList.setFont(font30);
		btnModi.setBounds(100, 250, 300, 70);btnModi.setFont(font30);
		btnDel.setBounds(100, 350, 300, 70);btnDel.setFont(font30);
		btnJoin.setBounds(100, 450, 300, 70);btnJoin.setFont(font30);
		btnEnd.setBounds(100, 570, 300, 70);btnEnd.setFont(font30);
		
		
	}
	void start()
	{
		btnList.addActionListener(this);
		btnModi.addActionListener(this);
		btnDel.addActionListener(this);
		btnJoin.addActionListener(this);
		btnEnd.addActionListener(this);
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnList)
		{
			SubList list = new SubList();	
		}
		else if(e.getSource() == btnModi)
		{
			SubModi modi = new SubModi();
		}
		else if(e.getSource() == btnDel)
		{
			SubDel del = new SubDel();
		}
		else if(e.getSource() == btnJoin)
		{
			SubJoin join = new SubJoin();
		}
		else if(e.getSource() == btnEnd)
		{
			System.exit(-1);
		}
		
		
	}
	void search(String name)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "1234";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getString(4).equals(name))
				{

				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void searchAll()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			while (rs.next()) {
				result += rs.getInt(1) + " / " + rs.getString(2)
				+ " / " + rs.getString(3)
				+ " / " + rs.getString(4)
				+ " / " + rs.getString(5)+"\n";			
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

}









