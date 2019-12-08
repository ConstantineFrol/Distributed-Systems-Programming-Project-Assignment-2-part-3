import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.Random;

public class Processor extends UnicastRemoteObject implements remoteObject {

	private static final long serialVersionUID = 1L;

	private enum goodGuysNames {
		SUPERMAN, BATMAN, SPIDER_MAN, THOR, CAPTAIN_AMERICA, WONDER_WOMAN, HULK;

		public static goodGuysNames getRandomNames() {
			Random rand = new Random();
			return values()[rand.nextInt(values().length)];
		}
	}

	protected Processor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person create(Person person) throws Exception {
		
		if (person.getType().equalsIgnoreCase("villain")) {
			SuperThing evilPerson = new SuperThing();
			Person thing = evilPerson.createThing("hero");
			thing.setName(goodGuysNames.getRandomNames().toString());
			thing.setType("hero");
			if (person.getSuperPower().equals("strong person")) {
				thing.setSuperPower("strong person");
			} else {
				thing.setSuperPower("flying person");
			}
			System.out.println("\nHero has bean created !!!\n" + thing.toString());
			return thing;
		}
		return person;

	}

}