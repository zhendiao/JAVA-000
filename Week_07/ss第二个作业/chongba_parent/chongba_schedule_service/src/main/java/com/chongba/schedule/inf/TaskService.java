package com.chongba.schedule.inf;

import com.chongba.entity.Task;
import com.chongba.exception.ScheduleSystemException;
import com.chongba.exception.TaskNotExistException;
import com.chongba.schedule.config.Master;
import com.chongba.schedule.config.ReadOnly;
import com.chongba.schedule.pojo.TaskInfoEntity;

import java.util.List;


public interface TaskService {
    @ReadOnly
    Integer selectAll();

    @Master
    void  updateTaskInfo();
    
}
