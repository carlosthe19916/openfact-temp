package org.openfact.provider;

public class ProviderConfigProperty {
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String STRING_TYPE = "String";
    public static final String LIST_TYPE = "List";

    protected String name;
    protected String label;
    protected String helpText;
    protected String type;
    protected Object defaultValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }
}
