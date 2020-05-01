public class Spieler
{
    private final String name;
    private final boolean isWhite;
    
    public Spieler (final String name, final boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }
    
    public boolean isWhite() {
        return isWhite;
    }
    
    public boolean isBlack() {
        return !isWhite;
    }
}
