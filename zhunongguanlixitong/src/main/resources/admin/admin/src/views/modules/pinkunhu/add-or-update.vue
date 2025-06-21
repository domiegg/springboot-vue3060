<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='gongzuorenyuan'">
                    <el-form-item class="select" v-if="type!='info'"  label="工作人员" prop="gongzuorenyuanId">
                        <el-select v-model="ruleForm.gongzuorenyuanId" :disabled="ro.gongzuorenyuanId" filterable placeholder="请选择工作人员" @change="gongzuorenyuanChange">
                            <el-option
                                    v-for="(item,index) in gongzuorenyuanOptions"
                                    v-bind:key="item.id"
                                    :label="item.gongzuorenyuanName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='gongzuorenyuan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工作人员姓名" prop="gongzuorenyuanName">
                        <el-input v-model="gongzuorenyuanForm.gongzuorenyuanName"
                                  placeholder="工作人员姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工作人员姓名" prop="gongzuorenyuanName">
                            <el-input v-model="ruleForm.gongzuorenyuanName"
                                      placeholder="工作人员姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='gongzuorenyuan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工作人员手机号" prop="gongzuorenyuanPhone">
                        <el-input v-model="gongzuorenyuanForm.gongzuorenyuanPhone"
                                  placeholder="工作人员手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工作人员手机号" prop="gongzuorenyuanPhone">
                            <el-input v-model="ruleForm.gongzuorenyuanPhone"
                                      placeholder="工作人员手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='gongzuorenyuan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工作人员身份证号" prop="gongzuorenyuanIdNumber">
                        <el-input v-model="gongzuorenyuanForm.gongzuorenyuanIdNumber"
                                  placeholder="工作人员身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工作人员身份证号" prop="gongzuorenyuanIdNumber">
                            <el-input v-model="ruleForm.gongzuorenyuanIdNumber"
                                      placeholder="工作人员身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='gongzuorenyuan' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.gongzuorenyuanPhoto" label="工作人员头像" prop="gongzuorenyuanPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (gongzuorenyuanForm.gongzuorenyuanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.gongzuorenyuanPhoto" label="工作人员头像" prop="gongzuorenyuanPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.gongzuorenyuanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='gongzuorenyuan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="gongzuorenyuanEmail">
                        <el-input v-model="gongzuorenyuanForm.gongzuorenyuanEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="gongzuorenyuanEmail">
                            <el-input v-model="ruleForm.gongzuorenyuanEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="账户" prop="username">
                       <el-input v-model="ruleForm.username"
                                 placeholder="账户" clearable  :readonly="ro.username"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="账户" prop="username">
                           <el-input v-model="ruleForm.username"
                                     placeholder="账户" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="gongzuorenyuanId" name="gongzuorenyuanId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="pinkunhuName">
                       <el-input v-model="ruleForm.pinkunhuName"
                                 placeholder="姓名" clearable  :readonly="ro.pinkunhuName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="姓名" prop="pinkunhuName">
                           <el-input v-model="ruleForm.pinkunhuName"
                                     placeholder="姓名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="pinkunhuPhone">
                       <el-input v-model="ruleForm.pinkunhuPhone"
                                 placeholder="手机号" clearable  :readonly="ro.pinkunhuPhone"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="手机号" prop="pinkunhuPhone">
                           <el-input v-model="ruleForm.pinkunhuPhone"
                                     placeholder="手机号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="身份证号" prop="pinkunhuAddress">
                       <el-input v-model="ruleForm.pinkunhuAddress"
                                 placeholder="身份证号" clearable  :readonly="ro.pinkunhuAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="身份证号" prop="pinkunhuAddress">
                           <el-input v-model="ruleForm.pinkunhuAddress"
                                     placeholder="身份证号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="家庭住址" prop="pinkunhuIdNumber">
                       <el-input v-model="ruleForm.pinkunhuIdNumber"
                                 placeholder="家庭住址" clearable  :readonly="ro.pinkunhuIdNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="家庭住址" prop="pinkunhuIdNumber">
                           <el-input v-model="ruleForm.pinkunhuIdNumber"
                                     placeholder="家庭住址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.pinkunhuPhoto" label="贫困户照片" prop="pinkunhuPhoto">
                        <file-upload
                            tip="点击上传贫困户照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.pinkunhuPhoto?$base.url+ruleForm.pinkunhuPhoto:''"
                            @change="pinkunhuPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.pinkunhuPhoto" label="贫困户照片" prop="pinkunhuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.pinkunhuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="性别" prop="sexTypes">
                        <el-select v-model="ruleForm.sexTypes" :disabled="ro.sexTypes" placeholder="请选择性别">
                            <el-option
                                v-for="(item,index) in sexTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="性别" prop="sexValue">
                        <el-input v-model="ruleForm.sexValue"
                            placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="pinkunhuEmail">
                       <el-input v-model="ruleForm.pinkunhuEmail"
                                 placeholder="电子邮箱" clearable  :readonly="ro.pinkunhuEmail"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="电子邮箱" prop="pinkunhuEmail">
                           <el-input v-model="ruleForm.pinkunhuEmail"
                                     placeholder="电子邮箱" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="家庭成员" prop="pinkunhuChengyuanText">
                        <el-input type="textarea"  :readonly="ro.pinkunhuChengyuanText" v-model="ruleForm.pinkunhuChengyuanText" placeholder="家庭成员"></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkunhuChengyuanText" label="家庭成员" prop="pinkunhuChengyuanText">
                            <span v-html="ruleForm.pinkunhuChengyuanText"></span>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="年收入" prop="yonghuNianshouru">
                       <el-input v-model="ruleForm.yonghuNianshouru"
                                 placeholder="年收入" clearable  :readonly="ro.yonghuNianshouru"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="年收入" prop="yonghuNianshouru">
                           <el-input v-model="ruleForm.yonghuNianshouru"
                                     placeholder="年收入" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否有额外收入" prop="ewaishouruTypes">
                        <el-select v-model="ruleForm.ewaishouruTypes" :disabled="ro.ewaishouruTypes" placeholder="请选择是否有额外收入">
                            <el-option
                                v-for="(item,index) in ewaishouruTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否有额外收入" prop="ewaishouruValue">
                        <el-input v-model="ruleForm.ewaishouruValue"
                            placeholder="是否有额外收入" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否存在运输困难" prop="yunshukunnanTypes">
                        <el-select v-model="ruleForm.yunshukunnanTypes" :disabled="ro.yunshukunnanTypes" placeholder="请选择是否存在运输困难">
                            <el-option
                                v-for="(item,index) in yunshukunnanTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否存在运输困难" prop="yunshukunnanValue">
                        <el-input v-model="ruleForm.yunshukunnanValue"
                            placeholder="是否存在运输困难" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                gongzuorenyuanForm: {},
                ro:{
                    username: false,
                    password: false,
                    gongzuorenyuanId: false,
                    pinkunhuName: false,
                    pinkunhuPhone: false,
                    pinkunhuAddress: false,
                    pinkunhuIdNumber: false,
                    pinkunhuPhoto: false,
                    sexTypes: false,
                    pinkunhuEmail: false,
                    pinkunhuChengyuanText: false,
                    yonghuNianshouru: false,
                    ewaishouruTypes: false,
                    yunshukunnanTypes: false,
                },
                ruleForm: {
                    username: '',
                    password: '',
                    gongzuorenyuanId: '',
                    pinkunhuName: '',
                    pinkunhuPhone: '',
                    pinkunhuAddress: '',
                    pinkunhuIdNumber: '',
                    pinkunhuPhoto: '',
                    sexTypes: '',
                    pinkunhuEmail: '',
                    pinkunhuChengyuanText: '',
                    yonghuNianshouru: '',
                    ewaishouruTypes: '',
                    yunshukunnanTypes: '',
                },
                sexTypesOptions : [],
                ewaishouruTypesOptions : [],
                yunshukunnanTypesOptions : [],
                gongzuorenyuanOptions : [],
                rules: {
                   username: [
                              { required: true, message: '账户不能为空', trigger: 'blur' },
                          ],
                   password: [
                              { required: true, message: '密码不能为空', trigger: 'blur' },
                          ],
                   gongzuorenyuanId: [
                              { required: true, message: '工作人员不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pinkunhuName: [
                              { required: true, message: '姓名不能为空', trigger: 'blur' },
                          ],
                   pinkunhuPhone: [
                              {  required: true, message: '手机号不能为空', trigger: 'blur' },
                              {  pattern: /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
                                 message: '手机号格式不对',
                                 trigger: 'blur'
                              }
                          ],
                   pinkunhuAddress: [
                              { required: true, message: '身份证号不能为空', trigger: 'blur' },
                          ],
                   pinkunhuIdNumber: [
                              { required: true, message: '家庭住址不能为空', trigger: 'blur' },
                              { pattern: /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
                                message: '家庭住址格式有误！',
                                trigger: 'blur'
                              }
                          ],
                   pinkunhuPhoto: [
                              { required: true, message: '贫困户照片不能为空', trigger: 'blur' },
                          ],
                   sexTypes: [
                              { required: true, message: '性别不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pinkunhuEmail: [
                              { required: true, message: '电子邮箱不能为空', trigger: 'blur' },
                              { pattern: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,
                                message: '电子邮箱只能是邮箱格式',
                                trigger: 'blur'
                              }
                          ],
                   pinkunhuChengyuanText: [
                              { required: true, message: '家庭成员不能为空', trigger: 'blur' },
                          ],
                   yonghuNianshouru: [
                              { required: true, message: '年收入不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   ewaishouruTypes: [
                              { required: true, message: '是否有额外收入不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yunshukunnanTypes: [
                              { required: true, message: '是否存在运输困难不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sexTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=ewaishouru_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ewaishouruTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=yunshukunnan_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yunshukunnanTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `gongzuorenyuan/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.gongzuorenyuanOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
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
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `pinkunhu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.gongzuorenyuanChange(data.data.gongzuorenyuanId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`pinkunhu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.pinkunhuCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.pinkunhuCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            pinkunhuPhotoUploadChange(fileUrls){
                this.ruleForm.pinkunhuPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

