package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


@RestController
@org.springframework.boot.autoconfigure.EnableAutoConfiguration
@org.springframework.stereotype.Controller
public class HelloController {

    HashMap<String,String> h = new HashMap<String,String>();
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

     @RequestMapping("/welcome")
     public String loginMessage() {
          return "welcome";
     }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void redirect(@PathVariable String id, HttpServletResponse resp) throws Exception {

    final String url = h.get(id);

        if (url != null) {
            System.out.println(url);
            resp.sendRedirect(url);
        }
        else
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<String> save(HttpServletRequest req) {

        final String queryParams = (req.getQueryString() != null) ? "?" + req.getQueryString() : "";
        final String url = (req.getRequestURI() + queryParams).substring(1);
        final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

        if (urlValidator.isValid(url)) {
            final String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();

            h.put(id,url);

            System.out.println(h);

            return new ResponseEntity<>("http://localhost:8080/" + id, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
