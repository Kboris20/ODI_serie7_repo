/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hearc.ODI.utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author boris.klett
 */
public class CheckSessions {

    public static void checkSess(HttpSession session, String prenom, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String val = (String) session.getAttribute(prenom);

            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/DisplayInformations?prenom=" + prenom);
            if (val == null) {
                dispatcher = request.getRequestDispatcher("/AskNameToStoreSession?prenom=" + prenom);

            }
            dispatcher.forward(request, response);
        } catch (NullPointerException e) {
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/AskNameToStoreSession?prenom=" + prenom);
            dispatcher.forward(request, response);
        }
    }

    public static String checkSes(HttpSession session, String prenom, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String val = (String) session.getAttribute(prenom);
            if (val == null) {
                prenom = null;
            }

        } catch (NullPointerException e) {
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/AskNameToStoreSession?prenom=" + prenom);
            dispatcher.forward(request, response);
        }
        return prenom;
    }

}
