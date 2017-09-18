/**
 * Created by bigmanstan on 17/9/17.
 */
public enum  Player {

    COMPUTER("X"), USER("0") ,NONE("-") ;

    private Player(String text){
        this.text=text;
    }
    private final String text;

    @Override
    public String toString() {
        return  this.text;
    }
}
