package �ڹ�23_���������α׷���_�̺�Ʈ;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class study8 {
//�౸����Ȯ������
	public static void main(String[] args) {
		soccer2 s = new soccer2();
		
	}

}
class soccer2 extends Frame implements ActionListener, ItemListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	int PossibleCnt = 10;
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	Label lbList = new Label("�౸��������Ʈ");
	Label lbListSelect = new Label("�౸����:�������...");
	Label lbPossible = new Label("�Ѱ��Ӱ���Ƚ��:");
	Label lbTotal = new Label("������:");
	Label lbShootSuccess = new Label("������:");
	Label lbShootFail = new Label("������:");
	Label lbTotCnt = new Label("0����");
	Label lbSuCnt = new Label("0ȸ");
	Label lbFailCnt = new Label("0ȸ");
	Label lbPossibleCnt = new Label(PossibleCnt+"ȸ");
	Label lbResult = new Label("���: �����....");
	List li = new List(3,false);
	Button btn1 = new Button("�߰Ÿ���");
	Button btn2 = new Button("�����");
	Button btn3 = new Button("�І�Ƽ��");
	Button btn4 = new Button("�����ʱ�ȭ");
	String name = "";//������ �౸���� �̸�
	int tot =0, ok=0, fail=0;
	String[] ment1={"�߰Ÿ�������!","�߰Ÿ�������!"};
	String[] ment2={"���������!","���������!"};
	String[] ment3={"�г�Ƽ������!","�г�Ƽ������!"};
	
	Dialog dialog;
	private Label diaLabel1 = new Label("è�Ǿ𽺸��� ���!");
	private Label diaLabel2 = new Label("��ũ�����̼�~!");
	private Button btnConfirm = new Button("Ȯ��");
	soccer2()
	{
		super("�౸����");
		this.setSize(630, 500);
		this.setVisible(true);
		this.center();
		this.init();
		this.start();
		dialog = new Dialog(this,"DialogExample", true);
		dialog.setLayout(null);
		dialog.add(diaLabel1);
		dialog.add(diaLabel2);
		dialog.add(btnConfirm);
		
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()//ȭ���ġ
	{
		this.setLayout(null);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(li);
		li.add("�����");
		li.add("�޽�");
		li.add("ȣ����");
		this.add(lbFailCnt);
		this.add(lbSuCnt);
		this.add(lbTotCnt);
		this.add(lbPossible);
		this.add(lbPossibleCnt);
		this.add(lbList);
		this.add(lbListSelect);
		this.add(lbResult);
		this.add(lbShootSuccess);
		this.add(lbShootFail);
		this.add(lbTotal);
		
		lbList.setBounds(50, 50, 150, 30); lbList.setFont(font20);
		li.setBounds(50, 100, 150, 200); li.setFont(font20);
		lbPossible.setBounds(40,400,250,30);lbPossible.setFont(font30);
		lbPossibleCnt.setBounds(290,400,150,30);lbPossibleCnt.setFont(font30);
		lbListSelect.setBounds(250, 50, 250, 30); lbListSelect.setFont(font20);
		btn1.setBounds(250, 100, 100, 30); btn1.setFont(font20);
		btn2.setBounds(370, 100, 100, 30); btn2.setFont(font20);
		btn3.setBounds(490, 100, 100, 30); btn3.setFont(font20);
		btn4.setBounds(460, 150, 150, 30); btn4.setFont(font20);
		lbResult.setBounds(250, 150, 250, 30); lbResult.setFont(font20);
		lbTotal.setBounds(250, 200, 70, 30); lbTotal.setFont(font20);
		lbTotCnt.setBounds(330, 200, 70, 30); lbTotCnt.setFont(font20);
		diaLabel1.setBounds(50, 50, 200, 50);diaLabel1.setFont(font20);
		diaLabel2.setBounds(50, 100, 200, 50);diaLabel2.setFont(font20);
		lbShootSuccess.setBounds(250, 250, 70, 30); lbShootSuccess.setFont(font20);
		lbSuCnt.setBounds(330, 250, 70, 30); lbSuCnt.setFont(font20);
		lbShootFail.setBounds(410, 250, 70, 30); lbShootFail.setFont(font20);
		lbFailCnt.setBounds(490, 250, 70, 30); lbFailCnt.setFont(font20);
		btnConfirm.setBounds(100, 200, 100, 30);
	}
	void start()
	{
		li.addItemListener(this);
		btn1.addActionListener(this);//�߰Ÿ�
		btn2.addActionListener(this);//�����
		btn3.addActionListener(this);//�І�Ƽ
		btn4.addActionListener(this);//�����ʱ�ȭ
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(name.equals(""))
		{
			lbResult.setText("������ ���ÿ�.");return;
		}
		while(true)
		{
			if(e.getSource()==btn4)
			{
				tot=0;ok=0;fail=0;
			}
			if(tot<PossibleCnt)
			{
				if(e.getSource()==btn1)//�߰Ÿ���
				{
					tot++;
					int num = (int)(Math.random()*10);//10�� �� ���� ������30%
					if(num==0||num==1||num==2)
					{
						lbResult.setText(ment1[0]);
						ok++;
					}else {
						lbResult.setText(ment1[1]);
						fail++;
					}
				}
				else if(e.getSource()==btn2)//�����
				{
					tot++;
					int num = (int)(Math.random()*10);//10�� �� ���� ������50%
					if(num==0||num==1||num==2||num==3||num==4)
					{
						lbResult.setText(ment2[0]);
						ok++;
					}
					else {
						lbResult.setText(ment2[1]);
						fail++;
					}
				}
				else if(e.getSource()==btn3)//�г�Ƽ��
				{
					tot++;
					int num = (int)(Math.random()*10);//10�� �� ���� ������90%
					if(num==0)
					{
						lbResult.setText(ment3[1]);
						fail++;
					}else {
						lbResult.setText(ment3[0]);
						ok++;
					}
					
				}
				if(ok>=8)//���̾�α� �߰�
				{
					dialog.setSize(300, 300);
					dialog.setVisible(true);
					dialog.setLocation(300, 300);
				}
				lbTotCnt.setText(tot+"ȸ");
				lbFailCnt.setText(fail+"ȸ");
				lbSuCnt.setText(ok+"ȸ");			
				break;
			}
		}	 
	}
	@Override
	public void itemStateChanged(ItemEvent e) {//����Ʈ ������ �̺�Ʈ
		name = li.getSelectedItem();
		lbListSelect.setText("�౸����:"+ name);
	}
}

//final Dialog dlg = new Dialog(this, "OK", true);
//dlg.setLayout(new BorderLayout());
//String sss = "�ֹι�ȣ : " + first + "-" + second + "�� ����� �� �ִ�.";
//dlg.add("Center", new Label(sss, Label.CENTER));
//Button bt = new Button("Ȯ��");
//Panel pp = new Panel(new FlowLayout());
//pp.add(bt);
//bt.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		dlg.setVisible(false);
//	}
//});
//dlg.add("South", pp);
//dlg.setSize(300, 100);
//dlg.setVisible(true);