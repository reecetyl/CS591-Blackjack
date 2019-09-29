public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitText;
    Suit(String suitText) {
        this.suitText = suitText;
    }

    @Override
    public String toString() {
        return suitText;
    }
}
