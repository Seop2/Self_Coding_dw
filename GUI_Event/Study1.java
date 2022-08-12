package 자바23_윈도우프로그래밍_이벤트;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1 {

	public static void main(String[] args) {
		MouseGame mg = new MouseGame();

	}

}
class MouseGame extends Frame implements MouseListener{
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Button btn1 = new Button("+1점");
	Button btn2 = new Button("+5점");
	Button btn3 = new Button("+10점");
	TextArea ta = new TextArea();
	
	int score = 0;
	MouseGame()
	{
		super("마우스게임");
		this.setSize(500,300);
		this.setVisible(true);
		this.center();
		this.init();
		this.start();
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()
	{
		this.setLayout(null);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(ta);
		
		btn1.setBounds(50, 50, 100, 30);btn1.setFont(font20);
		btn2.setBounds(200, 50, 100, 30);btn2.setFont(font20);
		btn3.setBounds(350, 50, 100, 30);btn3.setFont(font20);
		ta.setBounds(50, 150, 400, 100);ta.setFont(font20);
	
	}
	void start()
	{
		btn1.addMouseListener(this);
		btn2.addMouseListener(this);
		btn3.addMouseListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btn1) { score++;}
		else if(e.getSource()==btn2) { score+=5;}
		else if(e.getSource()==btn3) { score+=10;}
		ta.setText("현재점수:"+score+"점");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}