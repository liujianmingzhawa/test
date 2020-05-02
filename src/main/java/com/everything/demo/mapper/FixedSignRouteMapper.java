package com.everything.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.FixedSignRoute;



@Mapper
public interface FixedSignRouteMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FixedSignRoute record);

    int insertSelective(FixedSignRoute record);

    FixedSignRoute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FixedSignRoute record);

    int updateByPrimaryKey(FixedSignRoute record);

	Long selectByCount(Map<String, Object> map);

	List<FixedSignRoute> selectByPage(Map<String, Object> map);
}