package com.baichou.springboot.dao;

import com.baichou.springboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by root on 16-10-20.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    public User findByEmail(String email);
    public User findByName(String name);
    public User findById(String id);
    // 使用query 注解进行update 或者 delete 语句时，需要添加 modifying 注解修饰
//    @Query(value="delete from t_user;",nativeQuery=true)
//    @Modifying
//    public void deleteAllBySql();

    /** CrudRepository 接口继承于 Repository 接口，并新增了如下方法
     long count();
     boolean exists(Integer arg0);

     <S extends StudentPO> S save(S arg0);
     <S extends StudentPO> Iterable<S> save(Iterable<S> arg0);

     void delete(Integer arg0);
     void delete(Iterable<? extends StudentPO> arg0);
     void delete(StudentPO arg0);
     void deleteAll();

     StudentPO findOne(Integer arg0);
     Iterable<StudentPO> findAll();
     Iterable<StudentPO> findAll(Iterable<Integer> arg0);

     */


}