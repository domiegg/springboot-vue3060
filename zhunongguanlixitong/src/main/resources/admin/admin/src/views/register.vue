<template>
    <div>
        <div class="container">
            <div class="login-form">
                <h1 class="h1" style="color:#000;fontSize:28px;">助农管理系统注册</h1>
                <el-form class="rgs-form">
                    <el-form-item label="账号" class="input">
                        <el-input v-model="ruleForm.username" autocomplete="off" placeholder="账号"  />
                    </el-form-item>
                    <el-form-item label="密码" class="input">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" show-password/>
                    </el-form-item>
                    <el-form-item label="重复密码" class="input">
                        <el-input type="passwo   rd" v-model="ruleForm.repetitionPassword" autocomplete="off" show-password/>
                    </el-form-item>
                        <el-form-item label="工作人员姓名" class="input" v-if="tableName=='gongzuorenyuan'">
                            <el-input v-model="ruleForm.gongzuorenyuanName" autocomplete="off" placeholder="工作人员姓名"  />
                        </el-form-item>
                        <el-form-item label="工作人员手机号" class="input" v-if="tableName=='gongzuorenyuan'">
                            <el-input v-model="ruleForm.gongzuorenyuanPhone" autocomplete="off" placeholder="工作人员手机号"  />
                        </el-form-item>
                        <el-form-item label="工作人员身份证号" class="input" v-if="tableName=='gongzuorenyuan'">
                            <el-input v-model="ruleForm.gongzuorenyuanIdNumber" autocomplete="off" placeholder="工作人员身份证号"  />
                        </el-form-item>
                        <el-form-item label="电子邮箱" class="input" v-if="tableName=='gongzuorenyuan'">
                            <el-input v-model="ruleForm.gongzuorenyuanEmail" autocomplete="off" placeholder="电子邮箱"  />
                        </el-form-item>
                       <!--<el-form-item class="select" label="工作人员">
                            <el-select style="width: 399px;height: 40px;" v-model="ruleForm.gongzuorenyuanId" placeholder="请选择工作人员">
                                <el-option
                                        v-for="(item,index) in gongzuorenyuanOptions"
                                        v-bind:key="item.id"
                                        :label="item.gongzuorenyuanName"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>-->
                        <el-form-item label="姓名" class="input" v-if="tableName=='pinkunhu'">
                            <el-input v-model="ruleForm.pinkunhuName" autocomplete="off" placeholder="姓名"  />
                        </el-form-item>
                        <el-form-item label="手机号" class="input" v-if="tableName=='pinkunhu'">
                            <el-input v-model="ruleForm.pinkunhuPhone" autocomplete="off" placeholder="手机号"  />
                        </el-form-item>
                        <el-form-item label="家庭住址" class="input" v-if="tableName=='pinkunhu'">
                            <el-input v-model="ruleForm.pinkunhuIdNumber" autocomplete="off" placeholder="家庭住址"  />
                        </el-form-item>
                        <el-form-item label="电子邮箱" class="input" v-if="tableName=='pinkunhu'">
                            <el-input v-model="ruleForm.pinkunhuEmail" autocomplete="off" placeholder="电子邮箱"  />
                        </el-form-item>
                    <div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
                        <el-button class="btn" type="primary" @click="login()">注册</el-button>
                        <el-button class="btn close" type="primary" @click="close()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                ruleForm: {
                },
                tableName:"",
                rules: {},
                sexTypesOptions : [],
                gongzuorenyuanOptions : [],
            };
        },
        mounted(){
            let table = this.$storage.get("loginTable");
            this.tableName = table;

            //级联表的下拉框查询

            this.$http({
                url: `gongzuorenyuan/page?page=1&limit=100`,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    this.gongzuorenyuanOptions = data.data.list;
                }else {
                    alert(data.msg);
                }
            });

        },
        methods: {
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            close(){
                this.$router.push({ path: "/login" });
            },
            // 注册
            login() {

                            if((!this.ruleForm.username)){
                                this.$message.error('账号不能为空');
                                return
                            }
                            if((!this.ruleForm.password)){
                                this.$message.error('密码不能为空');
                                return
                            }
                            if((!this.ruleForm.repetitionPassword)){
                                this.$message.error('重复密码不能为空');
                                return
                            }
                            if(this.ruleForm.repetitionPassword != this.ruleForm.password){
                                this.$message.error('密码和重复密码不一致');
                                return
                            }
                            if((!this.ruleForm.gongzuorenyuanName)&& 'gongzuorenyuan'==this.tableName){
                                this.$message.error('工作人员姓名不能为空');
                                return
                            }
                             if('gongzuorenyuan' == this.tableName && this.ruleForm.gongzuorenyuanPhone&&(!this.$validate.isMobile(this.ruleForm.gongzuorenyuanPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.gongzuorenyuanIdNumber)&& 'gongzuorenyuan'==this.tableName){
                                this.$message.error('工作人员身份证号不能为空');
                                return
                            }
                            if('gongzuorenyuan' == this.tableName && this.ruleForm.gongzuorenyuanEmail&&(!this.$validate.isEmail(this.ruleForm.gongzuorenyuanEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            //// 贫困户 的 工作人员
                            // if((!this.ruleForm.gongzuorenyuanId)&& 'pinkunhu'==this.tableName){
                            //     this.$message.error('工作人员不能为空');
                            //     return
                            // }
                            if((!this.ruleForm.pinkunhuName)&& 'pinkunhu'==this.tableName){
                                this.$message.error('姓名不能为空');
                                return
                            }
                             if('pinkunhu' == this.tableName && this.ruleForm.pinkunhuPhone&&(!this.$validate.isMobile(this.ruleForm.pinkunhuPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.pinkunhuIdNumber)&& 'pinkunhu'==this.tableName){
                                this.$message.error('家庭住址不能为空');
                                return
                            }
                            if('pinkunhu' == this.tableName && this.ruleForm.pinkunhuEmail&&(!this.$validate.isEmail(this.ruleForm.pinkunhuEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                this.$http({
                    url: `${this.tableName}/register`,
                    method: "post",
                    data:this.ruleForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.$message({
                        message: "注册成功,请登录后在个人中心页面补充个人数据",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                        this.$router.replace({ path: "/login" });
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
    .el-radio__input.is-checked .el-radio__inner {
        border-color: #00c292;
        background: #00c292;
    }

    .el-radio__input.is-checked .el-radio__inner {
        border-color: #00c292;
        background: #00c292;
    }

    .el-radio__input.is-checked .el-radio__inner {
        border-color: #00c292;
        background: #00c292;
    }

    .el-radio__input.is-checked+.el-radio__label {
        color: #00c292;
    }

    .el-radio__input.is-checked+.el-radio__label {
        color: #00c292;
    }

    .el-radio__input.is-checked+.el-radio__label {
        color: #00c292;
    }

    .h1 {
        margin-top: 10px;
    }

    body {
        padding: 0;
        margin: 0;
    }

    .nk-navigation {
        margin-top: 15px;

    a {
        display: inline-block;
        color: #fff;
        background: rgba(255, 255, 255, .2);
        width: 100px;
        height: 50px;
        border-radius: 30px;
        text-align: center;
        display: flex;
        align-items: center;
        margin: 0 auto;
        justify-content: center;
        padding: 0 20px;
    }

    .icon {
        margin-left: 10px;
        width: 30px;
        height: 30px;
    }
    }

    .register-container {
        margin-top: 10px;

    a {
        display: inline-block;
        color: #fff;
        max-width: 500px;
        height: 50px;
        border-radius: 30px;
        text-align: center;
        display: flex;
        align-items: center;
        margin: 0 auto;
        justify-content: center;
        padding: 0 20px;

    div {
        margin-left: 10px;
    }
    }
    }

    .container {
        height: 100vh;
        background-position: center center;
        background-size: cover;
        background-repeat: no-repeat;
        background-image: url(/zhunongguanlixitong/img/back-img-bg.jpg);

    .login-form {
        right: 50%;
        top: 50%;
        transform: translate3d(50%, -50%, 0);
        border-radius: 10px;
        background-color: rgba(255,255,255,.5);
        font-size: 14px;
        font-weight: 500;
        box-sizing: border-box;

        width: 480px;
        height: auto;
        padding: 10px;
        margin: 0px 0px 0px 0px;
        border-radius: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(255,0,0,0);
        background-color: rgba(255, 255, 255, 0.5);
        box-shadow: 0 0 0px rgba(255,0,0,.1);

    .h1 {
        width: 460px;
        height: 40px;
        line-height:40px;
        color: #000;
        font-size: 23px;
        padding: 0;
        margin: 0px 0px 0px 0px;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: rgba(255,0,0,0);
        background-color: rgba(144, 238, 144, 0);
        box-shadow: 0 0 6px rgba(255,0,0,0);
        text-align: center;
    }

    .rgs-form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

    .el-form-item {
        width: 100%;
        display: flex;

    & /deep/ .el-form-item__content {
          flex: 1;
          display: flex;
      }
    }

    .input {
        width: 400px;
        height:auto;
        padding: 0;
        margin: 0 0 10px 0;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: rgba(255,0,0,0);
        background-color: rgba(255, 69, 0, 0);
        box-shadow: 0 0 6px rgba(255,0,0,0);

    & /deep/ .el-form-item__label {
          width: 110px;
          line-height:40px;
          color: rgba(0, 3, 9, 1);
          font-size: 14px;
          padding: 0px 0px 0px 0px;
          margin: 0px 12px 0px 0px;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255,0,0,0);
          background-color: rgba(255,0,0,0);
          box-shadow: 0 0 6px rgba(255,0,0,0);
      }

    & /deep/ .el-input__inner {
          width: 220px;
          height: 40px;
          line-height:40px;
          color: rgba(0, 0, 0, 1);
          font-size: 14px;
          padding: 0 12px;
          margin: 0;
          border-radius: 4px;
          border-width: 1px;
          border-style: solid;
          border-color: #606266;
          background-color: #fff;
          box-shadow: 0 0 6px rgba(255,0,0,0);
          text-align: left;
      }
    }

    .send-code {
    & /deep/ .el-input__inner {
          width: 140px;
          height: 40px;
          line-height:40px;
          color: rgba(0, 0, 0, 1);
          font-size: 14px;
          padding: 0 12px;
          margin: 0;
          border-radius: 4px 0px 0px 4px;
          border-width: 1;
          border-style: solid;
          border-color: #606266;
          background-color: #fff;
          box-shadow: 0 0 6px rgba(255,0,0,0);
          text-align: left;
      }

    .register-code {
        margin: 0;
        padding: 0;
        width: 80px;
        height: 40px;
        line-height:40px;
        color: #fff;
        font-size: 14px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(255,0,0,0);
        border-radius: 0;
        background-color: rgb(64, 158, 255);
        box-shadow: 0 0 6px rgba(255,0,0,0);
    }
    }

    .btn {
        margin: 0 10px;
        padding: 0;
        width: 88px;
        height: 44px;
        line-height:44px;
        color: rgba(0, 0, 0, 1);
        font-size: 14px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(64, 158, 255, 1);
        border-radius: 4px;
        background-color: rgba(64, 158, 255, 1);
        box-shadow: 0 0 0px rgba(255,0,0,0);
    }

    .close {
        margin: 0 10px;
        padding: 0;
        width: 88px;
        height: 44px;
        line-height:44px;
        color: rgba(0, 0, 0, 1);
        font-size: 14px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(64, 158, 255, 1);
        border-radius: 4px;
        background-color: rgba(64, 158, 255, 1);
        box-shadow: 0 0 0px rgba(255,0,0,0);
    }

    }
    }
    }
</style>

