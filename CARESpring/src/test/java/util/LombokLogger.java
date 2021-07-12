package util;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class LombokLogger {
	@Test
	public void print() {
		log.info("Hello World");
	}

}
