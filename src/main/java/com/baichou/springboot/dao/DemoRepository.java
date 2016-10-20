package com.baichou.springboot.dao;

import com.baichou.springboot.model.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by root on 16-10-20.
 */
/*

 * 在CrudRepository自带常用的crud方法.

 * 这样一个基本dao就写完了.

 */

public interface DemoRepository extends CrudRepository<Demo, Long> {



}