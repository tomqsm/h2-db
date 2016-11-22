package biz.letsweb.h2.jdbc;

import java.io.File;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class ProjectConfiguration {

    public static final Logger LOG = LoggerFactory.getLogger(ProjectConfiguration.class);

    private ProjectConfiguration() {
    }

    enum ForObject {

        H2("h2.properties");

        private final String fileName;

        ForObject(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return fileName;
        }

    }

    /**
     *
     * @param type
     * @return
     */
    public static Configuration getConfiguration(final ForObject type) {
        final Parameters params = new Parameters();
        final File file = new File(type.toString());
        Configuration config = new BaseConfiguration();
        final FileBasedConfigurationBuilder<FileBasedConfiguration> builder
                = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.fileBased()
                                .setFile(file));
        try {
            config = builder.getConfiguration();
        } catch (ConfigurationException ex) {
            LOG.error("Check properties file location. {}", ex);
        }
        return config;
    }
}
