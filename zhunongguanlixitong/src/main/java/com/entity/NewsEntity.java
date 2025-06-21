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
 * 农产品经济数据信息
 *
 * @author 
 * @email
 */
@TableName("news")
public class NewsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NewsEntity() {

	}

	public NewsEntity(T t) {
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
     * 农产品经济数据标题
     */
    @ColumnInfo(comment="农产品经济数据标题",type="varchar(200)")
    @TableField(value = "news_name")

    private String newsName;


    /**
     * 农产品经济数据封面
     */
    @ColumnInfo(comment="农产品经济数据封面",type="varchar(200)")
    @TableField(value = "news_photo")

    private String newsPhoto;


    /**
     * 农产品经济数据类型
     */
    @ColumnInfo(comment="农产品经济数据类型",type="int(11)")
    @TableField(value = "news_types")

    private Integer newsTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 农产品经济数据内容
     */
    @ColumnInfo(comment="农产品经济数据内容",type="text")
    @TableField(value = "news_content")

    private String newsContent;


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
	 * 获取：农产品经济数据标题
	 */
    public String getNewsName() {
        return newsName;
    }
    /**
	 * 设置：农产品经济数据标题
	 */

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }
    /**
	 * 获取：农产品经济数据封面
	 */
    public String getNewsPhoto() {
        return newsPhoto;
    }
    /**
	 * 设置：农产品经济数据封面
	 */

    public void setNewsPhoto(String newsPhoto) {
        this.newsPhoto = newsPhoto;
    }
    /**
	 * 获取：农产品经济数据类型
	 */
    public Integer getNewsTypes() {
        return newsTypes;
    }
    /**
	 * 设置：农产品经济数据类型
	 */

    public void setNewsTypes(Integer newsTypes) {
        this.newsTypes = newsTypes;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：农产品经济数据内容
	 */
    public String getNewsContent() {
        return newsContent;
    }
    /**
	 * 设置：农产品经济数据内容
	 */

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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
        return "News{" +
            ", id=" + id +
            ", newsName=" + newsName +
            ", newsPhoto=" + newsPhoto +
            ", newsTypes=" + newsTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", newsContent=" + newsContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
