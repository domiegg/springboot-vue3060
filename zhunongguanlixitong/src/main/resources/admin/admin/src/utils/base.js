const base = {
    get() {
        return {
            url : "http://localhost:8080/zhunongguanlixitong/",
            name: "zhunongguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhunongguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "助农管理系统"
        } 
    }
}
export default base
