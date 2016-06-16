package com.sample.hook.action;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class MyLoginAction extends Action {

	@Override
	public void run(HttpServletRequest req, HttpServletResponse res)
			throws ActionException {
		try {
			User user = PortalUtil.getUser(req);
			List<Role> lsRole = user.getRoles();
			int flag = 0;
			for (Role role : lsRole) {
				if (role.getTitle(Locale.getDefault()).trim().equals("OCPS_CITIZEN")) {flag=1;break; }
				else if (role.getTitle(Locale.getDefault()).trim().equals("OCPS_EMPLOYE")) {flag=2;break; }
				else if (role.getTitle(Locale.getDefault()).trim().equals("OCPS_MANAGER")) {flag=3;break; }
				else if (role.getTitle(Locale.getDefault()).trim().equals("OCPS_ACCOUNTING")) {flag=4;break; }
				else if (role.getTitle(Locale.getDefault()).trim().equals("OCPS_MOTCUA")) {flag=5;break; }
			}
			if(flag == 0){
				res.sendRedirect("/group/guest");
			}else if(flag == 1){
				res.sendRedirect("/group/guest/khong-gian-lam-viec-frontoffice");
			}else if(flag == 2){
				res.sendRedirect("/group/guest/quan-ly-ho-so");
			}else if(flag == 3){
				res.sendRedirect("/group/guest/quan-tri");
			}else if(flag == 4){
				res.sendRedirect("/group/guest/quan-ly-yeu-cau-thu-phi");
			}else if(flag == 5){
				res.sendRedirect("/group/guest/tra-ket-qua");
			}
				
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MyLoginAction.class);
}
