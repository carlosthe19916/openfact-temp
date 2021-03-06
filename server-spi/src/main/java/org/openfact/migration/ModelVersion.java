package org.openfact.migration;

import org.jboss.logging.Logger;

public class ModelVersion {
    private static Logger logger = Logger.getLogger(ModelVersion.class);
    int major;
    int minor;
    int micro;
    String qualifier;

    public ModelVersion(int major, int minor, int micro) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public ModelVersion(String version) {
        String[] split = version.split("\\.");
        try {
            if (split.length > 0) {
                major = Integer.parseInt(split[0]);
            }
            if (split.length > 1) {
                minor = Integer.parseInt(split[1]);
            }
            if (split.length > 2) {
                micro = Integer.parseInt(split[2]);
            }
            if (split.length > 3) {
                qualifier = split[3];
            }
        } catch (NumberFormatException e) {
            logger.warn("failed to parse version: " + version, e);
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getMicro() {
        return micro;
    }

    public String getQualifier() {
        return qualifier;
    }

    public boolean lessThan(ModelVersion version) {
        if (major < version.major) {
            return true;
        } else if (major > version.major) {
            return false;
        }

        if (minor < version.minor) {
            return true;
        } else if (minor > version.minor) {
            return false;
        }

        if (micro < version.micro) {
            return true;
        } else if (minor > version.minor) {
            return false;
        }

        if (qualifier != null && qualifier.equals(version.qualifier)) return false;
        if (qualifier == null) return false;
        if (version.qualifier == null) return true;
        int comp = qualifier.compareTo(version.qualifier);
        if (comp < 0) return true;
        return false;
    }
}
