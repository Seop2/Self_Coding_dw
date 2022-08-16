package day10;

import java.util.ArrayList;
import java.util.List;

class 카페{
	private String 메뉴이름;
	private int 가격;
	private int 포인트적립;
	public String get메뉴()
	{
		return this.메뉴이름;
	}
	public void set메뉴(String 메뉴이름)
	{
		this.메뉴이름 = 메뉴이름;
	}
	public int get가격()
	{
		return this.가격;
	}
	public void set가격(int 가격)
	{
		this.가격 = 가격;
	}
	public int get포인트적립()
	{
		return this.포인트적립;
	}
	public void set포인트적립(int 포인트)
	{
		this.포인트적립 = 포인트;
	}
}
/*
 * 1. 필드 변수 getter setter 메소드 생성
 * 2. 에스프레소 3000원, 아메리카노 4000원, 라떼 4500원 객체 생성
 * 3. 생성한 객체 list에 담기
 * 4. list에 있는 모든 원소 출력하기
 * 5. list에 라떼가 있으면 카페모카로 이름 수정
*/

public class List문제 {

	public static void main(String[] args) {
		List<카페>list = new ArrayList<카페>();
		카페 caf1 = new 카페();
		카페 caf2 = new 카페();
		카페 caf3 = new 카페();
		
		list.add(caf1);
		list.add(caf2);
		list.add(caf3);
		
		caf1.set메뉴("아메리카노");
		caf2.set메뉴("에스프레소");
		caf3.set메뉴("라떼");
		
		caf1.set가격(3000);
		caf2.set가격(4000);
		caf3.set가격(4500);
		caf1.set포인트적립(100);
		caf2.set포인트적립(200);
		caf3.set포인트적립(300);
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(2).get메뉴().equals("라떼"))
				list.get(2).set메뉴("카페모카");
			/////////////////////////////////////
			String 메뉴이름 = list.get(i).get메뉴();
			if("카페모카".equals(메뉴이름))
				list.get(i).set메뉴("카푸치노");
			System.out.println(list.get(i).get메뉴()+"/"+list.get(i).get가격()+"/"+list.get(i).get포인트적립());
		}
	}

}
