import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author lucas
 * @create 2020-07-04-00:59
 */
public class testJedis {

    Jedis jedis = new Jedis("localhost", 6379);

    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void testString() {
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void testList() {
        Boolean exists = jedis.exists("l1");
        if (exists) {
            List<String> list = jedis.lrange("l1", 0, -1);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void testHash() {
        jedis.hset("u3", "userName", "lisi");
        String name = jedis.hget("u3", "userName");
        System.out.println(name);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("telephone", "18300262950");
        map.put("address", "1903076902@qq.com");
        jedis.hset("u3", map);

        Set<String> hkeys = jedis.hkeys("u3");
        for (String hkey : hkeys) {
            System.out.println(hkey+"  =>  "+jedis.hget("u3",hkey));
        }
    }



}
