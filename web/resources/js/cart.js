var vm = new Vue({
    el:"#app",
    data:{
        totalMoney: 0,
        productList: [],
        checkAllFlag: false,
        delFlag: false,
        curProduct: ''
    },
    filters:{
        formatMoney: function(value) {
            return "¥" + value.toFixed(2);
        }
    },
    mounted:function () {
        Vue.nextTick(function () {
            vm.cartView();
        });
    },
    methods:{
        cartView: function () {
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

        //全选
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
        } ,

        //
    }
});

Vue.filter("money",function(value, type){
    return "￥ "+value.toFixed(2)+type;
});
