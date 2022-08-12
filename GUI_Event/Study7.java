package �ڹ�23_���������α׷���_�̺�Ʈ;

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
	Label lbList = new Label("�౸��������Ʈ");
	Label lbMember = new Label("�౸����:���ô��..");
	Label lbResult = new Label("���:�����..");
	Label lbTot = new Label("������:");
	Label lbTotCnt = new Label("0 ����");
	Label lbShoot = new Label("������:");
	Label lbShootCnt = new Label("0 ȸ");
	Label lbFail = new Label("������:");
	Label lbFailCnt = new Label("0 ȸ");
	Label lbgameTot = new Label("�Ѱ��Ӱ���Ƚ��: 0");
	Button btnShoot1 = new Button("�߰Ÿ���");
	Button btnShoot2 = new Button("�����");
	Button btnShoot3 = new Button("�г�Ƽ��");
	Button clear = new Button("�����ʱ�ȭ");
	List li = new List(3, false);
	
	String ment1[]= {"�߰Ÿ����� ����!","�߰Ÿ��� ����..."};			
	String ment2[]= {"������� ����!","����� ����..."};
	String ment3[]= {"�г�Ƽ���� ����!","�г�Ƽ�� ����..."};
	
	int tot=0, ok=0, fail=0; //����ó�� ������ ������
	String name="";//������ �౸�����̸�.
	Soccer()
	{
		super("�౸����");
		this.setSize(630,400);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
		
	}
	//����Ƚ���� �����ϴ� ����� �����ÿ�
	//�߰�����۾�
	//����, ����, ���� �ʱ�ȭ ��ư�� ����ÿ�.
	//��������: �г�Ƽ���� 1ȸ���� ���
	//������� 2ȸ���� ���
	//������ �߰Ÿ��� ���
	//Ư������, �������� 8ȸ�̻��̸� ���̾�α�â�� ���� ������ ���� ���ϸ�Ʈ ������(è�Ǿ𽺸��� ���! ��ũ�����̼�~)
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
		li.add("�����");
		li.add("�޽�");
		li.add("ȣ����");
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
		lbMember.setText("�౸����:"+name);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(name.equals(""))
		{
			lbResult.setText("���������ÿ�.");
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
		
		lbTotCnt.setText(tot+"ȸ");
		lbShootCnt.setText(ok+"ȸ");
		lbFailCnt.setText(fail+"ȸ");
		
	}
}












