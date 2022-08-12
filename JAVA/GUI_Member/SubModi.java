package 자바27_윈도우프로그래밍_member;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubModi extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("회원수정");
	Label lbId = new Label("아이디 : ");
	Label lbPw = new Label("비번 : ");
	Label lbPw2 = new Label("비번2 : ");
	Label lbName = new Label("이름 : ");
	Label lbHp = new Label("연락처 : ");
	Label lbAge = new Label("나이 : ");
	TextField tfId = new TextField();
	TextField tfName = new TextField();
	TextField tfPw = new TextField();
	TextField tfPw2 = new TextField();
	TextField tfHp = new TextField();
	TextField tfAge = new TextField();
	Button btnSearch = new Button("검색");
	Button btnModi = new Button("수정완료");
	
	SubModi()
	{
		super("회원수정");
		this.setSize(500,550);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
	}
	void init() {		
		this.setLayout(null);
		this.add(lbTitle);this.add(lbId);this.add(lbPw);
		this.add(lbPw2);this.add(lbName);this.add(lbHp);
		this.add(lbAge);
		this.add(tfId);this.add(tfName);this.add(tfPw);
		this.add(tfPw2);this.add(tfHp);this.add(tfAge);
		this.add(btnSearch);
		this.add(btnModi);
		
		lbTitle.setBounds(120, 50, 200, 30);lbTitle.setFont(font30);
		lbId.setBounds(50, 100, 100, 30);lbId.setFont(font20);
		tfId.setBounds(150, 100, 150, 30);tfId.setFont(font20);
		btnSearch.setBounds(350, 100, 100, 30);btnSearch.setFont(font20);
		
		lbPw.setBounds(50, 150, 100, 30);lbPw.setFont(font20);
		tfPw.setBounds(150, 150, 150, 30);tfPw.setFont(font20);
		
		lbPw2.setBounds(50, 200, 100, 30);lbPw2.setFont(font20);
		tfPw2.setBounds(150, 200, 150, 30);tfPw2.setFont(font20);
		
		lbName.setBounds(50, 250, 100, 30);lbName.setFont(font20);
		tfName.setBounds(150, 250, 150, 30);tfName.setFont(font20);
		
		lbHp.setBounds(50, 300, 100, 30);lbHp.setFont(font20);
		tfHp.setBounds(150, 300, 150, 30);tfHp.setFont(font20);
		
		lbAge.setBounds(50, 350, 100, 30);lbAge.setFont(font20);
		tfAge.setBounds(150, 350, 150, 30);tfAge.setFont(font20);
		
		btnModi.setBounds(150, 400, 100, 30);btnModi.setFont(font20);
	}
	void start()
	{
		btnModi.addActionListener(this);
		btnSearch.addActionListener(this);
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				modiClose();
			}
		});
	}
	void modiClose()
	{
		this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnModi)
		{
			String id = tfId.getText();
			String pw = tfPw.getText();
			String pw2 = tfPw2.getText();
			String name = tfName.getText();
			String hp = tfHp.getText();
			String age = tfAge.getText();
			//공백체크
			if(id.equals("")) {msg("아이디를입력해주세요!"); return;}
			if(pw.equals("")) {msg("비밀번호를 입력하세요.");return;}
			if(pw2.equals("")) {msg("비밀번호2를 입력해주세요!");return;}
			if(name.equals("")) {msg("이름을 입력해주세요!");return;}
			if(hp.equals("")) {msg("연락처를입력해주세요!");return;}
			if(age.equals("")) {msg("나이를입력해주세요!");return;}		
			if(!pw.equals(pw2)){msg("비번이서로같지않습니다.");return;}
			
			boolean end = update(id);
			if(end==true)
			{
				//수정완료
				
			}
			else if(end==false)
			{
				//수정실패
			}
		}
		else if(e.getSource()== btnSearch)
		{
			String id = tfId.getText();
			//공백체크
			if(id.equals("")) {msg("검색 대상을 입력해주세요!"); return;}
			search(id);
			
			
		}
	}
	void search(String findId)
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
		String query = "select * from member where id='"+findId+"'";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				tfId.setText(rs.getString("id"));
				tfPw.setText(rs.getString("pw"));
				tfPw2.setText(rs.getString("pw"));
				tfName.setText(rs.getString("name"));
				tfAge.setText(rs.getString("age"));
				tfHp.setText(rs.getString("hp"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	boolean update(String findId)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "1234";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update member set pw = ?, hp = ?, age = ?,name = ? where id = ?";
		String pw = tfPw.getText();
		String name = tfName.getText();
		String age = tfAge.getText();
		String hp = tfHp.getText();
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setString(2, hp);
			pstmt.setString(3, age);
			pstmt.setString(4, name);
			pstmt.setString(5, findId);
			pstmt.executeUpdate();
			pstmt.close();
			msg("회원정보수정완료!");
		} catch (SQLException ee) {
			System.err.println("회원 정보수정 실패!!");
			return false;
		}
		return true;
	}
	void insert(String id,String pw,String name,String hp,String age)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이브가 있습니당~! ^_^v");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 없음!!");
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";
		String user = "root";// ID
		String password = "1234";// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결되었습니다.");
		} catch (SQLException ee) {
			System.err.println("연결객체 생성실패!!");
		}		
		
		String pquery = "insert into member values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {			
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, hp);
			pstmt.setString(5, age);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("에러내용: " + ee.toString());
		}

		
		// 5. Close 작업
		try {			
			pstmt.close();			
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
	}
	
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(450, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}

}















