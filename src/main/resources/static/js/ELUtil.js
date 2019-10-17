var ELUI = new Vue({
    methods: {
        post(url, data) {
            console.log('username' + this.username);
            console.log('password' + this.password);
            axios({
                method: 'post',
                url: url,
                data: data
            }).then((response) => {
                if (response.data.code == 0) {
                    window.location.href = "/chatroom/home";
                } else {
                    elUI.showDialog(response.data.msg);
                }
            }).catch((error) => {
                elUI.showDialog(error);
            });
        },
        showDialog: function (msg) {
            this.$alert(msg, '提示', {
                confirmButtonText: '确定',
            });
        }, showError: function (msg) {
            this.$message({
                message: msg,
                center: true,
                type: 'warning'
            });
        }
    }
});