package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

	double v[] = { 4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0 };
	private Connection con;
	private Statement stmt;

	public db() {
		// JDBC설정
		try {
			String driverName = "org.gjt.mm.mysql.Driver"; // JDBC 드라이버에 따라 다르게
															// 설정
			Class.forName(driverName); // 드라이버이름 설정
			String url = "jdbc:mysql://localhost:3306/university";
			con = DriverManager.getConnection(url, "root", "dl84905018!!"); // connection
																			// 설정
			stmt = con.createStatement(); // 쿼리문을 실행할 statement 설정

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// constructor

	public void selectQueryOne() {
		String query = "select ID, name, grade, credits from (student natural join takes)join course using(course_id) order by ID;"; // attribute와
																																		// table이름에
																																		// 따라
																																		// 다르게
																																		// 설정하세요.
		ResultSet rs;
		try {

			rs = stmt.executeQuery(query); // 쿼리를 실행 시킵니다.

			double tot_crd = 0;
			String first = null;
			double sum = 0;
			String name = null;
			while (rs.next()) // 쿼리 실행 결과 다수의 라인을 포함하는 경우 반복문을 통하여 결과를 가져옵니다.
			{
				String second = rs.getString(1);

				if (first == null) {
					first = second;

				}

				if (!first.equals(second)) {

					if (sum / tot_crd >= 3.5) {
						System.out.printf("%s, %s, %.2f, %.2f\n", first, name, tot_crd, sum / tot_crd);
					}

					first = second;
					sum = 0;
					tot_crd = 0;

				}

				if (first.equals(second)) {

					name = rs.getString(2);
					int num = 0;
					String str = rs.getString(3);

					if (str.charAt(0) == 'A') {
						num = 1;
					} else if (str.charAt(0) == 'B') {
						num = 4;
					} else if (str.charAt(0) == 'C') {
						num = 7;
					} else if (str.charAt(0) == 'D') {
						num = 10;
					} else if (str.charAt(0) == 'F') {
						num = 12;
					}

					if (str.charAt(1) == '+') {
						num = num - 1;
					} else if (str.charAt(1) == '-') {
						num = num + 1;
					}

					sum += v[num] * rs.getDouble(4);

					tot_crd += rs.getDouble(4);
				}

				// 쿼리의 실행 결과를 출력합니다.
			} // while

			if (sum / tot_crd >= 3.5) {
				System.out.printf("%s, %s, %.2f, %.2f\n", first, name, tot_crd, sum / tot_crd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch
	}// selectQueryone

	public void selectQueryTwo(double paramDept) {

		String query = "select ID, name, grade, credits from (student natural join takes)join course using(course_id) order by ID;"; // attribute와
																																		// table이름에
																																		// 따라
																																		// 다르게
																																		// 설정하세요.
		ResultSet rs;
		try {

			rs = stmt.executeQuery(query); // 쿼리를 실행 시킵니다.

			double tot_crd = 0;
			String first = null;
			double sum = 0;
			String name = null;
			while (rs.next()) // 쿼리 실행 결과 다수의 라인을 포함하는 경우 반복문을 통하여 결과를 가져옵니다.
			{
				String second = rs.getString(1);

				if (first == null) {
					first = second;

				}

				if (!first.equals(second)) {

					if (sum / tot_crd > paramDept) {
						System.out.printf("%s, %s, %.2f, %.2f\n", first, name, tot_crd, sum / tot_crd);
					}

					first = second;
					sum = 0;
					tot_crd = 0;

				}

				if (first.equals(second)) {

					name = rs.getString(2);
					int num = 0;
					String str = rs.getString(3);

					if (str.charAt(0) == 'A') {
						num = 1;
					} else if (str.charAt(0) == 'B') {
						num = 4;
					} else if (str.charAt(0) == 'C') {
						num = 7;
					} else if (str.charAt(0) == 'D') {
						num = 10;
					} else if (str.charAt(0) == 'F') {
						num = 12;
					}

					if (str.charAt(1) == '+') {
						num = num - 1;
					} else if (str.charAt(1) == '-') {
						num = num + 1;
					}

					sum += v[num] * rs.getDouble(4);

					tot_crd += rs.getDouble(4);
				}

				// 쿼리의 실행 결과를 출력합니다.
			} // while

			if (sum / tot_crd > paramDept) {
				System.out.printf("%s, %s, %.2f, %.2f\n", first, name, tot_crd, sum / tot_crd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// selectQueryTwo

	public void selectQueryThree(int param) {

		String query = "select ID, name, year, semester, course_id, title, credits, grade from (student natural join takes)join course using(course_id) where ID = "
				+ param + ""; // 설정하세요.
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query); // 쿼리를 실행 시킵니다.

			int first = -1;
			double tot_crd = 0;
			double sum = 0;
			while (rs.next()) // 쿼리 실행 결과 다수의 라인을 포함하는 경우 반복문을 통하여 결과를 가져옵니다.
			{
				int id = rs.getInt(1);
				if (id == param) {
					if (first == -1) {
						first = id;
						String name = rs.getString(2);
						System.out.printf("ID : %d, 이름 : %s\n", id, name);
						System.out.printf("  해당년도      학기      과목번호                                                   과목명                                                   학점     성적  \n");
					}

				
					int year = rs.getInt(3);
					String sem = rs.getString(4);
					int c_id = rs.getInt(5);
					String t = rs.getString(6);
					int credits = rs.getInt(7);
					
					String str = rs.getString(8);

					 System.out.printf("%-8d%-10s%-8d%-60s%-6d%-5s\n", year,
					 sem, c_id, t, credits, str);

					int num = 0;

					if (str.charAt(0) == 'A') {
						num = 1;
					} else if (str.charAt(0) == 'B') {
						num = 4;
					} else if (str.charAt(0) == 'C') {
						num = 7;
					} else if (str.charAt(0) == 'D') {
						num = 10;
					} else if (str.charAt(0) == 'F') {
						num = 12;
					}

					if (str.charAt(1) == '+') {
						num = num - 1;
					} else if (str.charAt(1) == '-') {
						num = num + 1;
					}

					sum += v[num] * rs.getDouble(7);

					tot_crd += rs.getDouble(7);
					
				}

			}

			System.out.printf("총 이수학점: %.0f\n평점평균 : %.2f\n", tot_crd, sum / tot_crd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("쿼리를 잘못 입력하셨습니다");
		} // catch
	}// method

}// class
