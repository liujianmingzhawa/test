package com.everything.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.everything.demo.dao.SmsHistoryDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsHistoryService {
	
    @Autowired
    private SmsHistoryDAO smsHistoryDAO;

    
}
