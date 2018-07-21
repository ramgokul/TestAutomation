package managers;

import utilities.ConfigFileReader;

public class FileReaderManager {
    private static FileReaderManager ourInstance = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    public static FileReaderManager getInstance() {
        return ourInstance;
    }

    private FileReaderManager() {
    }

    public static ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
