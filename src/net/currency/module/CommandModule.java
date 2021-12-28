package net.currency.module;

import net.currency.module.handler.CommandHandler;

import java.util.Arrays;
import java.util.List;

public abstract class CommandModule implements CommandHandler {

    private String name;
    private String prefix;
    private List<String> aliases;

    public CommandModule(String name, String prefix, String... aliases) {
        this.name = name;
        this.prefix = prefix;
        this.aliases = Arrays.asList(aliases);
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public List<String> getAliases() {
        return this.aliases;
    }

}
