package com.zts.marathoner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "t_edw_t02_business_date", schema = "edwuser")
public class BusinessDate {

    private String fdate;

    private String fyear;

    private String fmonth;

    private String fisTradeDayFlag;

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    public String getFyear() {
        return fyear;
    }

    public void setFyear(String fyear) {
        this.fyear = fyear;
    }

    public String getFmonth() {
        return fmonth;
    }

    public void setFmonth(String fmonth) {
        this.fmonth = fmonth;
    }

    public String getFisTradeDayFlag() {
        return fisTradeDayFlag;
    }

    public void setFisTradeDayFlag(String fisTradeDayFlag) {
        this.fisTradeDayFlag = fisTradeDayFlag;
    }
}
