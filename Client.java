import java.rmi.*;
import java.util.Random;

public class Client {
	
	
	// Enum Generate random names
	enum badGuysNames {
		MAGNETO, JOKER, KINGPIN, LOKI, MYSTIQUE, VENOM, SHREDDER, DOCTOR_DOOM, NORMAN_OSBORN, RED_SKULL, GALACTUS, ULTRON,
		THANOS, APOCALYPSE, DOCTOR_OCTAPUS, ANNIHILUS, JUGGERNAUT;

		public static badGuysNames getRandomNames() {
			Random rand = new Random();
			return values()[rand.nextInt(values().length)];
		}
	}
	
	public static void main(String a[]) throws Exception{
		
		SuperThing evilPerson = new SuperThing();
		Person thing = evilPerson.createThing("villain");

		thing.setName(badGuysNames.getRandomNames().toString());
		thing.setType("villain");

		int random = (int) (Math.random() * 2);
		if (random == 1) {
			thing.setSuperPower("strong person");
		} else {
			thing.setSuperPower("flying person");
		}

		System.out.println("Villain created:\n" + thing.toString() + "\nSending villain to the server\n");

		
		remoteObject rObj = (remoteObject)Naming.lookup("Create_Thing");
		
		Person hero = rObj.create(thing);
		
		System.out.println("Received from server:\n" + hero.toString());
		
	}
}
