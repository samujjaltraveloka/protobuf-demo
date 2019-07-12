package dev.samujjal.poc.protobufdemo;

import dev.samujjal.poc.protobufdemo.generatedproto.DroolRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsoleRunner implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {
    DroolRule.Rule rule = DroolRule.Rule.newBuilder()
      .setName("Test Name")
      .setPriority(99999)
      .setDescription("This is a demo rule")
      .setAction("Test Action")
      .setCondition("Test Condition")
      .build();

    byte[] serializedRuleBytes = rule.toByteArray();


    long start = System.currentTimeMillis();
    DroolRule.Rule deserialized = DroolRule.Rule.newBuilder().mergeFrom(serializedRuleBytes).build();
    log.info("Time Taken {}", System.currentTimeMillis() - start);
    log.info(deserialized.getCondition());
    log.info(deserialized.getAction());

  }
}
