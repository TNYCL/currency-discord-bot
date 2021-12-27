package net.currency.listener;

import net.currency.Start;
import net.currency.handler.ActivityTimer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Currency extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals("!dolar")) event.getChannel().sendMessage("Dolar: " + Start.getActivityHandler().getValueWithType(ActivityTimer.Type.USD).getValue()).queue();
        if(event.getMessage().getContentRaw().equals("!euro")) event.getChannel().sendMessage("Euro: " + Start.getActivityHandler().getValueWithType(ActivityTimer.Type.EUR).getValue()).queue();
        if(event.getMessage().getContentRaw().equals("!sterlin")) event.getChannel().sendMessage("Sterlin: " + Start.getActivityHandler().getValueWithType(ActivityTimer.Type.GBP).getValue()).queue();
    }

}
