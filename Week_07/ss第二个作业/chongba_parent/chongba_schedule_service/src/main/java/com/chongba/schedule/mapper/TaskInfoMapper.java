package com.chongba.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskInfoMapper{
    
    public Integer getTaskCount();
    public void updateTaskInfo();
}
