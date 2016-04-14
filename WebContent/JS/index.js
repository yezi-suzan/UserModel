
	var setting = {
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
				rootPId: -1
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
		$.ajax({
			type: "POST",
			url: "FindServlet",
			datatype:"json",
			complete: function(data) {
//				console.log(data.responseText);
				var zNodes =JSON.parse( data.responseText);
//				console.log(zNodes);
				$.fn.zTree.init($("#ztree"), setting, zNodes);
			},
			async: true
		});
		
			document.getElementById("chaxun").onclick=function  () {
			var name=$("input").value
			$.ajax({
				type:"post",
				url:"ProfileFind",
				data: {"name":$("input").value},
				complete:function(data){
					console.log(data)
				},
				async:true
			});
				
			}
	})
