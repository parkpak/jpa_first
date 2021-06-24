package com.example.jpa.web.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.jpa.web.common.constant.HtmlUriConstant.URI_HOME;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final String LOGIN_SESSION = "login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug("=========== Login Interceptor PreHandler ==========");

        HttpSession session = request.getSession();
        Object user = session.getAttribute(LOGIN_SESSION);

        if (user != null) {
            log.info(user.toString());
//            log.info("로그인 세션 삭제");
//            session.removeAttribute(LOGIN);
            response.sendRedirect(URI_HOME);
            return false;   // 이후 controller 실행하지 않음.
        }
//        return false;   // exit..
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        log.info("============= Login Interceptor PostHandler ================");

        HttpSession session = request.getSession();
        ModelMap modelMap = modelAndView.getModelMap();
        Object user = modelMap.get("user");

        if (user != null) {
            log.info("new login success");
            session.setAttribute(LOGIN_SESSION, user);
            response.sendRedirect(URI_HOME);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
