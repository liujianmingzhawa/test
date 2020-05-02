package com.everything.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.TimeLimit;



@Mapper
public interface TimeLimitMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TimeLimit record);

    int insertSelective(TimeLimit record);

    TimeLimit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TimeLimit record);

    int updateByPrimaryKey(TimeLimit record);

	List<String> timeLimitChannelListByIsValid();

	Long selectByCount(Map<String, Object> map);

	List<TimeLimit> selectByPage(Map<String, Object> map);
}