package com.everything.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.everything.demo.po.BlackList;
import java.util.List;
import java.util.Map;

@Mapper
public interface BlackListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlackList record);

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackList record);

    int updateByPrimaryKey(BlackList record);

    Long selectByCount(Map<String, Object> map);

    List<BlackList> selectByPage(Map<String, Object> map);

	long selectCountByBlackNumber(String blackNumber);

	void batchInsertBlackList(BlackList record);

	List<String> selectAllBlackNumber();
}