;
(function() {
	var setting = {
		async: {
			autoParam: [],
			contentType: "application...",
			dataFilter: null,
			dataType: "text",
			enable: false,
			otherParam: [],
			type: "post",
			url: ""
		},
		callback: {
			beforeAsync: null,
			beforeCheck: null,
			beforeClick: null,
			beforeCollapse: null,
			beforeDblClick: null,
			beforeDrag: null,
			beforeDragOpen: null,
			beforeDrop: null,
			beforeEditName: null,
			beforeExpand: null,
			beforeMouseDown: null,
			beforeMouseUp: null,
			beforeRemove: null,
			beforeRename: null,
			beforeRightClick: null,
			onAsyncError: null,
			onAsyncSuccess: null,
			onCheck: null,
			onClick: null,
			onCollapse: null,
			onDblClick: null,
			onDrag: null,
			onDragMove: null,
			onDrop: null,
			onExpand: null,
			onMouseDown: null,
			onMouseUp: null,
			onNodeCreated: null,
			onRemove: null,
			onRename: null,
			onRightClick: null
		},
		data: {
			keep: {
				leaf: false,
				parent: false
			},
			key: {
				checked: "checked",
				children: "children",
				name: "name",
				title: "",
				url: "url"
			},
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "parent_id",
				rootPId: 0
			}
		},
		view: {
			addDiyDom: null,
			addHoverDom: null,
			autoCancelSelected: true,
			dblClickExpand: true,
			expandSpeed: "fast",
			fontCss: {},
			nameIsHTML: false,
			removeHoverDom: null,
			selectedMulti: true,
			showIcon: true,
			showLine: true,
			showTitle: true,
			txtSelectedEnable: false
		}
	};

	$(document).ready(function() {
		var zNodes;
		console.log(1);
		$.ajax({
			type: "get",
			url: "../org/servlet/FindServlet.java",
			complete: function(data) {
				console.log(data);
				zNodes = data;
				$.fn.zTree.init($("#ztree"), setting, zNodes);
			},
			async: true
		});
	})
})