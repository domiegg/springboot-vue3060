package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 农产品售卖
 *
 * @author 
 * @email
 */
@TableName("nongchanpin_xiaoshou")
public class NongchanpinXiaoshouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchanpinXiaoshouEntity() {

	}

	public NongchanpinXiaoshouEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 销售编号
     */
    @ColumnInfo(comment="销售编号",type="varchar(200)")
    @TableField(value = "nongchanpin_xiaoshou_uuid_number")

    private String nongchanpinXiaoshouUuidNumber;


    /**
     * 工作人员
     */
    @ColumnInfo(comment="工作人员",type="int(11)")
    @TableField(value = "gongzuorenyuan_id")

    private Integer gongzuorenyuanId;


    /**
     * 农产品
     */
    @ColumnInfo(comment="农产品",type="int(11)")
    @TableField(value = "nongchanpin_id")

    private Integer nongchanpinId;


    /**
     * 销售数量
     */
    @ColumnInfo(comment="销售数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 销售总额
     */
    @ColumnInfo(comment="销售总额",type="decimal(10,2)")
    @TableField(value = "nongchanpin_xiaoshou_xiaoshouzonge")

    private Double nongchanpinXiaoshouXiaoshouzonge;


    /**
     * 本次利润
     */
    @ColumnInfo(comment="本次利润",type="decimal(10,2)")
    @TableField(value = "nongchanpin_xiaoshou_lirun")

    private Double nongchanpinXiaoshouLirun;


    /**
     * 销售类型
     */
    @ColumnInfo(comment="销售类型",type="int(11)")
    @TableField(value = "nongchanpin_xiaoshou_types")

    private Integer nongchanpinXiaoshouTypes;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="销售时间",type="timestamp")
    @TableField(value = "xiaoshou_time")

    private Date xiaoshouTime;


    /**
     * 销售备注
     */
    @ColumnInfo(comment="销售备注",type="text")
    @TableField(value = "nongchanpin_xiaoshou_content")

    private String nongchanpinXiaoshouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "NongchanpinXiaoshou{" +
            ", id=" + id +
            ", nongchanpinXiaoshouUuidNumber=" + nongchanpinXiaoshouUuidNumber +
            ", gongzuorenyuanId=" + gongzuorenyuanId +
            ", nongchanpinId=" + nongchanpinId +
            ", buyNumber=" + buyNumber +
            ", nongchanpinXiaoshouXiaoshouzonge=" + nongchanpinXiaoshouXiaoshouzonge +
            ", nongchanpinXiaoshouLirun=" + nongchanpinXiaoshouLirun +
            ", nongchanpinXiaoshouTypes=" + nongchanpinXiaoshouTypes +
            ", xiaoshouTime=" + DateUtil.convertString(xiaoshouTime,"yyyy-MM-dd") +
            ", nongchanpinXiaoshouContent=" + nongchanpinXiaoshouContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
