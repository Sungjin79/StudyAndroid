import java.sql.Connection;

import study.java.daoex.dao.StudentDao;
import study.java.daoex.dao.impl.StudentDaoImpl;
import study.java.helper.DBHelper;

public class Main22 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		Connection conn = DBHelper.getInstance().open();
		
		if (conn == null) {
			System.out.println("데이터베이스 접속 실패");
			return;
		}
		
		// 2) 삭제할 데이터
		int target = 50505;
		
		// 3) 501번 데이터 삭제
		StudentDao dao = new StudentDaoImpl(conn);
		int result = dao.delete(target);
		
		// 4) 결과 판별
		System.out.println(result + "개의 데이터 삭제됨");
		
		// 5) DB 접속 해제
		DBHelper.getInstance().close();
	}
}
