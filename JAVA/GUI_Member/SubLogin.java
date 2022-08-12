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

 public class SubLogin extends Frame implements ActionListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("로그인");
	Label lbId = new Label("아 이 디  : ");
	Label lbPw = new Label("비밀번호 : ");
	TextField tfId = new TextField(20);
	TextField tfPw = new TextField(20);
	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("회원가입");
	
	//로그인 체크변수
	boolean loginCheck = false;
	
	SubLogin(){
		super("로그인화면");
		this.init();		
		this.setSize(400,500);
		this.center();//중앙배치	
		this.start();
		this.setVisible(true);
	}
	void start()
	{
		btnLogin.addActionListener(this);
		btnJoin.addActionListener(this);
	}
	void init()
	{
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font30 = new Font("SansSerif", Font.BOLD, 30);	
		
		this.setLayout(null); 
		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(150, 50, 100, 30);
		
		this.add(lbId); lbId.setFont(font20); 
		lbId.setBounds(50, 150, 100, 30);
		
		this.add(tfId); tfId.setFont(font20); 
		tfId.setBounds(200, 150, 150, 30);
		
		this.add(lbPw); lbPw.setFont(font20); 
		lbPw.setBounds(50, 200, 100, 30);
		
		this.add(tfPw); tfPw.setFont(font20); 
		tfPw.setBounds(200, 200, 150, 30);
		
		this.add(btnLogin); btnLogin.setFont(font20); 
		btnLogin.setBounds(130, 300, 150, 50);
		this.add(btnJoin); btnJoin.setFont(font20); 
		btnJoin.setBounds(130, 380, 150, 50);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin) {
				String id = tfId.getText();
				String pw = tfPw.getText();
				
				//공백체크
				if(id.equals("")) {msg("아이디를입력해주세요!"); return;}
				if(pw.equals("")) {msg("비밀번호를 입력하세요.");return;}
				
				login(id,pw);
				
				if(loginCheck == true)
				{
					msg("로그인성공!");
					this.setVisible(false);
					MainScreen ms = new MainScreen();
				}
				else
				{
					msg("로그인 실패!");
				}
			}
			else if(e.getSource() == btnJoin) {
				SubJoin m = new SubJoin();
			}
			
		
	}
	void login(String myId, String myPw)
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
				if(rs.getString("id").equals(myId))
				{
					if(rs.getString("pw").equals(myPw))
					{
						loginCheck=true;
						break;
					}
				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
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



