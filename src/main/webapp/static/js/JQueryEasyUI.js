

	

/**
 * JQueryEasyUI 增加tab页函数
 * @param tabId tab的唯一标识ID
 * @param title tab页标题
 * @param url	tab页请求地址
 */
function addTab(tabId,title, url){
	
    if ($('#'+tabId).tabs('exists', title)){
        $('#'+tabId).tabs('select', title);
        
        //当前tab
        var current_tab = $('#'+tabId).tabs('getSelected');
        $('#'+tabId).tabs('update',{
        	tab:current_tab,
        	options : {
        		content : '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>'
        	}
        });
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        $('#'+tabId).tabs('add',{
            title:title,
            content:content,
            closable:true
        });
    }
}