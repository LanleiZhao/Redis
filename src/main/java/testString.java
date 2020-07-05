import redis.clients.jedis.Jedis;

/**
 * @author lucas
 * @create 2020-07-06-00:32
 */
public class testString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("key1", "001");
        jedis.set("key2", "002");

    }
}
