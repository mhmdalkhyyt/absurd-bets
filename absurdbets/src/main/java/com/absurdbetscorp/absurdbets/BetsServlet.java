package com.absurdbetscorp.absurdbets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Bets;
import repositories.BetsRepository;


import java.io.IOException;

@WebServlet(name="BetsServlet", urlPatterns = {"/Bets"})
public class BetsServlet extends HttpServlet {

    //private BetsRepository repository = new BetsRepository();
    private BetsRepository repository = new BetsRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String userId = request.getParameter("userId");
        //String betId = request.getParameter("betId");
        //String amount = request.getParameter("amount");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int betId = Integer.parseInt(request.getParameter("betId"));
        Long amount = Long.parseLong(request.getParameter("amount"));


        var action = request.getParameter("action");
        action = (action == null) ? "create" : action;

        var bets = new Bets(betId, userId, amount);

        if (action.equals("create")) {
            repository.insert(bets);
        } else if (action.equals("update")) {
            var idString = request.getParameter("id");
            var id = Long.parseLong(idString);
            bets.setBetId(betId);

            repository.update(bets);
        } else if (action.equals("delete")) {
            var idString = request.getParameter("id");
            var id = Long.parseLong(idString);

            repository.delete(betId);
        }

        response.sendRedirect(request.getContextPath() + "/persons");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   var action = request.getParameter("action");
        action = (action == null) ? "index" : action;

        if (action.equals("create")){
            showCreatePersonForm(request, response);
        }
        else if(action.equals("update")){
            showUpdatePersonForm(request, response);
        }
        else{
            listPersons(request, response);
        }*/
    }

    private void listPersons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bets = repository.getAllBets();
        request.setAttribute("bets", bets);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/persons/index.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowCreateBetIdForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/persons/create.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowUpdateBetIdForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var idString = request.getParameter("id");
        var id = Integer.parseInt(idString);

        var betId = repository.getBetId(id);
        request.setAttribute("BetId", betId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/persons/update.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*     var idString = request.getParameter("id");
        var id = Long.parseLong(idString);

        repository.delete(id);

        response.sendRedirect(request.getContextPath() + "/persons");*/
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var idString = request.getParameter("id");
        var id = Long.parseLong(idString);
        var firstName = request.getParameter("firstName");
        var lastName = request.getParameter("lastName");
        var email = request.getParameter("email");
/*
        var person = repository.getPersonById(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);

        repository.update(person);

        response.sendRedirect(request.getContextPath() + "/persons");
    }*/
    }
}