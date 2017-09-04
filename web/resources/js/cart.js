var vm = new Vue({
    //1.vue监听的范围
    el:"#app",

    //2.反向操作jsp的数据
    data:{
        totalMoney: 0,
        productList: [],
        checkAllFlag: false,
        delFlag: false,
        curProduct: ''
    },

    //3.过滤器是对数据的格式化
    filters:{
        formatMoney: function(value) {
            return "¥" + value.toFixed(2);
        }
    },

    //4.编译完成后所要默认执行的方法--理解为初始化
    mounted:function () {
        Vue.nextTick(function () {
            vm.cartView();
        });
    },

    //5.方法
    methods:{
        cartView: function () {
            //this 默认指向的是vue的实例
            //在方法（function）的内部this作用域要改变 所以将this提取出来
            var _this = this;
            this.$http.get("resources/data/cartData.json").then(function (res){
                _this.productList = res.data.result.list;
            });
        },

        //更新商品数量
        changeQuantity: function(product, way){
            if(way > 0){
                product.productQuantity++;
            } else{
                product.productQuantity--;
                if(product.productQuantity < 1){
                    product.productQuantity = 1;
                }
            }
            this.calcTotalPrice();
        },

        //判断商品是否被选中
        selectedProduct: function(item) {
            if (typeof item.checked == 'undefined') {
                // Vue.set(item, "checked", true);
                this.$set(item, "checked", true);
            }
            else {
                item.checked = !item.checked;
            }
            this.calcTotalPrice();
        },

        //是否全选
        checkAll: function(){
            this.checkAllFlag = !this.checkAllFlag;
            var _this = this;
            this.productList.forEach(function (item, index) {
                if(typeof item.checked =='undefined'){
                    _this.$set(item, 'checked', _this.checkAllFlag);
                } else {
                    item.checked = _this.checkAllFlag;
                }
            });
            this.calcTotalPrice();
        },

        //点击删除按钮图标后，保存所选择的item商品到变量curProduct
        delConfirm: function(item){
            this.delFlag= true;
            this.curProduct = item;
        },

        //确认删除
        delProduct:function(){
            var delIndex = this.productList.indexOf(this.curProduct);
            this.productList.splice(delIndex, 1);
            this.delFlag = false;
            this.calcTotalPrice();

            // //真正的删除是请求后台接口，根据商品ID删除，返回删除的信息
            // var _this = this;
            // this.$http.get("domain/getUserById/{ID}").then(function (res){
            //     _this.productList = res.data.result.list;
            // });
        },

        //计算总金额
        calcTotalPrice: function () {
            var _this = this;
            this.totalMoney = 0;
            this.productList.forEach(function (item,index) {
                if(item.checked){
                    _this.totalMoney += item.productQuantity*item.productPrice;
                }
            })
        },

    }
});

//全局过滤器
Vue.filter("money",function(value, type){
    return "￥ "+value.toFixed(2)+type;
});
