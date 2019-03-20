package com.pidojo;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class ClusterNodeServlet extends HttpServlet {
    private Session session;
    private String nodeId;

    @Override
    public void init() throws ServletException {
        this.nodeId = this.getInitParameter("nodeId");
        String path = this.getServletContext().getContextPath() + "/clusterNodeSocket" + this.nodeId;
        try {
            URI uri = new URI("ws", "localhost:8080", path, null, null);
            this.session = ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
        } catch (URISyntaxException | IOException | DeploymentException e) {
            throw new ServletException("Cannot connect to" + path + ".", e);
        }
    }

    @Override
    public void destroy() {
        try {
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
