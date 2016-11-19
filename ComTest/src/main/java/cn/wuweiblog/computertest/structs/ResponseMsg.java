package cn.wuweiblog.computertest.structs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jervain on 2016-11-17.
 */
public class ResponseMsg {

    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List data = new ArrayList();
    private String error;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
