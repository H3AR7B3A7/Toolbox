package be.dog.d.steven.toolboxadapter.controller;

import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String getErrorPath(HttpServletResponse response) {
        log.warn("Server side error page reached: {} - {}", response.getStatus(), response.getHeaderNames());
        return "redirect:/error.html";
    }
}
