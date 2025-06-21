package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PinkunhuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 贫困户
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("pinkunhu")
public class PinkunhuView extends PinkunhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 是否有额外收入的值
	*/
	@ColumnInfo(comment="是否有额外收入的字典表值",type="varchar(200)")
	private String ewaishouruValue;
	/**
	* 是否存在运输困难的值
	*/
	@ColumnInfo(comment="是否存在运输困难的字典表值",type="varchar(200)")
	private String yunshukunnanValue;

	//级联表 工作人员
		/**
		* 工作人员姓名
		*/

		@ColumnInfo(comment="工作人员姓名",type="varchar(200)")
		private String gongzuorenyuanName;
		/**
		* 工作人员手机号
		*/

		@ColumnInfo(comment="工作人员手机号",type="varchar(200)")
		private String gongzuorenyuanPhone;
		/**
		* 工作人员身份证号
		*/

		@ColumnInfo(comment="工作人员身份证号",type="varchar(200)")
		private String gongzuorenyuanIdNumber;
		/**
		* 工作人员头像
		*/

		@ColumnInfo(comment="工作人员头像",type="varchar(200)")
		private String gongzuorenyuanPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String gongzuorenyuanEmail;

	//重复字段


	public PinkunhuView() {

	}

	public PinkunhuView(PinkunhuEntity pinkunhuEntity) {
		try {
			BeanUtils.copyProperties(this, pinkunhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 是否有额外收入的值
	*/
	public String getEwaishouruValue() {
		return ewaishouruValue;
	}
	/**
	* 设置： 是否有额外收入的值
	*/
	public void setEwaishouruValue(String ewaishouruValue) {
		this.ewaishouruValue = ewaishouruValue;
	}
	//当前表的
	/**
	* 获取： 是否存在运输困难的值
	*/
	public String getYunshukunnanValue() {
		return yunshukunnanValue;
	}
	/**
	* 设置： 是否存在运输困难的值
	*/
	public void setYunshukunnanValue(String yunshukunnanValue) {
		this.yunshukunnanValue = yunshukunnanValue;
	}


	//级联表的get和set 工作人员

		/**
		* 获取： 工作人员姓名
		*/
		public String getGongzuorenyuanName() {
			return gongzuorenyuanName;
		}
		/**
		* 设置： 工作人员姓名
		*/
		public void setGongzuorenyuanName(String gongzuorenyuanName) {
			this.gongzuorenyuanName = gongzuorenyuanName;
		}

		/**
		* 获取： 工作人员手机号
		*/
		public String getGongzuorenyuanPhone() {
			return gongzuorenyuanPhone;
		}
		/**
		* 设置： 工作人员手机号
		*/
		public void setGongzuorenyuanPhone(String gongzuorenyuanPhone) {
			this.gongzuorenyuanPhone = gongzuorenyuanPhone;
		}

		/**
		* 获取： 工作人员身份证号
		*/
		public String getGongzuorenyuanIdNumber() {
			return gongzuorenyuanIdNumber;
		}
		/**
		* 设置： 工作人员身份证号
		*/
		public void setGongzuorenyuanIdNumber(String gongzuorenyuanIdNumber) {
			this.gongzuorenyuanIdNumber = gongzuorenyuanIdNumber;
		}

		/**
		* 获取： 工作人员头像
		*/
		public String getGongzuorenyuanPhoto() {
			return gongzuorenyuanPhoto;
		}
		/**
		* 设置： 工作人员头像
		*/
		public void setGongzuorenyuanPhoto(String gongzuorenyuanPhoto) {
			this.gongzuorenyuanPhoto = gongzuorenyuanPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getGongzuorenyuanEmail() {
			return gongzuorenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setGongzuorenyuanEmail(String gongzuorenyuanEmail) {
			this.gongzuorenyuanEmail = gongzuorenyuanEmail;
		}

	//重复字段

	@Override
	public String toString() {
		return "PinkunhuView{" +
			", sexValue=" + sexValue +
			", ewaishouruValue=" + ewaishouruValue +
			", yunshukunnanValue=" + yunshukunnanValue +
			", gongzuorenyuanName=" + gongzuorenyuanName +
			", gongzuorenyuanPhone=" + gongzuorenyuanPhone +
			", gongzuorenyuanIdNumber=" + gongzuorenyuanIdNumber +
			", gongzuorenyuanPhoto=" + gongzuorenyuanPhoto +
			", gongzuorenyuanEmail=" + gongzuorenyuanEmail +
			"} " + super.toString();
	}
}
