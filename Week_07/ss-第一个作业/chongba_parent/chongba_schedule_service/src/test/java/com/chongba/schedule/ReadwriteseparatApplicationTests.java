package com.chongba.schedule;

import com.chongba.schedule.inf.TaskService;
import com.chongba.schedule.pojo.TaskInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReadwriteseparatApplicationTests {

    @Autowired
    TaskService taskService;

    @Test
    public void  test(){
      Integer size = taskService.selectAll();
      System.out.println(size);
    }

    @Test
    public void  testMaster(){
            taskService.updateTaskInfo();
    }

}
