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
 * 农产品
 *
 * @author 
 * @email
 */
@TableName("nongchanpin")
public class NongchanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchanpinEntity() {

	}

	public NongchanpinEntity(T t) {
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
     * 
     */
    @ColumnInfo(comment="",type="int(11)")
    @TableField(value = "pinkunhu_id")

    private Integer pinkunhuId;


    /**
     * 农产品名称
     */
    @ColumnInfo(comment="农产品名称",type="varchar(200)")
    @TableField(value = "nongchanpin_name")

    private String nongchanpinName;


    /**
     * 农产品编号
     */
    @ColumnInfo(comment="农产品编号",type="varchar(200)")
    @TableField(value = "nongchanpin_uuid_number")

    private String nongchanpinUuidNumber;


    /**
     * 农产品照片
     */
    @ColumnInfo(comment="农产品照片",type="varchar(200)")
    @TableField(value = "nongchanpin_photo")

    private String nongchanpinPhoto;


    /**
     * 产出地
     */
    @ColumnInfo(comment="产出地",type="varchar(200)")
    @TableField(value = "nongchanpin_address")

    private String nongchanpinAddress;


    /**
     * 农产品类型
     */
    @ColumnInfo(comment="农产品类型",type="int(11)")
    @TableField(value = "nongchanpin_types")

    private Integer nongchanpinTypes;


    /**
     * 农产品库存
     */
    @ColumnInfo(comment="农产品库存",type="int(11)")
    @TableField(value = "nongchanpin_kucun_number")

    private Integer nongchanpinKucunNumber;


    /**
     * 采购价
     */
    @ColumnInfo(comment="采购价",type="decimal(10,2)")
    @TableField(value = "nongchanpin_caigou_jine")

    private Double nongchanpinCaigouJine;


    /**
     * 销售价
     */
    @ColumnInfo(comment="销售价",type="decimal(10,2)")
    @TableField(value = "nongchanpin_new_jine")

    private Double nongchanpinNewJine;


    /**
     * 所属仓库
     */
    @ColumnInfo(comment="所属仓库",type="int(11)")
    @TableField(value = "cangku_types")

    private Integer cangkuTypes;


    /**
     * 产品介绍
     */
    @ColumnInfo(comment="产品介绍",type="text")
    @TableField(value = "nongchanpin_content")

    private String nongchanpinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "nongchanpin_delete")

    private Integer nongchanpinDelete;


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
	 * 获取：
	 */
    public Integer getPinkunhuId() {
        return pinkunhuId;
    }
    /**
	 * 设置：
	 */

    public void setPinkunhuId(Integer pinkunhuId) {
        this.pinkunhuId = pinkunhuId;
    }
    /**
	 * 获取：农产品名称
	 */
    public String getNongchanpinName() {
        return nongchanpinName;
    }
    /**
	 * 设置：农产品名称
	 */

    public void setNongchanpinName(String nongchanpinName) {
        this.nongchanpinName = nongchanpinName;
    }
    /**
	 * 获取：农产品编号
	 */
    public String getNongchanpinUuidNumber() {
        return nongchanpinUuidNumber;
    }
    /**
	 * 设置：农产品编号
	 */

    public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
        this.nongchanpinUuidNumber = nongchanpinUuidNumber;
    }
    /**
	 * 获取：农产品照片
	 */
    public String getNongchanpinPhoto() {
        return nongchanpinPhoto;
    }
    /**
	 * 设置：农产品照片
	 */

    public void setNongchanpinPhoto(String nongchanpinPhoto) {
        this.nongchanpinPhoto = nongchanpinPhoto;
    }
    /**
	 * 获取：产出地
	 */
    public String getNongchanpinAddress() {
        return nongchanpinAddress;
    }
    /**
	 * 设置：产出地
	 */

    public void setNongchanpinAddress(String nongchanpinAddress) {
        this.nongchanpinAddress = nongchanpinAddress;
    }
    /**
	 * 获取：农产品类型
	 */
    public Integer getNongchanpinTypes() {
        return nongchanpinTypes;
    }
    /**
	 * 设置：农产品类型
	 */

    public void setNongchanpinTypes(Integer nongchanpinTypes) {
        this.nongchanpinTypes = nongchanpinTypes;
    }
    /**
	 * 获取：农产品库存
	 */
    public Integer getNongchanpinKucunNumber() {
        return nongchanpinKucunNumber;
    }
    /**
	 * 设置：农产品库存
	 */

    public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
        this.nongchanpinKucunNumber = nongchanpinKucunNumber;
    }
    /**
	 * 获取：采购价
	 */
    public Double getNongchanpinCaigouJine() {
        return nongchanpinCaigouJine;
    }
    /**
	 * 设置：采购价
	 */

    public void setNongchanpinCaigouJine(Double nongchanpinCaigouJine) {
        this.nongchanpinCaigouJine = nongchanpinCaigouJine;
    }
    /**
	 * 获取：销售价
	 */
    public Double getNongchanpinNewJine() {
        return nongchanpinNewJine;
    }
    /**
	 * 设置：销售价
	 */

    public void setNongchanpinNewJine(Double nongchanpinNewJine) {
        this.nongchanpinNewJine = nongchanpinNewJine;
    }
    /**
	 * 获取：所属仓库
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }
    /**
	 * 设置：所属仓库
	 */

    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 获取：产品介绍
	 */
    public String getNongchanpinContent() {
        return nongchanpinContent;
    }
    /**
	 * 设置：产品介绍
	 */

    public void setNongchanpinContent(String nongchanpinContent) {
        this.nongchanpinContent = nongchanpinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getNongchanpinDelete() {
        return nongchanpinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setNongchanpinDelete(Integer nongchanpinDelete) {
        this.nongchanpinDelete = nongchanpinDelete;
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
        return "Nongchanpin{" +
            ", id=" + id +
            ", pinkunhuId=" + pinkunhuId +
            ", nongchanpinName=" + nongchanpinName +
            ", nongchanpinUuidNumber=" + nongchanpinUuidNumber +
            ", nongchanpinPhoto=" + nongchanpinPhoto +
            ", nongchanpinAddress=" + nongchanpinAddress +
            ", nongchanpinTypes=" + nongchanpinTypes +
            ", nongchanpinKucunNumber=" + nongchanpinKucunNumber +
            ", nongchanpinCaigouJine=" + nongchanpinCaigouJine +
            ", nongchanpinNewJine=" + nongchanpinNewJine +
            ", cangkuTypes=" + cangkuTypes +
            ", nongchanpinContent=" + nongchanpinContent +
            ", nongchanpinDelete=" + nongchanpinDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
