package net.yunzhanyi.common.core.vo;

import cn.hutool.http.HttpStatus;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/5
 * description: TODO
 */
public class TableDataInfo {

    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private int total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    public TableDataInfo(int code, String message)
    {
        this.code = code;
        this.msg = message;
    }

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total)
    {
        this.rows = list;
        this.total = total;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }


    public static TableDataInfo getDataTable(List<?> list, Long total)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.HTTP_OK);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(Math.toIntExact(total));
        return rspData;
    }
}
