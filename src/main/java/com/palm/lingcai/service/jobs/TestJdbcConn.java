package com.palm.lingcai.service.jobs;

import com.palm.lingcai.service.futian.FutianUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by nzhmac on 16/10/11.
 */
public class TestJdbcConn {

    @Autowired
    FutianUserInfoService futianUserInfoService;

    public void initTestJdbc(){
        List<Map<String, Object>> list = futianUserInfoService.adminList();
        System.out.println("  #########  列表数量 #######   " + list.size());
    }
}
