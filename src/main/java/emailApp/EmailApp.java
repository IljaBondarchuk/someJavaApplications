package emailApp;



public class EmailApp {
    public static void main(String[] args) {
        Email newEmail = new Email("Ilja", "Bondarchuk", "Software", "Intellias");
        Email newEmail1 = new Email("Jeanne", "Bondarchuk", "Designer", "Intellias");

        System.out.println(newEmail);
        System.out.println(newEmail.getPassword());
        newEmail.changePassword();
        System.out.println(newEmail.getPassword());


        System.out.println(newEmail.getAlternateEmail());
        newEmail.setAlternateEmail();
        System.out.println(newEmail.getAlternateEmail());

    }
}
