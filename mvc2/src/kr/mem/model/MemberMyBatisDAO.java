package kr.mem.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//jdbc
// 1. DriverManager   -> SqlSessionFactoryBuilder
// 2. Connection	  -> SqlSession
// 3. PreparedStatement
// 4. ResultSet
public class MemberMyBatisDAO {
   private static SqlSessionFactory sqlSessionFactory;
   
   //초기화 블럭
	static {
		try {
			String resource = "kr/mem/mybatis/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   //DB 연결 끗,,
   

	
	
	public int memberInsert(Member_VO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = -1;
		try {
			cnt = session.insert("memberInsert", vo);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();	//반납
		}
		
		return cnt;
	}
	
	
	
	public int memberDelete(int num) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = -1;
		
		try {
			cnt = session.insert("memberDelete", num);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();	
		}
		
		return cnt;
	}
		
	
	public List<Member_VO> memberAllList() {
		
		//db와 연결하는 부분
		SqlSession session=sqlSessionFactory.openSession();
		List<Member_VO> list = null;
		
		try {
			list = session.selectList("memberAllList");
			//session.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			session.close();
		}
		return list;
		
	}
	
	
	public Member_VO memberContent(int num) {
	
		SqlSession session = sqlSessionFactory.openSession();
		Member_VO vo = null;

		try {
			vo = session.selectOne("memberContent", num);
			// session.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return vo;

	}
	
	
	public int MemberUpdate(Member_VO vo) {	
	
	
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = -1;
		
		try {
			cnt = session.update("MemberUpdate", vo);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();	
		}
		
		return cnt;
	
	
	}
}