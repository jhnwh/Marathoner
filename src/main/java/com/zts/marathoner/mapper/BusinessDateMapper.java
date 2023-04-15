package com.zts.marathoner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zts.marathoner.entity.BusinessDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessDateMapper extends BaseMapper<BusinessDate> {

    @Select("SELECT * FROM EDWUSER.T_EDW_T02_BUSINESS_DATE WHERE FIS_TRADE_DAY_FLAG = '10002' AND FDATE BETWEEN #{startDate} AND #{endDate} ORDER BY FDATE")
    List<BusinessDate> queryBusinessDateByStartAndEnd(String startDate, String endDate);
}
