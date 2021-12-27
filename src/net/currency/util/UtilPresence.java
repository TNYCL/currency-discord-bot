package net.currency.util;

import net.currency.Main;
import net.dv8tion.jda.api.entities.Activity;

public class UtilPresence {

    public static void setActivity(Activity activity) {
        Main.getJda().getPresence().setActivity(activity);
    }

}
