package com.cyj.tbr.controller;

import com.cyj.tbr.service.GameService;
import com.cyj.tbr.service.TwitchException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public void getGame(
            @RequestParam(value = "game_name", required = false) String gameName,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            if (gameName != null) {
                response.getWriter().print(
                        new ObjectMapper().writeValueAsString(gameService.searchGame(gameName))
                );
            } else {
                response.getWriter().print(
                        new ObjectMapper().writeValueAsString(gameService.topGames(0))
                );
            }
        } catch (TwitchException e) {
            throw new ServletException(e);
        }
    }
}
