package com.everything.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.SmsRptTask;

import java.util.List;
import java.util.Map;

@Mapper
public interface SmsRptTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsRptTask record);

    int insertSelective(SmsRptTask record);

    SmsRptTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsRptTask record);

    int updateByPrimaryKey(SmsRptTask record);

    List<SmsRptTask> selectRetryByHostAndHash(Map<String, Object> map);
}