package homework;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		db db = new db();	// �����ͺ��̽� ��ü ����
		int input;
		
		while(true){
			
			System.out.println("�Է� �Ͻ� �����ͺ��̽� ������ Ÿ���� �����ϼ���");
			System.out.println("1�� ���� ����� 3.5�̻��� �л��� ���� ���(ID, �̸�, ���̼�����, �������)");
			System.out.println("2�� ���� ����� �Ķ���ͷ� �־� �Է� ���� ��պ��� ���� ����� ���� �л��� ���� ���(ID, �̸�, ���̼�����, �������)");
			System.out.println("3�� �л��� �й�(ID)�� �Է� �޾� �� �л��� ����ǥ ���");
			
			try{
				
				input = sc.nextInt();
				System.out.println(input+"�� �Է��ϼ̽��ϴ�.");
			
			switch(input)
			{
			case 1:
				db.selectQueryOne();
				break;
			case 2:
				System.out.println("���� ����� �Է����ּ���:");
				double average = sc.nextDouble();
				db.selectQueryTwo(average);
				break;
			case 3:
				System.out.println("�л��� �й�(ID)�� �Է��ϼ���");
				int param = sc.nextInt();
				db.selectQueryThree(param);
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				continue;
			}//switch
			
			}catch(Exception e){
				System.out.println("���ڸ� �Է����� �����̽��ϴ�. �ٽ� �Է��ϼ���.");
				sc.nextLine();
			}//catch
	}//while loop
}//main function
}//main class
