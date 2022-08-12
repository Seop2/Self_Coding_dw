package 자바23_윈도우프로그래밍_이벤트;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study7 {
	public static void main(String[] args) {	
		Soccer s = new Soccer();
	}
}
class Soccer extends Frame implements ItemListener, ActionListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	Label lbList = new Label("축구선수리스트");
	Label lbMember = new Label("축구선수:선택대기..");
	Label lbResult = new Label("결과:대기중..");
	Label lbTot = new Label("총전적:");
	Label lbTotCnt = new Label("0 게임");
	Label lbShoot = new Label("슛성공:");
	Label lbShootCnt = new Label("0 회");
	Label lbFail = new Label("슛실패:");
	Label lbFailCnt = new Label("0 회");
	Label lbgameTot = new Label("총게임가능횟수: 0");
	Button btnShoot1 = new Button("중거리슛");
	Button btnShoot2 = new Button("헤딩슛");
	Button btnShoot3 = new Button("패널티슛");
	Button clear = new Button("전적초기화");
	List li = new List(3, false);
	
	String ment1[]= {"중거리슛이 성공!","중거리슛 실패..."};			
	String ment2[]= {"헤딩슛이 성공!","헤딩슛 실패..."};
	String ment3[]= {"패널티슛이 성공!","패널티슛 실패..."};
	
	int tot=0, ok=0, fail=0; //전적처리 슛성공 슛실패
	String name="";//선택한 축구선수이름.
	Soccer()
	{
		super("축구게임");
		this.setSize(630,400);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
		
	}
	//게임횟수를 지정하는 기능을 넣으시오
	//추가기능작업
	//전적, 성공, 실패 초기화 버튼을 만드시오.
	//조건제어: 패널티슛은 1회까지 허용
	//헤딩슛은 2회까지 허용
	//나머지 중거리슛 허용
	//특수조건, 슛성공이 8회이상이면 다이얼로그창이 떠서 다음과 같이 축하멘트 나오게(챔피언스리그 우승! 콩크리츄레이션~)
	void init()
	{
		this.setLayout(null);
		this.add(lbList);		this.add(lbMember);
		this.add(lbTot);		this.add(lbTotCnt);
		this.add(lbShoot);		this.add(lbShootCnt);
		this.add(lbResult);		this.add(lbFail);
		this.add(lbFailCnt);		this.add(btnShoot1);
		this.add(btnShoot2);		this.add(btnShoot3);
		this.add(lbgameTot);	this.add(clear);
		li.add("손흥민");
		li.add("메시");
		li.add("호날듀");
		this.add(li);
		lbList.setBounds(50, 50, 150, 30); lbList.setFont(font20);
		li.setBounds(50, 100, 150, 200); li.setFont(font20);
		
		lbMember.setBounds(250, 50, 250, 30); lbMember.setFont(font20);
		btnShoot1.setBounds(250, 100, 100, 30); btnShoot1.setFont(font20);
		btnShoot2.setBounds(370, 100, 100, 30); btnShoot2.setFont(font20);
		btnShoot3.setBounds(490, 100, 100, 30); btnShoot3.setFont(font20);
		
		lbResult.setBounds(250, 150, 250, 30); lbResult.setFont(font20);
		lbTot.setBounds(250, 200, 70, 30); lbTot.setFont(font20);
		lbTotCnt.setBounds(330, 200, 70, 30); lbTotCnt.setFont(font20);
		
		lbShoot.setBounds(250, 250, 70, 30); lbShoot.setFont(font20);
		lbShootCnt.setBounds(330, 250, 70, 30); lbShootCnt.setFont(font20);
		lbFail.setBounds(410, 250, 70, 30); lbFail.setFont(font20);
		lbFailCnt.setBounds(490, 250, 70, 30); lbFailCnt.setFont(font20);
		lbgameTot.setBounds(50,310,200,30);lbgameTot.setFont(font20);
	}
	
	void start() {
		li.addItemListener(this);
		btnShoot1.addActionListener(this);
		btnShoot2.addActionListener(this);
		btnShoot3.addActionListener(this);
		clear.addActionListener(this);
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
	public void itemStateChanged(ItemEvent e) {
		name = li.getSelectedItem();
		lbMember.setText("축구선수:"+name);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(name.equals(""))
		{
			lbResult.setText("선수를고르시오.");
			return;
		}
		
		if(e.getSource()==btnShoot1) 	  {
			tot++;
			int num = (int)(Math.random()*10);
			if(num==0 || num==1 || num==2)
			{
				lbResult.setText(ment1[0]);
				ok++;
			}
			else
			{
				lbResult.setText(ment1[1]);
				fail++;
			}
		}
		else if(e.getSource()==btnShoot2) {
			tot++;
			int num = (int)(Math.random()*10);
			if(num==0 || num==1 || num==2 || num==3 || num==4)
			{
				lbResult.setText(ment2[0]);
				ok++;
			}
			else
			{
				lbResult.setText(ment2[1]);
				fail++;
			}
		}
		else if(e.getSource()==btnShoot3) {
			tot++;
			int num = (int)(Math.random()*10);
			if(num==0)
			{
				lbResult.setText(ment3[1]);
				fail++;
			}
			else
			{
				lbResult.setText(ment3[0]);
				ok++;
			}
		}
		
		lbTotCnt.setText(tot+"회");
		lbShootCnt.setText(ok+"회");
		lbFailCnt.setText(fail+"회");
		
	}
}












