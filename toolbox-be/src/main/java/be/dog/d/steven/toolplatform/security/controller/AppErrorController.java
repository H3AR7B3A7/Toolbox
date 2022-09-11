package be.dog.d.steven.toolplatform.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String getErrorPath(HttpServletResponse response) {
        log.warn("Server side error page reached: {} - {}", response.getStatus(), response.getHeaderNames());
        return "redirect:/error.html";
    }
}