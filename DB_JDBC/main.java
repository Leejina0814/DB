package homework;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		db db = new db();	// 데이터베이스 객체 생성
		int input;
		
		while(true){
			
			System.out.println("입력 하실 데이터베이스 쿼리의 타입을 설정하세요");
			System.out.println("1번 평점 평균이 3.5이상인 학생의 정보 출력(ID, 이름, 총이수학점, 평점평균)");
			System.out.println("2번 평점 평균을 파라미터로 주어 입력 평점 평균보다 평점 평균이 높은 학생의 정보 출력(ID, 이름, 총이수학점, 평점평균)");
			System.out.println("3번 학생의 학번(ID)를 입력 받아 그 학생의 성적표 출력");
			
			try{
				
				input = sc.nextInt();
				System.out.println(input+"번 입력하셨습니다.");
			
			switch(input)
			{
			case 1:
				db.selectQueryOne();
				break;
			case 2:
				System.out.println("평점 평균을 입력해주세요:");
				double average = sc.nextDouble();
				db.selectQueryTwo(average);
				break;
			case 3:
				System.out.println("학생의 학번(ID)를 입력하세요");
				int param = sc.nextInt();
				db.selectQueryThree(param);
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
				continue;
			}//switch
			
			}catch(Exception e){
				System.out.println("숫자를 입력하지 않으셨습니다. 다시 입력하세요.");
				sc.nextLine();
			}//catch
	}//while loop
}//main function
}//main class
