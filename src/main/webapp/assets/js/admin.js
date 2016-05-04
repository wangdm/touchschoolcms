function resizeDashboard(){
	var height = $(window).height()-58;
	var width = $(window).width()-$("#dashboard_menu").width();
	console.log(width);
	$("#dashboard_menu").css("height", height);
	$("#dashboard_menu").css("max-height", height);
	$("#dashboard_content").css("height", height);
	$("#dashboard_content").css("max-height", height);
	$("#dashboard_content").css("width", width);
	$("#dashboard_content").css("max-width", width);
}

function doAdminAction(action){
    $.ajax({
        "url": action,
        "type": "get",
    }).success(function(data){
        $("#dashboard_content").html(data);
    }).fail(function(){
    	console.log("connect "+this.url+" failed!");
    });
}