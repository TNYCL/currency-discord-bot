package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class GBP extends CommandModule {

    public GBP() { super("sterlin", Settings.prefix, "gbp", "ingiltere"); }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Sterlin: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.GBP).getValue() + " TL").queue();
    }

}
