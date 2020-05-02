package com.everything.demo.dao;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everything.demo.po.SmsHistory;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class SmsHistoryDAO {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private String getTabIndex(Date gmtSchedule) {
        return DateFormatUtils.format(gmtSchedule, "MMdd");
    }

    public SmsHistory selectByPrimaryKey(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectOne("com.everything.demo.mapper.SmsHistoryMapper.selectByPrimaryKey", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int deleteByPrimaryKey(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.delete("com.everything.demo.mapper.SmsHistoryMapper.deleteByPrimaryKey", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int insert(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.insert("com.everything.demo.mapper.SmsHistoryMapper.insert", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int insertSelective(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.insert("com.everything.demo.mapper.SmsHistoryMapper.insertSelective", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int updateByPrimaryKeySelective(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.update("com.everything.demo.mapper.SmsHistoryMapper.updateByPrimaryKeySelective", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int updateByPrimaryKey(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.update("com.everything.demo.mapper.SmsHistoryMapper.updateByPrimaryKey", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int updateResponseByDestNumberAndUuid(Map<String, Object> map) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                map.put("tabIndex", getTabIndex((Date) map.get("gmtSchedule")));
                return session.update("com.everything.demo.mapper.SmsHistoryMapper.updateResponseByDestNumberAndUuid", map);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int updateResponseById(Map<String, Object> map) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                map.put("tabIndex", getTabIndex((Date) map.get("gmtSchedule")));
                return session.update("com.everything.demo.mapper.SmsHistoryMapper.updateResponseById", map);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public int updateByDestNumberAndUuidSelective(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.update("com.everything.demo.mapper.SmsHistoryMapper.updateByDestNumberAndUuidSelective", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public SmsHistory selectByDestNumberAndUuid(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectOne("com.everything.demo.mapper.SmsHistoryMapper.selectByDestNumberAndUuid", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public List<SmsHistory> selectByDestNumberAndUuidAll(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectList("com.everything.demo.mapper.SmsHistoryMapper.selectByDestNumberAndUuidAll", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public SmsHistory selectByDestMsgId(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectOne("com.everything.demo.mapper.SmsHistoryMapper.selectByDestMsgId", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

	public SmsHistory selectBySrcNumberAndDestNumber(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectOne("com.everything.demo.mapper.SmsHistoryMapper.selectBySrcNumberAndDestNumber", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
	}

	public List<Long> selectBySrcChannelAndStatus(SmsHistory record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            try {
                if (StringUtils.isEmpty(record.getTabIndex())) {
                    record.setTabIndex(getTabIndex(record.getGmtSchedule()));
                }
                return session.selectList("com.everything.demo.mapper.SmsHistoryMapper.selectBySrcChannelAndStatus", record);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
	}
}
