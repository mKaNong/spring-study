package com.ahdy.xem.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
@RestController
@Controller
public class PageController {

    @RequestMapping("index")
    public String index(){
        System.out.println("access index page...");
        return "index";
    }

    //@RequestMapping(value="/{module}/{module2}/{page}")
    public String commonController(@PathVariable String module,
                                   @PathVariable String module2,
                                   @PathVariable String page,
                                   HttpServletRequest request, HttpServletResponse response) {
        System.out.println("access page3 " + page);
        if(!page.toLowerCase().endsWith("html")){
            returnResourcesToPage(request, response);
            return null;
        }
        return module + "/" + module2 + "/" + page;
    }


    //@RequestMapping(value="/{module}/{page}")
    public String commonController2(@PathVariable String module,
                                    @PathVariable String page,
                                    HttpServletRequest request, HttpServletResponse response) {
        System.out.println("access page2 " + page);
        if(!page.toLowerCase().endsWith("html")){
            returnResourcesToPage(request, response);
            return null;
        }
        return module + "/" + page;
    }

    @RequestMapping(value="/{page}")
    public String commonController(@PathVariable String page, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("access page1 " + page);
        if(!page.toLowerCase().endsWith("html")){
            returnResourcesToPage(request, response);
            return null;
        }
        return page;
    }


    public void returnResourcesToPage(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String[] arr = uri.split("static/");
        String resourceName = "index.html";
        if (arr.length > 1) {
            resourceName = arr[1];
        }
        String url = PageController.class.getResource("/").getPath() + "templates/" + resourceName;
        try {
            FileReader reader = new FileReader(new File(url));
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            response.getOutputStream().write(sb.toString().getBytes());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
