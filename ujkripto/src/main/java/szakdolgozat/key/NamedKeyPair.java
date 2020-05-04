package szakdolgozat.key;

import java.util.Objects;

public class NamedKeyPair {
    private String name;
    private String privateKey;
    private String publicKey;

    public NamedKeyPair() {}

    public NamedKeyPair(final String name, final String privateKey, final String publicKey) {
        this.name = name;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedKeyPair that = (NamedKeyPair) o;
        return getName().equals(that.getName()) &&
                getPrivateKey().equals(that.getPrivateKey()) &&
                getPublicKey().equals(that.getPublicKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrivateKey(), getPublicKey());
    }

    @Override
    public String toString() {
        return "NamedKeyPair{" +
                "name='" + name + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }
}
