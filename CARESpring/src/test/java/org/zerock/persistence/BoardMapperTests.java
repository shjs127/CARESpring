package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.care.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// @ContextConfiguration(classes = { org.zerock.config.RootConfig.class })
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private UserMapper boardMapper;

	@Test
	public void selectBoardList() throws Exception {
		log.info("/* "+boardMapper.getClass().getName());
		log.info("/* boardMapper.selectBoardList()="+boardMapper.selectBoardList());
	}

}
