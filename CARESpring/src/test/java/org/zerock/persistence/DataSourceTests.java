package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// @ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;

	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testDataSource() {

		try (Connection con = dataSource.getConnection()) {

			log.info("*** con="+con);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSqlSessionFactory() {

		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {

			log.info("*** session=" + session);
			log.info("*** con=" + con);

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

}
