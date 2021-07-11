//

var vm = new Vue({
    el: '#kanface_app',
    data: {
        q: {
            CourseDetail: ''
        },
        showAdd: false,
        showInfo: false,
        showList: true,
        title: null,
        user: {},
        users: [],
        CourseDetails: [],
        AttendanceRecord: {},
        xss: []
    },
    created: function () {
        $.getJSON("../CourseDetail/listMyKc", function (r) {
            vm.CourseDetails = r.list;
            if (r.list.length > 0) {
                vm.AttendanceRecord.CourseDetail = vm.CourseDetails[0].id;
                $.getJSON("../ChooseCourse/listStudentByKcId?CourseDetail=" + vm.CourseDetails[0].id, function (r) {
                    vm.xss = r.list;
                    if (r.list.length > 0){
                        vm.AttendanceRecord.bkhxs = vm.xss[0].sysUser;
                    }
                })
            }
        })

    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showAdd = true;
            vm.showList = false;
            vm.title = "新增";
            vm.AttendanceRecord = {};
        }
        ,
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null
            ) {
                return;
            }

            vm.showAdd = true;
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm
                .AttendanceRecord.id ==
            null ? "../AttendanceRecord/save" : "../AttendanceRecord/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.AttendanceRecord),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        ,
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../AttendanceRecord/delete",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }
        ,
        getInfo: function (id) {
            $.get("../AttendanceRecord/info/" + id, function (r) {
                vm.AttendanceRecord = r.AttendanceRecord;
            });
        }
        ,
        info: function (id) {
            if (isNaN(id)) {
                id
                    = getSelectedRow();
                if (id == null
                ) {
                    return;
                }
            }
            vm.showAdd = false;
            vm.showList = false;
            vm.showInfo = true;
            vm.title = "详情";

            vm.getInfo(id)
        }
        ,
        reload: function (event) {
            vm.showList = true;
            vm.showInfo = false;
            vm.showAdd = false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: vm.q,
                page: page
            }).trigger("reloadGrid");
        }
    }
});