
function GetQuery(param) {
		var reg = new RegExp("(^|&)" + param + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			var sname = r[2];
			if (sname != null) {
				var query = decodeURIComponent(sname);
				query = decodeURI(query);
				return query.toString();
			}
		}
		return null;
}	
