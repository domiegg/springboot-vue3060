<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='gongzuorenyuan'"  label='工作人员姓名' prop="gongzuorenyuanName">
               <el-input v-model="ruleForm.gongzuorenyuanName"  placeholder='工作人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='gongzuorenyuan'"  label='工作人员手机号' prop="gongzuorenyuanPhone">
               <el-input v-model="ruleForm.gongzuorenyuanPhone"  placeholder='工作人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='gongzuorenyuan'"  label='工作人员身份证号' prop="gongzuorenyuanIdNumber">
               <el-input v-model="ruleForm.gongzuorenyuanIdNumber"  placeholder='工作人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='gongzuorenyuan'" label='工作人员头像' prop="gongzuorenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.gongzuorenyuanPhoto?$base.url+ruleForm.gongzuorenyuanPhoto:''"
                         @change="gongzuorenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='gongzuorenyuan'"  label='电子邮箱' prop="gongzuorenyuanEmail">
               <el-input v-model="ruleForm.gongzuorenyuanEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

        <!--<el-col :span="12" v-if="flag=='pinkunhu'">
            <el-form-item class="select" label="工作人员" prop="gongzuorenyuanId">
                <el-select v-model="ruleForm.gongzuorenyuanId" filterable placeholder="请选择工作人员" @change="gongzuorenyuanChange">
                    <el-option
                            v-for="(item,index) in gongzuorenyuanOptions"
                            v-bind:key="item.id"
                                            :label="item.gongzuorenyuanName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>-->
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='工作人员姓名' prop="gongzuorenyuanName">
                 <el-input v-model="gongzuorenyuanForm.gongzuorenyuanName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='工作人员手机号' prop="gongzuorenyuanPhone">
                 <el-input v-model="gongzuorenyuanForm.gongzuorenyuanPhone" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='工作人员身份证号' prop="gongzuorenyuanIdNumber">
                 <el-input v-model="gongzuorenyuanForm.gongzuorenyuanIdNumber" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='工作人员头像' prop="gongzuorenyuanPhoto">
                 <el-image
                     style="width: 100px; height: 100px"
                     :src="gongzuorenyuanForm.gongzuorenyuanPhoto?$base.url+gongzuorenyuanForm.gongzuorenyuanPhoto:''"
                     :fit="fit">
                 </el-image>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='电子邮箱' prop="gongzuorenyuanEmail">
                 <el-input v-model="gongzuorenyuanForm.gongzuorenyuanEmail" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='姓名' prop="pinkunhuName">
               <el-input v-model="ruleForm.pinkunhuName"  placeholder='姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='手机号' prop="pinkunhuPhone">
               <el-input v-model="ruleForm.pinkunhuPhone"  placeholder='手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='身份证号' prop="pinkunhuAddress">
               <el-input v-model="ruleForm.pinkunhuAddress"  placeholder='身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='家庭住址' prop="pinkunhuIdNumber">
               <el-input v-model="ruleForm.pinkunhuIdNumber"  placeholder='家庭住址' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'" label='贫困户照片' prop="pinkunhuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.pinkunhuPhoto?$base.url+ruleForm.pinkunhuPhoto:''"
                         @change="pinkunhuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='电子邮箱' prop="pinkunhuEmail">
               <el-input v-model="ruleForm.pinkunhuEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='家庭成员' prop="pinkunhuChengyuanText">
               <el-input v-model="ruleForm.pinkunhuChengyuanText"  placeholder='家庭成员' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='pinkunhu'"  label='年收入' prop="yonghuNianshouru">
               <el-input v-model="ruleForm.yonghuNianshouru"  placeholder='年收入' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'"  label='是否有额外收入' prop="ewaishouruTypes">
                 <el-select v-model="ruleForm.ewaishouruTypes"  placeholder='请选择是否有额外收入'>
                     <el-option
                             v-for="(item,index) in ewaishouruTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='pinkunhu'"  label='是否存在运输困难' prop="yunshukunnanTypes">
                 <el-select v-model="ruleForm.yunshukunnanTypes"  placeholder='请选择是否存在运输困难'>
                     <el-option
                             v-for="(item,index) in yunshukunnanTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='pinkunhu'
|| flag=='gongzuorenyuan')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 贫困户
    // 注册的类型字段 贫困户
        // 性别
        sexTypesOptions : [],
        // 是否有额外收入
        ewaishouruTypesOptions : [],
        // 是否存在运输困难
        yunshukunnanTypesOptions : [],
    // 注册的级联表 贫困户
        // 工作人员列表
        gongzuorenyuanOptions : [],
        gongzuorenyuanForm:{},
// 注册表 工作人员
    // 注册的类型字段 工作人员
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 贫困户
    // 注册的级联表 贫困户
        if(table == 'pinkunhu'){
            this.gongzuorenyuanChange(this.ruleForm.gongzuorenyuanId);
        }
// 注册表 工作人员
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 贫困户 的级联表
    // 注册的级联表 贫困户
        // 工作人员列表
    this.$http({
        url: `gongzuorenyuan/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.gongzuorenyuanOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });
// 注册表 工作人员 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=ewaishouru_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.ewaishouruTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=yunshukunnan_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.yunshukunnanTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    gongzuorenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.gongzuorenyuanPhoto = fileUrls;
    },
    pinkunhuPhotoUploadChange(fileUrls) {
        this.ruleForm.pinkunhuPhoto = fileUrls;
    },
// 注册表的级联表
    gongzuorenyuanChange(id){
        this.$http({
            url: `gongzuorenyuan/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.gongzuorenyuanForm = data.data;
            }
        });
    },


    onUpdateHandler() {
                         if((!this.ruleForm.gongzuorenyuanName)&& 'gongzuorenyuan'==this.flag){
                             this.$message.error('工作人员姓名不能为空');
                             return
                         }

                             if( 'gongzuorenyuan' ==this.flag && this.ruleForm.gongzuorenyuanPhone&&(!isMobile(this.ruleForm.gongzuorenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.gongzuorenyuanIdNumber)&& 'gongzuorenyuan'==this.flag){
                             this.$message.error('工作人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.gongzuorenyuanPhoto)&& 'gongzuorenyuan'==this.flag){
                             this.$message.error('工作人员头像不能为空');
                             return
                         }

                             if( 'gongzuorenyuan' ==this.flag && this.ruleForm.gongzuorenyuanEmail&&(!isEmail(this.ruleForm.gongzuorenyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.gongzuorenyuanId)&& 'pinkunhu'==this.flag){
                             this.$message.error('工作人员不能为空');
                             return
                         }

                         if((!this.ruleForm.pinkunhuName)&& 'pinkunhu'==this.flag){
                             this.$message.error('姓名不能为空');
                             return
                         }

                             if( 'pinkunhu' ==this.flag && this.ruleForm.pinkunhuPhone&&(!isMobile(this.ruleForm.pinkunhuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.pinkunhuAddress)&& 'pinkunhu'==this.flag){
                             this.$message.error('身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.pinkunhuIdNumber)&& 'pinkunhu'==this.flag){
                             this.$message.error('家庭住址不能为空');
                             return
                         }

                         if((!this.ruleForm.pinkunhuPhoto)&& 'pinkunhu'==this.flag){
                             this.$message.error('贫困户照片不能为空');
                             return
                         }

                             if( 'pinkunhu' ==this.flag && this.ruleForm.pinkunhuEmail&&(!isEmail(this.ruleForm.pinkunhuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.pinkunhuChengyuanText)&& 'pinkunhu'==this.flag){
                             this.$message.error('家庭成员不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuNianshouru)&& 'pinkunhu'==this.flag){
                             this.$message.error('年收入不能为空');
                             return
                         }

                         if((!this.ruleForm.ewaishouruTypes)&& 'pinkunhu'==this.flag){
                             this.$message.error('是否有额外收入不能为空');
                             return
                         }

                         if((!this.ruleForm.yunshukunnanTypes)&& 'pinkunhu'==this.flag){
                             this.$message.error('是否存在运输困难不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='pinkunhu'
|| this.flag=='gongzuorenyuan')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
