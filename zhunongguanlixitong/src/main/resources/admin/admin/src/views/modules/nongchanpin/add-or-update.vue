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
                <el-col :span="12"  v-if="sessionTable !='pinkunhu'">
                    <el-form-item class="select" v-if="type!='info'"  label="贫困户" prop="pinkunhuId">
                        <el-select v-model="ruleForm.pinkunhuId" :disabled="ro.pinkunhuId" filterable placeholder="请选择贫困户" @change="pinkunhuChange">
                            <el-option
                                    v-for="(item,index) in pinkunhuOptions"
                                    v-bind:key="item.id"
                                    :label="item.pinkunhuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="pinkunhuName">
                        <el-input v-model="pinkunhuForm.pinkunhuName"
                                  placeholder="姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="姓名" prop="pinkunhuName">
                            <el-input v-model="ruleForm.pinkunhuName"
                                      placeholder="姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="pinkunhuPhone">
                        <el-input v-model="pinkunhuForm.pinkunhuPhone"
                                  placeholder="手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="手机号" prop="pinkunhuPhone">
                            <el-input v-model="ruleForm.pinkunhuPhone"
                                      placeholder="手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="身份证号" prop="pinkunhuAddress">
                        <el-input v-model="pinkunhuForm.pinkunhuAddress"
                                  placeholder="身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="身份证号" prop="pinkunhuAddress">
                            <el-input v-model="ruleForm.pinkunhuAddress"
                                      placeholder="身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="家庭住址" prop="pinkunhuIdNumber">
                        <el-input v-model="pinkunhuForm.pinkunhuIdNumber"
                                  placeholder="家庭住址" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="家庭住址" prop="pinkunhuIdNumber">
                            <el-input v-model="ruleForm.pinkunhuIdNumber"
                                      placeholder="家庭住址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.pinkunhuPhoto" label="贫困户照片" prop="pinkunhuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (pinkunhuForm.pinkunhuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkunhuPhoto" label="贫困户照片" prop="pinkunhuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.pinkunhuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="pinkunhuEmail">
                        <el-input v-model="pinkunhuForm.pinkunhuEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="pinkunhuEmail">
                            <el-input v-model="ruleForm.pinkunhuEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="家庭成员" prop="pinkunhuChengyuanText">
                        <el-input v-model="pinkunhuForm.pinkunhuChengyuanText"
                                  placeholder="家庭成员" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="家庭成员" prop="pinkunhuChengyuanText">
                            <el-input v-model="ruleForm.pinkunhuChengyuanText"
                                      placeholder="家庭成员" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="年收入" prop="yonghuNianshouru">
                        <el-input v-model="pinkunhuForm.yonghuNianshouru"
                                  placeholder="年收入" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="年收入" prop="yonghuNianshouru">
                            <el-input v-model="ruleForm.yonghuNianshouru"
                                      placeholder="年收入" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="是否有额外收入" prop="ewaishouruValue">
                        <el-input v-model="pinkunhuForm.ewaishouruValue"
                                  placeholder="是否有额外收入" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否有额外收入" prop="ewaishouruValue">
                            <el-input v-model="ruleForm.ewaishouruValue"
                                      placeholder="是否有额外收入" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='pinkunhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="是否存在运输困难" prop="yunshukunnanValue">
                        <el-input v-model="pinkunhuForm.yunshukunnanValue"
                                  placeholder="是否存在运输困难" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否存在运输困难" prop="yunshukunnanValue">
                            <el-input v-model="ruleForm.yunshukunnanValue"
                                      placeholder="是否存在运输困难" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="pinkunhuId" name="pinkunhuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="农产品名称" prop="nongchanpinName">
                       <el-input v-model="ruleForm.nongchanpinName"
                                 placeholder="农产品名称" clearable  :readonly="ro.nongchanpinName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="农产品名称" prop="nongchanpinName">
                           <el-input v-model="ruleForm.nongchanpinName"
                                     placeholder="农产品名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="农产品编号" prop="nongchanpinUuidNumber">
                       <el-input v-model="ruleForm.nongchanpinUuidNumber"
                                 placeholder="农产品编号" clearable  :readonly="ro.nongchanpinUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="农产品编号" prop="nongchanpinUuidNumber">
                           <el-input v-model="ruleForm.nongchanpinUuidNumber"
                                     placeholder="农产品编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.nongchanpinPhoto" label="农产品照片" prop="nongchanpinPhoto">
                        <file-upload
                            tip="点击上传农产品照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.nongchanpinPhoto?$base.url+ruleForm.nongchanpinPhoto:''"
                            @change="nongchanpinPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.nongchanpinPhoto" label="农产品照片" prop="nongchanpinPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.nongchanpinPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="产出地" prop="nongchanpinAddress">
                       <el-input v-model="ruleForm.nongchanpinAddress"
                                 placeholder="产出地" clearable  :readonly="ro.nongchanpinAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="产出地" prop="nongchanpinAddress">
                           <el-input v-model="ruleForm.nongchanpinAddress"
                                     placeholder="产出地" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="农产品类型" prop="nongchanpinTypes">
                        <el-select v-model="ruleForm.nongchanpinTypes" :disabled="ro.nongchanpinTypes" placeholder="请选择农产品类型">
                            <el-option
                                v-for="(item,index) in nongchanpinTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农产品类型" prop="nongchanpinValue">
                        <el-input v-model="ruleForm.nongchanpinValue"
                            placeholder="农产品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="农产品库存" prop="nongchanpinKucunNumber">
                       <el-input v-model="ruleForm.nongchanpinKucunNumber"
                                 placeholder="农产品库存" clearable  :readonly="ro.nongchanpinKucunNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="农产品库存" prop="nongchanpinKucunNumber">
                           <el-input v-model="ruleForm.nongchanpinKucunNumber"
                                     placeholder="农产品库存" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="采购价" prop="nongchanpinCaigouJine">
                       <el-input v-model="ruleForm.nongchanpinCaigouJine"
                                 placeholder="采购价" clearable  :readonly="ro.nongchanpinCaigouJine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="采购价" prop="nongchanpinCaigouJine">
                           <el-input v-model="ruleForm.nongchanpinCaigouJine"
                                     placeholder="采购价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售价" prop="nongchanpinNewJine">
                       <el-input v-model="ruleForm.nongchanpinNewJine"
                                 placeholder="销售价" clearable  :readonly="ro.nongchanpinNewJine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="销售价" prop="nongchanpinNewJine">
                           <el-input v-model="ruleForm.nongchanpinNewJine"
                                     placeholder="销售价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="所属仓库" prop="cangkuTypes">
                        <el-select v-model="ruleForm.cangkuTypes" :disabled="ro.cangkuTypes" placeholder="请选择所属仓库">
                            <el-option
                                v-for="(item,index) in cangkuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="所属仓库" prop="cangkuValue">
                        <el-input v-model="ruleForm.cangkuValue"
                            placeholder="所属仓库" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="产品介绍" prop="nongchanpinContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.nongchanpinContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.nongchanpinContent" label="产品介绍" prop="nongchanpinContent">
                            <span v-html="ruleForm.nongchanpinContent"></span>
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
                pinkunhuForm: {},
                ro:{
                    pinkunhuId: false,
                    nongchanpinName: false,
                    nongchanpinUuidNumber: false,
                    nongchanpinPhoto: false,
                    nongchanpinAddress: false,
                    nongchanpinTypes: false,
                    nongchanpinKucunNumber: false,
                    nongchanpinCaigouJine: false,
                    nongchanpinNewJine: false,
                    cangkuTypes: false,
                    nongchanpinContent: false,
                    nongchanpinDelete: false,
                },
                ruleForm: {
                    pinkunhuId: '',
                    nongchanpinName: '',
                    nongchanpinUuidNumber: new Date().getTime(),
                    nongchanpinPhoto: '',
                    nongchanpinAddress: '',
                    nongchanpinTypes: '',
                    nongchanpinKucunNumber: '',
                    nongchanpinCaigouJine: '',
                    nongchanpinNewJine: '',
                    cangkuTypes: '',
                    nongchanpinContent: '',
                    nongchanpinDelete: '',
                },
                nongchanpinTypesOptions : [],
                cangkuTypesOptions : [],
                pinkunhuOptions : [],
                rules: {
                   pinkunhuId: [
                              { required: true, message: '不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinName: [
                              { required: true, message: '农产品名称不能为空', trigger: 'blur' },
                          ],
                   nongchanpinUuidNumber: [
                              { required: true, message: '农产品编号不能为空', trigger: 'blur' },
                          ],
                   nongchanpinPhoto: [
                              { required: true, message: '农产品照片不能为空', trigger: 'blur' },
                          ],
                   nongchanpinAddress: [
                              { required: true, message: '产出地不能为空', trigger: 'blur' },
                          ],
                   nongchanpinTypes: [
                              { required: true, message: '农产品类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinKucunNumber: [
                              { required: true, message: '农产品库存不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinCaigouJine: [
                              { required: true, message: '采购价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinNewJine: [
                              { required: true, message: '销售价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   cangkuTypes: [
                              { required: true, message: '所属仓库不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinContent: [
                              { required: true, message: '产品介绍不能为空', trigger: 'blur' },
                          ],
                   nongchanpinDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
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
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=nongchanpin_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.nongchanpinTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=cangku_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.cangkuTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `pinkunhu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.pinkunhuOptions = data.data.list;
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
            pinkunhuChange(id){
                this.$http({
                    url: `pinkunhu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.pinkunhuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `nongchanpin/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.pinkunhuChange(data.data.pinkunhuId)
                        _this.ruleForm.nongchanpinContent = _this.ruleForm.nongchanpinContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.nongchanpinContent = this.ruleForm.nongchanpinContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`nongchanpin/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.nongchanpinCrossAddOrUpdateFlag = false;
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
                this.parent.nongchanpinCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            nongchanpinPhotoUploadChange(fileUrls){
                this.ruleForm.nongchanpinPhoto = fileUrls;
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

