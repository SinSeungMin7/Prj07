package ex01;

import java.util.Objects;

class Member {
	// Field
	private int      num;
	private String  name;
	private String phone;
	
	// 기본 생성자 Constructor
	public Member() { }
	// 인자있는 생성자
	public Member(int num, String name, String phone) {
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;
	}
	// Method
	// toString : 재정의 m1 내용을 볼수있도록 
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", phone=" + phone + "]";
	}
	
	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(name, num, phone);
	}
	// equals
	@Override
	public boolean equals(Object obj) {
		Member other = (Member) obj;
		return num == other.num;            // 번호 비교
	//	&& Objects.equals(name, other.name); // 이름비교
			//	&& Objects.equals(phone, other.phone); // 전화번호 비교
	}
	
	
}

public class TestMemberArray {

	public static void main(String[] args) {
		// 여러명의 정보를 입력받아
		// 검색객체를 만들어서 해당맴버를 찾는 코딩
		/*
		Member m1 = new Member(1, "민지", "010-1111-1111");
		Member m2 = new Member(2, "원영", "010-2222-2222");
		Member m3 = new Member(3, "윈터", "010-3333-3333");
		Member m4 = new Member(4, "유진", "");   // 빈 문자열
		Member m5 = new Member(5, "유나", "010-5555-5555");
		Member m6 = new Member(6, "닝닝", null); // null
		
		System.out.println( m1 );
		System.out.println( m2 );
		System.out.println( m3 );
		System.out.println( m4 );
		System.out.println( m5 );
		System.out.println( m6 );
		*/
		// 배열을 만든다
		Member[] mArr = new Member[6];
		
		mArr[0] = new Member(1, "민지", "010-1111-1111");
		mArr[1] = new Member(2, "원영", "010-2222-2222");
		mArr[2] = new Member(3, "윈터", "010-3333-3333");
		mArr[3] = new Member(4, "유진", "");   // 빈 문자열
		mArr[4] = new Member(5, "유나", "010-5555-5555");
		mArr[5] = new Member(6, "닝닝", null); // null
		
		// 배열 전체 출력
		
		for (Member member : mArr) {
			System.out.println(member);
		}
		
		System.out.println("=============================================");
		
		// 찾을 사람의 정보
		Member mem = new Member( 7, null, null );
		
		// 주소비교(==)로는 찾을수 없다 -> data 비교로 변경해야 한다
		// 데이터 비교로 변경 --> equals() 재정의
		// 일을 수행했다 안했다 체크할때 사용
		boolean isFound = false; 
		for (int i = 0; i < mArr.length; i++) {
			Member member = mArr[i];
		//	System.out.println( "member : " + member.hashCode() );
		//	System.out.println( "mem : " + mem.hashCode() );
		//	if ( member == mem ) { // == 이꼴 2개는 주소를 비교하는것
		//		System.out.println( member );
			if ( member.equals(mem) ) { 
				System.out.println( member );
				isFound = true;
				break;// 반복문 탈출
			}
			/*
			else {
				System.out.println("못찾음");
			} // 이건 여러번 나온다 못찾음이
			*/
		}
		// 못찾음
		if ( !isFound )
			System.out.println("못찾음");
		
		// if ( mem == m1 )  if 문은 사람 수만큼 만들어야하기때문에 비효율적이다.
		
		
		
	}

}
