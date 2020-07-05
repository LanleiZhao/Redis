import redis.clients.jedis.Jedis;

/**
 * @author lucas
 * @create 2020-07-06-00:52
 */
public class testList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.lpush("list1","a","b","c");
    }
}
