function clear_search(obj,count){
 if (count==1) {
    obj.value='';
    count=0;
 }
 return count;
}

function return_search(obj,count,text){
 if(obj.value=='') {
    obj.value=text;
    count=1;
 }
 return count;
}

function confirmation_(href_val_par,text){
    var flag=confirm(text);
    if (flag){
        window.location.href=href_val_par;
    }
}

function getBrowserInfo() {
	var t,v = undefined;
	if (window.opera) t = 'Opera';
	else if (document.all) {
		t = 'IE';
		var nv = navigator.appVersion;
		var s = nv.indexOf('MSIE')+5;
		v = nv.substring(s,s+1);
	}
	else if (navigator.appName) t = 'Netscape';
	return {
		type:t,
		version:v
	};
}

function bookmark(a){
	var url = window.document.location;
	var title = window.document.title;
	var b = getBrowserInfo();
	if (b.type == 'IE' && 7 > b.version && b.version >= 4) window.external.AddFavorite(url,title);
	else if (b.type == 'Opera') {
		a.href = url;
		a.rel = "sidebar";
		a.title = url+','+title;
		return true;
	}
	else if (b.type == "Netscape") window.sidebar.addPanel(title,url,"");
	else alert("Нажмите CTRL-D, чтобы добавить страницу в закладки.");
	return false;
}

function makeHomePage(objSrc)
{
    var homepage = window.document.location;
    if (objSrc.style.behavior)
    {
        objSrc.setHomePage(homepage);
    }
    else if (netscape
              && netscape.security
              && netscape.security.PrivilegeManager
              && navigator.preference)
    {
        netscape.security.PrivilegeManager.enablePrivilege("UniversalPreferencesWrite");
        navigator.preference("browser.startup.homepage", homepage);
    }
}
