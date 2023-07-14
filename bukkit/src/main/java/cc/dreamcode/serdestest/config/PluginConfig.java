package cc.dreamcode.serdestest.config;

import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import cc.dreamcode.serdestest.test.Test;
import cc.dreamcode.utilities.builder.ListBuilder;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;

import java.util.List;

@Configuration(
        child = "config.yml"
)
@Header("## Dream-Serdes-Test (Main-Config) ##")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class PluginConfig extends OkaeriConfig {

    public List<Test> testList = new ListBuilder<Test>()
            .add(new Test(1, "raz"))
            .add(new Test(2, "dwa"))
            .add(new Test(3, "trzy"))
            .build();
}
