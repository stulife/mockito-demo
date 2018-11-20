package com.mockito.demo.service;

import com.mockito.demo.entity.User;
import com.mockito.demo.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class TestServiceImpl implements  TestService {

    @Override
    public int callStaticMethod(Date date) {
        int month = DateUtils.getMonth(date);
        return month + 3;
    }
    @Override
    public int callPrivateMethod(Date date) {
        int month = getMonth(date);
        return month + 3;
    }


    @Override
    public void callVoid() {
        log.info("call void");
    }
    @Override
    public String callInternalInstance() {
        User user = new User();
        return user.getName();
    }


    /**
     * 当前月份
     *
     * @param date
     * @return
     */
    private int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }





}
