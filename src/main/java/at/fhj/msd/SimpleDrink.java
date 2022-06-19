package at.fhj.msd;
/**
 * Class represents a simple drink liquid which can be used in
 * drinks
 */
public class SimpleDrink extends at.fhj.msd.Drink {
    /**
     * uses only one liquid
     */
    protected at.fhj.msd.Liquid l;
    /**
     * Creates a SimpleDrink object with given age and
     * liquid
     *
     * @param name name of drink
     * @param l only liquid in drink
     */
    SimpleDrink(String name, at.fhj.msd.Liquid l){
        super(name);
        this.l = l;
    }

    /**
     * Returns volume of liquid l
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        return l.getVolume();
    }

    /**
     * Returns alcohol volume percent of liquid l
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return l.getAlcoholPercent();
    }
    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        if(l.getAlcoholPercent() > 0){
            return true;
        }
        return false;
    }
}
