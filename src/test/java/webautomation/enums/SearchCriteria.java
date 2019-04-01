package webautomation.enums;

public enum SearchCriteria {

    BY_WATCH_BRAND("Seiko"),
    BY_WATCH_MODEL("C4646-2"),
    BY_GENDER_TYPE("damski");

    private String criteria;

    public String getCriteria() {
        return criteria;
    }

    SearchCriteria(String criteria) {
        this.criteria = criteria;
    }
}
