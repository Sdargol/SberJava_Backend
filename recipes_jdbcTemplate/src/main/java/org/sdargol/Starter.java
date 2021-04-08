package org.sdargol;

import org.sdargol.config.SpringConfig;
import org.sdargol.consoleManager.ConsoleManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;



public class Starter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ConsoleManager consoleManager = context.getBean("consoleManager", ConsoleManager.class);
        consoleManager.mainLoop();

    }
}









