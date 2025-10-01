/**
 *  Burnymon singe their opponents with the fire of 5 suns.
 *  - Start with 15 health
 *  - takes in a name
 *  - Deal burny damage
 *  - say its name twice when printed
 */
public class Dampymon extends Forneymon {


    Dampymon (String name) {
        super(25, name);
    }

    @Override
    public int takeDamage (int dmg, String type) {
        if (type.equals("burny")) {
            dmg += 5;
        }
        return super.takeDamage(dmg, type);
    }


}
