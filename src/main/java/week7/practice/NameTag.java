package week7.practice;

public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] names = fullName.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
