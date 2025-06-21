package com.entity.vo;

import com.entity.PinkunhuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 贫困户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pinkunhu")
public class PinkunhuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 工作人员
     */

    @TableField(value = "gongzuorenyuan_id")
    private Integer gongzuorenyuanId;


    /**
     * 姓名
     */

    @TableField(value = "pinkunhu_name")
    private String pinkunhuName;


    /**
     * 手机号
     */

    @TableField(value = "pinkunhu_phone")
    private String pinkunhuPhone;


    /**
     * 身份证号
     */

    @TableField(value = "pinkunhu_address")
    private String pinkunhuAddress;


    /**
     * 家庭住址
     */

    @TableField(value = "pinkunhu_id_number")
    private String pinkunhuIdNumber;


    /**
     * 贫困户照片
     */

    @TableField(value = "pinkunhu_photo")
    private String pinkunhuPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "pinkunhu_email")
    private String pinkunhuEmail;


    /**
     * 家庭成员
     */

    @TableField(value = "pinkunhu_chengyuan_text")
    private String pinkunhuChengyuanText;


    /**
     * 年收入
     */

    @TableField(value = "yonghu_nianshouru")
    private Double yonghuNianshouru;


    /**
     * 是否有额外收入
     */

    @TableField(value = "ewaishouru_types")
    private Integer ewaishouruTypes;


    /**
     * 是否存在运输困难
     */

    @TableField(value = "yunshukunnan_types")
    private Integer yunshukunnanTypes;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
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
	 * 设置：姓名
	 */
    public String getPinkunhuName() {
        return pinkunhuName;
    }


    /**
	 * 获取：姓名
	 */

    public void setPinkunhuName(String pinkunhuName) {
        this.pinkunhuName = pinkunhuName;
    }
    /**
	 * 设置：手机号
	 */
    public String getPinkunhuPhone() {
        return pinkunhuPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setPinkunhuPhone(String pinkunhuPhone) {
        this.pinkunhuPhone = pinkunhuPhone;
    }
    /**
	 * 设置：身份证号
	 */
    public String getPinkunhuAddress() {
        return pinkunhuAddress;
    }


    /**
	 * 获取：身份证号
	 */

    public void setPinkunhuAddress(String pinkunhuAddress) {
        this.pinkunhuAddress = pinkunhuAddress;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getPinkunhuIdNumber() {
        return pinkunhuIdNumber;
    }


    /**
	 * 获取：家庭住址
	 */

    public void setPinkunhuIdNumber(String pinkunhuIdNumber) {
        this.pinkunhuIdNumber = pinkunhuIdNumber;
    }
    /**
	 * 设置：贫困户照片
	 */
    public String getPinkunhuPhoto() {
        return pinkunhuPhoto;
    }


    /**
	 * 获取：贫困户照片
	 */

    public void setPinkunhuPhoto(String pinkunhuPhoto) {
        this.pinkunhuPhoto = pinkunhuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getPinkunhuEmail() {
        return pinkunhuEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setPinkunhuEmail(String pinkunhuEmail) {
        this.pinkunhuEmail = pinkunhuEmail;
    }
    /**
	 * 设置：家庭成员
	 */
    public String getPinkunhuChengyuanText() {
        return pinkunhuChengyuanText;
    }


    /**
	 * 获取：家庭成员
	 */

    public void setPinkunhuChengyuanText(String pinkunhuChengyuanText) {
        this.pinkunhuChengyuanText = pinkunhuChengyuanText;
    }
    /**
	 * 设置：年收入
	 */
    public Double getYonghuNianshouru() {
        return yonghuNianshouru;
    }


    /**
	 * 获取：年收入
	 */

    public void setYonghuNianshouru(Double yonghuNianshouru) {
        this.yonghuNianshouru = yonghuNianshouru;
    }
    /**
	 * 设置：是否有额外收入
	 */
    public Integer getEwaishouruTypes() {
        return ewaishouruTypes;
    }


    /**
	 * 获取：是否有额外收入
	 */

    public void setEwaishouruTypes(Integer ewaishouruTypes) {
        this.ewaishouruTypes = ewaishouruTypes;
    }
    /**
	 * 设置：是否存在运输困难
	 */
    public Integer getYunshukunnanTypes() {
        return yunshukunnanTypes;
    }


    /**
	 * 获取：是否存在运输困难
	 */

    public void setYunshukunnanTypes(Integer yunshukunnanTypes) {
        this.yunshukunnanTypes = yunshukunnanTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
