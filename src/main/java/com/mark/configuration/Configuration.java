package com.mark.configuration;

import com.mark.exception.MarkException;
import com.shash.autoNG.utils.jsonUtil.ObjectMapperUtil;
import com.shash.autoNG.utils.yamlUtil.YamlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Configuration {
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
    private static final String CONFIG_FILE = "./config/mark-config.yaml";
    private static final String ENV_VARIABLE = "TARGET_ENV";

    private static String baseUrl;
    private static String driverType;
    private static Long globalSleepTimeInMS;

    private static Map configMap = null;

    static {
        Map<String, Object> webConfig;
        Map<String, Object> testConfig;

        try {
            Map yamlMap = YamlUtil.read(new File(CONFIG_FILE));
            String targetEnv = System.getenv(ENV_VARIABLE);
            logger.info("[Configuration] Target ENV: {}", targetEnv);

            if (targetEnv != null && yamlMap.containsKey(targetEnv)) {
                logger.info("[Configuration] Loading configurations for [{}]", targetEnv);
                configMap = (Map<String, Object>) yamlMap.get(targetEnv.trim().toLowerCase());
            } else {
                logger.info("[Configuration] Target Env is null/no config available for it, hence loading default config [localhost]");
                logger.info("[Configuration] If you with to use other environment, please " +
                        "'export {}=$ENV_NAME' and run the tests again", ENV_VARIABLE);
                configMap = (Map<String, Object>) yamlMap.get("localhost");
            }

            webConfig = (Map<String, Object>) configMap.get("webConfig");
            testConfig = (Map<String, Object>) configMap.get("testConfig");

        } catch (Exception e) {
            throw new MarkException("[Configuration] Error while loading configurations: " + e.getMessage());
        }

        baseUrl = (String) webConfig.get("baseUrl");
        driverType = (String) testConfig.get("driverType");
        globalSleepTimeInMS = Long.parseLong(String.valueOf(testConfig.get("globalSleepTimeInMS")));

        /*
        Print the configuration to be used for test
         */
        printConfig();
    }

    /**
     * @return baseUrl
     */
    public static String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @return driverType
     */
    public static String getDriverType() {
        return driverType;
    }

    /**
     * @return globalSleepTimeInMS
     */
    public static Long getGlobalSleepTimeInMS() {
        return globalSleepTimeInMS;
    }

    /**
     * print configuration
     */
    private static void printConfig() {
        try {
            logger.info("[Configuration] Test Configuration Used: {}", ObjectMapperUtil.instance().writeValueAsString(configMap));
        } catch (IOException e) {
            logger.error("[Configuration] Error while parsing config");
        }
    }
}


