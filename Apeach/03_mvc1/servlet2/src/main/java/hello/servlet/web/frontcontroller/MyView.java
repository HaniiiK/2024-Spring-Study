package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //view 를 만드는 행위 자체를 '렌더링한다'
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response); //jsp 가 자동으로 렌더링 됨
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        //모델에 있는 객체를 모두 꺼내주어야 함 + 꺼낸 후 request 에 모두 담아놈
        //즉, model 에 있는 데이터를 request attribute 로 바꾸는 역할
        //대신 HttpServletRequest.setAttribute 는 어디까지나 jsp 담아두는 역할. 다른걸 담아두기 위해선 다른 걸 사용해야함
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
