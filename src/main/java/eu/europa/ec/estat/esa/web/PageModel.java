package eu.europa.ec.estat.esa.web;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PageModel {
    private static int PAGE = 0;
    private static int SIZE = 20;

    private HttpServletRequest request;

    public PageModel(HttpServletRequest request) {
        this.request = request;
    }

    public void initPageAndSize(){
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            PAGE = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            PAGE = Integer.parseInt(request.getParameter("size"));
        }
    }

    public static void setSIZE(int SIZE) {
        PageModel.SIZE = SIZE;
    }

    public static int getPAGE() {
        return PAGE;
    }

    public static int getSIZE() {
        return SIZE;
    }
}
