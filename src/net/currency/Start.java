package net.currency;

import net.currency.handler.ActivityHandler;
import net.currency.listener.Currency;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Start {

    private static JDABuilder jdaBuilder;
    private static JDA jda;
    private static ActivityHandler activityHandler = new ActivityHandler();

    public static void main(String[] args) {
        executeBot();
    }

    private static void executeBot() {
        jdaBuilder = JDABuilder.createDefault("discord-token");
        try {
            registerListener();
            jda = jdaBuilder.build();
            activityHandler.getData();
        } catch(LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void restartBot() {
        jda.shutdown();
        executeBot();
    }

    private static void registerListener() {
        jdaBuilder.addEventListeners(new Currency());
    }

    public static JDA getJda() {
        return jda;
    }

    public static JDABuilder getJdaBuilder() {
        return jdaBuilder;
    }

    public static ActivityHandler getActivityHandler() { return activityHandler; }

}
