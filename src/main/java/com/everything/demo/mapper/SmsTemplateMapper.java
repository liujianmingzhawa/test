package com.everything.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.SmsTemplate;

import java.util.List;
import java.util.Map;

@Mapper
public interface SmsTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsTemplate record);

    int insertSelective(SmsTemplate record);

    SmsTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsTemplate record);

    int updateByPrimaryKey(SmsTemplate record);

    Long selectByCount(Map<String, Object> map);

    List<SmsTemplate> selectByPage(Map<String, Object> map);

	SmsTemplate getSmsTemplateByChannelName(String srcChannel);
}