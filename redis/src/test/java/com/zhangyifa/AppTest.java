package com.zhangyifa;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void testJedisClient() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("s2","222");
        String result = jedis.get("s2");
        System.out.println(result);
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool pool = new JedisPool("127.0.0.1",6379);

        Jedis jedis = pool.getResource();

        jedis.set("s3","333");

        String result = jedis.get("s2");

        System.out.println(result);
        jedis.close();
        pool.close();
    }

}
