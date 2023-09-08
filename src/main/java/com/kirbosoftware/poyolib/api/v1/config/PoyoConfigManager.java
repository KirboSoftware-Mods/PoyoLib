package com.kirbosoftware.poyolib.api.v1.config;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class PoyoConfigManager {
    public static void load(IPoyoConfig config) {
        Properties properties = new Properties();
        Path path = getConfigPath(config);
        System.out.println("Loading properties from: " + path);

        try (InputStream in = Files.newInputStream(path, StandardOpenOption.CREATE)) {
            properties.load(in);
            System.out.println("Loaded properties: " + properties);
        } catch (FileNotFoundException e) {
            // Handle the case when the file doesn't exist
            System.err.println("The properties file does not exist.");
        } catch (IOException e) {
            // Handle other IO exceptions
            e.printStackTrace();
        }
    }

    public static void store(IPoyoConfig config) {
        Path path = getConfigPath(config);
        System.out.println("Storing properties to: " + path);
        Properties properties = config.getProperties();
//        config.setValues(properties);
        try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            properties.store(out, "Configuration File");
        } catch (IOException e) {
            // Handle IO exceptions during file writing
            e.printStackTrace();
        }
    }

    private static Path getConfigPath(IPoyoConfig config) {
        return FabricLoader.getInstance().getConfigDir().resolve(config.getFileName() + ".properties");
    }
}