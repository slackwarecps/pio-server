package br.com.fabioalvaro.pioserver;


import java.time.Duration;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PioController {


  @Autowired
  LogUtil logUtil;

    @GetMapping("/pio")
  public String pio() {
      MDC.put("codePath", "timer");

      String myPio = "piu,piu!";
      logUtil.loginfo(myPio);
      MDC.remove("codePath");

      return myPio;
  }


  @GetMapping("/pio-delay")
  public String pioDelay() throws InterruptedException {
    String myPio = "piu zzzzzzz !";

    //call api... xpto

    logUtil.loginfo("message=" + myPio);

    logUtil.loginfo("log event from the domain service");

    Instant start= Instant.now();
    Thread.sleep(10000); // simulating an expensive operation
    Duration duration=Duration.between(start,Instant.now());

    MDC.put("thirdPartyCallDuration",String.valueOf(duration.getNano()));
    logUtil.loginfo("call to third-party service successful!");
    MDC.remove("thirdPartyCallDuration");


    return myPio;

  }




}
