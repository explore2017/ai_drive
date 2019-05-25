package com.explore.dao;

import com.explore.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    Staff login(@Param("name") String name, @Param("password")String password);

    List<Staff> selectAll();

    Integer selectAllCountByCampusId(Integer id);

    Integer selectAllCount();
}