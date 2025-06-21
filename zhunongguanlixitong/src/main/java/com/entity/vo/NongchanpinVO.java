package com.entity.vo;

import com.entity.NongchanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchanpin")
public class NongchanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农产品名称
     */

    @TableField(value = "nongchanpin_name")
    private String nongchanpinName;


    /**
     * 农产品编号
     */

    @TableField(value = "nongchanpin_uuid_number")
    private String nongchanpinUuidNumber;


    /**
     * 农产品照片
     */

    @TableField(value = "nongchanpin_photo")
    private String nongchanpinPhoto;


    /**
     * 产出地
     */

    @TableField(value = "nongchanpin_address")
    private String nongchanpinAddress;


    /**
     * 农产品类型
     */

    @TableField(value = "nongchanpin_types")
    private Integer nongchanpinTypes;


    /**
     * 农产品库存
     */

    @TableField(value = "nongchanpin_kucun_number")
    private Integer nongchanpinKucunNumber;


    /**
     * 采购价
     */

    @TableField(value = "nongchanpin_caigou_jine")
    private Double nongchanpinCaigouJine;


    /**
     * 销售价
     */

    @TableField(value = "nongchanpin_new_jine")
    private Double nongchanpinNewJine;


    /**
     * 所属仓库
     */

    @TableField(value = "cangku_types")
    private Integer cangkuTypes;


    /**
     * 产品介绍
     */

    @TableField(value = "nongchanpin_content")
    private String nongchanpinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "nongchanpin_delete")
    private Integer nongchanpinDelete;


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
	 * 设置：农产品名称
	 */
    public String getNongchanpinName() {
        return nongchanpinName;
    }


    /**
	 * 获取：农产品名称
	 */

    public void setNongchanpinName(String nongchanpinName) {
        this.nongchanpinName = nongchanpinName;
    }
    /**
	 * 设置：农产品编号
	 */
    public String getNongchanpinUuidNumber() {
        return nongchanpinUuidNumber;
    }


    /**
	 * 获取：农产品编号
	 */

    public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
        this.nongchanpinUuidNumber = nongchanpinUuidNumber;
    }
    /**
	 * 设置：农产品照片
	 */
    public String getNongchanpinPhoto() {
        return nongchanpinPhoto;
    }


    /**
	 * 获取：农产品照片
	 */

    public void setNongchanpinPhoto(String nongchanpinPhoto) {
        this.nongchanpinPhoto = nongchanpinPhoto;
    }
    /**
	 * 设置：产出地
	 */
    public String getNongchanpinAddress() {
        return nongchanpinAddress;
    }


    /**
	 * 获取：产出地
	 */

    public void setNongchanpinAddress(String nongchanpinAddress) {
        this.nongchanpinAddress = nongchanpinAddress;
    }
    /**
	 * 设置：农产品类型
	 */
    public Integer getNongchanpinTypes() {
        return nongchanpinTypes;
    }


    /**
	 * 获取：农产品类型
	 */

    public void setNongchanpinTypes(Integer nongchanpinTypes) {
        this.nongchanpinTypes = nongchanpinTypes;
    }
    /**
	 * 设置：农产品库存
	 */
    public Integer getNongchanpinKucunNumber() {
        return nongchanpinKucunNumber;
    }


    /**
	 * 获取：农产品库存
	 */

    public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
        this.nongchanpinKucunNumber = nongchanpinKucunNumber;
    }
    /**
	 * 设置：采购价
	 */
    public Double getNongchanpinCaigouJine() {
        return nongchanpinCaigouJine;
    }


    /**
	 * 获取：采购价
	 */

    public void setNongchanpinCaigouJine(Double nongchanpinCaigouJine) {
        this.nongchanpinCaigouJine = nongchanpinCaigouJine;
    }
    /**
	 * 设置：销售价
	 */
    public Double getNongchanpinNewJine() {
        return nongchanpinNewJine;
    }


    /**
	 * 获取：销售价
	 */

    public void setNongchanpinNewJine(Double nongchanpinNewJine) {
        this.nongchanpinNewJine = nongchanpinNewJine;
    }
    /**
	 * 设置：所属仓库
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }


    /**
	 * 获取：所属仓库
	 */

    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 设置：产品介绍
	 */
    public String getNongchanpinContent() {
        return nongchanpinContent;
    }


    /**
	 * 获取：产品介绍
	 */

    public void setNongchanpinContent(String nongchanpinContent) {
        this.nongchanpinContent = nongchanpinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getNongchanpinDelete() {
        return nongchanpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setNongchanpinDelete(Integer nongchanpinDelete) {
        this.nongchanpinDelete = nongchanpinDelete;
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
