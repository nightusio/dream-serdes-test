package cc.dreamcode.serdestest;

import cc.dreamcode.command.bukkit.BukkitCommandProvider;
import cc.dreamcode.platform.DreamVersion;
import cc.dreamcode.platform.bukkit.DreamBukkitConfig;
import cc.dreamcode.platform.bukkit.DreamBukkitPlatform;
import cc.dreamcode.platform.bukkit.component.CommandComponentResolver;
import cc.dreamcode.platform.bukkit.component.ConfigurationComponentResolver;
import cc.dreamcode.platform.component.ComponentManager;
import cc.dreamcode.platform.persistence.DreamPersistence;
import cc.dreamcode.serdestest.command.TestCommand;
import cc.dreamcode.serdestest.config.PluginConfig;
import cc.dreamcode.serdestest.test.TestManager;
import cc.dreamcode.serdestest.test.TestSerdes;
import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import lombok.Getter;
import lombok.NonNull;

public final class SerdesTestPlugin extends DreamBukkitPlatform implements DreamBukkitConfig, DreamPersistence {

    @Getter private static SerdesTestPlugin serdesTestPlugin;

    @Override
    public void load(@NonNull ComponentManager componentManager) {
        serdesTestPlugin = this;
    }

    @Override
    public void enable(@NonNull ComponentManager componentManager) {
        this.registerInjectable(BukkitCommandProvider.create(this, this.getInjector()));

        componentManager.registerResolver(CommandComponentResolver.class);
        componentManager.registerResolver(ConfigurationComponentResolver.class);
        componentManager.registerComponent(PluginConfig.class);

        componentManager.registerComponent(TestManager.class);
        componentManager.registerComponent(TestCommand.class);
    }

    @Override
    public void disable() {
        // features need to be call when server is stopping
    }

    @Override
    public @NonNull DreamVersion getDreamVersion() {
        return DreamVersion.create("Dream-Serdes-Test", "1.0", "Nightusio");
    }

    @Override
    public @NonNull OkaeriSerdesPack getConfigSerdesPack() {
        return registry -> {
            registry.register(new TestSerdes());

        };
    }


}
