public class GenericContainer implements Container<String>{
    private String value;

    @Override
    public void setValue(String value) {
        this.value=value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}