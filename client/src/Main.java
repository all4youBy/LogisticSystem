import remote.DbManagerRemote;

import javax.ejb.EJB;

public class Main {

    @EJB
    private static DbManagerRemote dbManagerRemote;

    public static void main(String[] args) {
        //dbManagerRemote.getCustomers().forEach(System.out::println);
        //System.out.println(dbManagerRemote.createCustomer("Maxim"));
    }
}
