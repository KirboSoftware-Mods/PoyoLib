package com.kirbosoftware.poyolib.api.v1.config;

import com.kirbosoftware.poyolib.util.Util;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class ConfigManager {
    public static void load(ConfigHolder holder) {
        Properties properties = new Properties();
        Path path = getConfigPath(holder);
        Util.LOGGER.info("Loading properties from: " + path);

        try (InputStream in = Files.newInputStream(path, StandardOpenOption.CREATE)) {
            properties.load(in);

            // Retrieve ConfigValues from the ConfigHolder and update their values
            for (ConfigValue<?> configValue : holder.getValues()) {
                String key = configValue.getKey();
                String valueStr = properties.getProperty(key);
                if (valueStr != null) {
                    // Convert the string value to the appropriate type
                    Object value = parseValue(valueStr, configValue.get().getClass());
                    configValue.setValue(value);
                }
            }

//            // Sync ExampleConfig fields with values from the ConfigHolder
//            syncConfig(holder);

            // Util.LOGGER.info("Loaded properties: " + properties);
        } catch (FileNotFoundException e) {
            // Handle the case when the file doesn't exist
            Util.LOGGER.warn("The properties file does not exist.");
        } catch (IOException e) {
            // Handle other IO exceptions
            Util.LOGGER.error(e.toString());
        }
    }

    public static void store(ConfigHolder holder) {
        Path path = getConfigPath(holder);
        Util.LOGGER.info("Storing properties to: " + path);
        Properties properties = new Properties();

        // Populate the properties with the values from the ConfigHolder
        for (ConfigValue<?> configValue : holder.getValues()) {
            properties.setProperty(configValue.getKey(), configValue.get().toString());
        }

        try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            properties.store(out, "Configuration File");
        } catch (IOException e) {
            // Handle IO exceptions during file writing
            Util.LOGGER.error(e.toString());
        }
    }

    private static Path getConfigPath(ConfigHolder holder) {
        return FabricLoader.getInstance().getConfigDir().resolve(holder.getFileName() + ".properties");
    }

    // Helper method to parse values from strings to their respective types
    private static Object parseValue(String valueStr, Class<?> targetType) {
        if (targetType == String.class) {
            return valueStr;
        } else if (targetType == Integer.class) {
            return Integer.parseInt(valueStr);
        } else if (targetType == Boolean.class) {
            return Boolean.parseBoolean(valueStr);
        } else {
            // Handle other types as needed
            throw new IllegalArgumentException("Unsupported type: " + targetType);
        }
    }

    // TODO: fix this mess
    private static void syncConfig(ConfigHolder holder) {
        Field[] fields = holder.getDeclaredFields();
        for (Field field : fields) {
            if (ConfigValue.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    ConfigValue<?> configValue = holder.getValue(fieldName);
                    field.set(null, configValue.get());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
