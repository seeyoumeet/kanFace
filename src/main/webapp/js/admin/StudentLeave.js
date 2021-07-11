$(function () {
    $("#jqGrid").jqGrid({
        url: '../StudentLeave/list',
        datatype: "json",
        colModel: [
            {
                label: 'id',
                name: 'id',
                index: 'id',
                width: 50,
                key: true,
                hidden: true,
                formatter: function (v, a, r) {
                    return "<a onclick='vm.info(\"" + r.id + "\")'>" + v + " </a>"
                }
            },
            {
                label: '请假学生',
                name: 'sysUserEntity.username',
                index: 'sysUserEntity.username',
                width: 80
            },
            {
                label: '请假类型',
                name: 'qjlx',
                index: 'qjlx',
                width: 80
            },
            {
                label: '请假开始时间',
                name: 'beginTime',
                index: 'begin_time',
                width: 80
            },
            {
                label: '请假结束时间',
                name: 'endTime',
                index: 'end_time',
                width: 80
            },
            {
                label: '请假天数',
                name: 'days',
                index: 'days',
                width: 80
            },
            {
                label: '请假原因',
                name: 'content',
                index: 'content',
                width: 80
            },
            {
                label: '老师审批',
                name: 'lssp',
                index: 'lssp',
                width: 80, formatter: function (value, options, row) {
                    if (value === 0) {
                        return '<span class="label label-info">未处理</span>';
                    }
                    if (value === 1) {
                        return '<span class="label label-success">通过</span>';
                    }
                    if (value === 2) {
                        return '<span class="label label-danger">不通过</span>';
                    }
                }
            },
            {
                label: '管理员审批',
                name: 'glysp',
                index: 'glysp',
                width: 80, formatter: function (value, options, row) {
                    if (value === 0) {
                        return '<span class="label label-info">未处理</span>';
                    }
                    if (value === 1) {
                        return '<span class="label label-success">通过</span>';
                    }
                    if (value === 2) {
                        return '<span class="label label-danger">不通过</span>';
                    }
                }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });


});

var vm = new Vue({
    el: '#kanface_app',
    data: {
        q: {
            sysUser: ''
        },
        showAdd: false,
        showInfo: false,
        showList: true,
        title: null,
        users: [],

        lasps: [{"id": 0, "name": "未处理"}, {"id": 1, "name": "通过"}, {"id": 2, "name": "不通过"}],
        sysUsers: [],


        StudentLeave: {},
    },
    created: function () {

        $.getJSON("../sys/user/list2", function (r) {
            vm.sysUsers = r.list;
        })

    },
    methods: {
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            vm.showAdd = true;
            vm.showList = false;
            vm.title = "新增";
            vm.StudentLeave = {};
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
                .StudentLeave.id ==
            null ? "../StudentLeave/save" : "../StudentLeave/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.StudentLeave),
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
                    url: "../StudentLeave/delete",
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
            $.get("../StudentLeave/info/" + id, function (r) {
                vm.StudentLeave = r.StudentLeave;
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