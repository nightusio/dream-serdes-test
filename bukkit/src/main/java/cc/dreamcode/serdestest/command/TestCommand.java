package cc.dreamcode.serdestest.command;

import cc.dreamcode.command.bukkit.BukkitCommand;
import cc.dreamcode.serdestest.test.TestManager;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TestCommand extends BukkitCommand {

    @Inject
    private TestManager testManager;

    public TestCommand() {
        super("test");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        if (args[0].equalsIgnoreCase("add")) {
            String testString = args[1];
            int testNumber = Integer.parseInt(args[2]);

            this.testManager.addTestStringAndInt(testString, testNumber);
            sender.sendMessage("added");
        } else {
            sender.sendMessage(this.testManager.getTestStrings() + " " + this.testManager.getTestNumbers());
        }
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
