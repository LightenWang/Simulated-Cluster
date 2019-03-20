package com.pidojo;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.IOException;
import java.io.InputStream;

@ClientEndpoint
public class ClusterNodeServlet extends HttpServlet {
    private Session session;
    private String nodeId;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
    }

    @OnMessage
    public void onMessage(InputStream input) {

    }

    @OnClose
    public void onClose(CloseReason reson) {

    }
}
