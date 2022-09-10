package com.store.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        List<String> items;
        StringBuilder sb = new StringBuilder();

        if (session.getAttribute("items") != null && session.getAttribute("items") instanceof List){
            items = (ArrayList<String>)session.getAttribute("items");
        } else {
            items = new ArrayList<>();
        }

        items.add(request.getParameter("item"));
        session.setAttribute("items", items);
        //sb.append("<html><body><h1>Shopping Cart</h1>");


        items.forEach(s -> {
            sb.append("<li>").append(s).append("</li>");
        });

        //sb.append("</ul>");

        //sb.append("<a href=\"shop.html\">I want to continue shopping</a></body></html>");
        //writer.write(sb.toString());
        //writer.close();

        requestDispatcher.forward(request, response);
    }
}
