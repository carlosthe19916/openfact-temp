package org.openfact.models.enums;

public enum AdditionalInformationType {

    /**
     * Total valor de venta - operaciones gravadas
     */
    GRAVADO("1001", "OPERACIONES GRAVADAS"),

    /**
     * Total valor de venta - operaciones inafectas
     */
    INACFECTO("1002", "OPERACIONES INAFECTAS"),

    /**
     * Total valor de venta - operaciones exoneradas
     */
    EXONERADO("1003", "OPERACIONES EXONERADAS"),

    /**
     * Total valor de venta - operaciones gratuitas
     */
    GRATUITO("1004", "OPERACIONES GRATUITAS");

    private final String code;
    private final String description;

    AdditionalInformationType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

}
