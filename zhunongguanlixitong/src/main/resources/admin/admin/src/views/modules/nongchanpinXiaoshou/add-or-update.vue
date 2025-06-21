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
                <el-col :span="12"  v-if="sessionTable !='nongchanpin'">
                    <el-form-item class="select" v-if="type!='info'"  label="农产品" prop="nongchanpinId">
                        <el-select v-model="ruleForm.nongchanpinId" :disabled="ro.nongchanpinId" filterable placeholder="请选择农产品" @change="nongchanpinChange">
                            <el-option
                                    v-for="(item,index) in nongchanpinOptions"
                                    v-bind:key="item.id"
                                    :label="item.nongchanpinName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农产品名称" prop="nongchanpinName">
                        <el-input v-model="nongchanpinForm.nongchanpinName"
                                  placeholder="农产品名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农产品名称" prop="nongchanpinName">
                            <el-input v-model="ruleForm.nongchanpinName"
                                      placeholder="农产品名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农产品编号" prop="nongchanpinUuidNumber">
                        <el-input v-model="nongchanpinForm.nongchanpinUuidNumber"
                                  placeholder="农产品编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农产品编号" prop="nongchanpinUuidNumber">
                            <el-input v-model="ruleForm.nongchanpinUuidNumber"
                                      placeholder="农产品编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.nongchanpinPhoto" label="农产品照片" prop="nongchanpinPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (nongchanpinForm.nongchanpinPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.nongchanpinPhoto" label="农产品照片" prop="nongchanpinPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.nongchanpinPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="产出地" prop="nongchanpinAddress">
                        <el-input v-model="nongchanpinForm.nongchanpinAddress"
                                  placeholder="产出地" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="产出地" prop="nongchanpinAddress">
                            <el-input v-model="ruleForm.nongchanpinAddress"
                                      placeholder="产出地" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农产品类型" prop="nongchanpinValue">
                        <el-input v-model="nongchanpinForm.nongchanpinValue"
                                  placeholder="农产品类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农产品类型" prop="nongchanpinValue">
                            <el-input v-model="ruleForm.nongchanpinValue"
                                      placeholder="农产品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农产品库存" prop="nongchanpinKucunNumber">
                        <el-input v-model="nongchanpinForm.nongchanpinKucunNumber"
                                  placeholder="农产品库存" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农产品库存" prop="nongchanpinKucunNumber">
                            <el-input v-model="ruleForm.nongchanpinKucunNumber"
                                      placeholder="农产品库存" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="采购价" prop="nongchanpinCaigouJine">
                        <el-input v-model="nongchanpinForm.nongchanpinCaigouJine"
                                  placeholder="采购价" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="采购价" prop="nongchanpinCaigouJine">
                            <el-input v-model="ruleForm.nongchanpinCaigouJine"
                                      placeholder="采购价" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="销售价" prop="nongchanpinNewJine">
                        <el-input v-model="nongchanpinForm.nongchanpinNewJine"
                                  placeholder="销售价" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="销售价" prop="nongchanpinNewJine">
                            <el-input v-model="ruleForm.nongchanpinNewJine"
                                      placeholder="销售价" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongchanpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="所属仓库" prop="cangkuValue">
                        <el-input v-model="nongchanpinForm.cangkuValue"
                                  placeholder="所属仓库" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="所属仓库" prop="cangkuValue">
                            <el-input v-model="ruleForm.cangkuValue"
                                      placeholder="所属仓库" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售编号" prop="nongchanpinXiaoshouUuidNumber">
                       <el-input v-model="ruleForm.nongchanpinXiaoshouUuidNumber"
                                 placeholder="销售编号" clearable  :readonly="ro.nongchanpinXiaoshouUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="销售编号" prop="nongchanpinXiaoshouUuidNumber">
                           <el-input v-model="ruleForm.nongchanpinXiaoshouUuidNumber"
                                     placeholder="销售编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="gongzuorenyuanId" name="gongzuorenyuanId" type="hidden">
            <input id="nongchanpinId" name="nongchanpinId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售数量" prop="buyNumber">
                       <el-input v-model="ruleForm.buyNumber"
                                 placeholder="销售数量" clearable  :readonly="ro.buyNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="销售数量" prop="buyNumber">
                           <el-input v-model="ruleForm.buyNumber"
                                     placeholder="销售数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="type=='info'">
                   <div>
                       <el-form-item class="input" label="销售总额" prop="nongchanpinXiaoshouXiaoshouzonge">
                           <el-input v-model="ruleForm.nongchanpinXiaoshouXiaoshouzonge"
                                     placeholder="销售总额" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="type=='info'">
                       <el-form-item class="input" label="本次利润" prop="nongchanpinXiaoshouLirun">
                           <el-input v-model="ruleForm.nongchanpinXiaoshouLirun"
                                     placeholder="本次利润" readonly></el-input>
                       </el-form-item>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="销售类型" prop="nongchanpinXiaoshouTypes">
                        <el-select v-model="ruleForm.nongchanpinXiaoshouTypes" :disabled="ro.nongchanpinXiaoshouTypes" placeholder="请选择销售类型">
                            <el-option
                                v-for="(item,index) in nongchanpinXiaoshouTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="销售类型" prop="nongchanpinXiaoshouValue">
                        <el-input v-model="ruleForm.nongchanpinXiaoshouValue"
                            placeholder="销售类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="销售时间" prop="xiaoshouTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.xiaoshouTime"
                                type="datetime"
                                placeholder="销售时间"
                                :disabled="ro.xiaoshouTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.xiaoshouTime" label="销售时间" prop="xiaoshouTime">
                            <span v-html="ruleForm.xiaoshouTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="销售备注" prop="nongchanpinXiaoshouContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.nongchanpinXiaoshouContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.nongchanpinXiaoshouContent" label="销售备注" prop="nongchanpinXiaoshouContent">
                            <span v-html="ruleForm.nongchanpinXiaoshouContent"></span>
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
                nongchanpinForm: {},
                ro:{
                    nongchanpinXiaoshouUuidNumber: false,
                    gongzuorenyuanId: false,
                    nongchanpinId: false,
                    buyNumber: false,
                    nongchanpinXiaoshouXiaoshouzonge: false,
                    nongchanpinXiaoshouLirun: false,
                    nongchanpinXiaoshouTypes: false,
                    xiaoshouTime: false,
                    nongchanpinXiaoshouContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    nongchanpinXiaoshouUuidNumber: new Date().getTime(),
                    gongzuorenyuanId: '',
                    nongchanpinId: '',
                    buyNumber: '',
                    nongchanpinXiaoshouXiaoshouzonge: '',
                    nongchanpinXiaoshouLirun: '',
                    nongchanpinXiaoshouTypes: '',
                    xiaoshouTime: '',
                    nongchanpinXiaoshouContent: '',
                    insertTime: '',
                },
                nongchanpinXiaoshouTypesOptions : [],
                gongzuorenyuanOptions : [],
                nongchanpinOptions : [],
                rules: {
                   nongchanpinXiaoshouUuidNumber: [
                              { required: true, message: '销售编号不能为空', trigger: 'blur' },
                          ],
                   gongzuorenyuanId: [
                              { required: true, message: '工作人员不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinId: [
                              { required: true, message: '农产品不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   buyNumber: [
                              { required: true, message: '销售数量不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinXiaoshouXiaoshouzonge: [
                              { required: true, message: '销售总额不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinXiaoshouLirun: [
                              { required: true, message: '本次利润不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   nongchanpinXiaoshouTypes: [
                              { required: true, message: '销售类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouTime: [
                              { required: true, message: '销售时间不能为空', trigger: 'blur' },
                          ],
                   nongchanpinXiaoshouContent: [
                              { required: true, message: '销售备注不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '录入时间不能为空', trigger: 'blur' },
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
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=nongchanpin_xiaoshou_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.nongchanpinXiaoshouTypesOptions = data.data.list;
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
         this.$http({
             url: `nongchanpin/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.nongchanpinOptions = data.data.list;
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
            nongchanpinChange(id){
                this.$http({
                    url: `nongchanpin/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.nongchanpinForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `nongchanpinXiaoshou/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.gongzuorenyuanChange(data.data.gongzuorenyuanId)
                        _this.nongchanpinChange(data.data.nongchanpinId)
                        _this.ruleForm.nongchanpinXiaoshouContent = _this.ruleForm.nongchanpinXiaoshouContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.nongchanpinXiaoshouContent = this.ruleForm.nongchanpinXiaoshouContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`nongchanpinXiaoshou/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.nongchanpinXiaoshouCrossAddOrUpdateFlag = false;
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
                this.parent.nongchanpinXiaoshouCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

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

