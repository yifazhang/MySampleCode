package com.zhangyifa.test.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by zhangyifa on 6/27/17.
 */
public class LogTest {

    @Test
    public void testLog() {
        Logger log = LogManager.getLogger(this.getClass());

        log.trace("this is a trace");
        log.debug("debug 级别日志");
        log.info("info 级别日志");
        log.warn("warn 级别日志");
        log.error("error 级别日志");
        log.fatal("fatal 级别日志");
    }

}
