package model;

/**
 * The Clients class represents a client entity with attributes such as ID, name, address, email, and age.
 *
 * @author Risteiu Ioana
 * @since May 19, 2024
 */
public class Clients {
    private int id;
    private String name_client;
    private String address;
    private String email;
    private int age;

    /**
     * Default constructor.
     */
    public Clients() {
    }

    /**
     * Constructs a client object with the specified ID, name, address, email, and age.
     *
     * @param id the client ID
     * @param name_client the client name
     * @param address the client address
     * @param email the client email
     * @param age the client age
     */
    public Clients(int id, String name_client, String address, String email, int age) {
        super();
        this.id = id;
        this.name_client = name_client;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    /**
     * Constructs a client object with the specified name, address, email, and age.
     *
     * @param name_client the client name
     * @param address the client address
     * @param email the client email
     * @param age the client age
     */
    public Clients(String name_client, String address, String email, int age) {
        super();
        this.name_client = name_client;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    /**
     * Gets the client ID.
     *
     * @return the client ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the client ID.
     *
     * @param id the client ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the client name.
     *
     * @return the client name
     */
    public String getName_client() {
        return name_client;
    }

    /**
     * Sets the client name.
     *
     * @param name_client the client name to set
     */
    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    /**
     * Gets the client address.
     *
     * @return the client address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the client address.
     *
     * @param address the client address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the client age.
     *
     * @return the client age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the client age.
     *
     * @param age the client age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the client email.
     *
     * @return the client email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the client email.
     *
     * @param email the client email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the client object.
     *
     * @return a string representation of the client object
     */
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name_client + ", address=" + address + ", email=" + email + ", age=" + age
                + "]";
    }
}
