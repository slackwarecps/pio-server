package br.com.fabioalvaro.pioserver;


import java.time.Duration;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class LogUtil {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());





  public void loginfo(String message) {
    logger.info("message=" + message);

  }

  public void loginfo(Object obj) {
    logger.info("message=", obj);

  }


}
