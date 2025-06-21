package com.entity.model;

import com.entity.NongchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongchanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农产品名称
     */
    private String nongchanpinName;


    /**
     * 农产品编号
     */
    private String nongchanpinUuidNumber;


    /**
     * 农产品照片
     */
    private String nongchanpinPhoto;


    /**
     * 产出地
     */
    private String nongchanpinAddress;


    /**
     * 农产品类型
     */
    private Integer nongchanpinTypes;


    /**
     * 农产品库存
     */
    private Integer nongchanpinKucunNumber;


    /**
     * 采购价
     */
    private Double nongchanpinCaigouJine;


    /**
     * 销售价
     */
    private Double nongchanpinNewJine;


    /**
     * 所属仓库
     */
    private Integer cangkuTypes;


    /**
     * 产品介绍
     */
    private String nongchanpinContent;


    /**
     * 逻辑删除
     */
    private Integer nongchanpinDelete;


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
