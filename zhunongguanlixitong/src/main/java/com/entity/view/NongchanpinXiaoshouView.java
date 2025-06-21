package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchanpinXiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品售卖
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchanpin_xiaoshou")
public class NongchanpinXiaoshouView extends NongchanpinXiaoshouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 销售类型的值
	*/
	@ColumnInfo(comment="销售类型的字典表值",type="varchar(200)")
	private String nongchanpinXiaoshouValue;

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
	//级联表 农产品
					 
		/**
		* 农产品 的 
		*/
		@ColumnInfo(comment="",type="int(11)")
		private Integer nongchanpinPinkunhuId;
		/**
		* 农产品名称
		*/

		@ColumnInfo(comment="农产品名称",type="varchar(200)")
		private String nongchanpinName;
		/**
		* 农产品编号
		*/

		@ColumnInfo(comment="农产品编号",type="varchar(200)")
		private String nongchanpinUuidNumber;
		/**
		* 农产品照片
		*/

		@ColumnInfo(comment="农产品照片",type="varchar(200)")
		private String nongchanpinPhoto;
		/**
		* 产出地
		*/

		@ColumnInfo(comment="产出地",type="varchar(200)")
		private String nongchanpinAddress;
		/**
		* 农产品类型
		*/
		@ColumnInfo(comment="农产品类型",type="int(11)")
		private Integer nongchanpinTypes;
			/**
			* 农产品类型的值
			*/
			@ColumnInfo(comment="农产品类型的字典表值",type="varchar(200)")
			private String nongchanpinValue;
		/**
		* 农产品库存
		*/

		@ColumnInfo(comment="农产品库存",type="int(11)")
		private Integer nongchanpinKucunNumber;
		/**
		* 采购价
		*/
		@ColumnInfo(comment="采购价",type="decimal(10,2)")
		private Double nongchanpinCaigouJine;
		/**
		* 销售价
		*/
		@ColumnInfo(comment="销售价",type="decimal(10,2)")
		private Double nongchanpinNewJine;
		/**
		* 所属仓库
		*/
		@ColumnInfo(comment="所属仓库",type="int(11)")
		private Integer cangkuTypes;
			/**
			* 所属仓库的值
			*/
			@ColumnInfo(comment="所属仓库的字典表值",type="varchar(200)")
			private String cangkuValue;
		/**
		* 产品介绍
		*/

		@ColumnInfo(comment="产品介绍",type="text")
		private String nongchanpinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer nongchanpinDelete;



	public NongchanpinXiaoshouView() {

	}

	public NongchanpinXiaoshouView(NongchanpinXiaoshouEntity nongchanpinXiaoshouEntity) {
		try {
			BeanUtils.copyProperties(this, nongchanpinXiaoshouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 销售类型的值
	*/
	public String getNongchanpinXiaoshouValue() {
		return nongchanpinXiaoshouValue;
	}
	/**
	* 设置： 销售类型的值
	*/
	public void setNongchanpinXiaoshouValue(String nongchanpinXiaoshouValue) {
		this.nongchanpinXiaoshouValue = nongchanpinXiaoshouValue;
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
	//级联表的get和set 农产品
		/**
		* 获取：农产品 的 
		*/
		public Integer getNongchanpinPinkunhuId() {
			return nongchanpinPinkunhuId;
		}
		/**
		* 设置：农产品 的 
		*/
		public void setNongchanpinPinkunhuId(Integer nongchanpinPinkunhuId) {
			this.nongchanpinPinkunhuId = nongchanpinPinkunhuId;
		}

		/**
		* 获取： 农产品名称
		*/
		public String getNongchanpinName() {
			return nongchanpinName;
		}
		/**
		* 设置： 农产品名称
		*/
		public void setNongchanpinName(String nongchanpinName) {
			this.nongchanpinName = nongchanpinName;
		}

		/**
		* 获取： 农产品编号
		*/
		public String getNongchanpinUuidNumber() {
			return nongchanpinUuidNumber;
		}
		/**
		* 设置： 农产品编号
		*/
		public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
			this.nongchanpinUuidNumber = nongchanpinUuidNumber;
		}

		/**
		* 获取： 农产品照片
		*/
		public String getNongchanpinPhoto() {
			return nongchanpinPhoto;
		}
		/**
		* 设置： 农产品照片
		*/
		public void setNongchanpinPhoto(String nongchanpinPhoto) {
			this.nongchanpinPhoto = nongchanpinPhoto;
		}

		/**
		* 获取： 产出地
		*/
		public String getNongchanpinAddress() {
			return nongchanpinAddress;
		}
		/**
		* 设置： 产出地
		*/
		public void setNongchanpinAddress(String nongchanpinAddress) {
			this.nongchanpinAddress = nongchanpinAddress;
		}
		/**
		* 获取： 农产品类型
		*/
		public Integer getNongchanpinTypes() {
			return nongchanpinTypes;
		}
		/**
		* 设置： 农产品类型
		*/
		public void setNongchanpinTypes(Integer nongchanpinTypes) {
			this.nongchanpinTypes = nongchanpinTypes;
		}


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

		/**
		* 获取： 农产品库存
		*/
		public Integer getNongchanpinKucunNumber() {
			return nongchanpinKucunNumber;
		}
		/**
		* 设置： 农产品库存
		*/
		public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
			this.nongchanpinKucunNumber = nongchanpinKucunNumber;
		}

		/**
		* 获取： 采购价
		*/
		public Double getNongchanpinCaigouJine() {
			return nongchanpinCaigouJine;
		}
		/**
		* 设置： 采购价
		*/
		public void setNongchanpinCaigouJine(Double nongchanpinCaigouJine) {
			this.nongchanpinCaigouJine = nongchanpinCaigouJine;
		}

		/**
		* 获取： 销售价
		*/
		public Double getNongchanpinNewJine() {
			return nongchanpinNewJine;
		}
		/**
		* 设置： 销售价
		*/
		public void setNongchanpinNewJine(Double nongchanpinNewJine) {
			this.nongchanpinNewJine = nongchanpinNewJine;
		}
		/**
		* 获取： 所属仓库
		*/
		public Integer getCangkuTypes() {
			return cangkuTypes;
		}
		/**
		* 设置： 所属仓库
		*/
		public void setCangkuTypes(Integer cangkuTypes) {
			this.cangkuTypes = cangkuTypes;
		}


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

		/**
		* 获取： 产品介绍
		*/
		public String getNongchanpinContent() {
			return nongchanpinContent;
		}
		/**
		* 设置： 产品介绍
		*/
		public void setNongchanpinContent(String nongchanpinContent) {
			this.nongchanpinContent = nongchanpinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getNongchanpinDelete() {
			return nongchanpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setNongchanpinDelete(Integer nongchanpinDelete) {
			this.nongchanpinDelete = nongchanpinDelete;
		}


	@Override
	public String toString() {
		return "NongchanpinXiaoshouView{" +
			", nongchanpinXiaoshouValue=" + nongchanpinXiaoshouValue +
			", nongchanpinName=" + nongchanpinName +
			", nongchanpinUuidNumber=" + nongchanpinUuidNumber +
			", nongchanpinPhoto=" + nongchanpinPhoto +
			", nongchanpinAddress=" + nongchanpinAddress +
			", nongchanpinKucunNumber=" + nongchanpinKucunNumber +
			", nongchanpinCaigouJine=" + nongchanpinCaigouJine +
			", nongchanpinNewJine=" + nongchanpinNewJine +
			", nongchanpinContent=" + nongchanpinContent +
			", nongchanpinDelete=" + nongchanpinDelete +
			", gongzuorenyuanName=" + gongzuorenyuanName +
			", gongzuorenyuanPhone=" + gongzuorenyuanPhone +
			", gongzuorenyuanIdNumber=" + gongzuorenyuanIdNumber +
			", gongzuorenyuanPhoto=" + gongzuorenyuanPhoto +
			", gongzuorenyuanEmail=" + gongzuorenyuanEmail +
			"} " + super.toString();
	}
}
