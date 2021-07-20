package org.care.mapper;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.care.domain.UserInfo;

@Repository
public class RegisterMapperImpl implements RegisterMapper {
	private static final String NAMESPACE = "org.care.mapper.RegisterMapper";
	private final SqlSession sqlSession;

	@Inject 
	public RegisterMapperImpl(SqlSession sqlSession) { 
		this.sqlSession = sqlSession; 
	}
		// 회원가입처리 
	@Override 
	public void register(UserInfo userInfo) throws Exception {
	 sqlSession.insert(NAMESPACE + ".register", userInfo); } 

}
