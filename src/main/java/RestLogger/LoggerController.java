package RestLogger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoggerController
{
    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    @RequestMapping("/log")
    public String greeting(@RequestParam(value="log", defaultValue = "No Value Provided") String log,HttpServletRequest request)
    {
        logger.info(request.getLocalAddr() + " " + request.getMethod() + " " + log);
        return log;
    }

}
