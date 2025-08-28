package MainClass;


import java.util.Scanner;
import java.util.*;

import Class.Book;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static HashMap<String, Book> data = new HashMap<>();	
	
	//*도서 정보 등록(REQ01)
	public static void AddBook() {
		//1)Book에 필요한 5개의 입력 받기
		System.out.println("도서 등록에 필요한 정보를 순차적으로 입력해주세요.");
		System.out.print("책번호(ISBN): ");
		String input_i = sc.next();
		System.out.print("책이름: ");
		String input_n = sc.next();
		System.out.print("저자: ");
		String input_a = sc.next();
		System.out.print("페이지수: ");
		int input_p = sc.nextInt();
		System.out.print("출판사명: ");
		String input_pub = sc.next();
		
		//2)Book에 대한 인스턴스 생성&입력값으로 멤버값 설정
		Book bk = new Book(input_i, input_n, input_a, input_p, input_pub);
		
		//3)인스턴스를 data에 추가
		//		<isbn값, 책 데이터>
		data.put(input_i, bk);
		System.out.println("***도서 등록이 완료되었습니다!***");
		System.out.println();
		
		PrintIntro();
	}
	//*도서 정보 조회(REQ02)
	//(수정사항)도서 전체 정보 조회->특정 도서 정보 조회
	public static void ReadBook() {
		//1)조회 하고자 하는 도서의 isbn값 검색
		System.out.println("검색할 도서의 ISBN값을 입력하세요.");
		String search=sc.next();
		System.out.println();
		
		//2)검색값을 기반으로, 해시맵데이터 조회(get()활용)
		Book result=data.get(search);
		
		//3)조회된 데이터 순차 출력
		if(result==null) {
			System.out.println("***검색에 실패했습니다. 다시시도해주세요.***");
		}
		else {
		System.out.println("***아래는 검색 결과입니다.***");
		System.out.println("책번호(ISBN): "+result.isbn);
		System.out.println("책이름: "+result.name);
		System.out.println("저자: "+result.author);
		System.out.println("페이지수: "+result.page+"쪽");
		System.out.println("출판사명: "+result.pub);
		}
		System.out.println();
		
		PrintIntro();	
	}
	
	//*도서 정보 삭제(REQ03)
	public static void DeleteBook() {
		//1)삭제할 도서의 isbn값 검색하기
		System.out.println("삭제할 도서의 ISBN값을 입력하세요.");
		String search = sc.next();
		
		Book result = data.get(search);
		if(result==null) {
			System.out.println();
			System.out.println("***삭제할 도서가 없습니다. 다시 시도해주세요.***");
			DeleteBook();	//도서 삭제 재실행
		} 
		data.remove(search);
		
		System.out.println();
		System.out.println("***도서 삭제를 수행했습니다.***");
		
		PrintIntro();
	}
	
	//*도서 정보 수정(REQ04)
	public static void EditBook() {
		//1)수정할 도서의 isbn값 검색 받기
		System.out.println("수정할 도서의 ISBN값을 입력하세요.");
		String search = sc.next();
		
		//2)isbn값을 기반으로, Book 인스턴스 불러오기 (hashmap.get()함수 활용)
		Book result = data.get(search);
		
		if (result == null) {	//검색결과가 없을 때
			System.out.println();
			System.out.println("***수정할 도서를 찾을 수 없습니다. ISBN을 다시 확인해주세요.***");
			EditBook();	//수정 기능 재실행
		}
		
		
		//3)도서의 수정할 부분 입력받기		
		System.out.println("수정할 카테고리를 선택하세요.");
		String category = sc.next();
		
		
		//4)수정할 값 입력받기
		System.out.println("해당 카테고리에 수정할 값을 입력하세요.");
		String edit = sc.next();
		
		//5)2)에서 받아온 Book 인스턴스의 멤버 변수값 설정하기
		//result::검색한 도서정보 전체를 갖고있음
		if(category.equals("책이름")==true) {
			result.name=edit;
			System.out.println("***<책이름>수정 완료***");
		}
		else if(category.equals("저자")==true) {
			result.author=edit;
			System.out.println("***<저자>수정 완료***");
		}
		else if(category.equals("페이지수")==true) {
			result.page=Integer.parseInt(edit);//int형으로 강제 변환 함수
			System.out.println("***<페이지수>수정 완료***");
		}
		else if(category.equals("출판사명")==true){
			result.pub=edit;
			System.out.println("***<출판사명>수정 완료***");
		}
		else {	//카테고리에 대해 입력이 엉뚱할때
			System.out.println();
			System.out.println("***입력이 올바르지 않습니다. 다시 시도해주세요.");
		}
		System.out.println();
		PrintIntro();
	}
	
	//*로그인 기능(ADD01)
	public static void DoLogin() {
		//1.로그인 수행(Login)
		//1-1)사용자에게 ID,PW값 요청
		System.out.println("아이디와 비밀번호를 순차적으로 입력해주세요.");
		System.out.print("아이디: ");
		String id=sc.next();
		System.out.print("비밀번호: ");
		String pw=sc.next();
		System.out.println();
		
		//1-2)관리자 계정 정보와 일치한지 확인
		if(id.equals("admin")==true && pw.equals("0000")==true) {//로그인성공
			System.out.println("***환영합니다, admin님!!!***");
			PrintIntro();
		}
		
		else {//로그인 실패
			System.out.println("로그인 정보가 올바르지 않습니다. 다시 시도해주세요.");
			DoLogin();	//로그인기능 재실행
		}
	}
	
	//인트로 기능(ADD02)
	public static void PrintIntro() {
		//1)사용자에게 선택지 제시 & 수행할 기능번호 입력받기
		System.out.println("1.도서 등록");
		System.out.println("2.도서 조회");
		System.out.println("3.도서 삭제");
		System.out.println("4.도서 수정");
		System.out.print("수행할 기능 번호를 입력해주세요.");
		int menu = sc.nextInt();
		System.out.println();
		
		//2)입력받은 기능 수행
		switch(menu) {
		case 1:
			System.out.println("***<1.도서 등록>수행***");
			AddBook();
			break;
		case 2:
			System.out.println("***<2.도서 조회>수행***");
			ReadBook();
			break;
		case 3:
			System.out.println("***<3.도서 삭제>수행***");
			DeleteBook();
			break;
		case 4:
			System.out.println("***<4.도서 수정>수행***");
			EditBook();
			break;
		default:
			System.out.println("올바르지 않은 입력입니다. 다시 수행해주세요.");
			PrintIntro();	//인트로 기능 재실행
		}
	}	
	
	public static void main(String args[]) {
		DoLogin();	//로그인 시도 재실행(재귀함수)
	}
}


