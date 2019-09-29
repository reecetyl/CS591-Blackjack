public enum FaceValue {
    ACE("ACE"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King");

    private final String faceValueText;
    FaceValue(String faceValueText) {
        this.faceValueText = faceValueText;
    }

    @Override
    public String toString() {
        return faceValueText;
    }

}
