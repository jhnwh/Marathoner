package com.zts.marathoner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zts.marathoner.entity.BusinessDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessDateMapper extends BaseMapper<BusinessDate> {

    @Select("select * from edwuser.t_edw_t02_business_date where fis_trade_day_flag = '10002' and fdate between #{startDate} and #{endDate} order by fdate")
    List<BusinessDate> queryBusinessDateByStartAndEnd(String startDate, String endDate);
}
