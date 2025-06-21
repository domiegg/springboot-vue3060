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
 * 贫困户
 *
 * @author 
 * @email
 */
@TableName("pinkunhu")
public class PinkunhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PinkunhuEntity() {

	}

	public PinkunhuEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 工作人员
     */
    @ColumnInfo(comment="工作人员",type="int(11)")
    @TableField(value = "gongzuorenyuan_id")

    private Integer gongzuorenyuanId;


    /**
     * 姓名
     */
    @ColumnInfo(comment="姓名",type="varchar(200)")
    @TableField(value = "pinkunhu_name")

    private String pinkunhuName;


    /**
     * 手机号
     */
    @ColumnInfo(comment="手机号",type="varchar(200)")
    @TableField(value = "pinkunhu_phone")

    private String pinkunhuPhone;


    /**
     * 身份证号
     */
    @ColumnInfo(comment="身份证号",type="varchar(200)")
    @TableField(value = "pinkunhu_address")

    private String pinkunhuAddress;


    /**
     * 家庭住址
     */
    @ColumnInfo(comment="家庭住址",type="varchar(200)")
    @TableField(value = "pinkunhu_id_number")

    private String pinkunhuIdNumber;


    /**
     * 贫困户照片
     */
    @ColumnInfo(comment="贫困户照片",type="varchar(200)")
    @TableField(value = "pinkunhu_photo")

    private String pinkunhuPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "pinkunhu_email")

    private String pinkunhuEmail;


    /**
     * 家庭成员
     */
    @ColumnInfo(comment="家庭成员",type="text")
    @TableField(value = "pinkunhu_chengyuan_text")

    private String pinkunhuChengyuanText;


    /**
     * 年收入
     */
    @ColumnInfo(comment="年收入",type="decimal(10,2)")
    @TableField(value = "yonghu_nianshouru")

    private Double yonghuNianshouru;


    /**
     * 是否有额外收入
     */
    @ColumnInfo(comment="是否有额外收入",type="int(11)")
    @TableField(value = "ewaishouru_types")

    private Integer ewaishouruTypes;


    /**
     * 是否存在运输困难
     */
    @ColumnInfo(comment="是否存在运输困难",type="int(11)")
    @TableField(value = "yunshukunnan_types")

    private Integer yunshukunnanTypes;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
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
	 * 获取：姓名
	 */
    public String getPinkunhuName() {
        return pinkunhuName;
    }
    /**
	 * 设置：姓名
	 */

    public void setPinkunhuName(String pinkunhuName) {
        this.pinkunhuName = pinkunhuName;
    }
    /**
	 * 获取：手机号
	 */
    public String getPinkunhuPhone() {
        return pinkunhuPhone;
    }
    /**
	 * 设置：手机号
	 */

    public void setPinkunhuPhone(String pinkunhuPhone) {
        this.pinkunhuPhone = pinkunhuPhone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getPinkunhuAddress() {
        return pinkunhuAddress;
    }
    /**
	 * 设置：身份证号
	 */

    public void setPinkunhuAddress(String pinkunhuAddress) {
        this.pinkunhuAddress = pinkunhuAddress;
    }
    /**
	 * 获取：家庭住址
	 */
    public String getPinkunhuIdNumber() {
        return pinkunhuIdNumber;
    }
    /**
	 * 设置：家庭住址
	 */

    public void setPinkunhuIdNumber(String pinkunhuIdNumber) {
        this.pinkunhuIdNumber = pinkunhuIdNumber;
    }
    /**
	 * 获取：贫困户照片
	 */
    public String getPinkunhuPhoto() {
        return pinkunhuPhoto;
    }
    /**
	 * 设置：贫困户照片
	 */

    public void setPinkunhuPhoto(String pinkunhuPhoto) {
        this.pinkunhuPhoto = pinkunhuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getPinkunhuEmail() {
        return pinkunhuEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setPinkunhuEmail(String pinkunhuEmail) {
        this.pinkunhuEmail = pinkunhuEmail;
    }
    /**
	 * 获取：家庭成员
	 */
    public String getPinkunhuChengyuanText() {
        return pinkunhuChengyuanText;
    }
    /**
	 * 设置：家庭成员
	 */

    public void setPinkunhuChengyuanText(String pinkunhuChengyuanText) {
        this.pinkunhuChengyuanText = pinkunhuChengyuanText;
    }
    /**
	 * 获取：年收入
	 */
    public Double getYonghuNianshouru() {
        return yonghuNianshouru;
    }
    /**
	 * 设置：年收入
	 */

    public void setYonghuNianshouru(Double yonghuNianshouru) {
        this.yonghuNianshouru = yonghuNianshouru;
    }
    /**
	 * 获取：是否有额外收入
	 */
    public Integer getEwaishouruTypes() {
        return ewaishouruTypes;
    }
    /**
	 * 设置：是否有额外收入
	 */

    public void setEwaishouruTypes(Integer ewaishouruTypes) {
        this.ewaishouruTypes = ewaishouruTypes;
    }
    /**
	 * 获取：是否存在运输困难
	 */
    public Integer getYunshukunnanTypes() {
        return yunshukunnanTypes;
    }
    /**
	 * 设置：是否存在运输困难
	 */

    public void setYunshukunnanTypes(Integer yunshukunnanTypes) {
        this.yunshukunnanTypes = yunshukunnanTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Pinkunhu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongzuorenyuanId=" + gongzuorenyuanId +
            ", pinkunhuName=" + pinkunhuName +
            ", pinkunhuPhone=" + pinkunhuPhone +
            ", pinkunhuAddress=" + pinkunhuAddress +
            ", pinkunhuIdNumber=" + pinkunhuIdNumber +
            ", pinkunhuPhoto=" + pinkunhuPhoto +
            ", sexTypes=" + sexTypes +
            ", pinkunhuEmail=" + pinkunhuEmail +
            ", pinkunhuChengyuanText=" + pinkunhuChengyuanText +
            ", yonghuNianshouru=" + yonghuNianshouru +
            ", ewaishouruTypes=" + ewaishouruTypes +
            ", yunshukunnanTypes=" + yunshukunnanTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
