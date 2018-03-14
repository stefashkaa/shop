package entities;

public class Client {
    private int id;
    private String name;
    private String defaultAddress;

    public Client() {}

    public Client(int id, String name, String defaultAddress) {
        this.id = id;
        this.name = name;
        this.defaultAddress = defaultAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
