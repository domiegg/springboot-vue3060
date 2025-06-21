import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import gongzuorenyuan from '@/views/modules/gongzuorenyuan/list'
    import news from '@/views/modules/news/list'
    import nongchanpin from '@/views/modules/nongchanpin/list'
    import nongchanpinXiaoshou from '@/views/modules/nongchanpinXiaoshou/list'
    import pinkunhu from '@/views/modules/pinkunhu/list'
    import singleSeach from '@/views/modules/singleSeach/list'
    import config from '@/views/modules/config/list'
    import dictionaryCangku from '@/views/modules/dictionaryCangku/list'
    import dictionaryEwaishouru from '@/views/modules/dictionaryEwaishouru/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryNongchanpin from '@/views/modules/dictionaryNongchanpin/list'
    import dictionaryNongchanpinXiaoshou from '@/views/modules/dictionaryNongchanpinXiaoshou/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionarySingleSeach from '@/views/modules/dictionarySingleSeach/list'
    import dictionaryYunshukunnan from '@/views/modules/dictionaryYunshukunnan/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryCangku',
        name: '仓库',
        component: dictionaryCangku
    }
    ,{
        path: '/dictionaryEwaishouru',
        name: '是否有额外收入',
        component: dictionaryEwaishouru
    }
    ,{
        path: '/dictionaryGonggao',
        name: '助农政策类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryNews',
        name: '农产品经济数据类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryNongchanpin',
        name: '农产品类型',
        component: dictionaryNongchanpin
    }
    ,{
        path: '/dictionaryNongchanpinXiaoshou',
        name: '销售类型',
        component: dictionaryNongchanpinXiaoshou
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionarySingleSeach',
        name: '单页数据类型',
        component: dictionarySingleSeach
    }
    ,{
        path: '/dictionaryYunshukunnan',
        name: '是否存在运输困难',
        component: dictionaryYunshukunnan
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '助农政策',
        component: gonggao
      }
    ,{
        path: '/gongzuorenyuan',
        name: '工作人员',
        component: gongzuorenyuan
      }
    ,{
        path: '/news',
        name: '农产品经济数据信息',
        component: news
      }
    ,{
        path: '/nongchanpin',
        name: '农产品',
        component: nongchanpin
      }
    ,{
        path: '/nongchanpinXiaoshou',
        name: '农产品售卖',
        component: nongchanpinXiaoshou
      }
    ,{
        path: '/pinkunhu',
        name: '贫困户',
        component: pinkunhu
      }
    ,{
        path: '/singleSeach',
        name: '单页数据',
        component: singleSeach
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
