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


    /**
     * Repository 是一个标记接口，继承该接口的Bean 会被Spring 容器识别为一个RepositoryBean，继承该接口的接口，有两大特点：
     * 1. 使用Query 注解查询
     * 2. 使用方法名查询：遵循SpringData 规范 命名，命名规则 ：（find | get | read) + By + field  ( + 条件关键字 + filed)
     *        注意条件关键字首字母大写
     * 3. spring data repository 接口中的方法默认只有查询 和 保存的 事务, 没有更新和删除的事务
     * @author: zyang0419
     * @date: 2016年10月21日
     */

    /*@Query(value="SELECT stu from StudentPO stu where student.id = ?1")
    public StudentPO getStudentPO(Integer id);

    @Query(value="SELECT stu from StudentPO stu where student.name = ?name")
    public StudentPO getStudentPOByName(@Param("name") String name);*/

    // 使用query 注解进行update 或者 delete 语句时，需要添加 modifying 注解修饰
   /* @Query(value="delete from t_demo",nativeQuery=true)
    @Modifying
    public void deleteAllBySql();*/

    /**
     * 根据id 列表查询, 采用的是in
     * Hibernate: select studentpo0_.id as id1_0_, studentpo0_.age as age2_0_, studentpo0_.birth as birth3_0_, studentpo0_.create_time as create_t4_0_, studentpo0_.name as name5_0_, studentpo0_.sex as sex6_0_ from spj_student studentpo0_  where studentpo0_.id in (? , ? , ?)
     */
    /*@Test
    public void test_findAll_Iterable(){
        List<Integer> idList = new ArrayList<>();
        idList.add(1);

        List<StudentPO> studentList = (List<StudentPO>) this.studentCrudRepository.findAll(idList);
        for (StudentPO studentPO : studentList) {
            System.out.println(studentPO);
        }

    }*/



    /**
     * 此种排序方式不能指定筛选条件
     * 排序会执行两条sql 语句
     * Hibernate: select count(*) as col_0_0_ from spj_student_2 studentpo0_
     * Hibernate: select studentpo0_.id as id1_0_, studentpo0_.age as age2_0_, studentpo0_.birth as birth3_0_, studentpo0_.create_time as create_t4_0_, studentpo0_.name as name5_0_, studentpo0_.sex as sex6_0_ from spj_student_2 studentpo0_ order by studentpo0_.id desc, studentpo0_.name asc limit ?
     */
   /*
    extends PagingAndSortingRepository<StudentPO, Integer>

    @Test
    public void test_findAll_page(){
        int currentPage =0; //当前页从0 开始
        int pageSize = 5;

        //排序
        Order idOrder = new Order(Direction.DESC, "id");
        Order nameOrder = new Order(Direction.ASC,"name");
        Sort sort = new Sort(idOrder,nameOrder);
        PageRequest pageRequest  = new PageRequest(currentPage, pageSize, sort);

        Page<StudentPO> page = this.studentdPageSortRepository.findAll(pageRequest);
        System.out.println("总记录数:" + page.getTotalElements());
        System.out.println("总页数:" + page.getTotalPages());
        System.out.println("当前页（request):" + page.getNumber());
        System.out.println("当前页总记录数（request):" + page.getSize());
        System.out.println("当前页记录总数：" + page.getNumberOfElements());
        List<StudentPO> students = page.getContent();
        for (StudentPO studentPO : students) {
            System.out.println(studentPO);
        }
    }*/

}