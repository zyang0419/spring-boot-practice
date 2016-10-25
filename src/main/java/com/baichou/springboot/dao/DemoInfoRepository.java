package com.baichou.springboot.dao;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * demoInfo持久化类
 *
 * @author zyang0419
 * @create 2016-10-25 上午9:45
 **/
public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {



}
