package com.baichou.springboot.service;

/**
 * Created by root on 16-10-20.
 */

import com.baichou.springboot.dao.DemoDao;
import com.baichou.springboot.dao.DemoRepository;
import com.baichou.springboot.model.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service

public class DemoService {

    @Resource
    private DemoRepository demoRepository;
    @Resource
    private DemoDao demoDao;

    @Transactional
    public void save(Demo demo) {
        demoRepository.save(demo);
    }

    public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return demoDao.getById(id);
    }

    public Demo findById(long id){
        return demoRepository.findOne(id);
    }
}