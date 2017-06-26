package com.zhangyifa.test.service.impl;

import com.zhangyifa.test.service.MyService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyifa on 6/26/17.
 */
@Service("myService")
public class MyServiceImpl implements MyService {

    @Override
    public void say() {
        System.out.println("MyServiceImpl say hi.");
    }
}
