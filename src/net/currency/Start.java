package net.currency;

import net.currency.handler.ActivityTimer;
import net.currency.listener.Currency;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Timer;

public class Start {

    private static JDABuilder jdaBuilder;
    private static JDA jda;
    private static ActivityTimer activityTimer = new ActivityTimer();

    public static void main(String[] args) {
        executeBot();
    }

    private static void executeBot() {
        jdaBuilder = JDABuilder.createDefault("discord-token");
        try {
            registerListener();
            jda = jdaBuilder.build();
            Timer timer = new Timer();
            timer.schedule(activityTimer, 0, 5000);
        } catch(LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerListener() {
        jdaBuilder.addEventListeners(new Currency());
    }

    public static JDA getJda() {
        return jda;
    }

    public static ActivityTimer getActivityHandler() { return activityTimer; }

}
