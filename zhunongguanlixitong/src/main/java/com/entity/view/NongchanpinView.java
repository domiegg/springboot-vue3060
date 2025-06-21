package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchanpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchanpin")
public class NongchanpinView extends NongchanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 农产品类型的值
	*/
	@ColumnInfo(comment="农产品类型的字典表值",type="varchar(200)")
	private String nongchanpinValue;
	/**
	* 所属仓库的值
	*/
	@ColumnInfo(comment="所属仓库的字典表值",type="varchar(200)")
	private String cangkuValue;

	//级联表 贫困户
					 
		/**
		* 贫困户 的 工作人员
		*/
		@ColumnInfo(comment="工作人员",type="int(11)")
		private Integer pinkunhuGongzuorenyuanId;
		/**
		* 姓名
		*/

		@ColumnInfo(comment="姓名",type="varchar(200)")
		private String pinkunhuName;
		/**
		* 手机号
		*/

		@ColumnInfo(comment="手机号",type="varchar(200)")
		private String pinkunhuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String pinkunhuAddress;
		/**
		* 家庭住址
		*/

		@ColumnInfo(comment="家庭住址",type="varchar(200)")
		private String pinkunhuIdNumber;
		/**
		* 贫困户照片
		*/

		@ColumnInfo(comment="贫困户照片",type="varchar(200)")
		private String pinkunhuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String pinkunhuEmail;
		/**
		* 家庭成员
		*/

		@ColumnInfo(comment="家庭成员",type="text")
		private String pinkunhuChengyuanText;
		/**
		* 年收入
		*/
		@ColumnInfo(comment="年收入",type="decimal(10,2)")
		private Double yonghuNianshouru;
		/**
		* 是否有额外收入
		*/
		@ColumnInfo(comment="是否有额外收入",type="int(11)")
		private Integer ewaishouruTypes;
			/**
			* 是否有额外收入的值
			*/
			@ColumnInfo(comment="是否有额外收入的字典表值",type="varchar(200)")
			private String ewaishouruValue;
		/**
		* 是否存在运输困难
		*/
		@ColumnInfo(comment="是否存在运输困难",type="int(11)")
		private Integer yunshukunnanTypes;
			/**
			* 是否存在运输困难的值
			*/
			@ColumnInfo(comment="是否存在运输困难的字典表值",type="varchar(200)")
			private String yunshukunnanValue;



	public NongchanpinView() {

	}

	public NongchanpinView(NongchanpinEntity nongchanpinEntity) {
		try {
			BeanUtils.copyProperties(this, nongchanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 农产品类型的值
	*/
	public String getNongchanpinValue() {
		return nongchanpinValue;
	}
	/**
	* 设置： 农产品类型的值
	*/
	public void setNongchanpinValue(String nongchanpinValue) {
		this.nongchanpinValue = nongchanpinValue;
	}
	//当前表的
	/**
	* 获取： 所属仓库的值
	*/
	public String getCangkuValue() {
		return cangkuValue;
	}
	/**
	* 设置： 所属仓库的值
	*/
	public void setCangkuValue(String cangkuValue) {
		this.cangkuValue = cangkuValue;
	}


	//级联表的get和set 贫困户
		/**
		* 获取：贫困户 的 工作人员
		*/
		public Integer getPinkunhuGongzuorenyuanId() {
			return pinkunhuGongzuorenyuanId;
		}
		/**
		* 设置：贫困户 的 工作人员
		*/
		public void setPinkunhuGongzuorenyuanId(Integer pinkunhuGongzuorenyuanId) {
			this.pinkunhuGongzuorenyuanId = pinkunhuGongzuorenyuanId;
		}

		/**
		* 获取： 姓名
		*/
		public String getPinkunhuName() {
			return pinkunhuName;
		}
		/**
		* 设置： 姓名
		*/
		public void setPinkunhuName(String pinkunhuName) {
			this.pinkunhuName = pinkunhuName;
		}

		/**
		* 获取： 手机号
		*/
		public String getPinkunhuPhone() {
			return pinkunhuPhone;
		}
		/**
		* 设置： 手机号
		*/
		public void setPinkunhuPhone(String pinkunhuPhone) {
			this.pinkunhuPhone = pinkunhuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getPinkunhuAddress() {
			return pinkunhuAddress;
		}
		/**
		* 设置： 身份证号
		*/
		public void setPinkunhuAddress(String pinkunhuAddress) {
			this.pinkunhuAddress = pinkunhuAddress;
		}

		/**
		* 获取： 家庭住址
		*/
		public String getPinkunhuIdNumber() {
			return pinkunhuIdNumber;
		}
		/**
		* 设置： 家庭住址
		*/
		public void setPinkunhuIdNumber(String pinkunhuIdNumber) {
			this.pinkunhuIdNumber = pinkunhuIdNumber;
		}

		/**
		* 获取： 贫困户照片
		*/
		public String getPinkunhuPhoto() {
			return pinkunhuPhoto;
		}
		/**
		* 设置： 贫困户照片
		*/
		public void setPinkunhuPhoto(String pinkunhuPhoto) {
			this.pinkunhuPhoto = pinkunhuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getPinkunhuEmail() {
			return pinkunhuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setPinkunhuEmail(String pinkunhuEmail) {
			this.pinkunhuEmail = pinkunhuEmail;
		}

		/**
		* 获取： 家庭成员
		*/
		public String getPinkunhuChengyuanText() {
			return pinkunhuChengyuanText;
		}
		/**
		* 设置： 家庭成员
		*/
		public void setPinkunhuChengyuanText(String pinkunhuChengyuanText) {
			this.pinkunhuChengyuanText = pinkunhuChengyuanText;
		}

		/**
		* 获取： 年收入
		*/
		public Double getYonghuNianshouru() {
			return yonghuNianshouru;
		}
		/**
		* 设置： 年收入
		*/
		public void setYonghuNianshouru(Double yonghuNianshouru) {
			this.yonghuNianshouru = yonghuNianshouru;
		}
		/**
		* 获取： 是否有额外收入
		*/
		public Integer getEwaishouruTypes() {
			return ewaishouruTypes;
		}
		/**
		* 设置： 是否有额外收入
		*/
		public void setEwaishouruTypes(Integer ewaishouruTypes) {
			this.ewaishouruTypes = ewaishouruTypes;
		}


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
		/**
		* 获取： 是否存在运输困难
		*/
		public Integer getYunshukunnanTypes() {
			return yunshukunnanTypes;
		}
		/**
		* 设置： 是否存在运输困难
		*/
		public void setYunshukunnanTypes(Integer yunshukunnanTypes) {
			this.yunshukunnanTypes = yunshukunnanTypes;
		}


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


	@Override
	public String toString() {
		return "NongchanpinView{" +
			", nongchanpinValue=" + nongchanpinValue +
			", cangkuValue=" + cangkuValue +
			", pinkunhuName=" + pinkunhuName +
			", pinkunhuPhone=" + pinkunhuPhone +
			", pinkunhuAddress=" + pinkunhuAddress +
			", pinkunhuIdNumber=" + pinkunhuIdNumber +
			", pinkunhuPhoto=" + pinkunhuPhoto +
			", pinkunhuEmail=" + pinkunhuEmail +
			", pinkunhuChengyuanText=" + pinkunhuChengyuanText +
			", yonghuNianshouru=" + yonghuNianshouru +
			"} " + super.toString();
	}
}
