package net.currency;

import net.currency.listener.currency.USD;
import net.currency.scheduler.CurrencyTimer;
import net.currency.listener.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Timer;

public class Main {

    private static JDABuilder jdaBuilder;
    private static JDA jda;
    private static Commands commands = new Commands();
    private static CurrencyTimer currencyTimer = new CurrencyTimer();

    public static void main(String[] args) {
        executeBot();
    }

    private static void executeBot() {
        jdaBuilder = JDABuilder.createDefault(Settings.botToken);
        try {
            registerListener();
            jda = jdaBuilder.build();
            new Timer().schedule(currencyTimer, 0, Settings.activityChangeSec*1000);
        } catch(LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerCustomCommands() { commands.registerCommands(new USD()); }
    private static void registerListener() {
        registerCustomCommands();
        jdaBuilder.addEventListeners(commands);
    }

    public static JDA getJda() {
        return jda;
    }

    public static CurrencyTimer getCurrencyTimer() { return currencyTimer; }

}
