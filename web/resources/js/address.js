new Vue({
    el:".container" ,
    data:{
        isMore:false,
        limitNum : 3,
        addressList:[],
        curIndex: 0,
        shippingWay: 1
    },
    mounted: function () {
        this.$nextTick(function () {
            this.getAddressList();
        });
    },
    computed:{
        addressFilter: function () {
            return this.addressList.slice(0,this.limitNum);
        }
    },
    methods:{
        getAddressList: function() {
            var _this = this;
            this.$http.get("resources/data/address.json").then(function(response) {
                var res = response.data;
                if (res.status == "0") {
                    _this.addressList = res.result;
                }
            });
        },

        //more方法
        loadMore:function () {
            this.isMore = !this.isMore;
            if(this.isMore){
                this.limitNum = this.addressList.length;
            } else {
                this.limitNum = 3;
            }
        },

        //设置默认地址
        setDefault: function (addressId) {
            this.addressList.forEach(function (address, index) {
                if(address.addressId == addressId){
                    address.isDefault = true;
                } else {
                    address.isDefault = false;
                }
            });
        },




    }
});