package day10;

class 멤버{
	private String 멤버이름;
	private int 멤버나이;
	public void set이름(String 멤버이름)
	{
		this.멤버이름 = 멤버이름;
	}
	public String get이름()
	{
		return this.멤버이름;
	}
	public void set나이(int 멤버나이)
	{
		this.멤버나이 = 멤버나이;
	}
	public int get나이()
	{
		return this.멤버나이;
	}
}
public class ListAndMap{

	public static void main(String[] args) {
		멤버 m = new 멤버();
		//m.멤버이름 = "유재석";//오류 -> 필드변수가 public이 아닌 private
		//문제1. 필드변수에 접근을 할 수 있게 로직을 수정하시오.
		//단 접근지정자는 private으로 !
		m.set이름("유재석");
		String 이름 = m.get이름();
		System.out.println("이름->"+이름);
		m.set나이(22);
		int 나이 = m.get나이();
		System.out.println("나이->"+나이);
	}

}
