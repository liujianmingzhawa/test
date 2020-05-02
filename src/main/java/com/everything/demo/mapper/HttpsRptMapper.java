package com.everything.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.everything.demo.po.HttpsRpt;

@Mapper
public interface HttpsRptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HttpsRpt record);

    int insertSelective(HttpsRpt record);

    HttpsRpt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HttpsRpt record);

    int updateByPrimaryKey(HttpsRpt record);

	int selectHttpsRptByUuid(String uuid);

	List<HttpsRpt> selectListByLimit(Map<String, Object> map);

	void updateBatchByIds(@Param("ids")List<Long> ids);

	void deleteByDateAndHashValue(Map<String, Object> map);
}