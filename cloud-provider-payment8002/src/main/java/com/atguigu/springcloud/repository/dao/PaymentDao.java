package com.atguigu.springcloud.repository.dao;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (PaymentDomain)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-18 10:25:40
 */
@Mapper
@Repository
public interface PaymentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PaymentDomain queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PaymentDomain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<PaymentDomain> queryAll();

    /**
     * 新增数据
     *
     * @param PaymentDomain 实例对象
     * @return 影响行数
     */
    int insert(PaymentDomain PaymentDomain);

    /**
     * 修改数据
     *
     * @param PaymentDomain 实例对象
     * @return 影响行数
     */
    int update(PaymentDomain PaymentDomain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}