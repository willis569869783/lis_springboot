var title = "";
var url = "";
var $;
var layer;
layui.use([ 'jquery', 'table', 'layer', 'form', 'laydate' ], function() {
	// 加载layui模块，使用其推荐的【预先加载】方式，详见官网【模块规范】一节
	$ = layui.$;
	var table = layui.table;
	layer = layui.layer;
	var form = layui.form;
	var laydate = layui.laydate;
	laydate.render({
		elem : '#vip-user' // 或 elem: document.getElementById('test')、elem:
	// lay('#test') 等
	});
	laydate.render({
		elem : '#vip-user2' // 或 elem:
	// document.getElementById('test')、elem:
	// lay('#test') 等
	});
	laydate.render({
		elem : '#search_beginDate' // 或 elem:
	// document.getElementById('test')、elem:
	// lay('#test') 等
	});
	laydate.render({
		elem : '#search_endDate' // 或 elem:
	// document.getElementById('test')、elem:
	// lay('#test') 等
	});
	// 记录选中的数据:做缓存使用,作为参数传递给后台
	var ids = new Array();
	// 当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
	var table_data = new Array();
	// 显示所有学生
	table.render({
		elem : '#test',
		url : '/vip-user/queryByPage',
		method : 'post',
		page : true,
		toolbar: '#toolbarDemo',
		defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
			title: '提示',
			layEvent: 'LAYTABLE_TIPS',
			icon: 'layui-icon-tips'
		}],
//		height : $(document).height() - $('#vip-user-tbl').offset().top
//				- 20,
		height : 'full-68',
		cols : [ [ {
			type : 'checkbox',
			fixed : 'left'
		}, {
			field : 'username',
			title : '会员账号',
			fixed : 'center'
		}, {
			field : 'name',
			title : '会员姓名',
			fixed : 'center'
		}, {
			field : 'phone',
			title : '会员电话',
			fixed : 'center'
		}, {
			field : 'address',
			title : '会员地址',
			fixed : 'center'
		}, {
			field : 'createTime',
			title : '创建时间',
			fixed : 'center'
		}, {
			fixed : 'right',
			title : '操作',
			toolbar : '#barDemo',
			width : 150
		} ] ],
		// 表格容器id，用于表格重载
		id : 'test',
		done : function(res, curr, count) {
			// 数据表格加载完成时调用此函数
			// 如果是异步请求数据方式，res即为你接口返回的信息。
			// 如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			if (res.count == 0) { // 没有查询到数据隐藏分页栏
				$(".layui-none").hide(); // 隐藏无数据
				$(".layui-table-page").hide(); // 隐藏分页
			} else {
				// 设置全部数据到全局变量
				table_data = res.data;

				// 在缓存中找到id ,然后设置data表格中的选中状态
				// 循环所有数据，找出对应关系，设置checkbox选中状态
				for (var i = 0; i < res.data.length; i++) {
					for (var j = 0; j < ids.length; j++) {
						// 数据id和要勾选的id相同时checkbox选中
						if (res.data[i].vipUserId == ids[j]) {
							// 这里才是真正的有效勾选
							res.data[i]["LAY_CHECKED"] = 'true';
							// 找到对应数据改变勾选样式，呈现出选中效果
							var index = res.data[i]['LAY_TABLE_INDEX'];
							$(
									'.layui-table tr[data-index=' + index
											+ '] input[type="checkbox"]').prop(
									'checked', true);
							$(
									'.layui-table tr[data-index=' + index
											+ '] input[type="checkbox"]')
									.next().addClass('layui-form-checked');
						}
					}
				}
				// 设置全选checkbox的选中状态，只有改变LAY_CHECKED的值，
				// table.checkStatus才能抓取到选中的状态
				var checkStatus = table.checkStatus('vip-user-tbl');
				if (checkStatus.isAll) {
					$('.layui-table th[data-field="0"] input[type="checkbox"]')
							.prop('checked', true);
					$('.layui-table th[data-field="0"] input[type="checkbox"]')
							.next().addClass('layui-form-checked');
				}
			}
		}
	});
	//头工具栏事件
	table.on('toolbar(test)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch(obj.event) {
			case 'add-vip-user-btn':
				// 每次显示前重置表单
				$('#vip-user-form')[0].reset();
				// 清空表单中id值
				$("input[name='id']").val('');
				title = "添加学生";
				url = "add";
				// 获取数据填充专业下拉框值
//				$.ajax({
//					url : "major/queryAll",
//					type : "get",
//					dataType : "json",
//					success : function(result) {
//						$("#majorId").empty().append(new Option('请选择专业', '')); // 清空下拉框
//						$.each(result, function(index, item) {
//							$("#majorId").append(new Option(item.name, item.id)); // 动态添加下拉选项
//						});
//						layui.form.render("select"); // 渲染下拉框
//					}
//				});
				// 打开对话框
				openDialog();
				break;
				//删除
			case 'delete-vip-user-btn':
				if (ids.length > 0) {
					layer.confirm("确定删除选中的" + ids.length + "条数据吗？", {
						icon : 3,
						title : '提示信息'
					}, function(index) {

						$.ajax({
							url : "/vip-user/deleteMore",
							type : "POST",
							data : "ids=" + ids.join(),
							dataType : 'json',
							success : function(data) {
								if (data.statue == 0) {
									layer.close(index);
									layer.msg(data.msg);
									table.reload('test');
								} else {
									layer.msg('删除失败');
								}
							}
						});

					})
				} else {
					layer.msg("请选择需要删除的记录");
				}
				break;
			case 'getCheckData':
				var data = checkStatus.data;
				layer.alert(JSON.stringify(data));
				break;
			case 'getCheckLength':
				var data = checkStatus.data;
				layer.msg('选中了：' + data.length + ' 个');
				break;
			case 'isAll':
				layer.msg(checkStatus.isAll ? '全选' : '未全选');
				break;

				//自定义头工具栏右侧图标 - 提示
			case 'LAYTABLE_TIPS':
				layer.alert('这是工具栏右侧自定义的一个图标按钮');
				break;
		};
	});

	//监听行工具事件
	table.on('tool(test)', function(obj) {
		var data = obj.data;
		var event = obj.event;
		//console.log(obj)
		if(event === 'del') {
			layer.confirm('确定删除该学生吗？', function(index) {
				// ajax方式删除学生
				$.ajax({
					url : '/vip-user/deleteMore',
					type : "post",
					data : 'ids=' + data.vipUserId,
					dataType : 'json',
					success : function(data) {
						if (data.statue == 0) {
							layer.msg(data.msg);
							table.reload('vip-user-tbl');
						} else {
							layer.msg('删除失败');
						}
						table.reload('test');
					},
					error : function() {
						console.log("ajax error");
					}
				});
				layer.close(index);
			});
		} else if(event === 'edit') {
			layer.prompt({
				formType: 2,
				value: data.email
			}, function(value, index) {
				obj.update({
					email: value
				});
				layer.close(index);
			});
		} else if(event === 'update-vip-user'){
			form.val('vip-user-form', {
				"vipUserId" : data.vipUserId,
				"name" : data.name,
				"username" : data.username,
				"phone" : data.phone,
				"address" : data.address
			});
			title = "更新用户";
			url = "update";
			openDialog();
		}
	});
	// 复选框选中监听,将选中的id 设置到缓存数组,或者删除缓存数组
	table.on('checkbox(test)', function(obj) {
		if (obj.checked) {
			if (obj.type == 'one') { // 单个复选框
				if (!isExist(obj.data.vipUserId, ids)) {
					ids.push(obj.data.vipUserId);
				}
			} else { // 全选复选框
				for (var i = 0; i < table_data.length; i++) {
					if (!isExist(table_data[i].vipUserId, ids)) { // 数组中不存在，则添加
						ids.push(table_data[i].vipUserId);
					}
				}
			}
		} else {
			if (obj.type == 'one') {
				for (var i = 0; i < ids.length; i++) {
					if (ids[i] == obj.data.vipUserId) {
						ids.splice(i, 1);
					}
				}
			} else {
				for (var i = 0; i < ids.length; i++) {
					for (var j = 0; j < table_data.length; j++) {
						if (ids[i] == table_data[j].vipUserId) {
							ids.splice(i, 1);
							i--; // 删除的时候数组长度也在动态变化
							break;
						}
					}
				}
			}
		}
	});
	// 显示添加学生弹出层
	$('#add-vip-user-btn').click(function() {
		// 每次显示前重置表单
		$('#vip-user-form')[0].reset();
		// 清空表单中id值
		$("input[name='id']").val('');
		title = "添加学生";
		url = "add";
		// 获取数据填充专业下拉框值
		$.ajax({
			url : "major/queryAll",
			type : "get",
			dataType : "json",
			success : function(result) {
				$("#majorId").empty().append(new Option('请选择专业', '')); // 清空下拉框
				$.each(result, function(index, item) {
					$("#majorId").append(new Option(item.name, item.id)); // 动态添加下拉选项
				});
				layui.form.render("select"); // 渲染下拉框
			}
		});
		// 打开对话框
		openDialog();
	});
	$("#deleteMore_btn").click(function() {
		if (ids.length > 0) {
			layer.confirm("确定删除选中的" + ids.length + "条数据吗？", {
				icon : 3,
				title : '提示信息'
			}, function(index) {

				$.ajax({
					url : "/vip-user/deleteMore",
					type : "POST",
					data : "ids=" + ids.join(),
					dataType : 'json',
					success : function(data) {
						if (data.statue == 0) {
							layer.close(index);
							layer.msg(data.msg);
							table.reload('test');
						} else {
							layer.msg('删除失败');
						}
					}
				});

			})
		} else {
			layer.msg("请选择需要删除的记录");
		}
	});
	/*
	 * //批量删除 $("#deleteMore_btn").click(function(){ var checkStatus =
	 * table.checkStatus('vip-user-tbl'), data = checkStatus.data, ids =
	 * []; if(data.length > 0) { layer.confirm("确定删除选中的"+data.length+"条数据吗？",
	 * {icon: 3, title: '提示信息'}, function (index) { for (var i in data) {
	 * ids.push(data[i].id); } $.ajax({ url : "vip-user/deleteMore", type :
	 * "POST", data : "ids="+ids.join(), dataType : 'json', success :
	 * function(data) { if (data.statue == 0) { layer.close(index);
	 * layer.msg(data.msg); table.reload('vip-user-tbl'); } else {
	 * layer.msg('删除失败'); } } }); }) }else{ layer.msg("请选择需要删除的记录"); } });
	 */
	// 添加学生表单提交
	form.on('submit(vip-user-form-submit)', function(data) {
		// ajax方式添加学生
		$.ajax({
			url : "/vip-user/" + url,
			type : "POST",
			data : data.field,
			// contentType: 'application/json',
			dataType : 'json',
			success : function(data) {
				if (data.statue == 0) {
					layer.close(layer.index);
					layer.msg(data.msg);
					table.reload('test');
				} else {
					layer.msg('添加失败');
				}
			},
			error : function() {
				console.log("ajax error");
			}
		});
		// 阻止表单跳转
		return false;
	});

	// 监听行工具栏事件：删除学生与更新学生
	table.on('tool(vip-user-tbl)', function(obj) {
		// 获取当前行数据和lay-event的值
		var data = obj.data;
		var event = obj.event;

		// 删除学生事件
		if (event === 'deleteStudentListen') {
			layer.confirm('确定删除该学生吗？', function(index) {
				// ajax方式删除学生
				$.ajax({
					url : 'vip-user/deleteMore',
					type : "post",
					data : 'ids=' + data.id,
					dataType : 'json',
					success : function(data) {
						if (data.statue == 0) {
							layer.msg(data.msg);
							table.reload('vip-user-tbl');
						} else {
							layer.msg('删除失败');
						}
					},
					error : function() {
						console.log("ajax error");
					}
				});
				layer.close(index);
			});
		}

		// 更新学生事件
		if (event === 'update-vip-user') {
			// 获取数据填充专业下拉框值
//			$.ajax({
//				url : "major/queryAll",
//				type : "get",
//				dataType : "json",
//				success : function(result) {
//					$("#majorId").empty().append(new Option('请选择专业', ''));
//					$.each(result, function(index, item) {
//						$("#majorId").append(new Option(item.name, item.id));
//						$("#majorId").val(data.majorId);
//					});
//					layui.form.render("select");
//				}
//			});
			// 每次显示更新学生的表单前自动为表单填写该行的数据
			form.val('vip-user-form', {
				"id" : data.id,
				"name" : data.name,
				"username" : data.username,
				"phone" : data.phone,
				"address" : data.address
			});
			title = "更新用户";
			url = "update";
			openDialog();
		}
	});

	$("#search_btn").click(function() {
		table.reload('test', {
			url : "/vip-user/queryByPage",
			where : {
				username : $('#search_username').val(),
				name : $('#search_name').val()
			},
			page : {
				curr : 1
			}
		});
	});
});

function openDialog() {
	// 显示更新学生表单的弹出层
	layer.open({
		type : 1,
		title : title,
		skin : 'layui-layer-molv',
		area : [ '500px' ],
		content : $('#vip-user-layer')
	});
}
// 判断数组中是否包含指定的元素
function isExist(value, array) {
	var flag = false;
	for (var i = 0; i < array.length; i++) {
		if (array[i] == value) {
			flag = true;
			break;
		}
	}
	return flag;
}