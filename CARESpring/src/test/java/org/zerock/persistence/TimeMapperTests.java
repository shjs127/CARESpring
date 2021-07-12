package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.care.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// @ContextConfiguration(classes = { org.zerock.config.RootConfig.class })
@Log4j
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {
		log.info("/* "+timeMapper.getClass().getName());
		log.info("/* timeMapper.getTime()="+timeMapper.getTime());
	}

	@Test
	public void tetGetTime2() {

		log.info("/* getTime2");
		log.info("/* timeMapper.getTime2()="+timeMapper.getTime2());

	}

}
