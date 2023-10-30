package redis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.JedisPooled;

/**
 * JedisPooled.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/30
 */
public class JedisPooledTest {

  @Test
  @DisplayName("JedisPooled는 try catch가 없네")
  void test() {
    //Arrange
    JedisPooled jedis = new JedisPooled("localhost", 6379);
    //Act
    jedis.set("foo", "bar");
    String value = jedis.get("foo");
    //Assert
    assertEquals("bar", value);
  }
}
