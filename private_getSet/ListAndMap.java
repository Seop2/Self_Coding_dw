package day10;

class ���{
	private String ����̸�;
	private int �������;
	public void set�̸�(String ����̸�)
	{
		this.����̸� = ����̸�;
	}
	public String get�̸�()
	{
		return this.����̸�;
	}
	public void set����(int �������)
	{
		this.������� = �������;
	}
	public int get����()
	{
		return this.�������;
	}
}
public class ListAndMap{

	public static void main(String[] args) {
		��� m = new ���();
		//m.����̸� = "���缮";//���� -> �ʵ庯���� public�� �ƴ� private
		//����1. �ʵ庯���� ������ �� �� �ְ� ������ �����Ͻÿ�.
		//�� ���������ڴ� private���� !
		m.set�̸�("���缮");
		String �̸� = m.get�̸�();
		System.out.println("�̸�->"+�̸�);
		m.set����(22);
		int ���� = m.get����();
		System.out.println("����->"+����);
	}

}
