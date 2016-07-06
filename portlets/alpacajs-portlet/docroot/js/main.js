Liferay.provide(window, 'openDialog', function(uri, id, title) {
	var opencpsDialog = Liferay.Util.openWindow(
		{
			dialog: {
				cache: false,
				cssClass: 'opencps-dialog',
				modal: true,
				
			},
			cache: false,
			id: id,
			title: title,
			uri: uri
			
		},function(evt){
			
		}
	);
});