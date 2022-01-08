package com.bankchallenge.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewUserForm implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "forward:formNewUser.jsp";

    }
}
