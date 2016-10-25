package com.baichou.springboot.service;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.DemoInfo;

/**
 * demoInfo服务接口
 *
 * @author zyang0419
 * @create 2016-10-25 上午9:47
 **/
public interface DemoInfoService {

    public DemoInfo findById(long id);

    public void deleteFromCache(long id);

    void test();
}
