package com.chongba.schedule.service;

import com.chongba.schedule.config.Master;
import com.chongba.schedule.config.ReadOnly;
import com.chongba.schedule.inf.TaskService;
import com.chongba.schedule.mapper.TaskInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskInfoMapper infoMapper;

    @Override
    @ReadOnly
    public Integer selectAll() {
        return infoMapper.getTaskCount();
    }

    @Override
    @Master
    public void updateTaskInfo() {
        infoMapper.updateTaskInfo();
    }
}
