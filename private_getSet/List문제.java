package day10;

import java.util.ArrayList;
import java.util.List;

class ī��{
	private String �޴��̸�;
	private int ����;
	private int ����Ʈ����;
	public String get�޴�()
	{
		return this.�޴��̸�;
	}
	public void set�޴�(String �޴��̸�)
	{
		this.�޴��̸� = �޴��̸�;
	}
	public int get����()
	{
		return this.����;
	}
	public void set����(int ����)
	{
		this.���� = ����;
	}
	public int get����Ʈ����()
	{
		return this.����Ʈ����;
	}
	public void set����Ʈ����(int ����Ʈ)
	{
		this.����Ʈ���� = ����Ʈ;
	}
}
/*
 * 1. �ʵ� ���� getter setter �޼ҵ� ����
 * 2. ���������� 3000��, �Ƹ޸�ī�� 4000��, �� 4500�� ��ü ����
 * 3. ������ ��ü list�� ���
 * 4. list�� �ִ� ��� ���� ����ϱ�
 * 5. list�� �󶼰� ������ ī���ī�� �̸� ����
*/

public class List���� {

	public static void main(String[] args) {
		List<ī��>list = new ArrayList<ī��>();
		ī�� caf1 = new ī��();
		ī�� caf2 = new ī��();
		ī�� caf3 = new ī��();
		
		list.add(caf1);
		list.add(caf2);
		list.add(caf3);
		
		caf1.set�޴�("�Ƹ޸�ī��");
		caf2.set�޴�("����������");
		caf3.set�޴�("��");
		
		caf1.set����(3000);
		caf2.set����(4000);
		caf3.set����(4500);
		caf1.set����Ʈ����(100);
		caf2.set����Ʈ����(200);
		caf3.set����Ʈ����(300);
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(2).get�޴�().equals("��"))
				list.get(2).set�޴�("ī���ī");
			/////////////////////////////////////
			String �޴��̸� = list.get(i).get�޴�();
			if("ī���ī".equals(�޴��̸�))
				list.get(i).set�޴�("īǪġ��");
			System.out.println(list.get(i).get�޴�()+"/"+list.get(i).get����()+"/"+list.get(i).get����Ʈ����());
		}
	}

}
