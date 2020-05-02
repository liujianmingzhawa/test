package com.everything.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.HttpsMo;



@Mapper
public interface HttpsMoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HttpsMo record);

    int insertSelective(HttpsMo record);

    HttpsMo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HttpsMo record);

    int updateByPrimaryKey(HttpsMo record);

	int selectByUuid(String uuid);

	List<HttpsMo> selectListByLimit(Map<String, Object> selectMap);

	void updateBatchByIds(List<Long> ids);

	void deleteByDateAndHashValue(Map<String, Object> map);
}