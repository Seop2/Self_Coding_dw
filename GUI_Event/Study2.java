package 자바23_윈도우프로그래밍_이벤트;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study2 {

	public static void main(String[] args) {
		playerList pl = new playerList();

	}

}
class playerList extends Frame implements ActionListener
{
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Label lbList = new Label("선수리스트");
	Label lbSoccer = new Label("축구선수:");
	Label lbPlayer = new Label("0");
	Label lbMent = new Label("결과: 대기중....");
	Label lbTot = new Label("총전적:");
	Label lbShootsuccess = new Label("슛성공:");
	Label lbShootFail = new Label("슛실패:");
	Label lbResult1 = new Label("0게임");
	Label lbResult2 = new Label("0 회");
	Label lbResult3 = new Label("0 회");
	
	Button longShoot = new Button("중거리슛");
	Button Heading = new Button("헤딩");
	Button pShoot = new Button("패널티슛");
	TextArea taPlayer = new TextArea();
	playerList()
	{
		super("선수리스트");
		this.setSize(600,400);
		this.setVisible(true);
		this.center();
		this.init();
		this.start();
	}
	void center()
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()
	{
		this.setLayout(null);
		this.add(longShoot);
		this.add(Heading);
		this.add(pShoot);
		this.add(taPlayer);
		this.add(lbList);
		this.add(lbSoccer);
		this.add(lbPlayer);
		this.add(lbMent);
		this.add(lbTot);
		this.add(lbShootsuccess);
		this.add(lbShootFail);
		this.add(lbResult1);
		this.add(lbResult2);
		this.add(lbResult3);
		
		lbList.setBounds(50, 50, 120, 30);lbList.setFont(font20);
		taPlayer.setBounds(50, 100, 120, 200);taPlayer.setFont(font20);
		lbSoccer.setBounds(210, 60, 130, 30);lbSoccer.setFont(font20);
		lbPlayer.setBounds(350, 60, 50, 30);lbPlayer.setFont(font20);
		longShoot.setBounds(210, 100, 130, 30);longShoot.setFont(font20);
		Heading.setBounds(350, 100, 50, 30);Heading.setFont(font20);
		pShoot.setBounds(410, 100, 130, 30);pShoot.setFont(font20);
		lbMent.setBounds(230, 150, 150, 50);lbMent.setFont(font20);
		lbTot.setBounds(240, 220, 100, 30);lbTot.setFont(font20);
		lbResult1.setBounds(350, 220, 100, 30);lbResult1.setFont(font20);
		lbShootsuccess.setBounds(240, 270, 100, 30);lbShootsuccess.setFont(font20);
		lbResult2.setBounds(340, 270, 100, 30);lbResult2.setFont(font20);
		lbShootFail.setBounds(390, 270, 100, 30);lbShootFail.setFont(font20);
		lbResult3.setBounds(490, 270, 100, 30);lbResult3.setFont(font20);
	}
	void start()
	{
		longShoot.addActionListener(this);
		Heading.addActionListener(this);
		pShoot.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==longShoot)
		{
			
		}
		if(e.getSource()==Heading)
		{
			
		}
		if(e.getSource()==pShoot)
		{
			
		}
		
		
	}
}