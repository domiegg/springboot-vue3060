package com.entity.vo;

import com.entity.NongchanpinXiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品售卖
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchanpin_xiaoshou")
public class NongchanpinXiaoshouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 销售编号
     */

    @TableField(value = "nongchanpin_xiaoshou_uuid_number")
    private String nongchanpinXiaoshouUuidNumber;


    /**
     * 工作人员
     */

    @TableField(value = "gongzuorenyuan_id")
    private Integer gongzuorenyuanId;


    /**
     * 农产品
     */

    @TableField(value = "nongchanpin_id")
    private Integer nongchanpinId;


    /**
     * 销售数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 销售总额
     */

    @TableField(value = "nongchanpin_xiaoshou_xiaoshouzonge")
    private Double nongchanpinXiaoshouXiaoshouzonge;


    /**
     * 本次利润
     */

    @TableField(value = "nongchanpin_xiaoshou_lirun")
    private Double nongchanpinXiaoshouLirun;


    /**
     * 销售类型
     */

    @TableField(value = "nongchanpin_xiaoshou_types")
    private Integer nongchanpinXiaoshouTypes;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiaoshou_time")
    private Date xiaoshouTime;


    /**
     * 销售备注
     */

    @TableField(value = "nongchanpin_xiaoshou_content")
    private String nongchanpinXiaoshouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：销售编号
	 */
    public String getNongchanpinXiaoshouUuidNumber() {
        return nongchanpinXiaoshouUuidNumber;
    }


    /**
	 * 获取：销售编号
	 */

    public void setNongchanpinXiaoshouUuidNumber(String nongchanpinXiaoshouUuidNumber) {
        this.nongchanpinXiaoshouUuidNumber = nongchanpinXiaoshouUuidNumber;
    }
    /**
	 * 设置：工作人员
	 */
    public Integer getGongzuorenyuanId() {
        return gongzuorenyuanId;
    }


    /**
	 * 获取：工作人员
	 */

    public void setGongzuorenyuanId(Integer gongzuorenyuanId) {
        this.gongzuorenyuanId = gongzuorenyuanId;
    }
    /**
	 * 设置：农产品
	 */
    public Integer getNongchanpinId() {
        return nongchanpinId;
    }


    /**
	 * 获取：农产品
	 */

    public void setNongchanpinId(Integer nongchanpinId) {
        this.nongchanpinId = nongchanpinId;
    }
    /**
	 * 设置：销售数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：销售数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：销售总额
	 */
    public Double getNongchanpinXiaoshouXiaoshouzonge() {
        return nongchanpinXiaoshouXiaoshouzonge;
    }


    /**
	 * 获取：销售总额
	 */

    public void setNongchanpinXiaoshouXiaoshouzonge(Double nongchanpinXiaoshouXiaoshouzonge) {
        this.nongchanpinXiaoshouXiaoshouzonge = nongchanpinXiaoshouXiaoshouzonge;
    }
    /**
	 * 设置：本次利润
	 */
    public Double getNongchanpinXiaoshouLirun() {
        return nongchanpinXiaoshouLirun;
    }


    /**
	 * 获取：本次利润
	 */

    public void setNongchanpinXiaoshouLirun(Double nongchanpinXiaoshouLirun) {
        this.nongchanpinXiaoshouLirun = nongchanpinXiaoshouLirun;
    }
    /**
	 * 设置：销售类型
	 */
    public Integer getNongchanpinXiaoshouTypes() {
        return nongchanpinXiaoshouTypes;
    }


    /**
	 * 获取：销售类型
	 */

    public void setNongchanpinXiaoshouTypes(Integer nongchanpinXiaoshouTypes) {
        this.nongchanpinXiaoshouTypes = nongchanpinXiaoshouTypes;
    }
    /**
	 * 设置：销售时间
	 */
    public Date getXiaoshouTime() {
        return xiaoshouTime;
    }


    /**
	 * 获取：销售时间
	 */

    public void setXiaoshouTime(Date xiaoshouTime) {
        this.xiaoshouTime = xiaoshouTime;
    }
    /**
	 * 设置：销售备注
	 */
    public String getNongchanpinXiaoshouContent() {
        return nongchanpinXiaoshouContent;
    }


    /**
	 * 获取：销售备注
	 */

    public void setNongchanpinXiaoshouContent(String nongchanpinXiaoshouContent) {
        this.nongchanpinXiaoshouContent = nongchanpinXiaoshouContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
