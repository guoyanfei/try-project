package com.guo.code.snippets.tools.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jTest.class);

        BasicConfigurator.configure();

        logger.setLevel(Level.INFO);

        logger.debug("this is debug");
        String aaa = (String) null;
        if (aaa == null) {
            System.out.println(aaa);
        }
        logger.info("this.info");
        logger.warn("this is warn");
        logger.error("this is orror");
        logger.fatal("this is fatal");
        return;
    }
}