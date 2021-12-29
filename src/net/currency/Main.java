package net.currency;

import net.currency.listener.currency.*;
import net.currency.scheduler.CurrencyTimer;
import net.currency.listener.CommandAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Timer;

public class Main {

    private static JDABuilder jdaBuilder;
    private static JDA jda;
    private static CommandAdapter commands = new CommandAdapter();
    private static CurrencyTimer currencyTimer = new CurrencyTimer();

    public static void main(String[] args) {
        executeBot();
    }

    private static void executeBot() {
        jdaBuilder = JDABuilder.createDefault(Settings.botToken);
        try {
            registerListener();
            jda = jdaBuilder.build();
            try {
                new Timer().schedule(currencyTimer, 0, Settings.activityChangeSec*1000);
            } catch(Exception e) {
                System.exit(0);
            }
        } catch(LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerCustomCommands() {
        commands.registerCommands(new USD());
        commands.registerCommands(new EUR());
        commands.registerCommands(new GBP());
        commands.registerCommands(new CHF());
        commands.registerCommands(new SAR());
        commands.registerCommands(new BTC());
        commands.registerCommands(new ETH());
        commands.registerCommands(new XRP());
        commands.registerCommands(new BCH());
        commands.registerCommands(new LTC());
        commands.registerCommands(new DOGE());
    }

    private static void registerListener() {
        registerCustomCommands();
        jdaBuilder.addEventListeners(commands);
    }

    public static JDA getJda() {
        return jda;
    }

    public static CurrencyTimer getCurrencyTimer() { return currencyTimer; }

}
