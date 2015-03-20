package com.epam.aa.parser.servlet;

import com.epam.aa.parser.model.Parser;
import com.epam.aa.parser.model.TextPart;
import com.epam.aa.parser.util.Files;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by almas on 20/03/2015.
 */
@WebServlet(name = "ParserServlet", urlPatterns = "/parser")
@MultipartConfig()
public class ParserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textString = request.getParameter("text");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("parseResult.jsp");
        if (textString != null) {
            TextPart text = Parser.parse(textString, TextPart.Type.TEXT);
            request.setAttribute("text", text.stringify());
            requestDispatcher.forward(request, response);
            return;
        }
        Part filePart = request.getPart("file");
        if (filePart != null) {
            InputStream inputStream = filePart.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            request.setAttribute("text", Files.inputReaderAsString(inputStreamReader));
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/parseForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
