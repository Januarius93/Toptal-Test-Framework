package webautomation.enums;

public enum UserFormData {

    NAME("EZegarki"),
    SURNAME("Test"),
    STREET("Immaginary"),
    HOUSE_NUMBER("20"),
    FLAT_NUMBER("14"),
    POSTAL_CODE("00-001"),
    CITY("Abstract"),
    PHONE_NUMBER("999888777");

    UserFormData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    String data;

}
