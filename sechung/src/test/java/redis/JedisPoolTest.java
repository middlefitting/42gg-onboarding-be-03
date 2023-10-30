package redis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * JedisPoolTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/30
 */
@DisplayName("JedisPool 연결 테스트")
public class JedisPoolTest {
  @Test
  @DisplayName("String 꺼내보기")
  void stringTest() {
    //Arrange
    JedisPool jedisPool = new JedisPool("localhost", 6379);
    try (Jedis jedis = jedisPool.getResource()) {
      //Act
      jedis.set("foo", "bar");
      String value = jedis.get("foo");
      //Assert
      assertEquals("bar", value);
    }
  }

  @Test
  @DisplayName("Hashmap 꺼내보기")
  void test() {
    //Arrange
    JedisPool jedisPool = new JedisPool("localhost", 6379);
    try (Jedis jedis = jedisPool.getResource()) {
      HashMap<String, String> map = new HashMap<>();
      map.put("name", "sechung");
      map.put("age", "28");
      map.put("job", "developer");
      jedis.hmset("user", map);
      //Act
      Map<String, String> user = jedis.hgetAll("user");
      //Assert
      assertEquals(map.get("name"), user.get("name"));
      assertEquals(map.get("age"), user.get("age"));
      assertEquals(map.get("job"), user.get("job"));
    }
  }
}
