package util;

import java.util.List;

import org.junit.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
public class LombokBuilder {
	@Test
	public void print() {
		User user1 = User.builder().id(1L).username("dale").password("1234").score(70).score(80).build();
		User user2 = User.builder().id(2L).username("hong").password("hong").build();
		log.info(user1.toString());
		log.info(user2.toString());
		user2.setPassword("1234");
		log.info(user2.toString());
	}
}

@Builder
@Getter
@Setter
@ToString
class User {
	private Long id;
	private String username;
	private String password;
	@Singular
	private List<Integer> scores;
}
