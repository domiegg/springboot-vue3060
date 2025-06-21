package com.entity.model;

import com.entity.NongchanpinXiaoshouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品售卖
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongchanpinXiaoshouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 销售编号
     */
    private String nongchanpinXiaoshouUuidNumber;


    /**
     * 工作人员
     */
    private Integer gongzuorenyuanId;


    /**
     * 农产品
     */
    private Integer nongchanpinId;


    /**
     * 销售数量
     */
    private Integer buyNumber;


    /**
     * 销售总额
     */
    private Double nongchanpinXiaoshouXiaoshouzonge;


    /**
     * 本次利润
     */
    private Double nongchanpinXiaoshouLirun;


    /**
     * 销售类型
     */
    private Integer nongchanpinXiaoshouTypes;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiaoshouTime;


    /**
     * 销售备注
     */
    private String nongchanpinXiaoshouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：销售编号
	 */
    public String getNongchanpinXiaoshouUuidNumber() {
        return nongchanpinXiaoshouUuidNumber;
    }


    /**
	 * 设置：销售编号
	 */
    public void setNongchanpinXiaoshouUuidNumber(String nongchanpinXiaoshouUuidNumber) {
        this.nongchanpinXiaoshouUuidNumber = nongchanpinXiaoshouUuidNumber;
    }
    /**
	 * 获取：工作人员
	 */
    public Integer getGongzuorenyuanId() {
        return gongzuorenyuanId;
    }


    /**
	 * 设置：工作人员
	 */
    public void setGongzuorenyuanId(Integer gongzuorenyuanId) {
        this.gongzuorenyuanId = gongzuorenyuanId;
    }
    /**
	 * 获取：农产品
	 */
    public Integer getNongchanpinId() {
        return nongchanpinId;
    }


    /**
	 * 设置：农产品
	 */
    public void setNongchanpinId(Integer nongchanpinId) {
        this.nongchanpinId = nongchanpinId;
    }
    /**
	 * 获取：销售数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：销售数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：销售总额
	 */
    public Double getNongchanpinXiaoshouXiaoshouzonge() {
        return nongchanpinXiaoshouXiaoshouzonge;
    }


    /**
	 * 设置：销售总额
	 */
    public void setNongchanpinXiaoshouXiaoshouzonge(Double nongchanpinXiaoshouXiaoshouzonge) {
        this.nongchanpinXiaoshouXiaoshouzonge = nongchanpinXiaoshouXiaoshouzonge;
    }
    /**
	 * 获取：本次利润
	 */
    public Double getNongchanpinXiaoshouLirun() {
        return nongchanpinXiaoshouLirun;
    }


    /**
	 * 设置：本次利润
	 */
    public void setNongchanpinXiaoshouLirun(Double nongchanpinXiaoshouLirun) {
        this.nongchanpinXiaoshouLirun = nongchanpinXiaoshouLirun;
    }
    /**
	 * 获取：销售类型
	 */
    public Integer getNongchanpinXiaoshouTypes() {
        return nongchanpinXiaoshouTypes;
    }


    /**
	 * 设置：销售类型
	 */
    public void setNongchanpinXiaoshouTypes(Integer nongchanpinXiaoshouTypes) {
        this.nongchanpinXiaoshouTypes = nongchanpinXiaoshouTypes;
    }
    /**
	 * 获取：销售时间
	 */
    public Date getXiaoshouTime() {
        return xiaoshouTime;
    }


    /**
	 * 设置：销售时间
	 */
    public void setXiaoshouTime(Date xiaoshouTime) {
        this.xiaoshouTime = xiaoshouTime;
    }
    /**
	 * 获取：销售备注
	 */
    public String getNongchanpinXiaoshouContent() {
        return nongchanpinXiaoshouContent;
    }


    /**
	 * 设置：销售备注
	 */
    public void setNongchanpinXiaoshouContent(String nongchanpinXiaoshouContent) {
        this.nongchanpinXiaoshouContent = nongchanpinXiaoshouContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
