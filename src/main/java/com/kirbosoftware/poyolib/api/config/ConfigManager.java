package com.kirbosoftware.poyolib.api.config;

import com.electronwill.nightconfig.core.ConfigFormat;
import com.electronwill.nightconfig.core.file.FileConfig;
import com.electronwill.nightconfig.core.io.ConfigWriter;
import com.electronwill.nightconfig.toml.TomlFormat;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@SuppressWarnings("unused")
public class ConfigManager {
    String fileName;
    Config configFile;
    static FileConfig config;

    public void initialize() {
        load();
        store();
    }

    public ConfigManager register(String fileName, Class<? extends Config> config) {
        this.fileName = fileName;
        try {
            this.configFile = config.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // Handle the exception according to your needs
            e.printStackTrace(); // Or log the error
        }
        return this;
    }

    private void load() {

        config = FileConfig.of(getConfigPath(fileName).toFile());
        Path path = getConfigPath(fileName);

        if (!config.getFile().isFile()) {
            store();
        } else {
            try (InputStream in = Files.newInputStream(path, StandardOpenOption.CREATE)) {
                config.load();

                for (ConfigValue<?> configValue : configFile.getConfigValues()) {
                    String key = configValue.getKey();
                    Object newValue = config.get(key);
                    if (configValue.get() != newValue) {
                        configValue.setValue(newValue);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void store() {
        Path path = getConfigPath(fileName);

        ConfigFormat<?> tomlFormat = TomlFormat.instance();
        ConfigWriter writer = TomlFormat.instance().createWriter();

        config = FileConfig.of(getConfigPath(fileName).toFile());

        for (ConfigValue<?> configValue : configFile.getConfigValues()) {
            config.set(configValue.getKey(), configValue.get());
        }

        try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            config.addAll(config);
            config.save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path getConfigPath(String fileName) {
        return FabricLoader.getInstance().getConfigDir().resolve(fileName + ".toml");
    }
}
