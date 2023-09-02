package com.example.javaspring.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  public void log(){
      logger.warn("warn");
      logger.error("error");
      logger.info("info");
      logger.debug("debug");
      logger.trace("trace");
  }

}
